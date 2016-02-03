/**
 *
NotificacionWS.java
 * Fecha de creaci�n: Dec 18, 2015, 12:33:54 PM
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
package mx.ine.sscc.servicios.ws.soap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;

import mx.ine.sscc.modelo.bean.NotificacionDTO;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@WebService
public interface NotificacionWS {

    /**
     * TODO [Agregar documentacion del m�todo]
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @param notificacion
     * @return
     */
    @WebMethod
    public int guardaNotificacion(NotificacionDTO notificacion);
}
