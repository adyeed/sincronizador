/**
 * ExecutorServicesManagment.java
 * Fecha de creaci�n: 17/11/2015, 11:40:52
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

package mx.ine.sscc.servicios.util;

import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.unicom.factory.ExecutorServiceFactory;

/**
 * TODO [Clase para administraci�n y gesti�n de objetos ExecutorService.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
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
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    public ExecutorServicesManagment() {
        // TODO [codificar el cuerpo del m�todo]
    }

    /**
     * TODO [M�todo que obtiene el num�ro de hilos que seran usados para la sincronizaci�n.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    @PostConstruct
    private void setExecutors() {
        setWorkers(workers);
    }

    /**
     * TODO [Metodo para gesti�n de objetos ExecutorService]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return Retorna un objeto ScheduledExecutorService por medio de una f�brica de objetos.
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
