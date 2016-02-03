/**
 * NotificacionDAOImpl.java
 * Fecha de creaci�n: 04/11/2015, 17:54:06
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
package mx.ine.sscc.servicios.siirfe.dao.impl;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.entidad.siirfe.Notificacion;
import mx.ine.sscc.servicios.siirfe.dao.NotificacionDAO;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO Implementaci�n del cuardado en bd
 * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("notificacionDAO")
@Transactional
public class NotificacionDAOImpl extends GenericHibernateDAOImpl implements NotificacionDAO {

    /*
     * La documentaci�n de este m�todo se encuentra en 
     * la clase o interface que lo declara (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.dao.NotificacionDAO#guardaNotificacion(mx.ine.sscc.modelo.entidad.siirfe.NotificacionDAO)
     */
    @Override
    public void guardaNotificacion(Notificacion notificacion) throws DataAccessException {
        saveOrUpdate(notificacion);
    }
}