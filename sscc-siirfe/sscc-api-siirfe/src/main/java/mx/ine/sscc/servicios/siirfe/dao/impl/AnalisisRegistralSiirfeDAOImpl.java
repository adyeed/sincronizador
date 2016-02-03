/**
 * AnalisisRegistralSiirfeDAOImpl.java
 * Fecha de creaci�n: 04/11/2015, 17:32:34
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
import mx.ine.sscc.modelo.entidad.siirfe.AnalisisRegistralSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.AnalisisRegistralSiirfeDAO;
import mx.ine.sscc.servicios.util.PropertiesFile;

/**
 * Implementacion de acceso a datos para analisis registral
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("analisisRegistralSiirfeDAO")
@Transactional
public class AnalisisRegistralSiirfeDAOImpl extends GenericHibernateDAOImpl
    implements AnalisisRegistralSiirfeDAO {

    private int bloqueSize;

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.dao.AnalisisRegistralSiirfeDAO#getAnalisisRegistralSiirfe()
     */
    @Override
    public List<AnalisisRegistralSiirfe> getAnalisisRegistralSiirfe()
        throws DataAccessException {
        obtieneBloque();
        Criteria criteria = construyeCriteria(AnalisisRegistralSiirfe.class);
        criteria.add(Restrictions.and(
            Restrictions.eq("controlSincronizacion",
                TipoControlSincronizacion.PENDIENTE.getClave()),
            Restrictions.isNotNull("ciudadanoId")));
        criteria.setFirstResult(0);
        criteria.setMaxResults(getBloqueSize());

        return criteria.list();
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.dao.AnalisisRegistralSiirfeDAO#updateAnalisisRegistralByFuar
     * (java.lang.String)
     */
    @Override
    public void updateAnalisisRegistralByCiudadanoId(Long ciudadanoId,
        String controlSincronizacion, Long bitacoraId) throws DataAccessException {

        int aux = update(
            "UPDATE AnalisisRegistralSiirfe set controlSincronizacion=?, procesoSincronizacionId=?"
                + " where ciudadanoId=? ",
            controlSincronizacion, bitacoraId, ciudadanoId);
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.dao.AnalisisRegistralSiirfeDAO#hasAvailableRecords()
     */

    @Override
    public long hasAvailableRecords() throws DataAccessException {
        // TODO [codificar el cuerpo del m�todo]
        Criteria criteria = construyeCriteria(AnalisisRegistralSiirfe.class);
        criteria.setProjection(Projections.rowCount());
        criteria.add(Restrictions.and(
            Restrictions.eq("controlSincronizacion",
                TipoControlSincronizacion.PENDIENTE.getClave()),
            Restrictions.isNotNull("ciudadanoId")));
        return (Long) criteria.uniqueResult();

    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.dao.AnalisisRegistralSiirfeDAO#updateAnalisisRegistralBySincId(java.lang.Long)
     */

    @Override
    public void updateAnalisisRegistralBySincId(String controlSincronizacion, Long bitacoraId)
        throws DataAccessException {
        // TODO [codificar el cuerpo del m�todo]
        // El cambio de codigo para el update se hizo debido que en el anterior hibernate
        // arroja un mensaje de que esa forma de enviar parametros esta deprecada.
        update(
            "UPDATE AnalisisRegistralSiirfe set controlSincronizacion = ?"
                + " where controlSincronizacion = 'E' and procesoSincronizacionId = ? ",
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
