/**
 * RespuestaSincronizacion.java
 * Fecha de creaci�n: Oct 29, 2015, 1:20:54 PM
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
package mx.ine.sscc.modelo.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * Objeto de respuesta para la sincronizaci�n de ambos lados
 * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class RespuestaSincronizacion implements Serializable {

    /**
     * TODO [Agregar documentaci�n del atributo]
     */
    private static final long serialVersionUID = -1000924821800195146L;
    private String mensajeError;

    private Map<Long, DatosSalida> responseHashMapObject;

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    public RespuestaSincronizacion() {
        // TODO [codificar el cuerpo del m�todo]
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