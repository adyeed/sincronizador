/**
 * AnalisisRegistralSiirfe.java
 * Fecha de creaci�n: 04/11/2015, 14:17:30
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
package mx.ine.sscc.modelo.entidad.siirfe;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */

public class ControlProcesoSincronizacion implements Serializable {

    /**
     * TODO [Agregar documentaci�n del atributo]
     */
    private static final long serialVersionUID = 1L;

    private ProcesoSincronizacion procesoSincronizacion;
    private Long secuencia;
    private String descripcionSecuencia;
    private String error;
    private Long registros;
    private Long registrosProcesados;
    private Date fechaInicio;
    private Date fechaFin;

    /**
     * @return el atributo procesoSincronizacion
     */
    public ProcesoSincronizacion getProcesoSincronizacion() {
        return procesoSincronizacion;
    }

    /**
     * @param procesoSincronizacion parametro procesoSincronizacion a actualizar
     */
    public void setProcesoSincronizacion(ProcesoSincronizacion procesoSincronizacion) {
        this.procesoSincronizacion = procesoSincronizacion;
    }

    /**
     * @return el atributo secuencia
     */
    public Long getSecuencia() {
        return secuencia;
    }

    /**
     * @param secuencia parametro secuencia a actualizar
     */
    public void setSecuencia(Long secuencia) {
        this.secuencia = secuencia;
    }

    /**
     * @return el atributo descripcionSecuencia
     */
    public String getDescripcionSecuencia() {
        return descripcionSecuencia;
    }

    /**
     * @param descripcionSecuencia parametro descripcionSecuencia a actualizar
     */
    public void setDescripcionSecuencia(String descripcionSecuencia) {
        this.descripcionSecuencia = descripcionSecuencia;
    }

    /**
     * @return el atributo error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error parametro error a actualizar
     */
    public void setError(String error) {
        this.error = error;
    }

    /**
     * @return el atributo registros
     */
    public Long getRegistros() {
        return registros;
    }

    /**
     * @param registros parametro registros a actualizar
     */
    public void setRegistros(Long registros) {
        this.registros = registros;
    }

    /**
     * @return el atributo registrosProcesados
     */
    public Long getRegistrosProcesados() {
        return registrosProcesados;
    }

    /**
     * @param registrosProcesados parametro registrosProcesados a actualizar
     */
    public void setRegistrosProcesados(Long registrosProcesados) {
        this.registrosProcesados = registrosProcesados;
    }

    /**
     * @return el atributo fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio parametro fechaInicio a actualizar
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     * @return el atributo fechaFin
     */
    public Date getFechaFin() {
        return fechaFin;
    }

    /**
     * @param fechaFin parametro fechaFin a actualizar
     */
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    /* La documentaci�n de este m�todo se encuentra en 
     * la clase o interface que lo declara (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return " secuencia=" + secuencia + ", descripcionSecuencia=" + descripcionSecuencia
            + ", error=" + error + ", registros=" + registros + ", registrosProcesados="
            + registrosProcesados + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin
            + "]";
    }

}