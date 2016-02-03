/**
 * StiacionDTO.java
 * Fecha de creaci�n: 06/01/2016, 10:26:01
 *
 * Copyright (c) 2016 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Federal Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */

package mx.ine.sscc.modelo.bean;

import java.io.Serializable;
import java.util.List;

import mx.ine.sscc.modelo.entidad.unicom.Respuestas;
import mx.ine.sscc.modelo.entidad.unicom.SituacionRegistral;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public class RespuestaSituacionRegistral implements Serializable {

    /**
     * TODO [Agregar documentaci�n del atributo]
     */
    private static final long serialVersionUID = 1L;

    /**
     * TODO [Agregar documentaci�n del atributo]
     */
    private List<SituacionRegistral> situacionRegistralList;

    private List<Respuestas> respuestas;

    private String mensajeError;

    /**
     * @return el atributo situacionRegistralList
     */

    public List<SituacionRegistral> getSituacionRegistralList() {
        return situacionRegistralList;
    }

    /**
     * @param situacionRegistralList parametro situacionRegistralList a actualizar
     */
    public void setSituacionRegistralList(List<SituacionRegistral> situacionRegistralList) {
        this.situacionRegistralList = situacionRegistralList;
    }

    /**
     * @return el atributo respuestas
     */
    public List<Respuestas> getRespuestas() {
        return respuestas;
    }

    /**
     * @param respuestas parametro respuestas a actualizar
     */
    public void setRespuestas(List<Respuestas> respuestas) {
        this.respuestas = respuestas;
    }

    /**
     * @return el atributo mensajeError
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * @param mensajeError parametro mensajeError a actualizar
     */
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

}
