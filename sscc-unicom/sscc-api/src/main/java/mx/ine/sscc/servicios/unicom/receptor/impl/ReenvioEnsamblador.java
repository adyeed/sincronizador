/**
 * ReenvioEnsamblador.java
 * Fecha de creación: 16/12/2015, 19:22:10
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

package mx.ine.sscc.servicios.unicom.receptor.impl;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.concurrent.Callable;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceException;

import org.hibernate.exception.GenericJDBCException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mx.ine.sscc.modelo.bean.NotificacionDTO;
import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.entidad.Reenvio;
import mx.ine.sscc.servicios.unicom.jaxb.DatosEntregaCredencial;
import mx.ine.sscc.servicios.unicom.jaxb.DetalleEstatusCredencial;
import mx.ine.sscc.servicios.unicom.receptor.Ensamblador;
import mx.ine.sscc.servicios.unicom.servicio.NotificacionService;
import mx.ine.sscc.servicios.unicom.servicio.ReenvioService;
import mx.ine.sscc.servicios.util.GeneralConstants;
import mx.ine.sscc.servicios.util.Utils;
import mx.ine.sscc.servicios.ws.soap.clientes.ClienteNotificacion;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component("NotificacionReenvioEnsamblador")
public class ReenvioEnsamblador implements Ensamblador, Callable<Void> {

    private static final Logger logger = LoggerFactory.getLogger(ReenvioEnsamblador.class);

    @Resource
    ClienteNotificacion clienteNotificacion;

    @Resource
    @Qualifier("ReenvioService")
    ReenvioService reenvioService;

    DatosEntregaCredencial datosEntregaCredencial;
    DetalleEstatusCredencial detalleEstatusCredencial;

    @Resource
    @Qualifier("NotificacionService")
    NotificacionService notificacionService;

    private Reenvio reenvio;
    private NotificacionDTO notificacionDTO;

    private long registroControl = 0;

    /**
     * TODO [Asignar un nombre al hilo que se encuentra en ejecución.]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    public void setThreadName() {
        Thread.currentThread()
            .setName(GeneralConstants.NOTIFICACION_REENVIO + Thread.currentThread().getId());
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public Void call() throws Exception {
        setThreadName();
        logger.info("ensamblando notificación de reenvio");
        /*
         * UNIDAD DE TAREA. ES EJECUTADA POR UN HILO DE FORMA INDEPENDIENTE.
         */
        datosDisponibles();// Se verifica que existan datos disponibles.
        logger.info("Datos disponibles---> " + getRegistroControl());
        while (getRegistroControl() > 0) {

            if (obtieneDatos()) {// Se llena el objeto de confirmación.
                if (!armaNotificacion()) {// Con el objeto de confirmacion lleno
                    enviaNotificacion(); // Se envia la notificación.
                }
            }
            disminuyeRegistroControl();
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
            setReenvio(reenvioService.obtieneReenvio());
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error al obtener los datos de reenvio " + e.getMessage());
            return false;
        }
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#armaNotificacion(java.util.List)
     */
    @Override
    public boolean armaNotificacion() {
        // TODO [codificar el cuerpo del método]
        byte estatusCredencial = 9;
        Date fechaEstatus = null;
        String folioFuar = null;
        String moduloIfeId = null;
        boolean error = false;
        /*
         * Se usa el servicio de Notifcación para crear la notificacion. Antes de esto se deben
         * llenar los objetos que van dentro del XML de Notificacion. DatosEntregaCredencial
         * DetalleEstatusCredencial
         */

        // Dar Valores a * DatosEntregaCredencial
        try {
            datosEntregaCredencial = new DatosEntregaCredencial();
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error creando datosEntregaCredencial " + e.getMessage());
            error = true;
        }

        // Dar Valores a * DetalleEstatusCredencial
        try {
            fechaEstatus = getReenvio().getFechaActualizacion();
            folioFuar = getReenvio().getFolioSi();
            moduloIfeId = Utils.obtieneModulo(folioFuar);
            detalleEstatusCredencial = new DetalleEstatusCredencial();
            detalleEstatusCredencial.setEstatusCredencial(estatusCredencial);
            detalleEstatusCredencial.setFechaEstatus(Utils.DateToXML(fechaEstatus));
            detalleEstatusCredencial.setFolioFuar(folioFuar);
            detalleEstatusCredencial.setModuloIFEID(moduloIfeId);

        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error  DetalleEstatusCredencial" + e.getMessage());
            error = true;
        }

        // Dar valores de la notificacion.
        try {
            notificacionService.setContenido(datosEntregaCredencial);
            notificacionService.setContenido(detalleEstatusCredencial);
            notificacionService.obtieneNotificacion();
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error valores de la notificacion. " + e.getMessage());
            error = true;
        }

        try {
            // Dar valores al objeto que será enviado
            notificacionDTO = new NotificacionDTO();
            notificacionDTO.setFuar(folioFuar);
            notificacionDTO.setModuloIFEID(moduloIfeId);
            notificacionDTO.setXmlNotificacion(notificacionService.obtieneNotificacion());
            logger.info("NOTIFICACION ---> " + notificacionDTO.toString());
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error valores DTO. " + e.getMessage());
            error = true;
        }

        return error;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#enviaNotificacion()
     */
    @Override
    public boolean enviaNotificacion() {
        // TODO [codificar el cuerpo del método]
        try {
            logger.info("Enviando Notificacion a SIIRFE");
            if (clienteNotificacion.setNotificacion(notificacionDTO) > 0) {
                reenvioService.actualizaEstatus(getReenvio().getFolioSi(),
                    getReenvio().getFechaEnvio(), TipoControlSincronizacion.ENVIADO.getClave(),
                    TipoControlSincronizacion.TERMINADO.getClave());
                return true;
            }
            logger.warn("Error de seguridad en Servicio Web");
            controlError(getReenvio().getFolioSi(), getReenvio().getFechaEnvio(),
                TipoControlSincronizacion.ENVIADO.getClave(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            return false;

        } catch (WebServiceException e) {
            logger.error("*** error al enviar la notificacion . " + e.getMessage());
            // TODO: handle exception
            /*
             * Si existe algun error al momento de enviar el registro a SIIRFE el estatus del
             * registro se regresa a P
             */
            controlError(getReenvio().getFolioSi(), getReenvio().getFechaEnvio(),
                TipoControlSincronizacion.ENVIADO.getClave(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            return false;
        } catch (MalformedURLException e) {
            logger.error("*** error al enviar la notificacion . " + e.getMessage());
            // TODO [Manejar la excepcion de forma correcta]
            controlError(getReenvio().getFolioSi(), getReenvio().getFechaEnvio(),
                TipoControlSincronizacion.ENVIADO.getClave(),
                TipoControlSincronizacion.PENDIENTE.getClave());

        } catch (RemoteException e) {
            logger.error("*** error al enviar la notificacion . " + e.getMessage());
            // TODO [Manejar la excepcion de forma correcta]
            controlError(getReenvio().getFolioSi(), getReenvio().getFechaEnvio(),
                TipoControlSincronizacion.ENVIADO.getClave(),
                TipoControlSincronizacion.PENDIENTE.getClave());
        }
        return true;
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
            setRegistroControl(reenvioService.datosDisponibles());
        } catch (GenericJDBCException e) {
            logger.error("*** error al obtener datos disponibles . " + e.getMessage());
            // TODO: handle exception
            setRegistroControl(0);
        } catch (Exception e) {
            logger.error("*** error al obtener datos disponibles . " + e.getMessage());
            // TODO: handle exception
            setRegistroControl(0);
        }

    }

    private void disminuyeRegistroControl() {
        setRegistroControl(getRegistroControl() - 1);
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#controlError(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void controlError(String folio, Date fechaEnvio, String estatus,
        String nuevoEstatus) {
        // TODO [codificar el cuerpo del método]
        reenvioService.actualizaEstatus(folio, fechaEnvio, estatus, nuevoEstatus);
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
     * @return el atributo reenvio
     */

    public Reenvio getReenvio() {
        return reenvio;
    }

    /**
     * @param reenvio parametro reenvio a actualizar
     */
    public void setReenvio(Reenvio reenvio) {
        this.reenvio = reenvio;
    }

    /**
     * @return el atributo notificacionDTO
     */

    public NotificacionDTO getNotificacionDTO() {
        return notificacionDTO;
    }

    /**
     * @param notificacionDTO parametro notificacionDTO a actualizar
     */
    public void setNotificacionDTO(NotificacionDTO notificacionDTO) {
        this.notificacionDTO = notificacionDTO;
    }

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

}
