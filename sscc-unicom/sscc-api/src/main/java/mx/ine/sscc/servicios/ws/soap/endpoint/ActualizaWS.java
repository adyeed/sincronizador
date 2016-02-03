/**
 * ActualizaWS.java
 * Fecha de creación: Nov 3, 2015, 5:25:01 PM
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
package mx.ine.sscc.servicios.ws.soap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ActualizaWS {

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaAnalisis(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaConsulta(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaFuarExtr(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaFuarRech(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaFuar(DatosEntrada datosEntrada);

}
