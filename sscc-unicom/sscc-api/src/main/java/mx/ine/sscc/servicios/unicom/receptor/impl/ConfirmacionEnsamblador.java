/**
 * NotificacionConfirmacionEnsamblador.java
 * Fecha de creación: 16/12/2015, 18:34:32
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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.ine.sscc.modelo.bean.NotificacionDTO;
import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.entidad.ConfirmacionCPVE;
import mx.ine.sscc.servicios.unicom.jaxb.DatosEntregaCredencial;
import mx.ine.sscc.servicios.unicom.jaxb.DetalleEstatusCredencial;
import mx.ine.sscc.servicios.unicom.receptor.Ensamblador;
import mx.ine.sscc.servicios.unicom.servicio.ConfirmacionCPVEService;
import mx.ine.sscc.servicios.unicom.servicio.NotificacionService;
import mx.ine.sscc.servicios.util.GeneralConstants;
import mx.ine.sscc.servicios.util.Utils;
import mx.ine.sscc.servicios.ws.soap.clientes.ClienteNotificacion;

/**
 * TODO [Unidad de trabajo para construir las notoficaciones de los registros de la tabla
 * ConfirmaCPVE.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component("NotificacionConfirmacionEnsamblador")
@Scope("prototype")
public class ConfirmacionEnsamblador implements Ensamblador, Callable<Void> {

    private static final Logger logger =
        LoggerFactory.getLogger(ConfirmacionEnsamblador.class);

    @Resource
    ClienteNotificacion clienteNotificacion;

    @Resource
    @Qualifier("ConfirmacionCPVEService")
    ConfirmacionCPVEService confirmacionCPVEService;

    protected DatosEntregaCredencial datosEntregaCredencial;
    protected DetalleEstatusCredencial detalleEstatusCredencial;

    @Resource
    @Qualifier("NotificacionService")
    NotificacionService notificacionService;

    private ConfirmacionCPVE confirmacionCPVE;
    private NotificacionDTO notificacionDTO;

    private long registroControl = 0;

    /**
     * TODO [Asignar un nombre al hilo que se encuentra en ejecución.]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    public void setThreadName() {
        Thread.currentThread().setName(
            GeneralConstants.NOTIFICACION_CONFIRMACIONCPVE + Thread.currentThread().getId());
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public Void call() throws Exception {
        setThreadName();
        logger.info("ensamblando notificación de confirmacion");
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
            setConfirmacionCPVE(confirmacionCPVEService.obtieneConfirmacionCPVE());
            return true;
        } catch (GenericJDBCException e) {
            // TODO: handle exception
            logger.error("*** error al obtener el dato de ConfirmacionCPVE " + e.getMessage());
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error al obtener el dato de ConfirmacionCPVE" + e.getMessage());
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
        byte estatusCredencial = GeneralConstants.ESTATUS_CREDENCIAL;
        Date fechaEstatus = null;
        String folioFuar = null;
        String moduloIfeId = null;
        boolean error = false;
        // TODO [codificar el cuerpo del método]

        /*
         * Se usa el servicio de Notifcación para crear la notificacion. Antes de esto se deben
         * llenar los objetos que van dentro del XML de Notificacion. DatosEntregaCredencial
         * DetalleEstatusCredencial
         */

        // Dar Valores a * DatosEntregaCredencial
        try {
            datosEntregaCredencial = new DatosEntregaCredencial();
            datosEntregaCredencial.setCic(getConfirmacionCPVE().getNumeroCic());
            logger.info(datosEntregaCredencial.toString());
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error creando datosEntregaCredencial " + e.getMessage());
            error = true;
        }

        // Dar Valores a DetalleEstatusCredencial
        try {
            fechaEstatus = getConfirmacionCPVE().getFechaActualizacion();
            folioFuar = getConfirmacionCPVE().getFolioSi();
            moduloIfeId = Utils.obtieneModulo(folioFuar);
            detalleEstatusCredencial = new DetalleEstatusCredencial();
            detalleEstatusCredencial.setEstatusCredencial(estatusCredencial);
            detalleEstatusCredencial.setFechaEstatus(Utils.DateToXML(fechaEstatus));
            detalleEstatusCredencial.setFolioFuar(folioFuar);
            detalleEstatusCredencial.setModuloIFEID(moduloIfeId);
            logger.info(detalleEstatusCredencial.toString());
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error  DetalleEstatusCredencial" + e.getMessage());
            error = true;
        }

        // Dar valores de la notificacion.
        try {
            notificacionService.setContenido(datosEntregaCredencial);
            notificacionService.setContenido(detalleEstatusCredencial);
            // notificacionService.obtieneNotificacion();
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
                confirmacionCPVEService.actualizaEstatus(getConfirmacionCPVE().getFolioSi(),
                    TipoControlSincronizacion.ENVIADO.getClave(),
                    TipoControlSincronizacion.TERMINADO.getClave());
                return true;
            }
            logger.warn("Error de seguridad en Servicio Web");
            controlError(getConfirmacionCPVE().getFolioSi(),
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
            e.printStackTrace();
            controlError(getConfirmacionCPVE().getFolioSi(),
                TipoControlSincronizacion.ENVIADO.getClave(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            return false;
        } catch (MalformedURLException e) {
            logger.error("*** error al enviar la notificacion . " + e.getMessage());
            // TODO [Manejar la excepcion de forma correcta]
            /*
             * Si existe algun error al momento de enviar el registro a SIIRFE el estatus del
             * registro se regresa a P
             */
            e.printStackTrace();
            controlError(getConfirmacionCPVE().getFolioSi(),
                TipoControlSincronizacion.ENVIADO.getClave(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            return false;

        } catch (RemoteException e) {
            logger.error("*** error al enviar la notificacion . " + e.getMessage());
            // TODO [Manejar la excepcion de forma correcta]
            /*
             * Si existe algun error al momento de enviar el registro a SIIRFE el estatus del
             * registro se regresa a P
             */
            e.printStackTrace();
            controlError(getConfirmacionCPVE().getFolioSi(),
                TipoControlSincronizacion.ENVIADO.getClave(),
                TipoControlSincronizacion.PENDIENTE.getClave());
            return false;
        }
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.receptor.Ensamblador#existenDatosDisponibles()
     */
    @Override
    public void datosDisponibles() {
        // TODO [codificar el cuerpo del método]
        try {
            setRegistroControl(confirmacionCPVEService.datosDisponibles());
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
     * java.util.Date, java.lang.String, java.lang.String)
     */
    @Override
    public void controlError(String folio, String estatus, String nuevoEstatus) {
        confirmacionCPVEService.actualizaEstatus(folio, estatus, nuevoEstatus);
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
     * GETTERS && SETTERRS
     */

    /**
     * @return el atributo confirmacionCPVE
     */
    public ConfirmacionCPVE getConfirmacionCPVE() {
        return confirmacionCPVE;
    }

    /**
     * @param confirmacionCPVE parametro confirmacionCPVE a actualizar
     */
    public void setConfirmacionCPVE(ConfirmacionCPVE confirmacionCPVE) {
        this.confirmacionCPVE = confirmacionCPVE;
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
