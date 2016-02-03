/**
 * FuarRechazadoSiirfeDAO.java
 * Fecha de creación: 04/11/2015, 17:45:49
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

import java.util.List;

import mx.ine.sscc.modelo.entidad.siirfe.FuarRechazadoSiirfe;

/**
 * Interfaz de acceso a datos para Fuar Rechazado
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface FuarRechazadoSiirfeDAO {
    /**
     * Obtiene un bloque de 100 registros de Fuar Rechazado
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return FuarRechazadoSiirfe
     */
    List<FuarRechazadoSiirfe> getFuarRechazado();

    /**
     * Actualiza un registro de FuarRechazado de acuerdo al fuar dado
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param id
     * @param controlSincronizacion
     */
    void updateFuarRechazadoById(Long id, String controlSincronizacion, Long bitacoraId);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param controlSincronizacion
     * @param bitacoraId
     */
    void updateFuarRechBySincId(String controlSincronizacion, Long bitacoraId);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return
     */
    public long hasAvailableRecords();

}
