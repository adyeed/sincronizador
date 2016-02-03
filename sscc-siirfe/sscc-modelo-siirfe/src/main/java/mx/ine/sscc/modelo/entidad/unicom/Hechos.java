/**
 * Hechos.java
 * Fecha de creaci�n: 08/12/2015, 17:02:02
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
 * clase que representa a la tabla HECHOS
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class Hechos implements Serializable {

    private static final long serialVersionUID = -245185410219991437L;
    private Long hechosId;
    private String descripcion;

    /**
     * @return el atributo hechosId
     */
    public Long getHechosId() {
        return hechosId;
    }

    /**
     * @param hechosId parametro hechosId a actualizar
     */
    public void setHechosId(Long hechosId) {
        this.hechosId = hechosId;
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

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Hechos [hechosId=" + hechosId + ", descripcion=" + descripcion + "]";
    }

}
