/**
 * NotificacionConfirmaciónDTO.java
 * Fecha de creación: 16/12/2015, 18:05:53
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Dirección
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
import java.util.Date;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public class NotificacionDTO implements Serializable {

    /**
     * TODO [Agregar documentación del atributo]
     */
    private static final long serialVersionUID = 1L;

    protected int estatusCredencial = 9;
    protected int tipoNotificacion_id = 16;
    protected int estatusNotificacion = 1;
    private final String procesoDigitalizacion = null;
    protected int residenteEnExtranjero = 1;
    private String ModuloIFEID;
    private String fuar;
    protected Date fechaDeIngresocecyrd = new Date();
    private String xmlNotificacion;

    /**
     * @return el atributo estatusCredencial
     */
    public int getEstatusCredencial() {
        return estatusCredencial;
    }

    /**
     * @param estatusCredencial parametro estatusCredencial a actualizar
     */
    public void setEstatusCredencial(int estatusCredencial) {
        this.estatusCredencial = estatusCredencial;
    }

    /**
     * @return el atributo tipoNotificacion_id
     */
    public int getTipoNotificacion_id() {
        return tipoNotificacion_id;
    }

    /**
     * @param tipoNotificacion_id parametro tipoNotificacion_id a actualizar
     */
    public void setTipoNotificacion_id(int tipoNotificacion_id) {
        this.tipoNotificacion_id = tipoNotificacion_id;
    }

    /**
     * @return el atributo estatusNotificacion
     */
    public int getEstatusNotificacion() {
        return estatusNotificacion;
    }

    /**
     * @param estatusNotificacion parametro estatusNotificacion a actualizar
     */
    public void setEstatusNotificacion(int estatusNotificacion) {
        this.estatusNotificacion = estatusNotificacion;
    }

    /**
     * @return el atributo residenteEnExtranjero
     */
    public int getResidenteEnExtranjero() {
        return residenteEnExtranjero;
    }

    /**
     * @param residenteEnExtranjero parametro residenteEnExtranjero a actualizar
     */
    public void setResidenteEnExtranjero(int residenteEnExtranjero) {
        this.residenteEnExtranjero = residenteEnExtranjero;
    }

    /**
     * @return el atributo moduloIFEID
     */
    public String getModuloIFEID() {
        return ModuloIFEID;
    }

    /**
     * @param moduloIFEID parametro moduloIFEID a actualizar
     */
    public void setModuloIFEID(String moduloIFEID) {
        ModuloIFEID = moduloIFEID;
    }

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
     * @return el atributo fechaDeIngresocecyrd
     */
    public Date getFechaDeIngresocecyrd() {
        return fechaDeIngresocecyrd;
    }

    /**
     * @param fechaDeIngresocecyrd parametro fechaDeIngresocecyrd a actualizar
     */
    public void setFechaDeIngresocecyrd(Date fechaDeIngresocecyrd) {
        this.fechaDeIngresocecyrd = fechaDeIngresocecyrd;
    }

    /**
     * @return el atributo xmlNotificacion
     */
    public String getXmlNotificacion() {
        return xmlNotificacion;
    }

    /**
     * @param xmlNotificacion parametro xmlNotificacion a actualizar
     */
    public void setXmlNotificacion(String xmlNotificacion) {
        this.xmlNotificacion = xmlNotificacion;
    }

    /**
     * @return el atributo procesoDigitalizacion
     */
    public String getProcesoDigitalizacion() {
        return procesoDigitalizacion;
    }

    /* La documentación de este método se encuentra en 
     * la clase o interface que lo declara (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "NotificacionDTO [estatusCredencial=" + estatusCredencial
            + ", tipoNotificacion_id=" + tipoNotificacion_id + ", estatusNotificacion="
            + estatusNotificacion + ", procesoDigitalizacion=" + procesoDigitalizacion
            + ", residenteEnExtranjero=" + residenteEnExtranjero + ", ModuloIFEID="
            + ModuloIFEID + ", fuar=" + fuar + ", fechaDeIngresocecyrd="
            + fechaDeIngresocecyrd + ", xmlNotificacion=" + xmlNotificacion + "]";
    }

}