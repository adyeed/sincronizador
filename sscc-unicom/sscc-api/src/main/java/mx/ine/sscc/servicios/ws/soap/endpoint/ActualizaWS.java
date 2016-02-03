/**
 * ActualizaWS.java
 * Fecha de creaci�n: Nov 3, 2015, 5:25:01 PM
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
package mx.ine.sscc.servicios.ws.soap.endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ActualizaWS {

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaAnalisis(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaConsulta(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaFuarExtr(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaFuarRech(DatosEntrada datosEntrada);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     */
    @WebMethod
    public RespuestaSincronizacion actualizaFuar(DatosEntrada datosEntrada);

}
