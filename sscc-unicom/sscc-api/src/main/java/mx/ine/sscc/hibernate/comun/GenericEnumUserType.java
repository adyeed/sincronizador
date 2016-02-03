/**
 * GenericEnumUserType.java
 * Fecha de creación: 22/04/2010, 17:09:51
 *
 * Copyright (c) 2010 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */
package mx.ine.sscc.hibernate.comun;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import org.hibernate.usertype.ParameterizedType;
import org.hibernate.usertype.UserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementación de un mapeo personalizado (user type) para realizar mapeos con enums. Cada
 * enum deberá contener un id (id de la constante y su metodo get), el cual será asociado con
 * un campo y una tabla especificada en el mapeo de la entidad. Adicionalmente el Enum deberá
 * contener un metodo valueOf(int id) que regrese una instancia subclase de {@link Enum}. Se
 * emplea esta estrategia en lugar de emplear el metodo name() y el metodo valueOf(String) de
 * la clase {@link Enum}
 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
 * @author Jorge Rodríguez Campos,actualizacion de código: 27/06/2012 Se realizan
 *         actualizaciones a los metodos nullSafeSet y nullSafeGet derivado a cambios en las
 *         clases del API de Hibernate para la version 4.1.4
 * @version 1.1
 * @since SIIRFE 5.1
 */
public class GenericEnumUserType implements UserType, ParameterizedType {

    private static final Logger logger = LoggerFactory.getLogger(GenericEnumUserType.class);

    /**
     * Nombre del parametro que contiene el nombre completo del Enum a mapear.
     */
    private static final String PARAM_CLASS_NAME = "enumClassName";

    /**
     * Nombre del parametro que contiene el nombre del método a partir del cual se obtendrá via
     * reflexión el identificador de la constante en el Enum para asociarlo con su
     * correspondiente id en la base de datos. Si no se especifica, por default se toma el
     * valor de DEFAULT_GET_ID_METHOD_NAME
     */
    private static final String PARAM_GET_ID_METHOD_NAME = "getIDMethodName";

    /**
     * Por defaullt se toma este nombre de método para extraer el id del Enum para ser empleado
     * en el mapeo con la BD.
     */
    private static final String DEFAULT_GET_ID_METHOD_NAME = "getId";

    /**
     * Metodo empledo para extraer el id de la constante ENUM
     */
    private Method getIdMethod;

    /**
     * Nombre del parametro que identifica al nombre del metodo en el enum encargado de obtener
     * una instancia {@link Enum} a partir de su id. Si no se especifica se toma el valor de
     * DEFAULT_VALUE_OF_METHOD_NAME
     */
    private static final String PARAM_VALUE_OF_METHOD_NAME = "valueOfMethodName";

    /**
     * Por default, se toma este nombre, como nombre del método en el enum que se encarga de
     * obtener un objeto {@link Enum} con base a un id.
     */
    private static final String DEFAULT_VALUE_OF_METHOD_NAME = "valueOf";

    /**
     * Metodo empleado para obtener una instancia tipo {@link Enum} al realizar una operacion
     * de load o get de la base de datos. Este objeto se emplea en el metodo nullSafeGet para
     * realizar la obtención del objeto Enum que le corresponde al id recuperado de la BD.
     */
    private Method valueOfMethod;

    /**
     * Objeto Class que representa el Enum a mapear.
     */
    private Class<?> enumClass;

    /**
     * Este atributo guarda una instancia de las subclases de
     * AbstractSingleColumnStandardBasicType que se emplea para obtener el valor almacenado en
     * la base de datos que se mapea con un ENUM. En la mayoria de los casos se emplea una
     * instancia de {@link IntegerType}, pero en otros caso como el enum {@link Sexo} se guarda
     * una cadena. Para estos casos, el valor de la base se debe escribir y leer con una
     * instancia de {@link StringType}
     */
    @SuppressWarnings("rawtypes")
    private AbstractSingleColumnStandardBasicType columnDataType;

