/**
 * DemoObservable.java
 * Fecha de creaci�n: 29/11/2015, 20:18:29
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
import mx.ine.sscc.servicios.siirfe.observador.FuarObservador;
import mx.ine.sscc.servicios.siirfe.service.FuarService;
import mx.ine.sscc.servicios.util.ExecutorServicesManagment;
import mx.ine.sscc.servicios.util.GeneralConstants;
import mx.ine.sscc.servicios.util.PropertiesFile;

/**
 * TODO [Esta clase tiene la responsabilidad de voltear a "ver" la tabla Fuar cada cierto
 * periodo de tiempo para verificar si existen registros para sincronizar.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
@EnableScheduling
public class SchedulerFuarObservable extends Observable implements Sujeto {

    private static final Logger logger =
        LoggerFactory.getLogger(SchedulerFuarObservable.class);

    @Resource
    private FuarObservador fuarObservador;

    @Resource
    private ExecutorServicesManagment executorServicesManagment;
    private ExecutorService executorService;

    private Long registrosFuar;

    @Resource
    private FuarService fuarService;

    private List<Observer> observadores = new ArrayList<Observer>();

    private String io_btn;

    /**
     * TODO [Constructor]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    public SchedulerFuarObservable() {
        // TODO [codificar el cuerpo del m�todo]
    }

    /**
     * TODO [M�todo de configuraci�n, se agregua el observador y el ejecutor de servicios.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    @PostConstruct
    private void init() {
        logger.info("::::: Configurando planificador " + this.getClass().getName());
        addObserver(fuarObservador);
        executorService = executorServicesManagment.getScheduledExecutorService();
    }

    /**
     * TODO [M�todo que verifica si existen registros en la tabla.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    /*
     * initialDelay --> Indica el tiempo de espera para ejecutar el m�todo desde que inicia la app
     * fixedDelay   --> Periodo de tiempo en el que se ejecutara de nuevo el m�todo.
     * Unidad de tiempo Milisegundos.
     */
    @Scheduled(initialDelayString = "${ctrl.sscc.init.delay}", fixedDelayString = "${ctrl.sscc.fixed.delay}")
    public void verificaRegistros() {
        _isON();
        Future<Long> _registrosFuar;
        if (GeneralConstants.ON.equals(io_btn)) {
            logger.info(">>> FUAR");
            _registrosFuar = executorService.submit(miraTablaFuar());
            try {
                logger.info(">>> Cantidad de registros: " + _registrosFuar.get());
                setRegistrosFuar(_registrosFuar.get());
            } catch (InterruptedException e) {
                // TODO [Manejar la excepcion de forma correcta]
                e.printStackTrace();
                logger.error("*** error en sujeto Observable --> " + getClass().getName());
            } catch (ExecutionException e) {
                // TODO [Manejar la excepcion de forma correcta]
                e.printStackTrace();
                logger.error("*** error en sujeto Observable --> " + getClass().getName());
            }
        } else {
            logger.info(">>> Sincronizador apagado ...  ");
        }
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.observable.Sujeto#eliminaObservador(java.util.Observer)
     */
    @Override
    public void agregaObservador(Observer observer) {
        // TODO [codificar el cuerpo del m�todo]
        observadores.add(observer);
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.observable.Sujeto#eliminaObservador(java.util.Observer)
     */
    @Override
    public void eliminaObservador(Observer observer) {
        // TODO [codificar el cuerpo del m�todo]
        observadores.remove(observer);
    }

    /**
     * TODO [Notifica al observador que ya exsiten registros.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    @Override
    public void notificaObservador() {
        // TODO [codificar el cuerpo del m�todo]
        if (getRegistrosFuar() > 0) {
            setChanged();
            notifyObservers(TipoTablaActualizacion.FUAR.getId());
        }
    }

    /**
     * TODO [Ejecucion de servicio para obtener registros disponibles a sincronizar.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return Registros Sincronizables.
     */
    private Callable<Long> miraTablaFuar() {
        // TODO [codificar el cuerpo del m�todo]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                try {
                    return fuarService.getAvailableRecordsFuar();
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
            setIo_btn(prop.getProperty("siirfe.sincro.fuar"));
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
     * @return el atributo registrosFuar
     */
    public Long getRegistrosFuar() {
        return registrosFuar;
    }

    /**
     * @param registrosFuar parametro registrosFuar a actualizar
     */
    public void setRegistrosFuar(Long registrosFuar) {
        this.registrosFuar = registrosFuar;
        notificaObservador();
    }

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
}
