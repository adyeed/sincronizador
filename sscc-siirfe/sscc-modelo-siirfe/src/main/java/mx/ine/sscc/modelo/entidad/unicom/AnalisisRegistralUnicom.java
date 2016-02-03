/**
 * AnalisisRegistralUnicom.java
 * Fecha de creación: 04/11/2015, 14:41:07
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
 * clase que representa a la tabla ANALISISREGISTRAL en el esquema de CREDENCIALEXTRANJERO de
 * UNICOM
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class AnalisisRegistralUnicom implements Serializable {

    private static final long serialVersionUID = 1344724091810822835L;
    private Long solicitudMacId;
    private Long ciudadanoId;
    private String tipoSituacionAnalisisRegistral;
    private Date inicioTramite;
    private String adscripcionAutJud;
    private String tipoResolucion;
    private Date fechaComunico;
    private String juzgado;
    private String causaPenal;
    private String nombreOfiRepMexicoExt;
    private String paisResidencia;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Date fechaNacimiento;
    private String lugarNacimiento;
    private String adscripcionAutJudC;
    private String tipoResolucionC;
    private String numeroExpediente;
    private String numeroOficioRespC;
    private Date fechaTramite;
    private String numeroTramite;
    private String calleTramite;
    private String coloniaTramite;
    private String municipioTramite;
    private String estadoTramite;
    private String paisTramite;
    private String fuar;
    private Long procesoSincronizacionId;

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
     * @return el atributo tipoSituacionAnalisisRegistral
     */
    public String getTipoSituacionAnalisisRegistral() {
        return tipoSituacionAnalisisRegistral;
    }

    /**
     * @param tipoSituacionAnalisisRegistral parametro tipoSituacionAnalisisRegistral a
     *        actualizar
     */
    public void setTipoSituacionAnalisisRegistral(String tipoSituacionAnalisisRegistral) {
        this.tipoSituacionAnalisisRegistral = tipoSituacionAnalisisRegistral;
    }

    /**
     * @return el atributo inicioTramite
     */
    public Date getInicioTramite() {
        return inicioTramite;
    }

    /**
     * @param inicioTramite parametro inicioTramite a actualizar
     */
    public void setInicioTramite(Date inicioTramite) {
        this.inicioTramite = inicioTramite;
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
     * @return el atributo fechaComunico
     */
    public Date getFechaComunico() {
        return fechaComunico;
    }

    /**
     * @param fechaComunico parametro fechaComunico a actualizar
     */
    public void setFechaComunico(Date fechaComunico) {
        this.fechaComunico = fechaComunico;
    }

    /**
     * @return el atributo juzgado
     */
    public String getJuzgado() {
        return juzgado;
    }

    /**
     * @param juzgado parametro juzgado a actualizar
     */
    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }

    /**
     * @return el atributo causaPenal
     */
    public String getCausaPenal() {
        return causaPenal;
    }

    /**
     * @param causaPenal parametro causaPenal a actualizar
     */
    public void setCausaPenal(String causaPenal) {
        this.causaPenal = causaPenal;
    }

    /**
     * @return el atributo nombreOfiRepMexicoExt
     */
    public String getNombreOfiRepMexicoExt() {
        return nombreOfiRepMexicoExt;
    }

    /**
     * @param nombreOfiRepMexicoExt parametro nombreOfiRepMexicoExt a actualizar
     */
    public void setNombreOfiRepMexicoExt(String nombreOfiRepMexicoExt) {
        this.nombreOfiRepMexicoExt = nombreOfiRepMexicoExt;
    }

    /**
     * @return el atributo paisResidencia
     */
    public String getPaisResidencia() {
        return paisResidencia;
    }

    /**
     * @param paisResidencia parametro paisResidencia a actualizar
     */
    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
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
     * @return el atributo adscripcionAutJudC
     */
    public String getAdscripcionAutJudC() {
        return adscripcionAutJudC;
    }

    /**
     * @param adscripcionAutJudC parametro adscripcionAutJudC a actualizar
     */
    public void setAdscripcionAutJudC(String adscripcionAutJudC) {
        this.adscripcionAutJudC = adscripcionAutJudC;
    }

    /**
     * @return el atributo tipoResolucionC
     */
    public String getTipoResolucionC() {
        return tipoResolucionC;
    }

    /**
     * @param tipoResolucionC parametro tipoResolucionC a actualizar
     */
    public void setTipoResolucionC(String tipoResolucionC) {
        this.tipoResolucionC = tipoResolucionC;
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
     * @return el atributo numeroOficioRespC
     */
    public String getNumeroOficioRespC() {
        return numeroOficioRespC;
    }

    /**
     * @param numeroOficioRespC parametro numeroOficioRespC a actualizar
     */
    public void setNumeroOficioRespC(String numeroOficioRespC) {
        this.numeroOficioRespC = numeroOficioRespC;
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
     * @return el atributo numeroTramite
     */
    public String getNumeroTramite() {
        return numeroTramite;
    }

    /**
     * @param numeroTramite parametro numeroTramite a actualizar
     */
    public void setNumeroTramite(String numeroTramite) {
        this.numeroTramite = numeroTramite;
    }

    /**
     * @return el atributo calleTramite
     */
    public String getCalleTramite() {
        return calleTramite;
    }

    /**
     * @param calleTramite parametro calleTramite a actualizar
     */
    public void setCalleTramite(String calleTramite) {
        this.calleTramite = calleTramite;
    }

    /**
     * @return el atributo coloniaTramite
     */
    public String getColoniaTramite() {
        return coloniaTramite;
    }

    /**
     * @param coloniaTramite parametro coloniaTramite a actualizar
     */
    public void setColoniaTramite(String coloniaTramite) {
        this.coloniaTramite = coloniaTramite;
    }

    /**
     * @return el atributo municipioTramite
     */
    public String getMunicipioTramite() {
        return municipioTramite;
    }

    /**
     * @param municipioTramite parametro municipioTramite a actualizar
     */
    public void setMunicipioTramite(String municipioTramite) {
        this.municipioTramite = municipioTramite;
    }

    /**
     * @return el atributo estadoTramite
     */
    public String getEstadoTramite() {
        return estadoTramite;
    }

    /**
     * @param estadoTramite parametro estadoTramite a actualizar
     */
    public void setEstadoTramite(String estadoTramite) {
        this.estadoTramite = estadoTramite;
    }

    /**
     * @return el atributo paisTramite
     */
    public String getPaisTramite() {
        return paisTramite;
    }

    /**
     * @param paisTramite parametro paisTramite a actualizar
     */
    public void setPaisTramite(String paisTramite) {
        this.paisTramite = paisTramite;
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
        return "AnalisisRegistralUnicom [solicitudMacId=" + solicitudMacId + ", ciudadanoId="
            + ciudadanoId + ", tipoSituacionAnalisisRegistral="
            + tipoSituacionAnalisisRegistral + ", inicioTramite=" + inicioTramite
            + ", adscripcionAutJud=" + adscripcionAutJud + ", tipoResolucion="
            + tipoResolucion + ", fechaComunico=" + fechaComunico + ", juzgado=" + juzgado
            + ", causaPenal=" + causaPenal + ", nombreOfiRepMexicoExt="
            + nombreOfiRepMexicoExt + ", paisResidencia=" + paisResidencia + ", nombre="
            + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
            + apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + ", lugarNacimiento="
            + lugarNacimiento + ", adscripcionAutJudC=" + adscripcionAutJudC
            + ", tipoResolucionC=" + tipoResolucionC + ", numeroExpediente="
            + numeroExpediente + ", numeroOficioRespC=" + numeroOficioRespC
            + ", fechaTramite=" + fechaTramite + ", numeroTramite=" + numeroTramite
            + ", calleTramite=" + calleTramite + ", coloniaTramite=" + coloniaTramite
            + ", municipioTramite=" + municipioTramite + ", estadoTramite=" + estadoTramite
            + ", paisTramite=" + paisTramite + ", fuar=" + fuar + ", procesoSincronizacionId="
            + procesoSincronizacionId + "]";
    }

}
