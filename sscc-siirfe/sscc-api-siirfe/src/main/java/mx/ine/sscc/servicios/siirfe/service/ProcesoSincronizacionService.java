/**
 * ConsultasService.java
 * Fecha de creación: 28/10/2015, 14:33:15
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */

package mx.ine.sscc.servicios.siirfe.service;

import mx.ine.sscc.modelo.entidad.siirfe.ProcesoSincronizacion;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
public interface ProcesoSincronizacionService {

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param bitacora
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion guardaBitacora(ProcesoSincronizacion bitacora);

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param bitacora
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion actualizaBitacora(ProcesoSincronizacion bitacora);

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param id
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion getBitacora(Long id);

}
