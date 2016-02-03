/**
 * UnicomService.java
 * Fecha de creaci�n: Oct 28, 2015, 12:49:47 PM
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
package mx.ine.sscc.servicios.unicom.servicio;

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;

/**
 * TODO [Agregar documentacion de la clase]
 *
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface UnicomService {

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaAnalisis(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaConsulta(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaFuarRech(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaFuarExtr(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    public RespuestaSincronizacion actualizaFuar(DatosEntrada datosEntrada);

}
