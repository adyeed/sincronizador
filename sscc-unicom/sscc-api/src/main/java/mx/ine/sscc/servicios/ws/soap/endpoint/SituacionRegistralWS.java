/**
 *
 * Fecha de creaci�n: Dec 18, 2015, 12:33:54 PM
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

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import mx.ine.sscc.modelo.bean.RespuestaSituacionRegistral;
import mx.ine.sscc.modelo.entidad.Respuestas;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@WebService
public interface SituacionRegistralWS {
    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param respuestasList
     * @return
     */
    @WebMethod
    public RespuestaSituacionRegistral guardaSituacionRegistral(List<Respuestas> respuestasList);
}
