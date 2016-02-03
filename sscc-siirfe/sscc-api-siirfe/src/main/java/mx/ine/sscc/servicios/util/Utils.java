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



}
