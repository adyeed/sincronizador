/**
 * ServicioEjecutorFactory.java
 * Fecha de creación: 13/11/2015, 13:21:29
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

package mx.ine.sscc.servicios.unicom.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

/**
 * TODO [Fábrica de objetos ExecutorService]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
public class ExecutorServiceFactory {

    /**
     * TODO [Método que obtiene un objeto Executor de tipo ScheduledThreadPool.
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param threads | Maximo número de hilos que podrán ser usados en el pool.
     * @return Retorna un objeto ExecutorService.
     */
    public ExecutorService getFixedThreadPool(int threads) {
        return Executors.newFixedThreadPool(threads);
    }

}
