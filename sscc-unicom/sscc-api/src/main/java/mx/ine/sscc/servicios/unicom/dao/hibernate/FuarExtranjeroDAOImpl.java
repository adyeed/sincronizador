/**
 * FuarExtranjeroDAOImple.java

 * Fecha de creaci�n: 21/12/2015, 16:08:30
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
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
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
