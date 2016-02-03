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
package mx.ine.sscc.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

/**
 * clase que representa a la tabla CONSULTAEXTERNA
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class ConsultaExterna implements Serializable {

    private static final long serialVersionUID = -8775039081441359545L;
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
    private Long estatusCiudadanoId;
    private Long tipoBajaPadronId;
    private Boolean residenteExtranjero;
    private Date fechaCreacion;
    private Date fechaUltimoTramite;
    private Date vigenciaCredencial;
    private Long entidadId;
    private String seccion;
    private Long tipoReincorporacionPadronId;
    private Long reporteRoboExtravioId;
    private Long estatusRoboExtravioId;
    private Long causaRoboExtravioId;
    private Boolean controlRegistro;

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
    public Long getEstatusCiudadanoId() {
        return estatusCiudadanoId;
    }

    /**
     * @param estatusCiudadanoId parametro estatusCiudadanoId a actualizar
     */
    public void setEstatusCiudadanoId(Long estatusCiudadanoId) {
        this.estatusCiudadanoId = estatusCiudadanoId;
    }

    /**
     * @return el atributo tipoBajaPadronId
     */
    public Long getTipoBajaPadronId() {
        return tipoBajaPadronId;
    }

    /**
     * @param tipoBajaPadronId parametro tipoBajaPadronId a actualizar
     */
    public void setTipoBajaPadronId(Long tipoBajaPadronId) {
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
     * @return el atributo entidadId
     */
    public Long getEntidadId() {
        return entidadId;
    }

    /**
     * @param entidadId parametro entidadId a actualizar
     */
    public void setEntidadId(Long entidadId) {
        this.entidadId = entidadId;
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
    public Long getTipoReincorporacionPadronId() {
        return tipoReincorporacionPadronId;
    }

    /**
     * @param tipoReincorporacionPadronId parametro tipoReincorporacionPadronId a actualizar
     */
    public void setTipoReincorporacionPadronId(Long tipoReincorporacionPadronId) {
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
    public Long getEstatusRoboExtravioId() {
        return estatusRoboExtravioId;
    }

    /**
     * @param estatusRoboExtravioId parametro estatusRoboExtravioId a actualizar
     */
    public void setEstatusRoboExtravioId(Long estatusRoboExtravioId) {
        this.estatusRoboExtravioId = estatusRoboExtravioId;
    }

    /**
     * @return el atributo causaRoboExtravioId
     */
    public Long getCausaRoboExtravioId() {
        return causaRoboExtravioId;
    }

    /**
     * @param causaRoboExtravioId parametro causaRoboExtravioId a actualizar
     */
    public void setCausaRoboExtravioId(Long causaRoboExtravioId) {
        this.causaRoboExtravioId = causaRoboExtravioId;
    }

    /**
     * @return el atributo controlRegistro
     */
    public Boolean getControlRegistro() {
        return controlRegistro;
    }

    /**
     * @param controlRegistro parametro controlRegistro a actualizar
     */
    public void setControlRegistro(Boolean controlRegistro) {
        this.controlRegistro = controlRegistro;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ConsultaExterna [ciudadanoId=" + ciudadanoId + ", credencialId="
            + credencialId + ", claveElector=" + claveElector + ", numeroEmisionCredencial="
            + numeroEmisionCredencial + ", ocr=" + ocr + ", cic=" + cic + ", curp=" + curp
            + ", fechaInscripcionPadron=" + fechaInscripcionPadron + ", nombre=" + nombre
            + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno
            + ", estatusCiudadanoId=" + estatusCiudadanoId + ", tipoBajaPadronId="
            + tipoBajaPadronId + ", residenteExtranjero=" + residenteExtranjero
            + ", fechaCreacion=" + fechaCreacion + ", fechaUltimoTramite="
            + fechaUltimoTramite + ", vigenciaCredencial=" + vigenciaCredencial
            + ", entidadId=" + entidadId + ", seccion=" + seccion
            + ", tipoReincorporacionPadronId=" + tipoReincorporacionPadronId
            + ", reporteRoboExtravioId=" + reporteRoboExtravioId + ", estatusRoboExtravioId="
            + estatusRoboExtravioId + ", causaRoboExtravioId=" + causaRoboExtravioId
            + ", controlRegistro=" + controlRegistro + "]";
    }

}
