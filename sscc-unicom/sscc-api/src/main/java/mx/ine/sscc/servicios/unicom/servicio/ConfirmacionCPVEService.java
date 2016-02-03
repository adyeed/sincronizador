/**
 * ConfirmacionCPVEService.java
 * Fecha de creación: 16/12/2015, 19:02:31
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

package mx.ine.sscc.servicios.unicom.servicio;

import mx.ine.sscc.modelo.entidad.ConfirmacionCPVE;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface ConfirmacionCPVEService {

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @return ConfirmacionCPVE
     */
    ConfirmacionCPVE obtieneConfirmacionCPVE();

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @return registros listos para procesar.
     */
    long datosDisponibles();

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param folio
     * @param estatus
     * @param nuevoEstatus
     */
    void actualizaEstatus(String folio, String estatus, String nuevoEstatus);

}
