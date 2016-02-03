/**
 * Utils.java
 * Fecha de creaci�n: Oct 28, 2015, 12:59:38 PM
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */
package mx.ine.sscc.servicios.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang3.StringUtils;

/**
 * Utilierias
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class Utils {

    /**
     * m�todo que regresa un valor booleano al comparar dos valores de tipo string que no sean
     * nulos, en caso contrario regresa null
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param valor1
     * @param valor2
     * @return
     */
    public static Boolean comparaString(String valor1, String valor2) {

        if (!StringUtils.isBlank(valor1) && !StringUtils.isBlank(valor2)) {
            return valor1.equalsIgnoreCase(valor2);
        }
        return null;

    }

    /**
     * Obtiene el a�o de una fecha determinada
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param date
     * @return anio
     */
    public static Integer obtieneAnio(Date date) {
        String formato = "yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(formato);
        if (date != null) {
            return Integer.parseInt(dateFormat.format(date));
        }
        return null;

    }

    /**
     * Convierte una fecha tipo string a un tipo Date
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param dateInString
     * @return newDate
     */
    public static Date strToDate(String dateInString) {
        Date newDate = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        if (dateInString != null) {
            try {
                newDate = sdf.parse(dateInString);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }

        return newDate;
    }

    /**
     * TODO [Convierte el obeto de fecha a Strgin dando formato, esta fecha es usada para crear
     * parte del identificador del bloque de registros que se este procesando.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param pd_fecha
     * @return La fecha con el formato establecido.
     */
    @SuppressWarnings("unused")
    public static String dateToString(Date pd_fecha) {
        String ls_fecha = null;
        try {
            SimpleDateFormat formatDateJava = new SimpleDateFormat("ddMMyyyyHH:mm:ss");
            ls_fecha = formatDateJava.format(pd_fecha);
        } catch (Exception e) {

            ls_fecha = null;
        }
        return ls_fecha;
    }

    /**
     * TODO [Calcula el n�mero de hilos que se deberan usar para la ejecuci�n de las tareas de
     * sincronizaci�n entre bases de datos. ]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param promedio
     * @return N�mero de Hilos con los que trabajara el Pool.
     */
    public static int getNoTrabajadores(long promedio) {

        int auxTrabajadores = 0;
        // Si el tiempo de respuesa promedio del ping al servidor de base de datos es menor a
        // 400 Milisegundos se usaran 7 hilos, en caso contrario intuimos que la conexion es
        // lenta y solo se envian 3 hilos.
        if ((promedio <= 400)) {
            auxTrabajadores = 7;
        } else {
            auxTrabajadores = 3;
        }
        return auxTrabajadores;
    }

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param date
     * @return
     */
    public static XMLGregorianCalendar DateToXML(Date date) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        XMLGregorianCalendar xmlDate = null;
        try {
            xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (Exception e) {
            // TODO: handle exception
            try {
                c.setTime(new Date());
                xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            } catch (Exception e2) {
                // TODO: handle exception
            }
            System.out.println("Error al transformar fecha XML");
        }

        return xmlDate;
    }

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param folio
     * @return modulo
     */
    public static String obtieneModulo(String folio) {
        String modulo = null;
        if (folio.length() == 13) {
            modulo = folio.substring(3, (folio.length() - 4));
        } else {
            modulo = folio.substring(3, (folio.length() - 5));
        }
        return modulo;
    }

}
