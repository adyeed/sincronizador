/**
 * FuarSiirfeDAO.java
 * Fecha de creación: 04/11/2015, 17:47:34
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
package mx.ine.sscc.servicios.siirfe.dao;

import mx.ine.sscc.modelo.entidad.siirfe.ProcesoSincronizacion;

/**
 * Interfaz de acceso a datos para Fuar
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */

public interface ProcesoSincronizacionDAO {

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param procesoSincronizacion
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion guardaBitacora(ProcesoSincronizacion procesoSincronizacion);

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param procesoSincronizacion
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion actualizaBitacora(ProcesoSincronizacion procesoSincronizacion);

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param id
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion getBitacora(Long id);

}
