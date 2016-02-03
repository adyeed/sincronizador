/**
 * ReenvioDAOImpl.java
 * Fecha de creación: 10/12/2015, 13:02:25
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
package mx.ine.sscc.servicios.unicom.dao.hibernate;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.entidad.Reenvio;
import mx.ine.sscc.servicios.unicom.dao.ReenvioDAO;

/**
 * Interfaz de acceso a datos para reenvio
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("reenvioDAO")
@Transactional
public class ReenvioDAOImpl extends GenericHibernateDAOImpl implements ReenvioDAO {

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ReenvioDAO#getReenvio()
     */
    @Override
    public Reenvio getReenvio() throws DataAccessException {
        Reenvio reenvio = new Reenvio();

        Criteria criteria = construyeCriteria(Reenvio.class);
        criteria.add(
            Restrictions.eq("estatusEnvio", TipoControlSincronizacion.PENDIENTE.getClave()));
        criteria.setFirstResult(0);
        criteria.setMaxResults(1);

        if (criteria.list() != null) {
            reenvio = (Reenvio) criteria.list().get(0);

            if (reenvio != null) {
                reenvio.setFechaActualizacion(new Date());
                reenvio.setEstatusEnvio(TipoControlSincronizacion.ENVIADO.getClave());
                update(reenvio);
            }
        }
        return reenvio;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ReenvioDAO#updateEstatus(java.lang.String,
     * java.util.Date)
     */
    @Override
    public void updateEstatus(String folio, Date fechaEnvio, String estatus,
        String nuevoEstatus) throws DataAccessException {
        update(
            "UPDATE Reenvio set estatusEnvio=? where folioSi=? and fechaEnvio=?  and estatusEnvio=?",
            nuevoEstatus, folio, fechaEnvio, estatus);
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ReenvioDAO#getDatosDisponibles()
     */
    @Override
    public long getDatosDisponibles() throws DataAccessException {
        // TODO [codificar el cuerpo del método]
        Criteria criteria = construyeCriteria(Reenvio.class);
        criteria.setProjection(Projections.rowCount());
        criteria.add(
            Restrictions.eq("estatusEnvio", TipoControlSincronizacion.PENDIENTE.getClave()));
        return (Long) criteria.uniqueResult();
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ReenvioDAO#update(mx.ine.sscc.modelo.entidad.Reenvio)
     */
    @Override
    public void update(Reenvio reenvio) throws DataAccessException {
        // TODO [codificar el cuerpo del método]
        saveOrUpdate(reenvio);
    }

}
