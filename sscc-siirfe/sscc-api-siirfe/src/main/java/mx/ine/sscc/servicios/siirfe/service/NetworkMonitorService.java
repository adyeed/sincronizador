/**
 * NetworkMonitorService.java
 * Fecha de creación: 03/11/2015, 16:21:56
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

/**
 * TODO [Servicio para verificar el tiempo de respuesta entre dos servidores por medio de un
 * ping.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface NetworkMonitorService {

    /**
     * TODO [Este método calcula el tiempo de respuesta de un ping a un servidor, regresando el
     * tiempo promedio de respuesta en Milisegundos.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return Promedio de tiempo en Milisegundos.
     */
    long getPromedio();

}
