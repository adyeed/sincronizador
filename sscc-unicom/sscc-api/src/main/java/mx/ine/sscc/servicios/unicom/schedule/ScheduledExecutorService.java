/**
 * ScheduledExecutorService.java
 * Fecha de creación: 16/12/2015, 17:09:50
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

package mx.ine.sscc.servicios.unicom.schedule;

import java.util.Properties;
import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.unicom.invocador.Invocador;
import mx.ine.sscc.servicios.util.ExecutorServicesManagment;
import mx.ine.sscc.servicios.util.PropertiesFile;

/**
 * TODO [Clase que dispara la el proceso para crear las notificaciones.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@EnableScheduling
@Component
public class ScheduledExecutorService {

    private static final Logger logger =
        LoggerFactory.getLogger(ScheduledExecutorService.class);

    @Resource
    private ExecutorServicesManagment executorServicesManagment;
    private ExecutorService executorService;

    @Resource
    @Qualifier("ConfirmacionInvocador")
    Invocador confirmacionInvocador;
    @Resource
    @Qualifier("ReenvioInvocador")
    Invocador reenvioInvocador;
    @Resource
    @Qualifier("SituacionRegistralInvocador")
    Invocador situacionInvocador;

    /**
     * TODO [Método de configuración, se agregua el observador y el ejecutor de servicios.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    @PostConstruct
    private void init() {
        setExecutorService(executorServicesManagment.getScheduledExecutorService());
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    public ScheduledExecutorService() {
        // TODO Auto-generated constructor stub
    }

    /*
     * EXPRESIONES CRON
     * Segundo , Minuto ,  Hora, Día del Mes, Mes, Días de la semana
     */
    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    @Scheduled(cron = "${expr.cron.scheduler}")
    public void ejecutaTarea() {
        Properties prop = PropertiesFile.getFilepropiedad();

        if (new String("on").equals(prop.get("btn.encendido"))) {
            logger.info("Iniciando tarea de sincronización de notficaciones.");
            getExecutorService().submit(reenvioInvocador.initAssemble());
            getExecutorService().submit(confirmacionInvocador.initAssemble());
            getExecutorService().submit(situacionInvocador.initAssemble());
        } else {
            logger.info("No es posible iniciar la tarea.");
            logger.warn("Notificaciones OFF");
        }

    }

    /*
     * GET  &&  SET
     */
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
