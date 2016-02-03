/**
 * NotificacionService.java
 * Fecha de creaci�n: 16/12/2015, 12:38:05
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

package mx.ine.sscc.servicios.unicom.servicio.impl;

import java.io.StringWriter;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import mx.ine.sscc.servicios.unicom.jaxb.DatosEntregaCredencial;
import mx.ine.sscc.servicios.unicom.jaxb.DetalleEstatusCredencial;
import mx.ine.sscc.servicios.unicom.jaxb.Notificacion;
import mx.ine.sscc.servicios.unicom.schedule.ScheduledExecutorService;
import mx.ine.sscc.servicios.unicom.servicio.NotificacionService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service("NotificacionService")
@Scope("prototype")
public class NotificacionServiceImpl implements NotificacionService {

    private static final Logger logger =
        LoggerFactory.getLogger(ScheduledExecutorService.class);
    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     */
    private JAXBContext jaxbContext;
    private Marshaller jaxbMarshaller;
    private Notificacion notificacion;

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     */
    public NotificacionServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    @PostConstruct
    @Override
    public void init() {
        try {
            jaxbContext = JAXBContext.newInstance(Notificacion.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "ISO-8859-1");
            creaNotificacion();
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error en init " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void creaNotificacion() {
        try {
            this.notificacion = new Notificacion();
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error al crear la notificaci�n " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @return XML
     */
    @Override
    public String obtieneNotificacion() {
        StringWriter xml = new StringWriter();
        try {
            jaxbMarshaller.marshal(this.notificacion, xml);
            return xml.toString();
        } catch (Exception e) {
            logger
                .error("*** error en ---> obtieneNotificacion  " + this.getClass().getName());
            // TODO: handle exception
            return xml.toString();
        }

    }

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosEntregaCredencial
     */
    @Override
    public void setContenido(DatosEntregaCredencial datosEntregaCredencial) {
        this.notificacion.setDatosEntregaCredencial(datosEntregaCredencial);
    }

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param detalleEstatusCredencial
     */
    @Override
    public void setContenido(DetalleEstatusCredencial detalleEstatusCredencial) {
        this.notificacion.setDetalleEstatusCredencial(detalleEstatusCredencial);
    }

}
