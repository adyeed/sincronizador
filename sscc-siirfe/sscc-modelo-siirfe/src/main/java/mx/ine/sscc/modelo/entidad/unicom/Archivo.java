/**
 * Archivo.java
 * Fecha de creación: 08/12/2015, 16:47:49
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
package mx.ine.sscc.modelo.entidad.unicom;

import java.io.Serializable;
import java.util.Arrays;

/**
 * clase que representa a la tabla ARCHIVO
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class Archivo implements Serializable {

    private static final long serialVersionUID = 5344110404135107735L;
    private Integer archivoId;
    private Byte[] documento;

    /**
     * @return el atributo archivoId
     */
    public Integer getArchivoId() {
        return archivoId;
    }

    /**
     * @param archivoId parametro archivoId a actualizar
     */
    public void setArchivoId(Integer archivoId) {
        this.archivoId = archivoId;
    }

    /**
     * @return el atributo documento
     */
    public Byte[] getDocumento() {
        return documento;
    }

    /**
     * @param documento parametro documento a actualizar
     */
    public void setDocumento(Byte[] documento) {
        this.documento = documento;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Archivo [archivoId=" + archivoId + ", documento=" + Arrays.toString(documento)
            + "]";
    }

}
