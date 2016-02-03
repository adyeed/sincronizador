/**
 * TipoRegistral.java
 * Fecha de creaci�n: 09/12/2015, 17:22:24
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
package mx.ine.sscc.modelo.entidad;

import java.io.Serializable;

/**
 * clase que representa a la tabla TIPOREGISTRAL
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class TipoRegistral implements Serializable {

    private static final long serialVersionUID = -4399098928842112840L;
    private Short tipoId;
    private String descripcion;
    private Boolean activo;

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

}
