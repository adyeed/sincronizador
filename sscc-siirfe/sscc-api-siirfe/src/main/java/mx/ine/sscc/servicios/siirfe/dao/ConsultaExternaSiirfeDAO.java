/**
 * ConsultaExternaSiirfeDAO.java
 * Fecha de creaci�n: 04/11/2015, 17:34:39
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

import mx.ine.sscc.modelo.entidad.siirfe.ConsultaExternaSiirfe;

/**
 * Interfaz de acceso a datos para Consulta Externa
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface ConsultaExternaSiirfeDAO {
    /**
     * Obtiene un bloque de 100 registros de ConsultaExterna
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return ConsultaExternaSiirfe
     */
    List<ConsultaExternaSiirfe> getConsultaExterna();

    /**
     * Actualiza un registro de ConsultaExterna de acuerdo al id del ciudadano
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param fuar
     * @param controlSincronizacion
     */
    void updateConsultaExternaById(Long idCiudadano, String controlSincronizacion,
        Long bitacoraId);

    void updateConsultaExtBySincId(String controlSincronizacion, Long bitacoraId);

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return N�mero de registros disponibles para sincronizar.
     */
    public long hasAvailableRecords();

}
