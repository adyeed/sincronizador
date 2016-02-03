/**
 * PruebaController.java
 * Fecha de creación: 04/01/2016, 10:30:17
 *
 * Copyright (c) 2016 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Federal Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */

package mx.ine.sscc.servicios.presentacion.controller;

import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mx.ine.sscc.servicios.unicom.invocador.Invocador;
import mx.ine.sscc.servicios.unicom.receptor.Ensamblador;
import mx.ine.sscc.servicios.util.ExecutorServicesManagment;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Controller
public class PruebaController {

    @Resource
    @Qualifier("NotificacionReenvioEnsamblador")
    Ensamblador reenvioEnsamblador;

    @Resource
    @Qualifier("NotificacionConfirmacionEnsamblador")
    Ensamblador confirmacionEnsamblador;

    @Resource
    @Qualifier("SituacionEnsamblador")
    Ensamblador situacionEnsamblador;

    @Resource
    private ExecutorServicesManagment executorServicesManagment;
    private ExecutorService executorService;
    @Resource
    @Qualifier("ReenvioInvocador")
    Invocador reenvioInvocador;

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

    public PruebaController() {
        // TODO Auto-generated constructor stub
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    @RequestMapping(value = "/reenvio", method = RequestMethod.POST)
    public void prueba() {

        // getExecutorService().submit(reenvioInvocador.initAssemble());
        reenvioEnsamblador.obtieneDatos();
        reenvioEnsamblador.armaNotificacion();
        reenvioEnsamblador.enviaNotificacion();
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    @RequestMapping(value = "/confirmacion", method = RequestMethod.POST)
    public void pruebaConf() {

        confirmacionEnsamblador.obtieneDatos();
        confirmacionEnsamblador.armaNotificacion();
        confirmacionEnsamblador.enviaNotificacion();
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    @RequestMapping(value = "/situacion", method = RequestMethod.POST)
    public void pruebaSitu() {

        situacionEnsamblador.obtieneDatos();
        // situacionEnsamblador.armaNotificacion();
        situacionEnsamblador.enviaNotificacion();
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
