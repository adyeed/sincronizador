/**
 * ServicioEjecutorFactory.java
 * Fecha de creaci�n: 13/11/2015, 13:21:29
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

package mx.ine.sscc.servicios.unicom.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

/**
 * TODO [F�brica de objetos ExecutorService]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
public class ExecutorServiceFactory {

    /**
     * TODO [M�todo que obtiene un objeto Executor de tipo ScheduledThreadPool.
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param threads | Maximo n�mero de hilos que podr�n ser usados en el pool.
     * @return Retorna un objeto ExecutorService.
     */
    public ExecutorService getFixedThreadPool(int threads) {
        return Executors.newFixedThreadPool(threads);
    }

}
