/**
 * AnalisisRegistralSiirfeDAO.java
 * Fecha de creación: 04/11/2015, 17:30:26
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

import mx.ine.sscc.modelo.entidad.siirfe.AnalisisRegistralSiirfe;

/**
 * Interfaz de acceso a datos para analisis registral
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface AnalisisRegistralSiirfeDAO {

    /**
     * Obtiene un bloque de 100 registros de analisis registral
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return AnalisisRegistralSiirfe
     */
    List<AnalisisRegistralSiirfe> getAnalisisRegistralSiirfe();

    /**
     * Actualiza un registro de analisis registral de acuerdo al ciudadano dado
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param ciudadanoId
     * @param controlSincronizacion
     */
    void updateAnalisisRegistralByCiudadanoId(Long ciudadanoId, String controlSincronizacion,
        Long bitacoraId);

    void updateAnalisisRegistralBySincId(String controlSincronizacion, Long bitacoraId);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return
     */
    long hasAvailableRecords();

}
