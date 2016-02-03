/**
 * DemoObservador.java
 * Fecha de creaci�n: 29/11/2015, 20:19:03
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

package mx.ine.sscc.servicios.siirfe.observador;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.siirfe.invocador.Invocador;
import mx.ine.sscc.servicios.util.ExecutorServicesManagment;

/**
 * TODO [Objeto Observador, este objeto recibe la notificaci�n de algun cambio realizado por el
 * Objeto Objersable.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
public class ConsultaExtrObservador implements Observer {

    private static final Logger logger = LoggerFactory.getLogger(ConsultaExtrObservador.class);

    @Resource
    private ExecutorServicesManagment executorServicesManagment;
    private ExecutorService executorService;

    @Resource
    @Qualifier("InvocadorConsultaExterImpl")
    private Invocador InvocadorConsultaExtr;

    private Long registrosConsulta;

    /**
     * TODO [Constructor]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    public ConsultaExtrObservador() {
        // TODO [codificar el cuerpo del m�todo]
    }

    /**
     * TODO [M�todo de configuraci�n. ]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    @PostConstruct
    public void setExecutors() {
        logger.info("::::: Configurando observador " + this.getClass().getName());
        executorService = executorServicesManagment.getScheduledExecutorService();
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable observable, Object arg1) {

        // TODO [codificar el cuerpo del m�todo]
        /*
         * Al momeno de que el obejto que es observable notifica al observador se ejecuta el
         * metodo UPDATE.
         */
        logger.info(">>> Sincronizando." + observable.getClass().getName());
        try {
            /*
             * Una ves que el observador ha sido informado que existen registros para
             * sicronizar manda llamar al objeto Sincronizador por medio de un objeto
             * Invocador.
             */
            executorService.submit(InvocadorConsultaExtr.initSinc());
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** Error en el Observador -- " + this.getClass().getName());
        }

    }

    /*
     /*
     * ****************************** GETTERS & SETTERS ****************************
     */
    /**
     * @return el atributo registrosFuarRech
     */
    public Long getRegistrosConsulta() {
        return registrosConsulta;
    }

    /**
     * @param registrosConsulta
     */
    public void setRegistrosConsulta(Long registrosConsulta) {
        this.registrosConsulta = registrosConsulta;
    }
}
