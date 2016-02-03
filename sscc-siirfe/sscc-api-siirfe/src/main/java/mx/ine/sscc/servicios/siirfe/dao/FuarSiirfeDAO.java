/**
 * FuarSiirfeDAO.java
 * Fecha de creación: 04/11/2015, 17:47:34
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

import mx.ine.sscc.modelo.entidad.siirfe.FuarSiirfe;

/**
 * Interfaz de acceso a datos para Fuar
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */

public interface FuarSiirfeDAO {

    /**
     * Obtiene un bloque de 100 registros de Fuars
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return FuarSiirfe
     */
    List<FuarSiirfe> getFuarSiirfe();

    /**
     * Actualiza un registro de Fuar de acuerdo al fuar dado
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param id
     * @param controlSincronizacion
     * @param bitacoraId
     */
    void updateFuarById(Long id, String controlSincronizacion, Long bitacoraId);

    void updateFuarBySincId(String controlSincronizacion, Long bitacoraId);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return
     */
    public long hasAvailableRecords();

}
