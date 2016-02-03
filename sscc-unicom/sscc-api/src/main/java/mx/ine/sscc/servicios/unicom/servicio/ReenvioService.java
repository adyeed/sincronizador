/**
 * ReenvioService.java
 * Fecha de creación: 16/12/2015, 19:22:28
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

import java.util.Date;

import mx.ine.sscc.modelo.entidad.Reenvio;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface ReenvioService {

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @return Reenvio
     */
    Reenvio obtieneReenvio();

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
     * @param fechaEnvio
     * @param estatus
     * @param nuevoEstatus
     */
    void actualizaEstatus(String folio, Date fechaEnvio, String estatus, String nuevoEstatus);
}
