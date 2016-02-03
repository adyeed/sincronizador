/**
 * Sujeto.java
 * Fecha de creaci�n: 26/11/2015, 17:09:40
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

package mx.ine.sscc.servicios.siirfe.observable;

import java.util.Observer;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

/**
 * TODO [Interfaz que define el comportamiento para los objetos que puede ser observados.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
public interface Sujeto {

    /**
     * TODO [M�todo para agregar observadores.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param observer
     */
    public void agregaObservador(Observer observer);

    /**
     * TODO [M�todo para eliminar observadores.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param observer
     */
    public void eliminaObservador(Observer observer);

    /**
     * TODO [M�todo para notificar a los observadores de alg�n cambio.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    public void notificaObservador();

}
