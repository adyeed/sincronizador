/**
 * FuarExtrService.java
 * Fecha de creación: 27/11/2015, 14:12:07
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */

package mx.ine.sscc.servicios.siirfe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.entidad.siirfe.FuarExtranjeroSiirfe;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public interface FuarExtrService {

    /**
     * Obtiene un bloque de 100 registros de FUAREXTRANJERO, cambiando el estatus
     * sincronizacion de ese bloque a procesado 'p'
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param bitacoraId
     * @return List<FuarExtranjeroSiirfe>
     */
    List<FuarExtranjeroSiirfe> obtieneListaFuarExtranjero(Long bitacoraId);

    /**
     * TODO [Obtiene el numero de registros disponibles para sincronizar.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return Número de registros.
     */
    long getHasAvailableRecordsFuarExtr();

    /**
     * TODO [Actualiza un registro por ID, Estatus y Id de Bloque procesado]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param id
     * @param nuevoEstatus
     * @param bitacoraId
     */
    void actualizaFuarExt(String id, String nuevoEstatus, Long bitacoraId);

    /**
     * TODO [Actualiza un registro por Id de Bloque procesado]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param nuevoEstatus
     * @param bitacoraId
     */
    void actualizaBloqueFuarExt(String nuevoEstatus, Long bitacoraId);

}
