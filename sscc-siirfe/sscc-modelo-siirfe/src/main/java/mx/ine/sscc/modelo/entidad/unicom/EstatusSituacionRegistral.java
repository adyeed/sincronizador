/**
 * EstatusSituacionRegistral.java
 * Fecha de creación: 09/12/2015, 17:17:02
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
 * Clase que representa la tabla ESTATUSSITUACIONREGISTRAL
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class EstatusSituacionRegistral implements Serializable {

    private static final long serialVersionUID = -6430020274427239045L;
    private Short estatusId;
    private String descripcion;
    private Boolean activo;

    /**
     * @return el atributo estatusId
     */
    public Short getEstatusId() {
        return estatusId;
    }

    /**
     * @param estatusId parametro estatusId a actualizar
     */
    public void setEstatusId(Short estatusId) {
        this.estatusId = estatusId;
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

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "EstatusSituacionRegistral [estatusId=" + estatusId + ", descripcion="
            + descripcion + ", activo=" + activo + "]";
    }

}
