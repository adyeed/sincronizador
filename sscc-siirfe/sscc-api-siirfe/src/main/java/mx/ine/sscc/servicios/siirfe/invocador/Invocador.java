/**
 * SwitchSincroniza.java
 * Fecha de creaci�n: 13/11/2015, 14:21:21
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

package mx.ine.sscc.servicios.siirfe.invocador;

import java.util.concurrent.Callable;

/**
 * TODO [Interface que define el comportamiento de la clase encargada de invocar las tareas de
 * trabajo para la sincronizaci�n de las tablas.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
public interface Invocador {

    /**
     * TODO [M�todo que inicia la sincronizaci�n de alguna tabla]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return Retorna un objeto de tipo Callable, este objeto contiene la unidad de trabajo
     *         necesaria para la sincronizaci�n de cada tabla.
     */
    public Callable<?> initSinc();

}
