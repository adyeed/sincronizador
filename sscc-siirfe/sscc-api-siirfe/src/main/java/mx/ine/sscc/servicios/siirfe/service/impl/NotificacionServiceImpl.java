/**
 * NotificacionServiceImpl.java
 * Fecha de creaci�n: 28/11/2015, 15:19:07
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

package mx.ine.sscc.servicios.siirfe.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.entidad.siirfe.Notificacion;
import mx.ine.sscc.servicios.siirfe.dao.NotificacionDAO;
import mx.ine.sscc.servicios.siirfe.service.NotificacionService;

/**
 * TODO Implementa NotificacionService
 * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Resource
    private NotificacionDAO notificacionDAO;

    /*
     * La documentaci�n de este m�todo se encuentra en
     * la clase o interface que lo declara (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.NotificacionService#guardaNotificacion(mx.ine.sscc.modelo.entidad.siirfe.Notificacion)
     */
    @Override
    public void guardaNotificacion(Notificacion notificacion) {
        // TODO [codificar el cuerpo del m�todo]
        notificacionDAO.guardaNotificacion(notificacion);

    }

}