    /**
     * Extrae el valor de los parametros para este mapeo personalizado.<br>
     * <b>enumClassName:</b> <br>
     * Especifica el nombre del enum a mapear<br>
     * <b> getIDMethodName:</b> <br>
     * Especifica el nombre del metodo a partir de cual se obtiene el id del enum<br>
     * <b>valueOfMethodName:</b> <br>
     * Especifica el nombre del metodo que obtiene un objeto {@link Enum} a partir de su id.<br>
     * Adicionalmente inicializa los atributos de instancia de la clase necesarios para
     * realizar el mapeo id-Enum y viceversa.
     * @see org.hibernate.usertype.ParameterizedType#setParameterValues(java.util .Properties)
     */
    @Override
    public void setParameterValues(Properties params) {
        String getIDMethodName;
        String valueOfMethodName;
        String enumName;

        Class<?> returnDataType;

        getIDMethodName =
            params.getProperty(PARAM_GET_ID_METHOD_NAME, DEFAULT_GET_ID_METHOD_NAME);
        valueOfMethodName =
            params.getProperty(PARAM_VALUE_OF_METHOD_NAME, DEFAULT_VALUE_OF_METHOD_NAME);

        enumName = params.getProperty(PARAM_CLASS_NAME);
        try {
            enumClass = Class.forName(enumName).asSubclass(Enum.class);
            getIdMethod = enumClass.getMethod(getIDMethodName, new Class[0]);
            // tipo de dato del id
            returnDataType = getIdMethod.getReturnType();
            valueOfMethod =
                enumClass.getMethod(valueOfMethodName, new Class[] { returnDataType });

            if (returnDataType.isAssignableFrom(Integer.class)
                || returnDataType.isAssignableFrom(int.class)) {
                columnDataType = IntegerType.INSTANCE;
            } else if (returnDataType.isAssignableFrom(String.class)) {
                columnDataType = StringType.INSTANCE;
            } else {
                throw new HibernateException(
                    "El tipo de dato del atributo en el Enum a emplear para mapear no esta "
                        + "soportado por este mapeador, debe ser int, Integer o String. "
                        + "Tipo de dato empleado: " + returnDataType.getName());
            }

        } catch (ClassNotFoundException e) {
            throw new HibernateException("Clase(Enum) no encontrada para realizar mapeo: "
                + enumName + ", revise el mapeo y la existencia de la clase", e);
        } catch (SecurityException e) {
            throw new HibernateException(e);
        } catch (NoSuchMethodException e) {
            throw new HibernateException("Nombre incorrecto o metodo no "
                + "encontrado  para obtener el id del Enum a mapear: " + getIDMethodName, e);

        }

    }

    /**
     * Regresa el tipo de dato SQL que se empleará para generar el DDL del mapeo.En este caso
     * todos los enums se van a mapear con un id (INTEGER) en la base de datos. Cada Enum
     * tendrá una tabla (catálogo estático) asociado, cada constante se identifica por la PK de
     * dicha tabla.
     * @see org.hibernate.usertype.UserType#sqlTypes()
     */
    @Override
    public int[] sqlTypes() {
        return new int[] { IntegerType.INSTANCE.sqlType() };
    }

    /**
     * Le indica a hibernate cual es la clase Java correspondiente con este mapeo. En este
     * caso, la clase del enum.
     * @see org.hibernate.usertype.UserType#returnedClass()
     */
    @Override
    public Class<?> returnedClass() {
        return enumClass;
    }

    /**
     * Indica si la clase en este caso el enum es mutable.
     * @see org.hibernate.usertype.UserType#isMutable()
     */
    @Override
    public boolean isMutable() {
        return false;
    }

