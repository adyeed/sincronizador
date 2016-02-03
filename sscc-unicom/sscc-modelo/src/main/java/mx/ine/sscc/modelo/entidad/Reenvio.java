/**
 * Reenvio.java
 * Fecha de creaci�n: 07/12/2015, 15:54:52
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
package mx.ine.sscc.modelo.entidad;

import java.io.Serializable;
import java.util.Date;

/**
 * clase que representa a la tabla REENVIO
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class Reenvio implements Serializable {

    private static final long serialVersionUID = 2636200080147673407L;
    private String folioSi;
    private Date fechaEnvio;
    private String estatusEnvio;
    private Date fechaActualizacion;
    private String cic;

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

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Reenvio [folioSi=" + folioSi + ", fechaEnvio=" + fechaEnvio
            + ", estatusEnvio=" + estatusEnvio + ", fechaActualizacion=" + fechaActualizacion
            + ", cic=" + cic + "]";
    }

}
