/**
 * ExecutorServicesManagment.java
 * Fecha de creación: 17/11/2015, 11:40:52
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

package mx.ine.sscc.servicios.util;

import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.unicom.factory.ExecutorServiceFactory;

/**
 * TODO [Clase para administración y gestión de objetos ExecutorService.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
public class ExecutorServicesManagment {

    @Resource
    ExecutorServiceFactory executorServiceFactory;

    private int workers = 5;

    /**
     * TODO [Constructor]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public ExecutorServicesManagment() {
        // TODO [codificar el cuerpo del método]
    }

    /**
     * TODO [Método que obtiene el numéro de hilos que seran usados para la sincronización.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    @PostConstruct
    private void setExecutors() {
        setWorkers(workers);
    }

    /**
     * TODO [Metodo para gestión de objetos ExecutorService]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return Retorna un objeto ScheduledExecutorService por medio de una fábrica de objetos.
     */
    public ExecutorService getScheduledExecutorService() {
        return executorServiceFactory.getFixedThreadPool(getWorkers());
    }

    // ***************************************************************** Getters & Setters
    /**
     * @return el atributo workers
     */
    public int getWorkers() {
        return workers;
    }

    /**
     * @param workers parametro workers a actualizar
     */
    public void setWorkers(int workers) {
        this.workers = workers;
    }
}
