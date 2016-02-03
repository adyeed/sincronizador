/**
 * SituacionRegistralDAO.java
 * Fecha de creaci�n: 10/12/2015, 13:00:30
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
package mx.ine.sscc.servicios.unicom.dao;

import java.util.List;

import mx.ine.sscc.modelo.entidad.SituacionRegistral;
import mx.ine.sscc.modelo.entidad.SituacionRegistralPK;

/**
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface SituacionRegistralDAO {

    /**
     * Obtiene un bloque de objetos de situacion registral
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return Lista de objetos de situaci�n registral.
     */
    List<SituacionRegistral> getSituacion();

    /**
     * Actualiza el estatus de la situacion registral
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param id
     * @param estatus
     * @param nuevoEstatus
     */
    void updateEstatusSituacionRegistral(SituacionRegistralPK id, String estatus,
        String nuevoEstatus);

    /**
     * obtiene el numero de registros disponibles
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return datos disponibles.
     *
     */
    long getDatosDisponibles();

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param situacionRegistralList
     * @param estatus
     * @return
     */
    List<SituacionRegistral> updateSituacion(List<SituacionRegistral> situacionRegistralList,
        String estatus);

}
