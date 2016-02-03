/**
 * NotificacionDAO.java
 * Fecha de creaci�n: 04/11/2015, 17:47:34
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
package mx.ine.sscc.servicios.siirfe.dao;

import mx.ine.sscc.modelo.entidad.siirfe.Notificacion;

/**
 * Interfaz para notificacion y su guardadoo
 * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface NotificacionDAO {

    /**
     * TODO Funci�n que guarda una notificaci�n en base
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @param notificacion
     */
    void guardaNotificacion(Notificacion notificacion);

}
