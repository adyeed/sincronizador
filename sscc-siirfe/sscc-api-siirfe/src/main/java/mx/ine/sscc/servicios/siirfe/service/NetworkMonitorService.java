/**
 * NetworkMonitorService.java
 * Fecha de creaci�n: 03/11/2015, 16:21:56
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

/**
 * TODO [Servicio para verificar el tiempo de respuesta entre dos servidores por medio de un
 * ping.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface NetworkMonitorService {

    /**
     * TODO [Este m�todo calcula el tiempo de respuesta de un ping a un servidor, regresando el
     * tiempo promedio de respuesta en Milisegundos.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return Promedio de tiempo en Milisegundos.
     */
    long getPromedio();

}
