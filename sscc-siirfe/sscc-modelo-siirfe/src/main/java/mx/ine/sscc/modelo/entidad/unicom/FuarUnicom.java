/**
 * FuarSiirfe.java
 * Fecha de creación: 03/11/2015, 13:52:54
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
 * clase que representa a la tabla FUAR en el esquema de CREDENCIALEXTRANJERO de UNICOM
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class FuarUnicom implements Serializable {

    private static final long serialVersionUID = 5847247904059113903L;

    private Long fuar;
    private Date fechaTraminte;
    private Date fechaUltimaActualizacion;
    private Integer estatusFuarId;
    private Long solicitudMac;
    private String modulo;
    private String folioEntregaCredencial;
    private Date fechaNacimiento;
    private String telefono;
    private String correoElectronico;
    private String codigoPostal;
    private String guiaPaqueteria;
    private Long procesoSincronizacionId;

    /**
     * @return el atributo fuar
     */
    public Long getFuar() {
        return fuar;
    }

    /**
     * @param fuar parametro fuar a actualizar
     */
    public void setFuar(Long fuar) {
        this.fuar = fuar;
    }

    /**
     * @return el atributo fechaTraminte
     */
    public Date getFechaTraminte() {
        return fechaTraminte;
    }

    /**
     * @param fechaTraminte parametro fechaTraminte a actualizar
     */
    public void setFechaTraminte(Date fechaTraminte) {
        this.fechaTraminte = fechaTraminte;
    }

    /**
     * @return el atributo fechaUltimaActualizacion
     */
    public Date getFechaUltimaActualizacion() {
        return fechaUltimaActualizacion;
    }

    /**
     * @param fechaUltimaActualizacion parametro fechaUltimaActualizacion a actualizar
     */
    public void setFechaUltimaActualizacion(Date fechaUltimaActualizacion) {
        this.fechaUltimaActualizacion = fechaUltimaActualizacion;
    }

    /**
     * @return el atributo estatusFuarId
     */
    public Integer getEstatusFuarId() {
        return estatusFuarId;
    }

    /**
     * @param estatusFuarId parametro estatusFuarId a actualizar
     */
    public void setEstatusFuarId(Integer estatusFuarId) {
        this.estatusFuarId = estatusFuarId;
    }

    /**
     * @return el atributo solicitudMac
     */
    public Long getSolicitudMac() {
        return solicitudMac;
    }

    /**
     * @param solicitudMac parametro solicitudMac a actualizar
     */
    public void setSolicitudMac(Long solicitudMac) {
        this.solicitudMac = solicitudMac;
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
     * @return el atributo folioEntregaCredencial
     */
    public String getFolioEntregaCredencial() {
        return folioEntregaCredencial;
    }

    /**
     * @param folioEntregaCredencial parametro folioEntregaCredencial a actualizar
     */
    public void setFolioEntregaCredencial(String folioEntregaCredencial) {
        this.folioEntregaCredencial = folioEntregaCredencial;
    }

    /**
     * @return el atributo fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento parametro fechaNacimiento a actualizar
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return el atributo telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono parametro telefono a actualizar
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return el atributo correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico parametro correoElectronico a actualizar
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return el atributo codigoPostal
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * @param codigoPostal parametro codigoPostal a actualizar
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * @return el atributo guiaPaqueteria
     */
    public String getGuiaPaqueteria() {
        return guiaPaqueteria;
    }

    /**
     * @param guiaPaqueteria parametro guiaPaqueteria a actualizar
     */
    public void setGuiaPaqueteria(String guiaPaqueteria) {
        this.guiaPaqueteria = guiaPaqueteria;
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
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "FuarUnicom [fuar=" + fuar + ", fechaTraminte=" + fechaTraminte
            + ", fechaUltimaActualizacion=" + fechaUltimaActualizacion + ", estatusFuarId="
            + estatusFuarId + ", solicitudMac=" + solicitudMac + ", modulo=" + modulo
            + ", folioEntregaCredencial=" + folioEntregaCredencial + ", fechaNacimiento="
            + fechaNacimiento + ", telefono=" + telefono + ", correoElectronico="
            + correoElectronico + ", codigoPostal=" + codigoPostal + ", guiaPaqueteria="
            + guiaPaqueteria + ", procesoSincronizacionId=" + procesoSincronizacionId + "]";
    }

}
