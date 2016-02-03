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

import java.util.Properties;
import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.siirfe.factory.ExecutorServiceFactory;

/**
 * TODO [Clase para administración y gestión de objetos ExecutorService.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
public class ExecutorServicesManagment {

    private static final Logger logger =
        LoggerFactory.getLogger(ExecutorServicesManagment.class);

    @Resource
    ExecutorServiceFactory executorServiceFactory;
    // @Resource
    // NetworkMonitorService networkMonitorService;

    private ExecutorService executorService;

    private int workers;

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
        logger.info("::::: Configurando número de hilos para la aplicación.");
        Properties prop = PropertiesFile.getFilepropiedad();
        String aux = prop.getProperty("siirfe.sscc.number.threads");
        try {
            setWorkers(Integer.parseInt(aux));
            logger.info(":::::: Número de hilos asignados para la aplicación - " + aux);
        } catch (Exception e) {
            // TODO: handle exception
            logger
                .warn("::::: Ups !!. algo salío mal con los hilos " + e.getCause().toString());
            logger.info("::::: Se asignan 7 hilos por default");
            setWorkers(7);
        }
        setExecutorService(executorServiceFactory.getFixedThreadPool(getWorkers()));
    }

    /**
     * TODO [Metodo para gestion de objetos ExecutorService]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return Retorna un objeto ScheduledExecutorService por medio de una fábrica de objetos.
     */
    public ExecutorService getScheduledExecutorService() {
        return getExecutorService();
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

    /**
     * TODO [Calcula el número de hilos que se deberan usar para la ejecución de las tareas de
     * sincronización entre bases de datos. ]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param promedio
     * @return Número de Hilos con los que trabajara el Pool.
     */
    public int getNoTrabajadores(long promedio) {
        int auxTrabajadores = 0;
        // Si el tiempo de respuesa promedio del ping al servidor de base de datos es menor a
        // 400 Milisegundos se usaran 7 hilos, en caso contrario intuimos que la conexion es
        // lenta y solo se envian 3 hilos.
        if ((promedio <= 10)) {
            auxTrabajadores = 14;
        } else {
            auxTrabajadores = 7;
        }
        return auxTrabajadores;
    }

    /**
     * @return el atributo executorService
     */

    public ExecutorService getExecutorService() {
        return executorService;
    }

    /**
     * @param executorService parametro executorService a actualizar
     */
    public void setExecutorService(ExecutorService executorService) {
        this.executorService = executorService;
    }

}
