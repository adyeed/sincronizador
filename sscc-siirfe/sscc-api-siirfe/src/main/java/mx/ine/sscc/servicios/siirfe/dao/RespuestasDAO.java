/**
 * RespuestasDAO.java
 * Fecha de creación: 28/12/2015, 18:23:22
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
package mx.ine.sscc.servicios.siirfe.dao;

import mx.ine.sscc.modelo.entidad.siirfe.RespuestasSiirfe;

/**
 * Interfaz para las operaciondes de Respuestas
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface RespuestasDAO {

    /**
     * Guarda un objeto de tipo Respuesta
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param respuesta
     */
    void saveRespuesta(RespuestasSiirfe respuesta);

}
