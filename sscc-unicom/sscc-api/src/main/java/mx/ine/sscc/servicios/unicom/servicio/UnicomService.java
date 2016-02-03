/**
 * UnicomService.java
 * Fecha de creación: Oct 28, 2015, 12:49:47 PM
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
package mx.ine.sscc.servicios.unicom.servicio;

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;

/**
 * TODO [Agregar documentacion de la clase]
 *
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface UnicomService {

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaAnalisis(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaConsulta(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaFuarRech(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaFuarExtr(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaFuar(DatosEntrada datosEntrada);

}
