/**
 * Command.java
 * Fecha de creaci�n: 13/11/2015, 14:27:36
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

package mx.ine.sscc.servicios.siirfe.command;

import java.util.concurrent.Callable;

/**
 * TODO [Intefaz Command, define el comportamiento para el objeto que sera llamado por el
 * Invocador.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
public interface Command {

    /**
     * TODO [M�todo principal. Aqui se deber� codificar la tarea o tareas concretas que de debe
     * ejecutar el receptor. En este caso la tarea es ejecutada por un objeto planificador
     * haciendo uso de un ExecutorService, es por eso que el retorno es un objeto de tipo
     * Callable<?>.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return Retorna un objeto Callable<?>.
     */
    public Callable<?> execute();

}
