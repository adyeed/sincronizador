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

import java.util.Properties;
import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.siirfe.factory.ExecutorServiceFactory;

/**
 * TODO [Clase para administraci�n y gesti�n de objetos ExecutorService.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
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
        logger.info("::::: Configurando n�mero de hilos para la aplicaci�n.");
        Properties prop = PropertiesFile.getFilepropiedad();
        String aux = prop.getProperty("siirfe.sscc.number.threads");
        try {
            setWorkers(Integer.parseInt(aux));
            logger.info(":::::: N�mero de hilos asignados para la aplicaci�n - " + aux);
        } catch (Exception e) {
            // TODO: handle exception
            logger
                .warn("::::: Ups !!. algo sal�o mal con los hilos " + e.getCause().toString());
            logger.info("::::: Se asignan 7 hilos por default");
            setWorkers(7);
        }
        setExecutorService(executorServiceFactory.getFixedThreadPool(getWorkers()));
    }

    /**
     * TODO [Metodo para gestion de objetos ExecutorService]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return Retorna un objeto ScheduledExecutorService por medio de una f�brica de objetos.
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
     * TODO [Calcula el n�mero de hilos que se deberan usar para la ejecuci�n de las tareas de
     * sincronizaci�n entre bases de datos. ]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param promedio
     * @return N�mero de Hilos con los que trabajara el Pool.
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
