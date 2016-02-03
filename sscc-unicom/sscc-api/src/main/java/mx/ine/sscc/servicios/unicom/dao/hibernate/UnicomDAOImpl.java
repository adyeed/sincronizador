/**
 * UnicomDAOImpl.java
 * Fecha de creación: Oct 28, 2015, 1:04:39 PM
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

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.entidad.unicom.AnalisisRegistralUnicom;
import mx.ine.sscc.modelo.entidad.unicom.ConsultaExternaUnicom;
import mx.ine.sscc.modelo.entidad.unicom.FuarExtranjeroUnicom;
import mx.ine.sscc.modelo.entidad.unicom.FuarRechazadoUnicom;
import mx.ine.sscc.modelo.entidad.unicom.FuarUnicom;
import mx.ine.sscc.servicios.unicom.dao.UnicomDAO;

/**
 * TODO [Agregar documentacion de la clase]
 *
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */

@Repository("unicomDAO")
@Transactional
public class UnicomDAOImpl extends GenericHibernateDAOImpl implements UnicomDAO {

    /**
     *
     */
    @Override
    @Transactional
    public void actualizaAnalisisRegistral(AnalisisRegistralUnicom analisisRegistralUnicom)
        throws DataAccessException {
        // saveOrUpdate(analisisRegistralUnicom);
        saveOrUpdate(analisisRegistralUnicom);
    }

    /**
     *
     */
    @Override
    @Transactional
    public void actualizaConsultaExterna(ConsultaExternaUnicom consultaExternaUnicom)
        throws DataAccessException {
        saveOrUpdate(consultaExternaUnicom);
    }

    /**
     *
     */
    @Override
    @Transactional
    public void actualizaFuarExtranjero(FuarExtranjeroUnicom fuarExtranjeroUnicom)
        throws DataAccessException {
        saveOrUpdate(fuarExtranjeroUnicom);

    }

    /**
     *
     */
    @Override
    @Transactional
    public void actualizaFuarRechazadoUnicom(FuarRechazadoUnicom fuarRechazadoUnicom)
        throws DataAccessException {
        saveOrUpdate(fuarRechazadoUnicom);

    }

    /**
     *
     */
    @Override
    @Transactional
    public void actualizaFuarUnicom(FuarUnicom fuarUnicom) throws DataAccessException {
        saveOrUpdate(fuarUnicom);

    }

    @Override
    @Transactional
    public void guardaFuarRechazadoUnicom(FuarRechazadoUnicom fuarRechazadoUnicom)
        throws DataAccessException {
        saveOrUpdate(fuarRechazadoUnicom);
    }

}
