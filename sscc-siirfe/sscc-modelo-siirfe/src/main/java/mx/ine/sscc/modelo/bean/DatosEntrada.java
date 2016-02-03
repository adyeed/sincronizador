/**
 * DatosEntrada.java
 * Fecha de creación: 09/11/2015, 15:25:17
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
package mx.ine.sscc.modelo.bean;

import java.io.Serializable;
import java.util.List;

import mx.ine.sscc.modelo.entidad.siirfe.AnalisisRegistralSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.ConsultaExternaSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.FuarExtranjeroSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.FuarRechazadoSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.FuarSiirfe;

/**
 * Datos para la sincronizacion
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class DatosEntrada implements Serializable {

    /**
     * TODO [Agregar documentación del atributo]
     */
    private static final long serialVersionUID = -5133921287122621048L;
    private List<AnalisisRegistralSiirfe> analisisRegistralSiirfe;
    private List<ConsultaExternaSiirfe> consultaExternaSiirfe;
    private List<FuarExtranjeroSiirfe> fuarExtranjeroSiirfe;
    private List<FuarRechazadoSiirfe> fuarRechazadoSiirfe;
    private List<FuarSiirfe> fuarSiirfe;
    private Long procesoSincronizacioId;
    private String threadName;

    /**
     * @return el atributo analisisRegistralSiirfe
     */
    public List<AnalisisRegistralSiirfe> getAnalisisRegistralSiirfe() {
        return analisisRegistralSiirfe;
    }

    /**
     * @param analisisRegistralSiirfe parametro analisisRegistralSiirfe a actualizar
     */
    public void setAnalisisRegistralSiirfe(
        List<AnalisisRegistralSiirfe> analisisRegistralSiirfe) {
        this.analisisRegistralSiirfe = analisisRegistralSiirfe;
    }

    /**
     * @return el atributo consultaExternaSiirfe
     */
    public List<ConsultaExternaSiirfe> getConsultaExternaSiirfe() {
        return consultaExternaSiirfe;
    }

    /**
     * @param consultaExternaSiirfe parametro consultaExternaSiirfe a actualizar
     */
    public void setConsultaExternaSiirfe(List<ConsultaExternaSiirfe> consultaExternaSiirfe) {
        this.consultaExternaSiirfe = consultaExternaSiirfe;
    }

    /**
     * @return el atributo fuarExtranjeroSiirfe
     */
    public List<FuarExtranjeroSiirfe> getFuarExtranjeroSiirfe() {
        return fuarExtranjeroSiirfe;
    }

    /**
     * @param fuarExtranjeroSiirfe parametro fuarExtranjeroSiirfe a actualizar
     */
    public void setFuarExtranjeroSiirfe(List<FuarExtranjeroSiirfe> fuarExtranjeroSiirfe) {
        this.fuarExtranjeroSiirfe = fuarExtranjeroSiirfe;
    }

    /**
     * @return el atributo fuarRechazadoSiirfe
     */
    public List<FuarRechazadoSiirfe> getFuarRechazadoSiirfe() {
        return fuarRechazadoSiirfe;
    }

    /**
     * @param fuarRechazadoSiirfe parametro fuarRechazadoSiirfe a actualizar
     */
    public void setFuarRechazadoSiirfe(List<FuarRechazadoSiirfe> fuarRechazadoSiirfe) {
        this.fuarRechazadoSiirfe = fuarRechazadoSiirfe;
    }

    /**
     * @return el atributo fuarSiirfe
     */
    public List<FuarSiirfe> getFuarSiirfe() {
        return fuarSiirfe;
    }

    /**
     * @param fuarSiirfe parametro fuarSiirfe a actualizar
     */
    public void setFuarSiirfe(List<FuarSiirfe> fuarSiirfe) {
        this.fuarSiirfe = fuarSiirfe;
    }

    /**
     * @return el atributo procesoSincronizacioId
     */
    public Long getProcesoSincronizacioId() {
        return procesoSincronizacioId;
    }

    /**
     * @param procesoSincronizacioId parametro procesoSincronizacioId a actualizar
     */
    public void setProcesoSincronizacioId(Long procesoSincronizacioId) {
        this.procesoSincronizacioId = procesoSincronizacioId;
    }

    /**
     * @return el atributo threadName
     */

    public String getThreadName() {
        return threadName;
    }

    /**
     * @param threadName parametro threadName a actualizar
     */
    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

}
