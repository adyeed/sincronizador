/**
 * Sincronizador.java
 * Fecha de creación: 27/11/2015, 14:41:13
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */

package mx.ine.sscc.servicios.unicom.receptor;

import java.util.Date;

/**
 * TODO [Interfaz que define el comportamiento para el objeto encargado ensamblar las
 * notificaciones.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface Ensamblador {

    /**
     * TODO [Método donde se obtiene los datos necesarios para llenar los objetos de
     * notificación.]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @return true / false
     */
    boolean obtieneDatos();

    /**
     * TODO [Método donde se construyen los objetos de notificación. ]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @return true / false
     */
    boolean armaNotificacion();

    /**
     * TODO [Método encargado de enviar el objeto de notoficación al servidor SIIRFE.]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @return true / false
     */
    boolean enviaNotificacion();

    /**
     * TODO [Método para obtener el número de registros disponibles para crear la
     * notoficación.]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    void datosDisponibles();

    /**
     * TODO [Método para control de error de registros. Si por alguna razón el registro no pudo
     * ser enviado se acctualiza regresandolo a su estatus de origen.]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param folio
     * @param fechaEnvio
     * @param estatus
     * @param nuevoEstatus
     */
    void controlError(String folio, Date fechaEnvio, String estatus, String nuevoEstatus);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param folio
     * @param estatus
     * @param nuevoEstatus
     */
    void controlError(String folio, String estatus, String nuevoEstatus);

}
