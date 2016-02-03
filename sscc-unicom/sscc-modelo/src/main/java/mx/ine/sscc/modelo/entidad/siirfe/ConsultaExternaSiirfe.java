/**
 * ConsultaExterna.java
 * Fecha de creación: 28/10/2015, 11:32:09
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
 * clase que representa a la tabla CONSULTAEXTERNA en el esquema de CONCILIACIONES del SIIRFE
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class ConsultaExternaSiirfe implements Serializable {

    private static final long serialVersionUID = 8920719214714840168L;
    private Long ciudadanoId;
    private Long credencialId;
    private String claveElector;
    private Integer numeroEmisionCredencial;
    private String ocr;
    private String cic;
    private String curp;
    private Date fechaInscripcionPadron;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer estatusCiudadanoId;
    private Integer tipoBajaPadronId;
    private Boolean residenteExtranjero;
    private Date fechaCreacion;
    private Date fechaUltimoTramite;
    private Date vigenciaCredencial;
    private Integer entidad;
    private String seccion;
    private Integer tipoReincorporacionPadronId;
    private Long reporteRoboExtravioId;
    private Integer estatusRoboExtravioId;
    private Integer causaRoboExtravioId;
    private String controlSincronizacion;
    private Long procesoSincronizacionId;

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
     * @return el atributo credencialId
     */
    public Long getCredencialId() {
        return credencialId;
    }

    /**
     * @param credencialId parametro credencialId a actualizar
     */
    public void setCredencialId(Long credencialId) {
        this.credencialId = credencialId;
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
     * @return el atributo numeroEmisionCredencial
     */
    public Integer getNumeroEmisionCredencial() {
        return numeroEmisionCredencial;
    }

    /**
     * @param numeroEmisionCredencial parametro numeroEmisionCredencial a actualizar
     */
    public void setNumeroEmisionCredencial(Integer numeroEmisionCredencial) {
        this.numeroEmisionCredencial = numeroEmisionCredencial;
    }

    /**
     * @return el atributo ocr
     */
    public String getOcr() {
        return ocr;
    }

    /**
     * @param ocr parametro ocr a actualizar
     */
    public void setOcr(String ocr) {
        this.ocr = ocr;
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
     * @return el atributo fechaInscripcionPadron
     */
    public Date getFechaInscripcionPadron() {
        return fechaInscripcionPadron;
    }

    /**
     * @param fechaInscripcionPadron parametro fechaInscripcionPadron a actualizar
     */
    public void setFechaInscripcionPadron(Date fechaInscripcionPadron) {
        this.fechaInscripcionPadron = fechaInscripcionPadron;
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
     * @return el atributo estatusCiudadanoId
     */
    public Integer getEstatusCiudadanoId() {
        return estatusCiudadanoId;
    }

    /**
     * @param estatusCiudadanoId parametro estatusCiudadanoId a actualizar
     */
    public void setEstatusCiudadanoId(Integer estatusCiudadanoId) {
        this.estatusCiudadanoId = estatusCiudadanoId;
    }

    /**
     * @return el atributo tipoBajaPadronId
     */
    public Integer getTipoBajaPadronId() {
        return tipoBajaPadronId;
    }

    /**
     * @param tipoBajaPadronId parametro tipoBajaPadronId a actualizar
     */
    public void setTipoBajaPadronId(Integer tipoBajaPadronId) {
        this.tipoBajaPadronId = tipoBajaPadronId;
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
     * @return el atributo fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion parametro fechaCreacion a actualizar
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return el atributo fechaUltimoTramite
     */
    public Date getFechaUltimoTramite() {
        return fechaUltimoTramite;
    }

    /**
     * @param fechaUltimoTramite parametro fechaUltimoTramite a actualizar
     */
    public void setFechaUltimoTramite(Date fechaUltimoTramite) {
        this.fechaUltimoTramite = fechaUltimoTramite;
    }

    /**
     * @return el atributo vigenciaCredencial
     */
    public Date getVigenciaCredencial() {
        return vigenciaCredencial;
    }

    /**
     * @param vigenciaCredencial parametro vigenciaCredencial a actualizar
     */
    public void setVigenciaCredencial(Date vigenciaCredencial) {
        this.vigenciaCredencial = vigenciaCredencial;
    }

    /**
     * @return el atributo entidad
     */
    public Integer getEntidad() {
        return entidad;
    }

    /**
     * @param entidad parametro entidad a actualizar
     */
    public void setEntidad(Integer entidad) {
        this.entidad = entidad;
    }

    /**
     * @return el atributo seccion
     */
    public String getSeccion() {
        return seccion;
    }

    /**
     * @param seccion parametro seccion a actualizar
     */
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    /**
     * @return el atributo tipoReincorporacionPadronId
     */
    public Integer getTipoReincorporacionPadronId() {
        return tipoReincorporacionPadronId;
    }

    /**
     * @param tipoReincorporacionPadronId parametro tipoReincorporacionPadronId a actualizar
     */
    public void setTipoReincorporacionPadronId(Integer tipoReincorporacionPadronId) {
        this.tipoReincorporacionPadronId = tipoReincorporacionPadronId;
    }

    /**
     * @return el atributo reporteRoboExtravioId
     */
    public Long getReporteRoboExtravioId() {
        return reporteRoboExtravioId;
    }

    /**
     * @param reporteRoboExtravioId parametro reporteRoboExtravioId a actualizar
     */
    public void setReporteRoboExtravioId(Long reporteRoboExtravioId) {
        this.reporteRoboExtravioId = reporteRoboExtravioId;
    }

    /**
     * @return el atributo estatusRoboExtravioId
     */
    public Integer getEstatusRoboExtravioId() {
        return estatusRoboExtravioId;
    }

    /**
     * @param estatusRoboExtravioId parametro estatusRoboExtravioId a actualizar
     */
    public void setEstatusRoboExtravioId(Integer estatusRoboExtravioId) {
        this.estatusRoboExtravioId = estatusRoboExtravioId;
    }

    /**
     * @return el atributo causaRoboExtravioId
     */
    public Integer getCausaRoboExtravioId() {
        return causaRoboExtravioId;
    }

    /**
     * @param causaRoboExtravioId parametro causaRoboExtravioId a actualizar
     */
    public void setCausaRoboExtravioId(Integer causaRoboExtravioId) {
        this.causaRoboExtravioId = causaRoboExtravioId;
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
        return "ConsultaExternaSiirfe [ciudadanoId=" + ciudadanoId + ", credencialId="
            + credencialId + ", claveElector=" + claveElector + ", numeroEmisionCredencial="
            + numeroEmisionCredencial + ", ocr=" + ocr + ", cic=" + cic + ", curp=" + curp
            + ", fechaInscripcionPadron=" + fechaInscripcionPadron + ", nombre=" + nombre
            + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
            + ", estatusCiudadanoId=" + estatusCiudadanoId + ", tipoBajaPadronId="
            + tipoBajaPadronId + ", residenteExtranjero=" + residenteExtranjero
            + ", fechaCreacion=" + fechaCreacion + ", fechaUltimoTramite="
            + fechaUltimoTramite + ", vigenciaCredencial=" + vigenciaCredencial + ", entidad="
            + entidad + ", seccion=" + seccion + ", tipoReincorporacionPadronId="
            + tipoReincorporacionPadronId + ", reporteRoboExtravioId=" + reporteRoboExtravioId
            + ", estatusRoboExtravioId=" + estatusRoboExtravioId + ", causaRoboExtravioId="
            + causaRoboExtravioId + ", controlSincronizacion=" + controlSincronizacion
            + ", procesoSincronizacionId=" + procesoSincronizacionId + "]";
    }

}
