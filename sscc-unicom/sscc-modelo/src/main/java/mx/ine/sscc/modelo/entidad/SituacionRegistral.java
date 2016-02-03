/**
 * SituacionRegistral.java
 * Fecha de creación: 08/12/2015, 14:01:14
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
package mx.ine.sscc.modelo.entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Proxy;

/**
 * clase que representa a la tabla SITUACIONREGISTRAL
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Proxy(lazy = false)
public class SituacionRegistral implements Serializable {

    /**
     * TODO [Agregar documentación del atributo]
     */

    private static final long serialVersionUID = 1L;
    private SituacionRegistralPK id;
    private Cuestionario cuestionario;
    private EstatusSituacionRegistral estatuSituacionRegistral;
    private Date fechaUltimaAct;
    private Date fechaInicio;
    private Date fechaLimite;
    private Date fechaActualizacion;
    private String estatus;
    private List<Respuestas> respuestases;

    /**
     * TODO [Agregar documentacion del método]
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     */
    private SituacionRegistral() {

    }

    /**
     * @return el atributo id
     */
    public SituacionRegistralPK getId() {
        return id;
    }

    /**
     * @param id parametro id a actualizar
     */
    public void setId(SituacionRegistralPK id) {
        this.id = id;
    }

    /**
     * @return el atributo cuestionario
     */
    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    /**
     * @param cuestionario parametro cuestionario a actualizar
     */
    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    /**
     * @return el atributo estatuSituacionRegistral
     */
    public EstatusSituacionRegistral getEstatuSituacionRegistral() {
        return estatuSituacionRegistral;
    }

    /**
     * @param estatuSituacionRegistral parametro estatuSituacionRegistral a actualizar
     */
    public void setEstatuSituacionRegistral(EstatusSituacionRegistral estatuSituacionRegistral) {
        this.estatuSituacionRegistral = estatuSituacionRegistral;
    }

    /**
     * @return el atributo fechaUltimaAct
     */
    public Date getFechaUltimaAct() {
        return fechaUltimaAct;
    }

    /**
     * @param fechaUltimaAct parametro fechaUltimaAct a actualizar
     */
    public void setFechaUltimaAct(Date fechaUltimaAct) {
        this.fechaUltimaAct = fechaUltimaAct;
    }

    /**
     * @return el atributo fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio parametro fechaInicio a actualizar
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return el atributo fechaLimite
     */
    public Date getFechaLimite() {
        return fechaLimite;
    }

    /**
     * @param fechaLimite parametro fechaLimite a actualizar
     */
    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    /**
     * @return el atributo fechaActualizacion
     */
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * @param fechaActualizacion parametro fechaActualizacion a actualizar
     */
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * @return el atributo estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus parametro estatus a actualizar
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * @return el atributo respuestases
     */
    public List<Respuestas> getRespuestases() {
        return respuestases;
    }

    /**
     * @param respuestases parametro respuestases a actualizar
     */
    public void setRespuestases(List<Respuestas> respuestases) {
        this.respuestases = respuestases;
    }

}