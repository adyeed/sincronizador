/**
 * UnicomDAO.java
 * Fecha de creación: Oct 28, 2015, 1:03:42 PM
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
package mx.ine.sscc.servicios.unicom.dao;

import java.sql.BatchUpdateException;
import java.sql.SQLDataException;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;

import mx.ine.sscc.modelo.entidad.unicom.AnalisisRegistralUnicom;
import mx.ine.sscc.modelo.entidad.unicom.ConsultaExternaUnicom;
import mx.ine.sscc.modelo.entidad.unicom.FuarExtranjeroUnicom;
import mx.ine.sscc.modelo.entidad.unicom.FuarRechazadoUnicom;
import mx.ine.sscc.modelo.entidad.unicom.FuarUnicom;

/**
 * TODO [Agregar documentacion de la clase]
 *
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface UnicomDAO {

    /**
     * TODO [Agregar documentacion del método]
     *
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param analisisRegistralUnicom
     * @return void
     */
    void actualizaAnalisisRegistral(AnalisisRegistralUnicom analisisRegistralUnicom)
        throws DataAccessException;

    /**
     * TODO [Agregar documentacion del método]
     *
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param consultaExternaUnicom
     * @return void
     * @throws SQLDataException
     * @throws DataAccessException
     * @throws BatchUpdateException
     * @throws SQLException
     */
    void actualizaConsultaExterna(ConsultaExternaUnicom consultaExternaUnicom)
        throws DataAccessException;

    /**
     * TODO [Agregar documentacion del método]
     *
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param fuarExtranjeroUnicom
     * @return void
     */
    void actualizaFuarExtranjero(FuarExtranjeroUnicom fuarExtranjeroUnicom)
        throws DataAccessException;

    /**
     * TODO [Agregar documentacion del método]
     *
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param fuarRechazadoUnicom
     * @return void
     */
    void actualizaFuarRechazadoUnicom(FuarRechazadoUnicom fuarRechazadoUnicom)
        throws DataAccessException;

    /**
     * TODO [Agregar documentacion del método]
     *
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param fuarUnicom
     * @return void
     */
    void actualizaFuarUnicom(FuarUnicom fuarUnicom) throws DataAccessException;

    /**
     * TODO [Agregar documentacion del método]
     *
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param fuarRechazadoUnicom
     */
    void guardaFuarRechazadoUnicom(FuarRechazadoUnicom fuarRechazadoUnicom)
        throws DataAccessException;

}
