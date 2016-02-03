/**
 * DemoObservable.java
 * Fecha de creación: 29/11/2015, 20:18:29
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

package mx.ine.sscc.servicios.siirfe.observable.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import mx.ine.sscc.modelo.catalogo.TipoTablaActualizacion;
import mx.ine.sscc.servicios.siirfe.observable.Sujeto;
import mx.ine.sscc.servicios.siirfe.observador.FuarExtrObservador;
import mx.ine.sscc.servicios.siirfe.service.FuarExtrService;
import mx.ine.sscc.servicios.util.ExecutorServicesManagment;
import mx.ine.sscc.servicios.util.GeneralConstants;
import mx.ine.sscc.servicios.util.PropertiesFile;

/**
 * TODO [Esta clase tiene la responsabilidad de voltear a "ver" la tabla Fuar Extrangero cada
 * cierto periodo de tiempo para verificar si existen registros para sincronizar.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
@EnableScheduling
public class SchedulerFuarExtrObservable extends Observable implements Sujeto {

    private static final Logger logger =
        LoggerFactory.getLogger(SchedulerFuarExtrObservable.class);

    @Resource
    private FuarExtrObservador fuarExtrObservador;

    @Resource
    private ExecutorServicesManagment executorServicesManagment;
    private ExecutorService executorService;

    private Long registrosFuarExtr;

    @Resource
    private FuarExtrService fuarExtrService;

    private List<Observer> observadores = new ArrayList<Observer>();

    private String io_btn;

    /**
     * TODO [Constructor]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public SchedulerFuarExtrObservable() {
        // TODO [codificar el cuerpo del método]
    }

    /**
     * TODO [Método de configuración, se agregua el observador y el ejecutor de servicios.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    @PostConstruct
    private void init() {
        logger.info("::::: Configurando planificador " + this.getClass().getName());
        addObserver(fuarExtrObservador);
        executorService = executorServicesManagment.getScheduledExecutorService();
    }

    /**
     * TODO [Método que verifica si existen registros en la tabla.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    /*
     * initialDelay --> Indica el tiempo de espera para ejecutar el método desde que inicia la app
     * fixedDelay   --> Periodo de tiempo en el que se ejecutara de nuevo el método.
     * Unidad de tiempo Milisegundos.
     */
    @Scheduled(initialDelayString = "${ctrl.sscc.init.delay}", fixedDelayString = "${ctrl.sscc.fixed.delay}")
    public void verificaRegistros() {
        _isON();
        Future<Long> _registrosFuarExtr;
        if (GeneralConstants.ON.equals(io_btn)) {
            logger.info(">>> FUAR EXTRANJERO  ");
            _registrosFuarExtr = executorService.submit(miraTablaFuarExtr());
            try {
                logger.info(">>> Cantidad de registros: " + _registrosFuarExtr.get());
                setRegistrosFuarExtr(_registrosFuarExtr.get());
            } catch (InterruptedException e) {
                // TODO [Manejar la excepcion de forma correcta]
                e.printStackTrace();
                logger.error("*** error en sujeto Observable --> " + getClass().getName());
            } catch (ExecutionException e) {
                // TODO [Manejar la excepcion de forma correcta]
                e.printStackTrace();
                logger.error("*** error en sujeto Obsevrable --> " + getClass().getName());
            }
        } else {
            logger.info(">>> Sincronizador apagado ...  ");
        }
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.observable.Sujeto#eliminaObservador(java.util.Observer)
     */
    @Override
    public void agregaObservador(Observer observer) {
        // TODO [codificar el cuerpo del método]
        observadores.add(observer);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.observable.Sujeto#eliminaObservador(java.util.Observer)
     */
    @Override
    public void eliminaObservador(Observer observer) {
        // TODO [codificar el cuerpo del método]
        observadores.remove(observer);
    }

    /**
     * TODO [Notifica al observador que ya exsiten registros.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    @Override
    public void notificaObservador() {
        // TODO [codificar el cuerpo del método]
        // Si no existen registros para sincronizar no se le notifica al observador.
        if (getRegistrosFuarExtr() > 0) {
            setChanged();
            notifyObservers(TipoTablaActualizacion.FUAREXTRANJERO.getId());
        }
    }

    /**
     * TODO [Ejecucion de servicio para obtener registros disponibles a sincronizar.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return Registros Sincronizables.
     */
    private Callable<Long> miraTablaFuarExtr() {
        // TODO [codificar el cuerpo del método]
        // Se ejecuta el servicio que obtiene los registros disponibles para sicronizar.
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                try {
                    return fuarExtrService.getHasAvailableRecordsFuarExtr();
                } catch (Exception e) {
                    // TODO: handle exception
                    logger.warn("*** error al verificar tabla --> " + getClass().getName());
                    return new Long(0);
                }
            }
        };
    }

    private void _isON() {
        Properties prop = PropertiesFile.getFilepropiedad();
        try {
            setIo_btn(prop.getProperty("siirfe.sincro.fuarextr"));
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("**** Error ****");
            setIo_btn("off");
        }
    }

    /*
     * GETTERS Y SETTERS:..
     */

    /**
     * @return el atributo io_btn
     */

    public String getIo_btn() {
        return io_btn;
    }

    /**
     * @param io_btn parametro io_btn a actualizar
     */
    public void setIo_btn(String io_btn) {
        this.io_btn = io_btn;
    }

    /**
     * @return el atributo registrosFuarExtr
     */

    public Long getRegistrosFuarExtr() {
        return registrosFuarExtr;
    }

    /**
     * @param registrosFuarExtr parametro registrosFuarExtr a actualizar
     */
    public void setRegistrosFuarExtr(Long registrosFuarExtr) {
        this.registrosFuarExtr = registrosFuarExtr;
        notificaObservador();
    }
}
