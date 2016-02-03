/**
 * Preguntas.java
 * Fecha de creación: 08/12/2015, 16:24:19
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

/**
 * clase que representa a la tabla PREGUNTAS
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 3207627409391270663L;
    private PreguntasPK id;
    private String descripcion;
    private Boolean activo;
    private Boolean reqCandidatos;
    private Boolean reqArchivo;
    private Short tipoId;

    /**
     * @return el atributo id
     */
    public PreguntasPK getId() {
        return id;
    }

    /**
     * @param id parametro id a actualizar
     */
    public void setId(PreguntasPK id) {
        this.id = id;
    }

    /**
     * @return el atributo descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion parametro descripcion a actualizar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return el atributo activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @param activo parametro activo a actualizar
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return el atributo reqCandidatos
     */
    public Boolean getReqCandidatos() {
        return reqCandidatos;
    }

    /**
     * @param reqCandidatos parametro reqCandidatos a actualizar
     */
    public void setReqCandidatos(Boolean reqCandidatos) {
        this.reqCandidatos = reqCandidatos;
    }

    /**
     * @return el atributo reqArchivo
     */
    public Boolean getReqArchivo() {
        return reqArchivo;
    }

    /**
     * @param reqArchivo parametro reqArchivo a actualizar
     */
    public void setReqArchivo(Boolean reqArchivo) {
        this.reqArchivo = reqArchivo;
    }

    /**
     * @return el atributo tipoId
     */
    public Short getTipoId() {
        return tipoId;
    }

    /**
     * @param tipoId parametro tipoId a actualizar
     */
    public void setTipoId(Short tipoId) {
        this.tipoId = tipoId;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Preguntas [id=" + id + ", descripcion=" + descripcion + ", activo=" + activo
            + ", reqCandidatos=" + reqCandidatos + ", reqArchivo=" + reqArchivo + ", tipoId="
            + tipoId + "]";
    }

}
