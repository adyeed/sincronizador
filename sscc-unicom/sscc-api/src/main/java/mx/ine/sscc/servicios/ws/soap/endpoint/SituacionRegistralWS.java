/**
 *
 * Fecha de creación: Dec 18, 2015, 12:33:54 PM
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

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import mx.ine.sscc.modelo.bean.RespuestaSituacionRegistral;
import mx.ine.sscc.modelo.entidad.Respuestas;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@WebService
public interface SituacionRegistralWS {
    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param respuestasList
     * @return
     */
    @WebMethod
    public RespuestaSituacionRegistral guardaSituacionRegistral(List<Respuestas> respuestasList);
}
