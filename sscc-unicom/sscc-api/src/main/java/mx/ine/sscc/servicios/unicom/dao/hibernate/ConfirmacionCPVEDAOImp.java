/**
 * ConfirmacionCPVEDAOImp.java
 * Fecha de creación: 09/12/2015, 13:29:40
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
     * La documentación de este método se encuentra en la clase o interface que lo declara
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
     * La documentación de este método se encuentra en la clase o interface que lo declara
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
     * La documentación de este método se encuentra en la clase o interface que lo declara
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

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO#getDatosDisponibles()
     */
    @Override
    public long getDatosDisponibles() {
        // TODO [codificar el cuerpo del método]
        Criteria criteria = construyeCriteria(ConfirmacionCPVE.class);
        criteria.setProjection(Projections.rowCount());
        criteria.add(
            Restrictions.eq("estatusEnvio", TipoControlSincronizacion.PENDIENTE.getClave()));
        return (Long) criteria.uniqueResult();
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO#update(mx.ine.sscc.modelo.entidad.ConfirmacionCPVE)
     */
    @Override
    public void update(ConfirmacionCPVE confirmacionCPVE) throws DataAccessException {
        // TODO [codificar el cuerpo del método]
        saveOrUpdate(confirmacionCPVE);
    }

}
