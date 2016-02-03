/**
 * Modulo.java
 * Fecha de creación: 04/11/2015, 16:26:28
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
package mx.ine.sscc.modelo.entidad.siirfe;

import java.io.Serializable;

/**
 * clase que representa a la tabla MODULO en el esquema de CONCILIACIONES del SIIRFE
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class Modulo implements Serializable {

    private static final long serialVersionUID = 131206290676746211L;
    private Long moduloId;
    private String modulo;
    private Integer entidad;
    private Integer distrito;
    private String fuarInicial;
    private String fuarFinal;
    private String anio;
    private String primerFuar;
    private String necInicial;
    private String necFinal;

    /**
     * @return el atributo moduloId
     */
    public Long getModuloId() {
        return moduloId;
    }

    /**
     * @param moduloId parametro moduloId a actualizar
     */
    public void setModuloId(Long moduloId) {
        this.moduloId = moduloId;
    }

    /**
     * @return el atributo modulo
     */
    public String getModulo() {
        return modulo;
    }

    /**
     * @param modulo parametro modulo a actualizar
     */
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    /**
     * @return el atributo entidad
     */
    public Integer getEntidad() {
        return entidad;
    }

    /**
     * @param entidad parametro entidad a actualizar
     */
    public void setEntidad(Integer entidad) {
        this.entidad = entidad;
    }

    /**
     * @return el atributo distrito
     */
    public Integer getDistrito() {
        return distrito;
    }

    /**
     * @param distrito parametro distrito a actualizar
     */
    public void setDistrito(Integer distrito) {
        this.distrito = distrito;
    }

    /**
     * @return el atributo fuarInicial
     */
    public String getFuarInicial() {
        return fuarInicial;
    }

    /**
     * @param fuarInicial parametro fuarInicial a actualizar
     */
    public void setFuarInicial(String fuarInicial) {
        this.fuarInicial = fuarInicial;
    }

    /**
     * @return el atributo fuarFinal
     */
    public String getFuarFinal() {
        return fuarFinal;
    }

    /**
     * @param fuarFinal parametro fuarFinal a actualizar
     */
    public void setFuarFinal(String fuarFinal) {
        this.fuarFinal = fuarFinal;
    }

    /**
     * @return el atributo anio
     */
    public String getAnio() {
        return anio;
    }

    /**
     * @param anio parametro anio a actualizar
     */
    public void setAnio(String anio) {
        this.anio = anio;
    }

    /**
     * @return el atributo primerFuar
     */
    public String getPrimerFuar() {
        return primerFuar;
    }

    /**
     * @param primerFuar parametro primerFuar a actualizar
     */
    public void setPrimerFuar(String primerFuar) {
        this.primerFuar = primerFuar;
    }

    /**
     * @return el atributo necInicial
     */
    public String getNecInicial() {
        return necInicial;
    }

    /**
     * @param necInicial parametro necInicial a actualizar
     */
    public void setNecInicial(String necInicial) {
        this.necInicial = necInicial;
    }

    /**
     * @return el atributo necFinal
     */
    public String getNecFinal() {
        return necFinal;
    }

    /**
     * @param necFinal parametro necFinal a actualizar
     */
    public void setNecFinal(String necFinal) {
        this.necFinal = necFinal;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Modulo [moduloId=" + moduloId + ", modulo=" + modulo + ", entidad=" + entidad
            + ", distrito=" + distrito + ", fuarInicial=" + fuarInicial + ", fuarFinal="
            + fuarFinal + ", anio=" + anio + ", primerFuar=" + primerFuar + ", necInicial="
            + necInicial + ", necFinal=" + necFinal + "]";
    }

}
