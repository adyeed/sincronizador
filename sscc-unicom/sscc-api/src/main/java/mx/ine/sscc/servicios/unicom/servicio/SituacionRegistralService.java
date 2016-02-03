/**
 * SituacionRegistralService.java
 * Fecha de creaci�n: 22/12/2015, 17:54:38
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
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param situacionRegistralList
     */
    void updateSituacion(List<SituacionRegistral> situacionRegistralList, String estatus);
}
