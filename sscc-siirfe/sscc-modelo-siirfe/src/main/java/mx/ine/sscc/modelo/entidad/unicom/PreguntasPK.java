/**
 * PreguntasPK.java
 * Fecha de creaci�n: 22/12/2015, 17:23:57
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
package mx.ine.sscc.modelo.entidad.unicom;

import java.io.Serializable;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class PreguntasPK implements Serializable {

    /**
     * TODO [Agregar documentaci�n del atributo]
     */
    private static final long serialVersionUID = 3304489143585507339L;
    private Integer preguntaId;
    private Integer cuestionarioId;

    /**
     * @return el atributo preguntaId
     */
    public Integer getPreguntaId() {
        return preguntaId;
    }

    /**
     * @param preguntaId parametro preguntaId a actualizar
     */
    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    /**
     * @return el atributo cuestionarioId
     */
    public Integer getCuestionarioId() {
        return cuestionarioId;
    }

    /**
     * @param cuestionarioId parametro cuestionarioId a actualizar
     */
    public void setCuestionarioId(Integer cuestionarioId) {
        this.cuestionarioId = cuestionarioId;
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PreguntasPK [preguntaId=" + preguntaId + ", cuestionarioId=" + cuestionarioId
            + "]";
    }

}
