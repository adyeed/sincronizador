/**
 * SituacionRegistralService.java
 * Fecha de creación: 22/12/2015, 17:54:38
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
package mx.ine.sscc.servicios.unicom.servicio;

import java.util.List;

import mx.ine.sscc.modelo.entidad.SituacionRegistral;
import mx.ine.sscc.modelo.entidad.SituacionRegistralPK;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface SituacionRegistralService {

    /**
     * obtiene una lista de objetos de tipo situacion registral
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return
     */
    public List<SituacionRegistral> obtieneSituacionRegistral();

    /**
     * Actualiza el estatus de la situacion registral
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param id
     * @param estatus
     * @param nuevoEstatus
     */
    void actualizaEstatusSituacionRegistral(SituacionRegistralPK id, String estatus,
        String nuevoEstatus);

    /**
     * obtiene el numero de datos disponibles pendientes por procesar
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return numero de datos.
     */
    long datosDisponibles();

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param situacionRegistralList
     */
    void updateSituacion(List<SituacionRegistral> situacionRegistralList, String estatus);
}
