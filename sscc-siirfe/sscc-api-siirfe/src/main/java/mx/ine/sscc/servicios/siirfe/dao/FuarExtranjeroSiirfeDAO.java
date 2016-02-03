/**
 * FuarExtranjeroSiirfeDAO.java
 * Fecha de creación: 04/11/2015, 17:35:33
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

import mx.ine.sscc.modelo.entidad.siirfe.FuarExtranjeroSiirfe;

/**
 * Interfaz de acceso a datos para Fuar Extranjero
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface FuarExtranjeroSiirfeDAO {
    /**
     * Obtiene un bloque de 100 registros de Fuar extranjero
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return
     */
    List<FuarExtranjeroSiirfe> getFuarExtranjero();

    /**
     * Actualiza un registro de FuarExtranjero de acuerdo al fuar dado
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param fuar
     * @param controlSincronizacion
     */
    void updateFuarExtranjeroByFuar(String fuar, String controlSincronizacion,
        Long bitacoraId);

    void updateFuarExtBySincId(String controlSincronizacion, Long bitacoraId);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return
     */
    public long hasAvailableRecords();

}
