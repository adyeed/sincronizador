/**
 * ReenvioDAO.java
 * Fecha de creación: 10/12/2015, 13:02:14
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

import java.util.Date;

import mx.ine.sscc.modelo.entidad.Reenvio;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface ReenvioDAO {

    /**
     * Obtiene un registro en estatus 'P' de la tabla REENVIO
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return reenvio
     */
    Reenvio getReenvio();

    /**
     * Actualiza el estatus de un registro de acuerdo al folio y fecha de envio
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param folio
     * @param fechaEnvio
     * @param estatus
     * @param nuevoEstatus
     */
    void updateEstatus(String folio, Date fechaEnvio, String estatus, String nuevoEstatus);

    /**
     * TODO [obtiene el número de registros disponibles para generar notificación.]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @return Número de datos.
     */
    long getDatosDisponibles();

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param reenvio
     */
    void update(Reenvio reenvio);

}
