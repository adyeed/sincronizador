/**
 * GenericHibernateDAO.java
 * Fecha de creación: 21/09/2012, 16:04:45
 *
 * Copyright (c) 2012 Instituto Federal Electoral. Dirección
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
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

/**
 * Interface que puese ser empleada por las interfaces de los daos del SIIRFE para tener
 * disponible de forma directa los métodos básicos para realizar persistencia con hibernate.
 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
 * @version 1.0
 * @since SIIRFE 5.1
 */

public interface GenericHibernateDAO {

	/**
	 * Realiza obtiene todos los atributos de una entidad o null si esta no existe.
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param id
	 * @param clazz el tipo de entidad a regresar
	 * @return La entidad solicitada con base a su id, o null si no existe.
	 */

	<T> T get(Class<T> clazz, Serializable id);

	/**
	 * Ejecuta un query de consulta esperando una unica entidad. A diferencia del método
	 * <code>queryForEntity</code> regresa null si la entidad no existe. Si se obtienen mas de
	 * un resultado, se lanza {@link IncorrectResultSizeDataAccessException}
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param clazz
	 * @param query
	 * @param params
	 * @return la entidad solicitada, null si no existe, o excepcion s se obtiene mas de un
	 *         registro.
	 */
	<T> T get(Class<T> clazz, String query, Object... params);

	/**
	 * Realiza una carga empleando lazy loading. El método no garantiza que la instancia
	 * exista, se asume que existe y la obtención de sus atributos se realiza empleando lazy
	 * loading.
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param clazz el tipo de entidad a regresar
	 * @param id
	 * @return Un proxy de la entidad solicitada.
	 */

	<T> T load(Class<T> clazz, Serializable id);

	/**
	 * Ejecuta una consulta empleando HQL con un conjunto de parametros.
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param query
	 * @param params
	 * @return Una lista de entidades asociadas al DAO, o lista vacia si no existen.
	 */

	<T> List<T> find(String query, Object... params);

	/**
	 * Metodo que obtiene un detalle paginado
	 * @author Hugo A. Zavala López (hugo.zavala@ife.org.mx, zavha1981@hotmail.com)
	 * @param query {@link String}
	 * @param paginaActual int
	 * @param numFilas int
	 * @param params Parametros
	 * @return {@link List}
	 */
	<T> List<T> findPaginado(String query, int paginaActual, int numFilas, Object... params);

	/**
	 * Ejecuta HQL en la que se espera un solo registro, lanza
	 * {@link IncorrectResultSizeDataAccessException} en caso de no obtener exactamente una
	 * entidad
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param query
	 * @param params
	 * @return la entidad solicitada
	 */

	<T> T queryForEntity(String query, Object... params);

	/**
	 * Realiza una consulta empleando queryByExample en donde se espera un solo registro. se
	 * lanza {@link IncorrectResultSizeDataAccessException} en caso de no obtener exactamente
	 * una entidad
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param entityExample La entidad con los atributos a considerar como condiciones de la
	 *        consulta.
	 * @return la entidad solicitada
	 */

	<T> T queryForEntity(T entityExample);

	/**
	 * Realiza una consulta empleando queryByExample en donde se espera un solo registro. se
	 * lanza {@link IncorrectResultSizeDataAccessException} en caso de no obtener exactamente
	 * una entidad. Este método acepta un objeto {@link Example}, se emplea cuando se requera
	 * personalizar la consulta.
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param example El objeto que contiene la configuración y los criterios de búsqueda para
	 *        realizar la consulta.
	 * @param clazz el tipo de entidad esperado.
	 * @return la entidad solicitada
	 */

	<T> T queryForEntity(Example example, Class<T> clazz);

	/**
	 * Regresa un objeto {@link Criteria} para construir consultas empleando esta
	 * funcionalidad.
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param clazz
	 * @return un objeto {@link Criteria} listo para ser configurado y ejecutado.
	 */
	Criteria construyeCriteria(Class<?> clazz);

	/**
	 * Realiza búsquedas de entidades empleando la funcionalidad de QBE (query by example) de
	 * Hibernate
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param example
	 * @return Una lista de objetos que coinciden con las propiedades que se pasan en la
	 *         entidad de ejemplo.
	 */
	<T> List<T> queryByExample(T example);

	/**
	 * Misma funcionalidad que el metodo sobrecargado con la diferencia en que este acepta un
	 * objeto {@link Example} previamente personalizado y configurado. Hibernate
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param example
	 * @param entityClass el tipo de entidad que se espera.
	 * @return Una lista de objetos que coinciden con las propiedades que se pasan en la
	 *         entidad de ejemplo.
	 */
	<T> List<T> queryByExample(Example example, Class<T> entityClass);

	/**
	 * Método que obtiene todos los regitros de la entidad <T>
	 * @param clazz el tipo de entidad a regresar
	 * @autor Maricela Barrera Bautista (maricela.barrera@ife.org.mx, alhezy@gmail.com)
	 * @return lista de los registros obtenidos
	 */

	<T> List<T> findAll(Class<T> clazz);

	/**
	 * Persiste la información de la entidad proporcionada
	 * @autor Maricela Barrera Bautista (maricela.barrera@ife.org.mx, alhezy@gmail.com)
	 * @param entity
	 */
	void save(Serializable entity);

	/**
	 * Aplica una operacion de save o update sobre la entidad que se pasa como parámetro.
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param entity
	 */
	void saveOrUpdate(Serializable entity);

	/**
	 * Actualiza la información de la entidad proporcionada
	 * @autor Maricela Barrera Bautista (maricela.barrera@ife.org.mx, alhezy@gmail.com)
	 * @param entity Esta entidad no necesariamente esta asociada a la sesion.
	 * @return La instancia actualizada y asociada a la sesion.
	 */

	<T> T merge(final T entity);

	/**
	 * Realiza una operación de update. El objeto que se recibe no debe esta asociado a la
	 * sesion. Si existe un objeto en sesion con el mismo id, se lanza excepcion.
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param entity
	 */
	<T> void update(T entity);

	/**
	 * Realiza una operación de update empleando hql
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param query
	 * @param params
	 * @return el número de registros afectados.
	 */
	int update(String query, Object... params);

	/**
	 * Elimina la entidad proporcionada
	 * @autor Maricela Barrera Bautista (maricela.barrera@ife.org.mx, alhezy@gmail.com)
	 * @param entity
	 */
	<T> void delete(final T entity);

	/**
	 * Invoca una operación de refresh de la entidad que se pasa como parámetro.
	 * @author Jorge A. Rodríguez Campos (jorge.rodriguez@ife.org.mx, jorgerdc79@hotmail.com)
	 * @param entity
	 */
	void refresh(Serializable entity);

	/**
	 * Realiza comit a bd
	 * @author Juan Manuel Reyes Medina (manuel.reyes@ife.org.mx, reyesmjm@gmail.com)
	 */
	void flush();
}