    /**
     * Hibernate emplea este método para generar snapshots del estado del objeto en este caso
     * del enum. Debido a que el enum es una clase inmutable no es necesario generar una copia
     * del objeto, se regresa el mismo objeto.
     * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
     */
    @Override
    public Object deepCopy(Object obj) throws HibernateException {

        return obj;
    }

    /**
     * Este metodo lo emplea hibernate al subir al objeto al cache de segundo nivel en formato
     * {@link Serializable}
     * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
     */
    @Override
    public Serializable disassemble(Object obj) throws HibernateException {

        return (Serializable) obj;
    }

    /**
     * Realiza la operacion contraria a disassemble reconstruye al objeto serializado en cache
     * de segundo nivel, debido a que es una clase inmutable se regresa el mismo objeto, no hay
     * cambios por ser inmutable.
     * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable, java.lang.Object)
     */
    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {

        return cached;
    }

    /**
     * Se emplea para hacer operaciones merge a una entidad en estado detached. En un objeto
     * mutable, se regresa al menos un snapshot (deepCopy) del estado del objeto. En objets
     * inmutables se regresa el objeto original.
     * @see org.hibernate.usertype.UserType#replace(java.lang.Object, java.lang.Object,
     *      java.lang.Object)
     */
    @Override
    public Object replace(Object original, Object target, Object owner)
        throws HibernateException {

        return original;
    }

    /**
     * Hibernate emplea este metodo para realizar operaciones dirty checking. Compara el estado
     * de 2 objetos para determinar si el estado a cambiado y determinar si requiere actualizar
     * el estado en la BD. El resultado de equals se delega al equals de los objetos en
     * cuestion. En este caso a los enums.
     * @see org.hibernate.usertype.UserType#equals(java.lang.Object, java.lang.Object)
     */
    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if (x == y) {
            return true;
        }
        if (x == null || y == null) {
            return false;
        }
        return x.equals(y);
    }

    /**
     * Se emplea para el mismo propósito que equals. Se delega el calculo del hashcode al
     * objeto a mapear (enum).
     * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
     */
    @Override
    public int hashCode(Object x) throws HibernateException {

        return x.hashCode();
    }

    /**
     * Obtiene el objeto de tipo {@link Enum} a partir del valor del ID obtenido de la BD. Se
     * requiere que el enum defina un metodo estatico valueOf(id) y que regrese el objeto tipo
     * {@link Enum}
     * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet, java.lang.String[],
     *      org.hibernate.engine.spi.SessionImplementor, java.lang.Object)
     */
    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SessionImplementor session,
        Object owner) throws HibernateException, SQLException {

        Object id = null;
        try {
            id = columnDataType.get(rs, names[0], session);
            if (id == null) {
                return null;
            }
            return valueOfMethod.invoke(enumClass, new Object[] { id });
        } catch (Exception e) {
            logger.error("Error al invocar el metodo " + valueOfMethod.getName()
                + " para obtener el Enum " + enumClass.getName() + " con id: " + id
                + ". De cualquier forma retornamos null para evitar propagar el error.");
            return null;
        }
    }

    /**
     * Establece el valor del id del enum en el preparedStatement para enviar a la base de
     * datos empleando los parametros proporcionados en el mapeo.
     * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement,
     *      java.lang.Object, int, org.hibernate.engine.spi.SessionImplementor)
     */
    @SuppressWarnings("unchecked")
    @Override
    public void nullSafeSet(PreparedStatement ps, Object value, int index,
        SessionImplementor session) throws HibernateException, SQLException {
        Object enumValue;
        try {
            if (value == null) {
                columnDataType.set(ps, null, index, session);
                return;
            }
            enumValue = getIdMethod.invoke(value, new Object[0]);
            columnDataType.set(ps, enumValue, index, session);
            // ps.setObject(index, enumValue);
        } catch (Exception e) {
            throw new HibernateException("Error al invocar el metodo " + getIdMethod.getName()
                + " para obtener el identificador del enum: " + enumClass.getName(), e);
        }

    }
}
