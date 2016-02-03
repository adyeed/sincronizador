/**
 * ConsultaExternaSiirfeDAOImpl.java
 * Fecha de creaci�n: 04/11/2015, 17:48:57
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

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.entidad.siirfe.ConsultaExternaSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.ConsultaExternaSiirfeDAO;
import mx.ine.sscc.servicios.util.PropertiesFile;

/**
 * Implementacion de acceso a datos para Consulta Externa
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("consultaExternaSiirfeDAO")
@Transactional
public class ConsultaExternaSiirfeDAOImpl extends GenericHibernateDAOImpl
    implements ConsultaExternaSiirfeDAO {

    private int bloqueSize;

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.dao.ConsultaExternaSiirfeDAO#getConsultaExterna()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<ConsultaExternaSiirfe> getConsultaExterna() throws DataAccessException {
        obtieneBloque();
        Criteria criteria = construyeCriteria(ConsultaExternaSiirfe.class);
        criteria.add(Restrictions.eq("controlSincronizacion",
            TipoControlSincronizacion.PENDIENTE.getClave()));
        criteria.setFirstResult(0);
        criteria.setMaxResults(getBloqueSize());
        return criteria.list();
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.dao.ConsultaExternaSiirfeDAO#updateConsultaExternaById(
     * java.lang.Long, java.lang.String)
     */
    @Override
    public void updateConsultaExternaById(Long idCiudadano, String controlSincronizacion,
        Long bitacoraId) throws DataAccessException {
        update(
            "UPDATE ConsultaExternaSiirfe set controlSincronizacion=?,procesoSincronizacionId=?"
                + " where ciudadanoId=? ",
            controlSincronizacion, bitacoraId, idCiudadano);

    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.dao.ConsultaExternaSiirfeDAO#hasAvailableRecords()
     */

    @Override
    public long hasAvailableRecords() throws DataAccessException {
        // TODO [codificar el cuerpo del m�todo]
        Criteria criteria = construyeCriteria(ConsultaExternaSiirfe.class);
        criteria.setProjection(Projections.rowCount());
        criteria.add(Restrictions.eq("controlSincronizacion",
            TipoControlSincronizacion.PENDIENTE.getClave()));
        return (Long) criteria.uniqueResult();

    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.dao.AnalisisRegistralSiirfeDAO#updateAnalisisRegistralBySincId(java.lang.Long)
     */

    @Override
    public void updateConsultaExtBySincId(String controlSincronizacion, Long bitacoraId)
        throws DataAccessException {
        // TODO [codificar el cuerpo del m�todo]
        update(
            "UPDATE ConsultaExternaSiirfe set controlSincronizacion = ?"
                + " where procesoSincronizacionId = ? and controlSincronizacion ='E' ",
            controlSincronizacion, bitacoraId);
    }

    private void obtieneBloque() {
        try {
            String aux =
                PropertiesFile.getFilepropiedad().getProperty("siirfe.sincro.tama�o.bloque");
            setBloqueSize(Integer.parseInt(aux));
        } catch (Exception e) {
            // TODO: handle exception
            setBloqueSize(200);
        }
    }

    /**
     * @return el atributo bloqueSize
     */

    public int getBloqueSize() {
        return bloqueSize;
    }

    /**
     * @param bloqueSize parametro bloqueSize a actualizar
     */
    public void setBloqueSize(int bloqueSize) {
        this.bloqueSize = bloqueSize;
    }
}
