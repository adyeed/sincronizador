/**
 * Notificacion.java
 * Fecha de creaci�n: 17/12/2015, 11:41:37
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

package mx.ine.sscc.servicios.unicom.servicio;

import mx.ine.sscc.servicios.unicom.jaxb.DatosEntregaCredencial;
import mx.ine.sscc.servicios.unicom.jaxb.DetalleEstatusCredencial;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface NotificacionService {

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     */
    void init();

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @return String XML
     */
    String obtieneNotificacion();

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntregaCredencial
     * @param datosEntregaCredencial
     */
    void setContenido(DatosEntregaCredencial datosEntregaCredencial);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param detalleEstatusCredencial
     */
    void setContenido(DetalleEstatusCredencial detalleEstatusCredencial);

}
