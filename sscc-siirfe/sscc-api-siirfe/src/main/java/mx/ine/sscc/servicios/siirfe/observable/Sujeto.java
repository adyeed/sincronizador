/**
 * Sujeto.java
 * Fecha de creación: 26/11/2015, 17:09:40
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

package mx.ine.sscc.servicios.siirfe.observable;

import java.util.Observer;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

/**
 * TODO [Interfaz que define el comportamiento para los objetos que puede ser observados.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
public interface Sujeto {

    /**
     * TODO [Método para agregar observadores.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param observer
     */
    public void agregaObservador(Observer observer);

    /**
     * TODO [Método para eliminar observadores.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param observer
     */
    public void eliminaObservador(Observer observer);

    /**
     * TODO [Método para notificar a los observadores de algún cambio.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public void notificaObservador();

}
