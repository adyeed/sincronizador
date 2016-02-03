/**
 * SituacionRegistralDAO.java
 * Fecha de creación: 10/12/2015, 13:00:30
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
     * @return Lista de objetos de situación registral.
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
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param situacionRegistralList
     * @param estatus
     * @return
     */
    List<SituacionRegistral> updateSituacion(List<SituacionRegistral> situacionRegistralList,
        String estatus);

}
