/**
 * SituacionEnsamblador.java
 * Fecha de creación: 04/01/2016, 10:25:37
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

package mx.ine.sscc.servicios.unicom.receptor.impl;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceException;

import org.hibernate.HibernateException;
import org.hibernate.exception.GenericJDBCException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import mx.ine.sscc.modelo.bean.RespuestaSituacionRegistral;
import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.entidad.SituacionRegistral;
import mx.ine.sscc.servicios.unicom.receptor.Ensamblador;
import mx.ine.sscc.servicios.unicom.servicio.SituacionRegistralService;
import mx.ine.sscc.servicios.util.GeneralConstants;
import mx.ine.sscc.servicios.ws.soap.clientes.ClienteSituacionRegistralWS;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component("SituacionEnsamblador")
@Transactional
public class SituacionEnsamblador implements Ensamblador, Callable<Void> {

    private static final Logger logger = LoggerFactory.getLogger(SituacionEnsamblador.class);

    @Resource
    @Qualifier("situacionRegistralService")
    SituacionRegistralService situacionRegistralService;

    @Resource
    ClienteSituacionRegistralWS clienteSituacionRegistralWS;

    private long registroControl = 0;
    private List<SituacionRegistral> situacionRegistralList;

    /**
     * TODO [Asignar un nombre al hilo que se encuentra en ejecución.]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    public void setThreadName() {
        Thread.currentThread()
            .setName(GeneralConstants.SITUACION_REGISTRAL + Thread.currentThread().getId());
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public Void call() throws Exception {
        /*
         * UNIDAD DE TAREA.
         */
        datosDisponibles();// Se verifica que existan datos disponibles.
        while (getRegistroControl() > 0) {
            setThreadName();
            if (obtieneDatos()) {// Se llena el objeto de confirmación.
                if (enviaNotificacion()) {// Se envia la notificación.
                    disminuyeRegistroControl();
                }
            }
        }
        return null;
        // TODO [codificar el cuerpo del método]
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#obtieneDatos()
     */
    @Override
    public boolean obtieneDatos() {
        // TODO [codificar el cuerpo del método]
        try {
            setSituacionRegistralList(situacionRegistralService.obtieneSituacionRegistral());
            return true;
        } catch (HibernateException e) {
            // TODO: handle exception
            situacionRegistralService.updateSituacion(getSituacionRegistralList(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            logger.error("*** Error: " + e.getCause().toString());
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            situacionRegistralService.updateSituacion(getSituacionRegistralList(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            logger.error("*** Error: " + e.getCause().toString());
            e.printStackTrace();
            return false;
        }
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#armaNotificacion()
     */
    @Override
    public boolean armaNotificacion() {
        return false;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#enviaNotificacion()
     */
    @Override
    public boolean enviaNotificacion() {
        try {
            RespuestaSituacionRegistral respuesta = clienteSituacionRegistralWS
                .enviaSituacionRegistral(getSituacionRegistralList().get(0).getRespuestases());

            if (respuesta.getMensajeError() == null) {
                situacionRegistralService.updateSituacion(getSituacionRegistralList(),
                    TipoControlSincronizacion.TERMINADO.getClave());
                logger.info("respuestas enviadas");
                return true;
            }
            situacionRegistralService.updateSituacion(getSituacionRegistralList(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            logger.info("error al enviar respuestas--> " + respuesta.getMensajeError());
            return false;

        } catch (MalformedURLException e) {
            // TODO [Manejar la excepcion de forma correcta]
            situacionRegistralService.updateSituacion(getSituacionRegistralList(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            e.printStackTrace();
            logger.info("ERROR Malformed ---> " + e.getCause().toString());
            return false;
        } catch (WebServiceException e) {
            // TODO [Manejar la excepcion de forma correcta]
            logger.info("ERROR Ws Exception ---> " + e.getCause().toString());
            return false;
        } catch (RemoteException e) {
            // TODO [Manejar la excepcion de forma correcta]
            situacionRegistralService.updateSituacion(getSituacionRegistralList(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            e.printStackTrace();
            logger.info("ERROR Remote --->  " + e.getCause().toString());
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            situacionRegistralService.updateSituacion(getSituacionRegistralList(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            e.printStackTrace();
            logger.info("ERROR Ex ---> " + e.getCause().toString());
            return false;
        }

    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#datosDisponibles()
     */
    @Override
    public void datosDisponibles() {
        // TODO [codificar el cuerpo del método]
        try {
            setRegistroControl(situacionRegistralService.datosDisponibles());
        } catch (GenericJDBCException e) {
            // TODO: handle exception
            setRegistroControl(0);
        } catch (Exception e) {
            // TODO: handle exception
            setRegistroControl(0);
        }
    }

    private void disminuyeRegistroControl() {
        setRegistroControl(getSituacionRegistralList().size());
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#controlError(java.lang.String,
     * java.util.Date, java.lang.String, java.lang.String)
     */
    @Override
    public void controlError(String folio, Date fechaEnvio, String estatus,
        String nuevoEstatus) {
        // TODO [codificar el cuerpo del método]

    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#controlError(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void controlError(String folio, String estatus, String nuevoEstatus) {
        // TODO [codificar el cuerpo del método]

    }

    /*
     * GETTERS && SETTERS
     */
    /**
     * @return el atributo registroControl
     */

    public long getRegistroControl() {
        return registroControl;
    }

    /**
     * @param registroControl parametro registroControl a actualizar
     */
    public void setRegistroControl(long registroControl) {
        this.registroControl = registroControl;
    }

    /**
     * @return el atributo situacionRegistralList
     */

    public List<SituacionRegistral> getSituacionRegistralList() {
        return situacionRegistralList;
    }

    /**
     * @param situacionRegistralList parametro situacionRegistralList a actualizar
     */
    public void setSituacionRegistralList(List<SituacionRegistral> situacionRegistralList) {
        this.situacionRegistralList = situacionRegistralList;
    }

}
