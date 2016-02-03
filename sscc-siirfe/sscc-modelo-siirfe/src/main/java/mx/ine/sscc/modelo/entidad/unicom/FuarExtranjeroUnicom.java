/**
 * FuarExtranjeroUnicom.java
 * Fecha de creación: 04/11/2015, 13:44:38
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
 * clase que representa a la tabla FUAREXTRANJERO en el esquema de CREDENCIALEXTRANJERO de
 * UNICOM
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class FuarExtranjeroUnicom implements Serializable {

    private static final long serialVersionUID = -7500785851898079262L;
    private String fuar;
    private Integer estatusFuarId;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String claveElector;
    private String pais;
    private Date fechaNacimiento;
    private String estado;
    private String ciudad;
    private String telefono;
    private String correoElectronico;
    private String guiaPaqueteria;
    private Long solicitudMacId;
    private Date fechaTramite;
    private Date fechaUltimaActualizacion;
    private String curp;
    private String calle;
    private String numeroInterior;
    private String numeroExterior;
    private String codigoPostal;
    private String escolaridad;
    private String ocupacion;
    private String sexo;
    private String lugarNacimiento;
    private String colonia;
    private String municipio;
    private Date fechaEntrega;
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
     * @return el atributo nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre parametro nombre a actualizar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return el atributo apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * @param apellidoPaterno parametro apellidoPaterno a actualizar
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * @return el atributo apellidoMaterno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * @param apellidoMaterno parametro apellidoMaterno a actualizar
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * @return el atributo claveElector
     */
    public String getClaveElector() {
        return claveElector;
    }

    /**
     * @param claveElector parametro claveElector a actualizar
     */
    public void setClaveElector(String claveElector) {
        this.claveElector = claveElector;
    }

    /**
     * @return el atributo pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais parametro pais a actualizar
     */
    public void setPais(String pais) {
        this.pais = pais;
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
     * @return el atributo estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado parametro estado a actualizar
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return el atributo ciudad
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * @param ciudad parametro ciudad a actualizar
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
     * @return el atributo solicitudMacId
     */
    public Long getSolicitudMacId() {
        return solicitudMacId;
    }

    /**
     * @param solicitudMacId parametro solicitudMacId a actualizar
     */
    public void setSolicitudMacId(Long solicitudMacId) {
        this.solicitudMacId = solicitudMacId;
    }

    /**
     * @return el atributo fechaTramite
     */
    public Date getFechaTramite() {
        return fechaTramite;
    }

    /**
     * @param fechaTramite parametro fechaTramite a actualizar
     */
    public void setFechaTramite(Date fechaTramite) {
        this.fechaTramite = fechaTramite;
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
     * @return el atributo curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * @param curp parametro curp a actualizar
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * @return el atributo calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle parametro calle a actualizar
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return el atributo numeroInterior
     */
    public String getNumeroInterior() {
        return numeroInterior;
    }

    /**
     * @param numeroInterior parametro numeroInterior a actualizar
     */
    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    /**
     * @return el atributo numeroExterior
     */
    public String getNumeroExterior() {
        return numeroExterior;
    }

    /**
     * @param numeroExterior parametro numeroExterior a actualizar
     */
    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
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
     * @return el atributo escolaridad
     */
    public String getEscolaridad() {
        return escolaridad;
    }

    /**
     * @param escolaridad parametro escolaridad a actualizar
     */
    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    /**
     * @return el atributo ocupacion
     */
    public String getOcupacion() {
        return ocupacion;
    }

    /**
     * @param ocupacion parametro ocupacion a actualizar
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    /**
     * @return el atributo sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo parametro sexo a actualizar
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return el atributo lugarNacimiento
     */
    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    /**
     * @param lugarNacimiento parametro lugarNacimiento a actualizar
     */
    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    /**
     * @return el atributo colonia
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * @param colonia parametro colonia a actualizar
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * @return el atributo municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio parametro municipio a actualizar
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return el atributo fechaEntrega
     */
    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * @param fechaEntrega parametro fechaEntrega a actualizar
     */
    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
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
        return "FuarExtranjeroUnicom [fuar=" + fuar + ", estatusFuarId=" + estatusFuarId
            + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
            + ", apellidoMaterno=" + apellidoMaterno + ", claveElector=" + claveElector
            + ", pais=" + pais + ", fechaNacimiento=" + fechaNacimiento + ", estado=" + estado
            + ", ciudad=" + ciudad + ", telefono=" + telefono + ", correoElectronico="
            + correoElectronico + ", guiaPaqueteria=" + guiaPaqueteria + ", solicitudMacId="
            + solicitudMacId + ", fechaTramite=" + fechaTramite
            + ", fechaUltimaActualizacion=" + fechaUltimaActualizacion + ", curp=" + curp
            + ", calle=" + calle + ", numeroInterior=" + numeroInterior + ", numeroExterior="
            + numeroExterior + ", codigoPostal=" + codigoPostal + ", escolaridad="
            + escolaridad + ", ocupacion=" + ocupacion + ", sexo=" + sexo
            + ", lugarNacimiento=" + lugarNacimiento + ", colonia=" + colonia + ", municipio="
            + municipio + ", fechaEntrega=" + fechaEntrega + ", procesoSincronizacionId="
            + procesoSincronizacionId + "]";
    }

}