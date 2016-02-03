/**
 * NotificacionDAO.java
 * Fecha de creación: 04/11/2015, 17:47:34
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Nacional Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */
package mx.ine.sscc.servicios.siirfe.dao;

import mx.ine.sscc.modelo.entidad.siirfe.Notificacion;

/**
 * Interfaz para notificacion y su guardadoo
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface NotificacionDAO {

    /**
     * TODO Función que guarda una notificación en base
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param notificacion
     */
    void guardaNotificacion(Notificacion notificacion);

}
