/**
 * AnalisisRegistralSiirfe.java
 * Fecha de creación: 04/11/2015, 14:17:30
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
import java.util.List;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */

public class ProcesoSincronizacion implements Serializable {

    /**
     * TODO [Agregar documentación del atributo]
     */
    private static final long serialVersionUID = 1L;

    private Long procesoSincronizacionId;
    private String nombreProceso;
    private Date fechaInicio;
    private Date fechaFin;
    private String estatus;
    private String respuesta;
    private Long secuencia;
    private List<ControlProcesoSincronizacion> controlProcesoSincronizacion;

    /**
     * @return el atributo procesoSincronizacionId
     */
    public Long getProcesoSincronizacionId() {
        return procesoSincronizacionId;
    }

    /**
     * @param procesoSincronizacionId parametro procesoSincronizacionId a
     *        actualizar
     */
    public void setProcesoSincronizacionId(Long procesoSincronizacionId) {
        this.procesoSincronizacionId = procesoSincronizacionId;
    }

    /**
     * @return el atributo nombreProceso
     */
    public String getNombreProceso() {
        return nombreProceso;
    }

    /**
     * @param nombreProceso parametro nombreProceso a actualizar
     */
    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
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

    /**
     * @return el atributo estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus parametro estatus a actualizar
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * @return el atributo respuesta
     */
    public String getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta parametro respuesta a actualizar
     */
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
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
     * @return el atributo controlProcesoSincronizacion
     */
    public List<ControlProcesoSincronizacion> getControlProcesoSincronizacion() {
        return controlProcesoSincronizacion;
    }

    /**
     * @param controlProcesoSincronizacion parametro
     *        controlProcesoSincronizacion a actualizar
     */
    public void setControlProcesoSincronizacion(
        List<ControlProcesoSincronizacion> controlProcesoSincronizacion) {
        this.controlProcesoSincronizacion = controlProcesoSincronizacion;
    }

    /* La documentación de este método se encuentra en 
     * la clase o interface que lo declara (non-Javadoc)
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "ProcesoSincronizacion [procesoSincronizacionId=" + procesoSincronizacionId
            + ", nombreProceso=" + nombreProceso + ", fechaInicio=" + fechaInicio
            + ", fechaFin=" + fechaFin + ", estatus=" + estatus + ", respuesta=" + respuesta
            + ", secuencia=" + secuencia + ", controlProcesoSincronizacion="
            + controlProcesoSincronizacion + "]";
    }

}
