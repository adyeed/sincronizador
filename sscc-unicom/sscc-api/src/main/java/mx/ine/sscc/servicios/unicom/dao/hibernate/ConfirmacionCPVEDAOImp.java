/**
 * ConfirmacionCPVEDAOImp.java
 * Fecha de creaci�n: 09/12/2015, 13:29:40
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
package mx.ine.sscc.servicios.unicom.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.entidad.ConfirmacionCPVE;
import mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("confirmacionCPVEDAO")
@Transactional
public class ConfirmacionCPVEDAOImp extends GenericHibernateDAOImpl
    implements ConfirmacionCPVEDAO {

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO#getConfirmacionCPVE()
     */
    @Override
    public List<ConfirmacionCPVE> getListConfirmacionCPVE() throws DataAccessException {
        Criteria criteria = construyeCriteria(ConfirmacionCPVE.class);
        criteria.add(
            Restrictions.eq("estatusEnvio", TipoControlSincronizacion.PENDIENTE.getClave()));
        return criteria.list();
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO#getConfirmacionCPVE()
     */
    @Override
    public ConfirmacionCPVE getConfirmacionCPVE() throws DataAccessException {
        Criteria criteria = construyeCriteria(ConfirmacionCPVE.class);
        criteria.add(
            Restrictions.eq("estatusEnvio", TipoControlSincronizacion.PENDIENTE.getClave()));
        ConfirmacionCPVE confirmacionCPVE = (ConfirmacionCPVE) criteria.list().get(0);

        confirmacionCPVE.setEstatusEnvio(TipoControlSincronizacion.ENVIADO.getClave());
        confirmacionCPVE.setFechaActualizacion(new Date());
        update(confirmacionCPVE);

        return confirmacionCPVE;
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO#updateEstatus(java.lang.String,
     * java.lang.String)
     */
    @Override
    public void updateEstatus(String folio, String estatus, String nuevoEstatus)
        throws DataAccessException {
        update(
            "UPDATE ConfirmacionCPVE set estatusEnvio=? where folioSi=?  and estatusEnvio=? ",
            nuevoEstatus, folio, estatus);

    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO#getDatosDisponibles()
     */
    @Override
    public long getDatosDisponibles() {
        // TODO [codificar el cuerpo del m�todo]
        Criteria criteria = construyeCriteria(ConfirmacionCPVE.class);
        criteria.setProjection(Projections.rowCount());
        criteria.add(
            Restrictions.eq("estatusEnvio", TipoControlSincronizacion.PENDIENTE.getClave()));
        return (Long) criteria.uniqueResult();
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO#update(mx.ine.sscc.modelo.entidad.ConfirmacionCPVE)
     */
    @Override
    public void update(ConfirmacionCPVE confirmacionCPVE) throws DataAccessException {
        // TODO [codificar el cuerpo del m�todo]
        saveOrUpdate(confirmacionCPVE);
    }

}
