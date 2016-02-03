/**
 * SituacionRegistralDAOImpl.java
 * Fecha de creaci�n: 10/12/2015, 13:00:58
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

import javax.xml.ws.http.HTTPException;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.entidad.SituacionRegistral;
import mx.ine.sscc.modelo.entidad.SituacionRegistralPK;
import mx.ine.sscc.servicios.unicom.dao.SituacionRegistralDAO;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("situacionRegistralDAO")
@Transactional(noRollbackFor = { HTTPException.class })
public class SituacionRegistralDAOImpl extends GenericHibernateDAOImpl
    implements SituacionRegistralDAO {

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.SituacionRegistralDAO#getSituacion()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<SituacionRegistral> getSituacion() {
        List<SituacionRegistral> situacionList;
        Criteria criteria = construyeCriteria(SituacionRegistral.class);
        criteria.createCriteria("respuestases.preguntas");
        criteria.createCriteria("respuestases.archivo");
        criteria.createCriteria("respuestases.hechos");
        criteria
            .add(Restrictions.eq("estatus", TipoControlSincronizacion.PENDIENTE.getClave()));
        criteria.setFirstResult(0);
        criteria.setMaxResults(1);
        situacionList = criteria.list();
        return updateSituacion(situacionList, TipoControlSincronizacion.ENVIADO.getClave());

    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.unicom.dao.SituacionRegistralDAO#updateEstatus(mx.ine.sscc.modelo
     * .entidad.SituacionRegistralPK, java.lang.String, java.lang.String)
     */
    @Override
    public void updateEstatusSituacionRegistral(SituacionRegistralPK id, String estatus,
        String nuevoEstatus) throws DataAccessException {
        update(
            "UPDATE SituacionRegistral set estatus=?, fechaActualizacion=? where id=? and estatus=? ",
            nuevoEstatus, new Date(), id.getFolioSi(), estatus);

    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.SituacionRegistralDAO#getDatosDisponibles()
     */
    @Override
    public long getDatosDisponibles() throws DataAccessException {

        Criteria criteria = construyeCriteria(SituacionRegistral.class);
        criteria.setProjection(Projections.rowCount());
        criteria
            .add(Restrictions.eq("estatus", TipoControlSincronizacion.PENDIENTE.getClave()));
        return (Long) criteria.uniqueResult();
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.dao.SituacionRegistralDAO#update(java.util.List)
     */
    @Override
    public List<SituacionRegistral> updateSituacion(
        List<SituacionRegistral> situacionRegistralList, String estatus) {
        // TODO [codificar el cuerpo del m�todo]
        for (SituacionRegistral situacionRegistral : situacionRegistralList) {
            situacionRegistral.setFechaActualizacion(new Date());
            situacionRegistral.setEstatus(estatus);
            saveOrUpdate(situacionRegistral);
        }

        return situacionRegistralList;
    }

}
