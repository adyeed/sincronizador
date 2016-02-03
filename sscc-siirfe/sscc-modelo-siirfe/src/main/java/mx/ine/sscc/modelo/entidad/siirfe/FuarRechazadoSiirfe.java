/**
 * FuarRechazadoSiirfe.java
 * Fecha de creación: 04/11/2015, 12:00:32
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
 * clase que representa a la tabla FUAR_RECHAZADO en el esquema de CONCILIACIONES del SIIRFE
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class FuarRechazadoSiirfe implements Serializable {

    private static final long serialVersionUID = -3993050615506916967L;
    private Long id;
    private String fuar;
    private String clave;
    private String descripcion;
    private String usuarioAudit;
    private Date fechaAudit;
    private String controlSincronizacion;
    private Long procesoSincronizacionId;

    /**
     * @return el atributo id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id parametro id a actualizar
     */
    public void setId(Long id) {
        this.id = id;
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
     * @return el atributo clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave parametro clave a actualizar
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return el atributo descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion parametro descripcion a actualizar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return el atributo usuarioAudit
     */
    public String getUsuarioAudit() {
        return usuarioAudit;
    }

    /**
     * @param usuarioAudit parametro usuarioAudit a actualizar
     */
    public void setUsuarioAudit(String usuarioAudit) {
        this.usuarioAudit = usuarioAudit;
    }

    /**
     * @return el atributo fechaAudit
     */
    public Date getFechaAudit() {
        return fechaAudit;
    }

    /**
     * @param fechaAudit parametro fechaAudit a actualizar
     */
    public void setFechaAudit(Date fechaAudit) {
        this.fechaAudit = fechaAudit;
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

}
