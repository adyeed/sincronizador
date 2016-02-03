/**
 * FuarExtranjero.java
 * Fecha de creación: 04/11/2015, 12:12:39
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
 * clase que representa a la tabla FUAREXTRANJERO en el esquema de CONCILIACIONES del SIIRFE
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class FuarExtranjeroSiirfe implements Serializable {

    /**
     * TODO [Agregar documentación del atributo]
     */
    private static final long serialVersionUID = -4190505202410613639L;
    private String fuar;
    private Integer estatusFuarId;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String claveElector;
    private String pais;
    private Date fechaNacimiento;
    private String lugarNacimiento;
    private String sexo;
    private String escolaridad;
    private String ocupacion;
    private String curp;
    private String estado;
    private String ciudad;
    private String calle;
    private String numeroInterior;
    private String numeroExterior;
    private String codigoPostal;
    private String telefono;
    private String correoElectronico;
    private Date fechaRegSi;
    private Date fechaRechazo;
    private String adscripcionAutJud;
    private String tipoResolucion;
    private String numeroExpediente;
    private String numeroOficioResp;
    private Date fechaTramiteSi;
    private String guiaPaqueteria;
    private Date fechaEntrega;
    private String cic;
    private Date fechaEnvio;
    private Boolean faltante;
    private Long solicitudMacId;
    private Long claveUnicaCiudadanoId;
    private Long ciudadanoIdentificadoId;
    private Long tramiteId;
    private Boolean utilizado;
    private Integer movimientoInicial;
    private Integer movimientoAplicado;
    private Integer movimientoMultiple;
    private String lote;
    private String endoso;
    private String tipoDemandaId;
    private Boolean pendienteEnProceso;
    private Date procesadoFecha;
    private Date faltanteFecha;
    private Integer tipoSolicitudMacId;
    private Long ciudadanoId;
    private Integer medioIdentificacion;
    private Integer formaIdentificacionCredencialId;
    private Boolean residenteExtranjero;
    private String semanaOperativa;
    private String campana;
    private Boolean listaNominal;
    private Date fechaTramite;
    private Date fechaUltimaActualizacion;
    private String folioEntregaCredencial;
    private String controlSincronizacion;
    private String colonia;
    private String municipio;
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
     * @return el atributo fechaRegSi
     */
    public Date getFechaRegSi() {
        return fechaRegSi;
    }

    /**
     * @param fechaRegSi parametro fechaRegSi a actualizar
     */
    public void setFechaRegSi(Date fechaRegSi) {
        this.fechaRegSi = fechaRegSi;
    }

    /**
     * @return el atributo fechaRechazo
     */
    public Date getFechaRechazo() {
        return fechaRechazo;
    }

    /**
     * @param fechaRechazo parametro fechaRechazo a actualizar
     */
    public void setFechaRechazo(Date fechaRechazo) {
        this.fechaRechazo = fechaRechazo;
    }

    /**
     * @return el atributo adscripcionAutJud
     */
    public String getAdscripcionAutJud() {
        return adscripcionAutJud;
    }

    /**
     * @param adscripcionAutJud parametro adscripcionAutJud a actualizar
     */
    public void setAdscripcionAutJud(String adscripcionAutJud) {
        this.adscripcionAutJud = adscripcionAutJud;
    }

    /**
     * @return el atributo tipoResolucion
     */
    public String getTipoResolucion() {
        return tipoResolucion;
    }

    /**
     * @param tipoResolucion parametro tipoResolucion a actualizar
     */
    public void setTipoResolucion(String tipoResolucion) {
        this.tipoResolucion = tipoResolucion;
    }

    /**
     * @return el atributo numeroExpediente
     */
    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    /**
     * @param numeroExpediente parametro numeroExpediente a actualizar
     */
    public void setNumeroExpediente(String numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    /**
     * @return el atributo numeroOficioResp
     */
    public String getNumeroOficioResp() {
        return numeroOficioResp;
    }

    /**
     * @param numeroOficioResp parametro numeroOficioResp a actualizar
     */
    public void setNumeroOficioResp(String numeroOficioResp) {
        this.numeroOficioResp = numeroOficioResp;
    }

    /**
     * @return el atributo fechaTramiteSi
     */
    public Date getFechaTramiteSi() {
        return fechaTramiteSi;
    }

    /**
     * @param fechaTramiteSi parametro fechaTramiteSi a actualizar
     */
    public void setFechaTramiteSi(Date fechaTramiteSi) {
        this.fechaTramiteSi = fechaTramiteSi;
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
     * @return el atributo cic
     */
    public String getCic() {
        return cic;
    }

    /**
     * @param cic parametro cic a actualizar
     */
    public void setCic(String cic) {
        this.cic = cic;
    }

    /**
     * @return el atributo fechaEnvio
     */
    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     * @param fechaEnvio parametro fechaEnvio a actualizar
     */
    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
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
     * @return el atributo medioIdentificacion
     */
    public Integer getMedioIdentificacion() {
        return medioIdentificacion;
    }

    /**
     * @param medioIdentificacion parametro medioIdentificacion a actualizar
     */
    public void setMedioIdentificacion(Integer medioIdentificacion) {
        this.medioIdentificacion = medioIdentificacion;
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
        return "FuarExtranjeroSiirfe [fuar=" + fuar + ", estatusFuarId=" + estatusFuarId
            + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno
            + ", apellidoMaterno=" + apellidoMaterno + ", claveElector=" + claveElector
            + ", pais=" + pais + ", fechaNacimiento=" + fechaNacimiento + ", lugarNacimiento="
            + lugarNacimiento + ", sexo=" + sexo + ", escolaridad=" + escolaridad
            + ", ocupacion=" + ocupacion + ", curp=" + curp + ", estado=" + estado
            + ", ciudad=" + ciudad + ", calle=" + calle + ", numeroInterior=" + numeroInterior
            + ", numeroExterior=" + numeroExterior + ", codigoPostal=" + codigoPostal
            + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico
            + ", fechaRegSi=" + fechaRegSi + ", fechaRechazo=" + fechaRechazo
            + ", adscripcionAutJud=" + adscripcionAutJud + ", tipoResolucion="
            + tipoResolucion + ", numeroExpediente=" + numeroExpediente
            + ", numeroOficioResp=" + numeroOficioResp + ", fechaTramiteSi=" + fechaTramiteSi
            + ", guiaPaqueteria=" + guiaPaqueteria + ", fechaEntrega=" + fechaEntrega
            + ", cic=" + cic + ", fechaEnvio=" + fechaEnvio + ", faltante=" + faltante
            + ", solicitudMacId=" + solicitudMacId + ", claveUnicaCiudadanoId="
            + claveUnicaCiudadanoId + ", ciudadanoIdentificadoId=" + ciudadanoIdentificadoId
            + ", tramiteId=" + tramiteId + ", utilizado=" + utilizado + ", movimientoInicial="
            + movimientoInicial + ", movimientoAplicado=" + movimientoAplicado
            + ", movimientoMultiple=" + movimientoMultiple + ", lote=" + lote + ", endoso="
            + endoso + ", tipoDemandaId=" + tipoDemandaId + ", pendienteEnProceso="
            + pendienteEnProceso + ", procesadoFecha=" + procesadoFecha + ", faltanteFecha="
            + faltanteFecha + ", tipoSolicitudMacId=" + tipoSolicitudMacId + ", ciudadanoId="
            + ciudadanoId + ", medioIdentificacion=" + medioIdentificacion
            + ", formaIdentificacionCredencialId=" + formaIdentificacionCredencialId
            + ", residenteExtranjero=" + residenteExtranjero + ", semanaOperativa="
            + semanaOperativa + ", campana=" + campana + ", listaNominal=" + listaNominal
            + ", fechaTramite=" + fechaTramite + ", fechaUltimaActualizacion="
            + fechaUltimaActualizacion + ", folioEntregaCredencial=" + folioEntregaCredencial
            + ", controlSincronizacion=" + controlSincronizacion + ", colonia=" + colonia
            + ", municipio=" + municipio + ", procesoSincronizacionId="
            + procesoSincronizacionId + "]";
    }

}
