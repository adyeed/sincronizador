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
package mx.ine.sscc.modelo.entidad.siirfe;

import java.io.Serializable;
import java.util.Date;

/**
 * clase que representa a la tabla FUAR en el esquema de CONCILIACIONES del SIIRFE
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class FuarSiirfe implements Serializable {

    private static final long serialVersionUID = 5847247904059113903L;

    private Long fuar;
    private Date fechaTraminte;
    private Date fechaUltimaActualizacion;
    private Integer estatusFuarId;
    private Boolean faltante;
    private Long solicitudMac;
    private Long claveUnicaCiudadanoId;
    private Long ciudadanoIdentificadoId;
    private Long tramiteId;
    private Modulo modulo;
    private Long georeferenciaId;
    private String entidad;
    private Integer distrito;
    private Integer municipio;
    private Integer seccion;
    private Integer localidad;
    private Integer manzana;
    private Boolean utilizado;
    private Integer movimientoInicial;
    private Integer movimientoAplicado;
    private Integer movimientoMultiple;
    private String lote;
    private String endoso;
    private String tipoDemandaId;
    private Boolean pendienteEnProceso;
    private Integer distritoDestino;
    private String moduloDestino;
    private Integer moduloDistrito;
    private Date procesadoFecha;
    private Date faltanteFecha;
    private Integer tipoSolicitudMacId;
    private String moduloEntidad;
    private Long ciudadanoId;
    private Integer mediodIdentificacion;
    private Integer docFotografia;
    private Integer comprobanteDomicilio;
    private String folioEntregaCredencial;
    private String testigo1Foto;
    private String testigo2Foto;
    private String testigo1Domicilio;
    private String testigo2Domicilio;
    private Integer formaIdentificacionCredencialId;
    private Boolean residenteExtranjero;
    private String semanaOperativa;
    private String campana;
    private Boolean listaNominal;
    private Integer mapeoEstatusId;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String telefono;
    private String correoElectronico;
    private String codigoPostal;
    private String guiaPaqueteria;
    private Integer paqueteMacId;
    private String controlSincronizacion;
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
     * @return el atributo faltante
     */
    public Boolean getFaltante() {
        return faltante;
    }

    /**
     * @param faltante parametro faltante a actualizar
     */
    public void setFaltante(Boolean faltante) {
        this.faltante = faltante;
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
     * @return el atributo claveUnicaCiudadanoId
     */
    public Long getClaveUnicaCiudadanoId() {
        return claveUnicaCiudadanoId;
    }

    /**
     * @param claveUnicaCiudadanoId parametro claveUnicaCiudadanoId a actualizar
     */
    public void setClaveUnicaCiudadanoId(Long claveUnicaCiudadanoId) {
        this.claveUnicaCiudadanoId = claveUnicaCiudadanoId;
    }

    /**
     * @return el atributo ciudadanoIdentificadoId
     */
    public Long getCiudadanoIdentificadoId() {
        return ciudadanoIdentificadoId;
    }

    /**
     * @param ciudadanoIdentificadoId parametro ciudadanoIdentificadoId a actualizar
     */
    public void setCiudadanoIdentificadoId(Long ciudadanoIdentificadoId) {
        this.ciudadanoIdentificadoId = ciudadanoIdentificadoId;
    }

    /**
     * @return el atributo tramiteId
     */
    public Long getTramiteId() {
        return tramiteId;
    }

    /**
     * @param tramiteId parametro tramiteId a actualizar
     */
    public void setTramiteId(Long tramiteId) {
        this.tramiteId = tramiteId;
    }

    /**
     * @return el atributo modulo
     */
    public Modulo getModulo() {
        return modulo;
    }

    /**
     * @param modulo parametro modulo a actualizar
     */
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    /**
     * @return el atributo georeferenciaId
     */
    public Long getGeoreferenciaId() {
        return georeferenciaId;
    }

    /**
     * @param georeferenciaId parametro georeferenciaId a actualizar
     */
    public void setGeoreferenciaId(Long georeferenciaId) {
        this.georeferenciaId = georeferenciaId;
    }

    /**
     * @return el atributo entidad
     */
    public String getEntidad() {
        return entidad;
    }

    /**
     * @param entidad parametro entidad a actualizar
     */
    public void setEntidad(String entidad) {
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
     * @return el atributo municipio
     */
    public Integer getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio parametro municipio a actualizar
     */
    public void setMunicipio(Integer municipio) {
        this.municipio = municipio;
    }

    /**
     * @return el atributo seccion
     */
    public Integer getSeccion() {
        return seccion;
    }

    /**
     * @param seccion parametro seccion a actualizar
     */
    public void setSeccion(Integer seccion) {
        this.seccion = seccion;
    }

    /**
     * @return el atributo localidad
     */
    public Integer getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad parametro localidad a actualizar
     */
    public void setLocalidad(Integer localidad) {
        this.localidad = localidad;
    }

    /**
     * @return el atributo manzana
     */
    public Integer getManzana() {
        return manzana;
    }

    /**
     * @param manzana parametro manzana a actualizar
     */
    public void setManzana(Integer manzana) {
        this.manzana = manzana;
    }

    /**
     * @return el atributo utilizado
     */
    public Boolean getUtilizado() {
        return utilizado;
    }

    /**
     * @param utilizado parametro utilizado a actualizar
     */
    public void setUtilizado(Boolean utilizado) {
        this.utilizado = utilizado;
    }

    /**
     * @return el atributo movimientoInicial
     */
    public Integer getMovimientoInicial() {
        return movimientoInicial;
    }

    /**
     * @param movimientoInicial parametro movimientoInicial a actualizar
     */
    public void setMovimientoInicial(Integer movimientoInicial) {
        this.movimientoInicial = movimientoInicial;
    }

    /**
     * @return el atributo movimientoAplicado
     */
    public Integer getMovimientoAplicado() {
        return movimientoAplicado;
    }

    /**
     * @param movimientoAplicado parametro movimientoAplicado a actualizar
     */
    public void setMovimientoAplicado(Integer movimientoAplicado) {
        this.movimientoAplicado = movimientoAplicado;
    }

    /**
     * @return el atributo movimientoMultiple
     */
    public Integer getMovimientoMultiple() {
        return movimientoMultiple;
    }

    /**
     * @param movimientoMultiple parametro movimientoMultiple a actualizar
     */
    public void setMovimientoMultiple(Integer movimientoMultiple) {
        this.movimientoMultiple = movimientoMultiple;
    }

    /**
     * @return el atributo lote
     */
    public String getLote() {
        return lote;
    }

    /**
     * @param lote parametro lote a actualizar
     */
    public void setLote(String lote) {
        this.lote = lote;
    }

    /**
     * @return el atributo endoso
     */
    public String getEndoso() {
        return endoso;
    }

    /**
     * @param endoso parametro endoso a actualizar
     */
    public void setEndoso(String endoso) {
        this.endoso = endoso;
    }

    /**
     * @return el atributo tipoDemandaId
     */
    public String getTipoDemandaId() {
        return tipoDemandaId;
    }

    /**
     * @param tipoDemandaId parametro tipoDemandaId a actualizar
     */
    public void setTipoDemandaId(String tipoDemandaId) {
        this.tipoDemandaId = tipoDemandaId;
    }

    /**
     * @return el atributo pendienteEnProceso
     */
    public Boolean getPendienteEnProceso() {
        return pendienteEnProceso;
    }

    /**
     * @param pendienteEnProceso parametro pendienteEnProceso a actualizar
     */
    public void setPendienteEnProceso(Boolean pendienteEnProceso) {
        this.pendienteEnProceso = pendienteEnProceso;
    }

    /**
     * @return el atributo distritoDestino
     */
    public Integer getDistritoDestino() {
        return distritoDestino;
    }

    /**
     * @param distritoDestino parametro distritoDestino a actualizar
     */
    public void setDistritoDestino(Integer distritoDestino) {
        this.distritoDestino = distritoDestino;
    }

    /**
     * @return el atributo moduloDestino
     */
    public String getModuloDestino() {
        return moduloDestino;
    }

    /**
     * @param moduloDestino parametro moduloDestino a actualizar
     */
    public void setModuloDestino(String moduloDestino) {
        this.moduloDestino = moduloDestino;
    }

    /**
     * @return el atributo moduloDistrito
     */
    public Integer getModuloDistrito() {
        return moduloDistrito;
    }

    /**
     * @param moduloDistrito parametro moduloDistrito a actualizar
     */
    public void setModuloDistrito(Integer moduloDistrito) {
        this.moduloDistrito = moduloDistrito;
    }

    /**
     * @return el atributo procesadoFecha
     */
    public Date getProcesadoFecha() {
        return procesadoFecha;
    }

    /**
     * @param procesadoFecha parametro procesadoFecha a actualizar
     */
    public void setProcesadoFecha(Date procesadoFecha) {
        this.procesadoFecha = procesadoFecha;
    }

    /**
     * @return el atributo faltanteFecha
     */
    public Date getFaltanteFecha() {
        return faltanteFecha;
    }

    /**
     * @param faltanteFecha parametro faltanteFecha a actualizar
     */
    public void setFaltanteFecha(Date faltanteFecha) {
        this.faltanteFecha = faltanteFecha;
    }

    /**
     * @return el atributo tipoSolicitudMacId
     */
    public Integer getTipoSolicitudMacId() {
        return tipoSolicitudMacId;
    }

    /**
     * @param tipoSolicitudMacId parametro tipoSolicitudMacId a actualizar
     */
    public void setTipoSolicitudMacId(Integer tipoSolicitudMacId) {
        this.tipoSolicitudMacId = tipoSolicitudMacId;
    }

    /**
     * @return el atributo moduloEntidad
     */
    public String getModuloEntidad() {
        return moduloEntidad;
    }

    /**
     * @param moduloEntidad parametro moduloEntidad a actualizar
     */
    public void setModuloEntidad(String moduloEntidad) {
        this.moduloEntidad = moduloEntidad;
    }

    /**
     * @return el atributo ciudadanoId
     */
    public Long getCiudadanoId() {
        return ciudadanoId;
    }

    /**
     * @param ciudadanoId parametro ciudadanoId a actualizar
     */
    public void setCiudadanoId(Long ciudadanoId) {
        this.ciudadanoId = ciudadanoId;
    }

    /**
     * @return el atributo mediodIdentificacion
     */
    public Integer getMediodIdentificacion() {
        return mediodIdentificacion;
    }

    /**
     * @param mediodIdentificacion parametro mediodIdentificacion a actualizar
     */
    public void setMediodIdentificacion(Integer mediodIdentificacion) {
        this.mediodIdentificacion = mediodIdentificacion;
    }

    /**
     * @return el atributo docFotografia
     */
    public Integer getDocFotografia() {
        return docFotografia;
    }

    /**
     * @param docFotografia parametro docFotografia a actualizar
     */
    public void setDocFotografia(Integer docFotografia) {
        this.docFotografia = docFotografia;
    }

    /**
     * @return el atributo comprobanteDomicilio
     */
    public Integer getComprobanteDomicilio() {
        return comprobanteDomicilio;
    }

    /**
     * @param comprobanteDomicilio parametro comprobanteDomicilio a actualizar
     */
    public void setComprobanteDomicilio(Integer comprobanteDomicilio) {
        this.comprobanteDomicilio = comprobanteDomicilio;
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
     * @return el atributo testigo1Foto
     */
    public String getTestigo1Foto() {
        return testigo1Foto;
    }

    /**
     * @param testigo1Foto parametro testigo1Foto a actualizar
     */
    public void setTestigo1Foto(String testigo1Foto) {
        this.testigo1Foto = testigo1Foto;
    }

    /**
     * @return el atributo testigo2Foto
     */
    public String getTestigo2Foto() {
        return testigo2Foto;
    }

    /**
     * @param testigo2Foto parametro testigo2Foto a actualizar
     */
    public void setTestigo2Foto(String testigo2Foto) {
        this.testigo2Foto = testigo2Foto;
    }

    /**
     * @return el atributo testigo1Domicilio
     */
    public String getTestigo1Domicilio() {
        return testigo1Domicilio;
    }

    /**
     * @param testigo1Domicilio parametro testigo1Domicilio a actualizar
     */
    public void setTestigo1Domicilio(String testigo1Domicilio) {
        this.testigo1Domicilio = testigo1Domicilio;
    }

    /**
     * @return el atributo testigo2Domicilio
     */
    public String getTestigo2Domicilio() {
        return testigo2Domicilio;
    }

    /**
     * @param testigo2Domicilio parametro testigo2Domicilio a actualizar
     */
    public void setTestigo2Domicilio(String testigo2Domicilio) {
        this.testigo2Domicilio = testigo2Domicilio;
    }

    /**
     * @return el atributo formaIdentificacionCredencialId
     */
    public Integer getFormaIdentificacionCredencialId() {
        return formaIdentificacionCredencialId;
    }

    /**
     * @param formaIdentificacionCredencialId parametro formaIdentificacionCredencialId a
     *        actualizar
     */
    public void setFormaIdentificacionCredencialId(Integer formaIdentificacionCredencialId) {
        this.formaIdentificacionCredencialId = formaIdentificacionCredencialId;
    }

    /**
     * @return el atributo residenteExtranjero
     */
    public Boolean getResidenteExtranjero() {
        return residenteExtranjero;
    }

    /**
     * @param residenteExtranjero parametro residenteExtranjero a actualizar
     */
    public void setResidenteExtranjero(Boolean residenteExtranjero) {
        this.residenteExtranjero = residenteExtranjero;
    }

    /**
     * @return el atributo semanaOperativa
     */
    public String getSemanaOperativa() {
        return semanaOperativa;
    }

    /**
     * @param semanaOperativa parametro semanaOperativa a actualizar
     */
    public void setSemanaOperativa(String semanaOperativa) {
        this.semanaOperativa = semanaOperativa;
    }

    /**
     * @return el atributo campana
     */
    public String getCampana() {
        return campana;
    }

    /**
     * @param campana parametro campana a actualizar
     */
    public void setCampana(String campana) {
        this.campana = campana;
    }

    /**
     * @return el atributo listaNominal
     */
    public Boolean getListaNominal() {
        return listaNominal;
    }

    /**
     * @param listaNominal parametro listaNominal a actualizar
     */
    public void setListaNominal(Boolean listaNominal) {
        this.listaNominal = listaNominal;
    }

    /**
     * @return el atributo mapeoEstatusId
     */
    public Integer getMapeoEstatusId() {
        return mapeoEstatusId;
    }

    /**
     * @param mapeoEstatusId parametro mapeoEstatusId a actualizar
     */
    public void setMapeoEstatusId(Integer mapeoEstatusId) {
        this.mapeoEstatusId = mapeoEstatusId;
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
     * @return el atributo paqueteMacId
     */
    public Integer getPaqueteMacId() {
        return paqueteMacId;
    }

    /**
     * @param paqueteMacId parametro paqueteMacId a actualizar
     */
    public void setPaqueteMacId(Integer paqueteMacId) {
        this.paqueteMacId = paqueteMacId;
    }

    /**
     * @return el atributo controlSincronizacion
     */
    public String getControlSincronizacion() {
        return controlSincronizacion;
    }

    /**
     * @param controlSincronizacion parametro controlSincronizacion a actualizar
     */
    public void setControlSincronizacion(String controlSincronizacion) {
        this.controlSincronizacion = controlSincronizacion;
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
        return "FuarSiirfe [fuar=" + fuar + ", fechaTraminte=" + fechaTraminte
            + ", fechaUltimaActualizacion=" + fechaUltimaActualizacion + ", estatusFuarId="
            + estatusFuarId + ", faltante=" + faltante + ", solicitudMac=" + solicitudMac
            + ", claveUnicaCiudadanoId=" + claveUnicaCiudadanoId
            + ", ciudadanoIdentificadoId=" + ciudadanoIdentificadoId + ", tramiteId="
            + tramiteId + ", modulo=" + modulo + ", georeferenciaId=" + georeferenciaId
            + ", entidad=" + entidad + ", distrito=" + distrito + ", municipio=" + municipio
            + ", seccion=" + seccion + ", localidad=" + localidad + ", manzana=" + manzana
            + ", utilizado=" + utilizado + ", movimientoInicial=" + movimientoInicial
            + ", movimientoAplicado=" + movimientoAplicado + ", movimientoMultiple="
            + movimientoMultiple + ", lote=" + lote + ", endoso=" + endoso
            + ", tipoDemandaId=" + tipoDemandaId + ", pendienteEnProceso="
            + pendienteEnProceso + ", distritoDestino=" + distritoDestino + ", moduloDestino="
            + moduloDestino + ", moduloDistrito=" + moduloDistrito + ", procesadoFecha="
            + procesadoFecha + ", faltanteFecha=" + faltanteFecha + ", tipoSolicitudMacId="
            + tipoSolicitudMacId + ", moduloEntidad=" + moduloEntidad + ", ciudadanoId="
            + ciudadanoId + ", mediodIdentificacion=" + mediodIdentificacion
            + ", docFotografia=" + docFotografia + ", comprobanteDomicilio="
            + comprobanteDomicilio + ", folioEntregaCredencial=" + folioEntregaCredencial
            + ", testigo1Foto=" + testigo1Foto + ", testigo2Foto=" + testigo2Foto
            + ", testigo1Domicilio=" + testigo1Domicilio + ", testigo2Domicilio="
            + testigo2Domicilio + ", formaIdentificacionCredencialId="
            + formaIdentificacionCredencialId + ", residenteExtranjero=" + residenteExtranjero
            + ", semanaOperativa=" + semanaOperativa + ", campana=" + campana
            + ", listaNominal=" + listaNominal + ", mapeoEstatusId=" + mapeoEstatusId
            + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
            + ", apellidoMaterno=" + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento
            + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico
            + ", codigoPostal=" + codigoPostal + ", guiaPaqueteria=" + guiaPaqueteria
            + ", paqueteMacId=" + paqueteMacId + ", controlSincronizacion="
            + controlSincronizacion + ", procesoSincronizacionId=" + procesoSincronizacionId
            + "]";
    }

}
