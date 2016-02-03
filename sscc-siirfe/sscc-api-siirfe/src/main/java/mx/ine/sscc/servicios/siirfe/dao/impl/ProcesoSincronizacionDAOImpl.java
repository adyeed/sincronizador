/**
 * FuarSiirfeDAOImpl.java
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

import org.hibernate.exception.GenericJDBCException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.entidad.siirfe.ProcesoSincronizacion;
import mx.ine.sscc.servicios.siirfe.dao.ProcesoSincronizacionDAO;

/**
 * Implementacion de acceso a datos para Fuar
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("procesoSincronizacionDAO")
@Transactional
public class ProcesoSincronizacionDAOImpl extends GenericHibernateDAOImpl
    implements ProcesoSincronizacionDAO {

    /**
     *
     */
    @Override
    public ProcesoSincronizacion guardaBitacora(ProcesoSincronizacion procesoSincronizacion)
        throws DataAccessException {
        save(procesoSincronizacion);
        return procesoSincronizacion;
    }

    @Override
    public ProcesoSincronizacion actualizaBitacora(ProcesoSincronizacion procesoSincronizacion)
        throws DataAccessException {
        saveOrUpdate(procesoSincronizacion);
        return procesoSincronizacion;
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.dao.ProcesoSincronizacionDAO#getBitacora(java.lang.Long)
     */

    @Override
    public ProcesoSincronizacion getBitacora(Long id) throws GenericJDBCException {
        return get(ProcesoSincronizacion.class, id);
    }

}
