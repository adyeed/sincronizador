/**
 * AnalisisRegistralSiirfeDAO.java
 * Fecha de creaci�n: 04/11/2015, 17:30:26
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
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return
     */
    long hasAvailableRecords();

}
