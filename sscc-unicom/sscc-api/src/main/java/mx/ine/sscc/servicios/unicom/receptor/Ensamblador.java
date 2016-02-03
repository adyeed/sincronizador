/**
 * Sincronizador.java
 * Fecha de creaci�n: 27/11/2015, 14:41:13
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Federal Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */

package mx.ine.sscc.servicios.unicom.receptor;

import java.util.Date;

/**
 * TODO [Interfaz que define el comportamiento para el objeto encargado ensamblar las
 * notificaciones.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface Ensamblador {

    /**
     * TODO [M�todo donde se obtiene los datos necesarios para llenar los objetos de
     * notificaci�n.]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @return true / false
     */
    boolean obtieneDatos();

    /**
     * TODO [M�todo donde se construyen los objetos de notificaci�n. ]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @return true / false
     */
    boolean armaNotificacion();

    /**
     * TODO [M�todo encargado de enviar el objeto de notoficaci�n al servidor SIIRFE.]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @return true / false
     */
    boolean enviaNotificacion();

    /**
     * TODO [M�todo para obtener el n�mero de registros disponibles para crear la
     * notoficaci�n.]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     */
    void datosDisponibles();

    /**
     * TODO [M�todo para control de error de registros. Si por alguna raz�n el registro no pudo
     * ser enviado se acctualiza regresandolo a su estatus de origen.]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param folio
     * @param fechaEnvio
     * @param estatus
     * @param nuevoEstatus
     */
    void controlError(String folio, Date fechaEnvio, String estatus, String nuevoEstatus);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param folio
     * @param estatus
     * @param nuevoEstatus
     */
    void controlError(String folio, String estatus, String nuevoEstatus);

}
