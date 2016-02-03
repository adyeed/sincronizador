/**
 * FuarRechazadoUnicom.java
 * Fecha de creaci�n: 03/11/2015, 18:13:09
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
package mx.ine.sscc.modelo.entidad.unicom;

import java.io.Serializable;
import java.util.Date;

/**
 * clase que representa a la tabla FUAR_RECHAZADO en el esquema de CREDENCIALEXTRANJERO de
 * UNICOM
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class FuarRechazadoUnicom implements Serializable {

    private static final long serialVersionUID = 5490633346832830646L;

    private String fuar;
    private Date fechaRechazoSi;
    private String clave;
    private String descripcion;
    private Long procesoSincronizacionId;

    /**
     * @return el atributo fuar
     */
    public String getFuar() {
        return fuar;
    }

    /**
     * @param fuar parametro fuar a actualizar
     */
    public void setFuar(String fuar) {
        this.fuar = fuar;
    }

    /**
     * @return el atributo fechaRechazoSi
     */
    public Date getFechaRechazoSi() {
        return fechaRechazoSi;
    }

    /**
     * @param fechaRechazoSi parametro fechaRechazoSi a actualizar
     */
    public void setFechaRechazoSi(Date fechaRechazoSi) {
        this.fechaRechazoSi = fechaRechazoSi;
    }

    /**
     * @return el atributo clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave parametro clave a actualizar
     */
    public void setClave(String clave) {
        this.clave = clave;
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
     * @return el atributo procesoSincronizacionId
     */
    public Long getProcesoSincronizacionId() {
        return procesoSincronizacionId;
    }

    /**
     * @param procesoSincronizacionId parametro procesoSincronizacionId a actualizar
     */
    public void setProcesoSincronizacionId(Long procesoSincronizacionId) {
        this.procesoSincronizacionId = procesoSincronizacionId;
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FuarRechazadoUnicom [fuar=" + fuar + ", fechaRechazoSi=" + fechaRechazoSi
            + ", clave=" + clave + ", descripcion=" + descripcion
            + ", procesoSincronizacionId=" + procesoSincronizacionId + "]";
    }

}
