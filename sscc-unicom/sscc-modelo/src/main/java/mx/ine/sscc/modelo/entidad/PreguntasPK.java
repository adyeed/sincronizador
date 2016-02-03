/**
 * PreguntasPK.java
 * Fecha de creación: 22/12/2015, 17:23:57
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

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class PreguntasPK implements Serializable {

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */

    public PreguntasPK() {
        // TODO Auto-generated constructor stub
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */

    public PreguntasPK(Integer cuestionarioId, Integer preguntaId) {
        // TODO Auto-generated constructor stub
        this.cuestionarioId = cuestionarioId;
        this.preguntaId = preguntaId;
    }

    /**
     * TODO [Agregar documentación del atributo]
     */
    private static final long serialVersionUID = 3304489143585507339L;

    private Integer cuestionarioId;
    private Integer preguntaId;

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

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PreguntasPK [preguntaId=" + preguntaId + ", cuestionarioId=" + cuestionarioId
            + "]";
    }

}
