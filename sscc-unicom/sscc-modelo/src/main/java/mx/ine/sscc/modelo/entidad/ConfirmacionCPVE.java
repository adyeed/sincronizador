/**
 * ConfirmacionCPVE.java
 * Fecha de creación: 07/12/2015, 15:45:05
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
 * clase que representa a la tabla CONFIRMACIONCPVE
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class ConfirmacionCPVE implements Serializable {

    private static final long serialVersionUID = 6147513735163015090L;
    private String folioSi;
    private String numeroCic;
    private String correoElectronico;
    private String telefono;
    private Date fechaAlta;
    private Date fechaActualizacion;
    private String estatusEnvio;

    /**
     * @return el atributo folioSi
     */
    public String getFolioSi() {
        return folioSi;
    }

    /**
     * @param folioSi parametro folioSi a actualizar
     */
    public void setFolioSi(String folioSi) {
        this.folioSi = folioSi;
    }

    /**
     * @return el atributo numeroCic
     */
    public String getNumeroCic() {
        return numeroCic;
    }

    /**
     * @param numeroCic parametro numeroCic a actualizar
     */
    public void setNumeroCic(String numeroCic) {
        this.numeroCic = numeroCic;
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
     * @return el atributo fechaAlta
     */
    public Date getFechaAlta() {
        return fechaAlta;
    }

    /**
     * @param fechaAlta parametro fechaAlta a actualizar
     */
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * @return el atributo fechaActualizacion
     */
    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    /**
     * @param fechaActualizacion parametro fechaActualizacion a actualizar
     */
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    /**
     * @return el atributo estatusEnvio
     */
    public String getEstatusEnvio() {
        return estatusEnvio;
    }

    /**
     * @param estatusEnvio parametro estatusEnvio a actualizar
     */
    public void setEstatusEnvio(String estatusEnvio) {
        this.estatusEnvio = estatusEnvio;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ConfirmacionCPVE [folioSi=" + folioSi + ", numeroCic=" + numeroCic
            + ", correoElectronico=" + correoElectronico + ", telefono=" + telefono
            + ", fechaAlta=" + fechaAlta + ", fechaActualizacion=" + fechaActualizacion
            + ", estatusEnvio=" + estatusEnvio + "]";
    }

}
