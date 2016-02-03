/**
 * NotificacionService.java
 * Fecha de creaci�n: 27/11/2015, 14:12:07
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

package mx.ine.sscc.servicios.siirfe.service;

import mx.ine.sscc.modelo.entidad.siirfe.Notificacion;

import org.springframework.stereotype.Service;

/**
 * TODO Interfaz que guarda una notificacion
 * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Service
public interface NotificacionService {

    /**
     * TODO M�todo que guarda en bd
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @param notificacion
     */
    void guardaNotificacion(Notificacion notificacion);

}
