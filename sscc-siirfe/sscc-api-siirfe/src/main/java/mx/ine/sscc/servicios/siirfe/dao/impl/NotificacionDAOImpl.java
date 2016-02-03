/**
 * NotificacionDAOImpl.java
 * Fecha de creación: 04/11/2015, 17:54:06
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
package mx.ine.sscc.servicios.siirfe.dao.impl;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.entidad.siirfe.Notificacion;
import mx.ine.sscc.servicios.siirfe.dao.NotificacionDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO Implementación del cuardado en bd
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("notificacionDAO")
@Transactional
public class NotificacionDAOImpl extends GenericHibernateDAOImpl implements NotificacionDAO {

    /*
     * La documentación de este método se encuentra en 
     * la clase o interface que lo declara (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.dao.NotificacionDAO#guardaNotificacion(mx.ine.sscc.modelo.entidad.siirfe.NotificacionDAO)
     */
    @Override
    public void guardaNotificacion(Notificacion notificacion) throws DataAccessException {
        saveOrUpdate(notificacion);
    }
}