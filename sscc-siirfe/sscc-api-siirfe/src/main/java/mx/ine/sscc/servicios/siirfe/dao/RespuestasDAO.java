/**
 * RespuestasDAO.java
 * Fecha de creaci�n: 28/12/2015, 18:23:22
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
