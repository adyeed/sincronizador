/**
 * Notificacion.java
 * Fecha de creación: 17/12/2015, 16:25:46
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
import java.sql.Clob;
import java.util.Date;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 2164397534979471907L;
    private Long notificacionId;
    private String modulo;
    private String fuar;
    private Date fechaIngresoCecyrd;
    private Date fechaProceso;
    private Clob notificacion;
    private Integer versionXml;
    private Clob detalleRechazo;
    private Integer estatusCredencialId;
    private Integer estatusNotificacionId;
    private Integer tipoNotificacionId;
    private Long procesoDigitalizacionId;
    private Date fechaTramite;
    private Integer paisId;
    private String folioMRE;

    /**
     * @return el atributo notificacionId
     */
    public Long getNotificacionId() {
        return notificacionId;
    }

    /**
     * @param notificacionId parametro notificacionId a actualizar
     */
    public void setNotificacionId(Long notificacionId) {
        this.notificacionId = notificacionId;
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
     * @return el atributo fechaIngresoCecyrd
     */
    public Date getFechaIngresoCecyrd() {
        return fechaIngresoCecyrd;
    }

    /**
     * @param fechaIngresoCecyrd parametro fechaIngresoCecyrd a actualizar
     */
    public void setFechaIngresoCecyrd(Date fechaIngresoCecyrd) {
        this.fechaIngresoCecyrd = fechaIngresoCecyrd;
    }

    /**
     * @return el atributo fechaProceso
     */
    public Date getFechaProceso() {
        return fechaProceso;
    }

    /**
     * @param fechaProceso parametro fechaProceso a actualizar
     */
    public void setFechaProceso(Date fechaProceso) {
        this.fechaProceso = fechaProceso;
    }

    /**
     * @return el atributo notifiacacion
     */
    public Clob getNotificacion() {
        return notificacion;
    }

    /**
     * @param notificacion
     */
    public void setNotificacion(Clob notificacion) {
        this.notificacion = notificacion;
    }

    /**
     * @return el atributo versionXml
     */
    public Integer getVersionXml() {
        return versionXml;
    }

    /**
     * @param versionXml parametro versionXml a actualizar
     */
    public void setVersionXml(Integer versionXml) {
        this.versionXml = versionXml;
    }

    /**
     * @return el atributo detalleRechazo
     */
    public Clob getDetalleRechazo() {
        return detalleRechazo;
    }

    /**
     * @param detalleRechazo parametro detalleRechazo a actualizar
     */
    public void setDetalleRechazo(Clob detalleRechazo) {
        this.detalleRechazo = detalleRechazo;
    }

    /**
     * @return el atributo estatusCredencialId
     */
    public Integer getEstatusCredencialId() {
        return estatusCredencialId;
    }

    /**
     * @param estatusCredencialId parametro estatusCredencialId a actualizar
     */
    public void setEstatusCredencialId(Integer estatusCredencialId) {
        this.estatusCredencialId = estatusCredencialId;
    }

    /**
     * @return el atributo estatusNotificacionId
     */
    public Integer getEstatusNotificacionId() {
        return estatusNotificacionId;
    }

    /**
     * @param estatusNotificacionId parametro estatusNotificacionId a actualizar
     */
    public void setEstatusNotificacionId(Integer estatusNotificacionId) {
        this.estatusNotificacionId = estatusNotificacionId;
    }

    /**
     * @return el atributo tipoNotificacionId
     */
    public Integer getTipoNotificacionId() {
        return tipoNotificacionId;
    }

    /**
     * @param tipoNotificacionId parametro tipoNotificacionId a actualizar
     */
    public void setTipoNotificacionId(Integer tipoNotificacionId) {
        this.tipoNotificacionId = tipoNotificacionId;
    }

    /**
     * @return el atributo procesoDigitalizacionId
     */
    public Long getProcesoDigitalizacionId() {
        return procesoDigitalizacionId;
    }

    /**
     * @param procesoDigitalizacionId parametro procesoDigitalizacionId a actualizar
     */
    public void setProcesoDigitalizacionId(Long procesoDigitalizacionId) {
        this.procesoDigitalizacionId = procesoDigitalizacionId;
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
     * @return el atributo paisId
     */
    public Integer getPaisId() {
        return paisId;
    }

    /**
     * @param paisId parametro paisId a actualizar
     */
    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Notificacion [notificacionId=" + notificacionId + ", modulo=" + modulo
            + ", fuar=" + fuar + ", fechaIngresoCecyrd=" + fechaIngresoCecyrd
            + ", fechaProceso=" + fechaProceso + ", notifiacacion=" + notificacion
            + ", versionXml=" + versionXml + ", detalleRechazo=" + detalleRechazo
            + ", estatusCredencialId=" + estatusCredencialId + ", estatusNotificacionId="
            + estatusNotificacionId + ", tipoNotificacionId=" + tipoNotificacionId
            + ", procesoDigitalizacionId=" + procesoDigitalizacionId + ", fechaTramite="
            + fechaTramite + ", paisId=" + paisId + "]";
    }

    /**
     * @return el atributo folioMRE
     */

    public String getFolioMRE() {
        return folioMRE;
    }

    /**
     * @param folioMRE parametro folioMRE a actualizar
     */
    public void setFolioMRE(String folioMRE) {
        this.folioMRE = folioMRE;
    }

}
