/**
 * NotificacionService.java
 * Fecha de creación: 27/11/2015, 14:12:07
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

package mx.ine.sscc.servicios.siirfe.service;

import mx.ine.sscc.modelo.entidad.siirfe.Notificacion;

import org.springframework.stereotype.Service;

/**
 * TODO Interfaz que guarda una notificacion
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Service
public interface NotificacionService {

    /**
     * TODO Método que guarda en bd
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param notificacion
     */
    void guardaNotificacion(Notificacion notificacion);

}
