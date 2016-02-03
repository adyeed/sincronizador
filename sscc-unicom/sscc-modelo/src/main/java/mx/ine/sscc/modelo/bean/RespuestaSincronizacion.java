/**
 * RespuestaSincronizacion.java
 * Fecha de creación: Oct 29, 2015, 1:20:54 PM
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
import java.util.Map;

/**
 * Objeto de respuesta para la sincronización de ambos lados
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class RespuestaSincronizacion implements Serializable {

    /**
     * TODO [Agregar documentación del atributo]
     */
    private static final long serialVersionUID = -1000924821800195146L;
    private String mensajeError;

    private Map<Long, DatosSalida> responseHashMapObject;

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public RespuestaSincronizacion() {
        // TODO [codificar el cuerpo del método]
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public Map<Long, DatosSalida> getResponseHashMapObject() {
        return responseHashMapObject;
    }

    public void setResponseHashMapObject(Map<Long, DatosSalida> responseHashMapObject) {
        this.responseHashMapObject = responseHashMapObject;
    }

}