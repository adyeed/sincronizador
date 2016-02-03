/**
 * Cuestionario.java
 * Fecha de creación: 07/12/2015, 17:55:01
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
 * clase que representa a la tabla CUESTIONARIO
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class Cuestionario implements Serializable {

    private static final long serialVersionUID = -6651831149696036621L;
    private Short cuestionarioId;
    private String descripcion;
    private TipoRegistral tipoRegistral;
    private Boolean activo;

    /**
     * @return el atributo cuestionarioId
     */
    public Short getCuestionarioId() {
        return cuestionarioId;
    }

    /**
     * @param cuestionarioId parametro cuestionarioId a actualizar
     */
    public void setCuestionarioId(Short cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
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
     * @return el atributo tipoRegistral
     */
    public TipoRegistral getTipoRegistral() {
        return tipoRegistral;
    }

    /**
     * @param tipoRegistral parametro tipoRegistral a actualizar
     */
    public void setTipoRegistral(TipoRegistral tipoRegistral) {
        this.tipoRegistral = tipoRegistral;
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

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Cuestionario [cuestionarioId=" + cuestionarioId + ", descripcion="
            + descripcion + ", tipoRegistral=" + tipoRegistral + ", activo=" + activo + "]";
    }

}
