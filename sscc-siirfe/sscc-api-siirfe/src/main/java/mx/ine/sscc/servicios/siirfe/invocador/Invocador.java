/**
 * SwitchSincroniza.java
 * Fecha de creación: 13/11/2015, 14:21:21
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

package mx.ine.sscc.servicios.siirfe.invocador;

import java.util.concurrent.Callable;

/**
 * TODO [Interface que define el comportamiento de la clase encargada de invocar las tareas de
 * trabajo para la sincronización de las tablas.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
public interface Invocador {

    /**
     * TODO [Método que inicia la sincronización de alguna tabla]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return Retorna un objeto de tipo Callable, este objeto contiene la unidad de trabajo
     *         necesaria para la sincronización de cada tabla.
     */
    public Callable<?> initSinc();

}
