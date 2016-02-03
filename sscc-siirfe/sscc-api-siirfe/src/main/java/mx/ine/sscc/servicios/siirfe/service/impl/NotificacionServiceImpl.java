/**
 * NotificacionServiceImpl.java
 * Fecha de creación: 28/11/2015, 15:19:07
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

package mx.ine.sscc.servicios.siirfe.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.entidad.siirfe.Notificacion;
import mx.ine.sscc.servicios.siirfe.dao.NotificacionDAO;
import mx.ine.sscc.servicios.siirfe.service.NotificacionService;

/**
 * TODO Implementa NotificacionService
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Resource
    private NotificacionDAO notificacionDAO;

    /*
     * La documentación de este método se encuentra en
     * la clase o interface que lo declara (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.NotificacionService#guardaNotificacion(mx.ine.sscc.modelo.entidad.siirfe.Notificacion)
     */
    @Override
    public void guardaNotificacion(Notificacion notificacion) {
        // TODO [codificar el cuerpo del método]
        notificacionDAO.guardaNotificacion(notificacion);

    }

}
