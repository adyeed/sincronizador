/**
 * RespuestasDAOImpl.java
 * Fecha de creación: 28/12/2015, 18:26:13
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
package mx.ine.sscc.servicios.siirfe.dao.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import mx.ine.sscc.hibernate.comun.GenericHibernateDAOImpl;
import mx.ine.sscc.modelo.entidad.siirfe.RespuestasSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.RespuestasDAO;

/**
 * implementacion para el acceso a datos de respuestas
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Repository("respuestasDAO")
public class RespuestasDAOImpl extends GenericHibernateDAOImpl implements RespuestasDAO {

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.dao.RespuestasDAO#saveRespuesta(mx.ine.sscc.modelo.entidad
     * .siirfe.Respuestas)
     */
    @Override
    public void saveRespuesta(RespuestasSiirfe respuesta) throws DataAccessException {
        save(respuesta);
    }

}
