/**
 * Respuestas.java
 * Fecha de creación: 10/12/2015, 12:10:47
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
package mx.ine.sscc.modelo.entidad.unicom;

import java.io.Serializable;
import java.util.Date;

/**
 * clase que representa la tabla RESPUESTAS
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class Respuestas implements Serializable {

    private static final long serialVersionUID = 7855548575493480326L;
    private RespuestasPK id;
    private Archivo archivo;

    private SituacionRegistral situacionRegistral;

    private Preguntas preguntas;
    private Hechos hechos;
    private Boolean respAfirmativa;

    private Date fechaAlta;
    private String estatus;
    private Integer respAnio;
    private String respNombre;
    private String respApellidoP;
    private String respApellidoM;
    private String respEntNac;
    private Date respFecNac;

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */

    public Respuestas() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @return el atributo id
     */
    public RespuestasPK getId() {
        return id;
    }

    /**
     * @param id parametro id a actualizar
     */
    public void setId(RespuestasPK id) {
        this.id = id;
    }

    /**
     * @return el atributo archivo
     */
    public Archivo getArchivo() {
        return archivo;
    }

    /**
     * @param archivo parametro archivo a actualizar
     */
    public void setArchivo(Archivo archivo) {
        this.archivo = archivo;
    }

    /**
     * @return el atributo situacionRegistral
     */
    public SituacionRegistral getSituacionRegistral() {
        return situacionRegistral;
    }

    /**
     * @param situacionRegistral parametro situacionRegistral a actualizar
     */
    public void setSituacionRegistral(SituacionRegistral situacionRegistral) {
        this.situacionRegistral = situacionRegistral;
    }

    /**
     * @return el atributo preguntas
     */
    public Preguntas getPreguntas() {
        return preguntas;
    }

    /**
     * @param preguntas parametro preguntas a actualizar
     */
    public void setPreguntas(Preguntas preguntas) {
        this.preguntas = preguntas;
    }

    /**
     * @return el atributo hechos
     */
    public Hechos getHechos() {
        return hechos;
    }

    /**
     * @param hechos parametro hechos a actualizar
     */
    public void setHechos(Hechos hechos) {
        this.hechos = hechos;
    }

    /**
     * @return el atributo respAfirmativa
     */
    public Boolean getRespAfirmativa() {
        return respAfirmativa;
    }

    /**
     * @param respAfirmativa parametro respAfirmativa a actualizar
     */
    public void setRespAfirmativa(Boolean respAfirmativa) {
        this.respAfirmativa = respAfirmativa;
    }

    /**
     * @return el atributo fechaAlta
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * @param fechaAlta parametro fechaAlta a actualizar
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
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
     * @return el atributo respAnio
     */
    public Integer getRespAnio() {
        return respAnio;
    }

    /**
     * @param respAnio parametro respAnio a actualizar
     */
    public void setRespAnio(Integer respAnio) {
        this.respAnio = respAnio;
    }

    /**
     * @return el atributo respNombre
     */
    public String getRespNombre() {
        return respNombre;
    }

    /**
     * @param respNombre parametro respNombre a actualizar
     */
    public void setRespNombre(String respNombre) {
        this.respNombre = respNombre;
    }

    /**
     * @return el atributo respApellidoP
     */
    public String getRespApellidoP() {
        return respApellidoP;
    }

    /**
     * @param respApellidoP parametro respApellidoP a actualizar
     */
    public void setRespApellidoP(String respApellidoP) {
        this.respApellidoP = respApellidoP;
    }

    /**
     * @return el atributo respApellidoM
     */
    public String getRespApellidoM() {
        return respApellidoM;
    }

    /**
     * @param respApellidoM parametro respApellidoM a actualizar
     */
    public void setRespApellidoM(String respApellidoM) {
        this.respApellidoM = respApellidoM;
    }

    /**
     * @return el atributo respEntNac
     */
    public String getRespEntNac() {
        return respEntNac;
    }

    /**
     * @param respEntNac parametro respEntNac a actualizar
     */
    public void setRespEntNac(String respEntNac) {
        this.respEntNac = respEntNac;
    }

    /**
     * @return el atributo respFecNac
     */
    public Date getRespFecNac() {
        return respFecNac;
    }

    /**
     * @param respFecNac parametro respFecNac a actualizar
     */
    public void setRespFecNac(Date respFecNac) {
        this.respFecNac = respFecNac;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Respuestas [id=" + id + ", archivo=" + archivo + ", situacionRegistral="
            + situacionRegistral + ", preguntas=" + preguntas + ", hechos=" + hechos
            + ", respAfirmativa=" + respAfirmativa + ", fechaAlta=" + fechaAlta + ", estatus="
            + estatus + ", respAnio=" + respAnio + ", respNombre=" + respNombre
            + ", respApellidoP=" + respApellidoP + ", respApellidoM=" + respApellidoM
            + ", respEntNac=" + respEntNac + ", respFecNac=" + respFecNac + "]";
    }

}
