/**
 * main.java
 * Fecha de creaci�n: Dec 22, 2015, 5:02:14 PM
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */
package mx.ine.sscc.servicios.presentacion.controller;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceException;

import mx.ine.sscc.modelo.bean.NotificacionDTO;
import mx.ine.sscc.servicios.ws.soap.clientes.ClienteNotificacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
@SuppressWarnings("javadoc")
public class InicioController {

    @Resource
    ClienteNotificacion notificacion;

    /**
     * TODO Funcion de prueba para el WS
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @return JSP
     * @throws Exception
     */
    @RequestMapping(value = "/prueba", method = RequestMethod.GET)
    public String home() {

        System.err.println("Error controlado");
        System.out.println("Sistem controlado");

        NotificacionDTO notificacionDTO = new NotificacionDTO();
        notificacionDTO.setXmlNotificacion("<?xml version='1.0'"
            + "encoding='ISO-8859-1'?><ns2:NotificacionEstatusCredencial"
            + "tZipoNotificacionId=\"16\" versionXML=\"60\""
            + "xsi:schemaLocation=\"http://www.ife.org.mx/rfe/siirfe/comun/notificaciones"
            + "schemas/notificacionEstatusCredencial.xsd\""
            + "xmlns:con=\"http://www.ife.org.mx/siirfe/cecyrd/dto/xmlbeanVO/container\""
            + "xmlns:ns2=\"http://www.ife.org.mx/rfe/siirfe/comun/notificaciones\""
            + "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
            + "<datosEntregaCredencial>" + "<cic>129960877</cic>"
            + "</datosEntregaCredencial>" + "<detalleEstatusCredencial>"
            + "<estatusCredencial>9</estatusCredencial>"
            + "<fechaEstatus>2015-05-28T10:35:49.770-05:00</fechaEstatus>"
            + "<folioFuar>1531052103118</folioFuar>" + "<moduloIFEID>310521</moduloIFEID>"
            + "</detalleEstatusCredencial>" + "</ns2:NotificacionEstatusCredencial>");

        try {
            notificacion.setNotificacion(notificacionDTO);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        } catch (WebServiceException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        } catch (RemoteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }

        return "inicio";
    }
}
