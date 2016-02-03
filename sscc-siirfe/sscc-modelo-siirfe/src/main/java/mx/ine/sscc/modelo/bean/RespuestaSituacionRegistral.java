/**
 * StiacionDTO.java
 * Fecha de creación: 06/01/2016, 10:26:01
 *
 * Copyright (c) 2016 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */

package mx.ine.sscc.modelo.bean;

import java.io.Serializable;
import java.util.List;

import mx.ine.sscc.modelo.entidad.unicom.Respuestas;
import mx.ine.sscc.modelo.entidad.unicom.SituacionRegistral;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public class RespuestaSituacionRegistral implements Serializable {

    /**
     * TODO [Agregar documentación del atributo]
     */
    private static final long serialVersionUID = 1L;

    /**
     * TODO [Agregar documentación del atributo]
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
