/**
 * ConfirmacionCPVEService.java
 * Fecha de creaci�n: 16/12/2015, 19:02:31
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Federal Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */

package mx.ine.sscc.servicios.unicom.servicio;

import mx.ine.sscc.modelo.entidad.ConfirmacionCPVE;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface ConfirmacionCPVEService {

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @return ConfirmacionCPVE
     */
    ConfirmacionCPVE obtieneConfirmacionCPVE();

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @return registros listos para procesar.
     */
    long datosDisponibles();

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param folio
     * @param estatus
     * @param nuevoEstatus
     */
    void actualizaEstatus(String folio, String estatus, String nuevoEstatus);

}
