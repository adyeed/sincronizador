/**
 * Command.java
 * Fecha de creación: 13/11/2015, 14:27:36
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

package mx.ine.sscc.servicios.siirfe.command;

import java.util.concurrent.Callable;

/**
 * TODO [Intefaz Command, define el comportamiento para el objeto que sera llamado por el
 * Invocador.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
public interface Command {

    /**
     * TODO [Método principal. Aqui se deberá codificar la tarea o tareas concretas que de debe
     * ejecutar el receptor. En este caso la tarea es ejecutada por un objeto planificador
     * haciendo uso de un ExecutorService, es por eso que el retorno es un objeto de tipo
     * Callable<?>.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return Retorna un objeto Callable<?>.
     */
    public Callable<?> execute();

}
