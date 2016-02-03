/**
 * FuarExtranjeroDAOImple.java

 * Fecha de creación: 21/12/2015, 16:08:30
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

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.entidad.unicom.FuarExtranjeroUnicom;
import mx.ine.sscc.servicios.unicom.dao.FuarExtranjeroDAO;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("fuarExtranjeroDAO")
@Transactional
public class FuarExtranjeroDAOImpl extends GenericHibernateDAOImpl
    implements FuarExtranjeroDAO {

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.unicom.dao.FuarExtranjeroDAO#getFuarExtranjero(java.lang.String)
     */
    @Override
    public FuarExtranjeroUnicom getFuarExtranjero(String fuar) throws DataAccessException {
        Criteria criteria = construyeCriteria(FuarExtranjeroUnicom.class);
        criteria.add(Restrictions.eq("fuar", fuar));
        return (FuarExtranjeroUnicom) criteria.uniqueResult();
    }
}
