/**
 *
NotificacionWS.java
 * Fecha de creación: Dec 18, 2015, 12:33:54 PM
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
package mx.ine.sscc.servicios.ws.soap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import mx.ine.sscc.modelo.bean.NotificacionDTO;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@WebService
public interface NotificacionWS {

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param notificacion
     * @return
     */
    @WebMethod
    public int guardaNotificacion(NotificacionDTO notificacion);
}
