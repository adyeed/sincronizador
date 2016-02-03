/**
 * ConsultaExternaService.java
 * Fecha de creaci�n: 28/11/2015, 15:36:09
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

package mx.ine.sscc.servicios.siirfe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.entidad.siirfe.ConsultaExternaSiirfe;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public interface ConsultaExternaService {

    /**
     * Obtiene un bloque de 100 registros de CONSULTA EXTERNA, cambiando el estatus
     * sincronizacion de ese bloque a procesado 'p'
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param bitacoraId
     * @return List<FuarExtranjeroSiirfe>
     */
    List<ConsultaExternaSiirfe> obtieneListaConsultaExtr(Long bitacoraId);

    /**
     * TODO [Obtiene el numero de registros disponibles para sincronizar.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return N�mero de registros.
     */
    long getHasAvailableRecordsConsultaExtr();

    /**
     * TODO [Actualiza un registro por ID, Estatus y Id de Bloque procesado]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param id
     * @param nuevoEstatus
     * @param boqueId
     */
    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param id
     * @param nuevoEstatus
     * @param bitacoraId
     */
    void actualizaConsultaExtr(Long id, String nuevoEstatus, Long bitacoraId);

    /**
     * TODO [Actualiza un registro por Id de Bloque procesado]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param nuevoEstatus
     * @param boqueId
     */
    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param nuevoEstatus
     * @param bitacoraId
     */
    void actualizaBloqueConsultaExtr(String nuevoEstatus, Long bitacoraId);

}
