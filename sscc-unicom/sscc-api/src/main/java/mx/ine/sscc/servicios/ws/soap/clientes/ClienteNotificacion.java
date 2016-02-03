/**
 * ClienteNotificacion.java
 * Fecha de creación: Dec 28, 2015, 9:49:20 AM
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Nacional Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */
package mx.ine.sscc.servicios.ws.soap.clientes;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

import org.springframework.stereotype.Component;

import mx.ine.sscc.modelo.bean.NotificacionDTO;
import mx.ine.sscc.servicios.util.PropertiesFile;
import mx.ine.sscc.servicios.ws.soap.endpoint.NotificacionWS;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
public class ClienteNotificacion {

    private String userValue;
    private String passValue;
    private String qName;
    private String sName;
    private String WS_URL;

    private void config() {
        Properties prop = PropertiesFile.getFilepropiedad();
        setUserValue(prop.getProperty("unicom.ws.user"));
        setPassValue(prop.getProperty("unicom.ws.pass"));
        setqName(prop.getProperty("unicom.ws.notificacion.qname"));
        setsName(prop.getProperty("unicom.ws.notificacion.service"));
        setWS_URL(prop.getProperty("unicom.ws.notificacion.port"));
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param notificacion
     * @return
     * @throws MalformedURLException
     * @throws WebServiceException
     * @throws RemoteException
     */
    public int setNotificacion(NotificacionDTO notificacion)
        throws MalformedURLException, WebServiceException, RemoteException {
        config();
        URL url = new URL(getWS_URL());
        QName qname = new QName(getqName(), getsName());
        Service service = Service.create(url, qname);

        NotificacionWS servicioNotificacionWS = service.getPort(NotificacionWS.class);

        /******************* UserName & Password ******************************/
        Map<String, Object> req_ctx =
            ((BindingProvider) servicioNotificacionWS).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList(userValue));
        headers.put("Password", Collections.singletonList(passValue));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        /** Ejecución de servicios de consulta. */
        return servicioNotificacionWS.guardaNotificacion(notificacion);

    }

    /**
     * @return el atributo userValue
     */

    public String getUserValue() {
        return userValue;
    }

    /**
     * @param userValue parametro userValue a actualizar
     */
    public void setUserValue(String userValue) {
        this.userValue = userValue;
    }

    /**
     * @return el atributo passValue
     */

    public String getPassValue() {
        return passValue;
    }

    /**
     * @param passValue parametro passValue a actualizar
     */
    public void setPassValue(String passValue) {
        this.passValue = passValue;
    }

    /**
     * @return el atributo qName
     */

    public String getqName() {
        return qName;
    }

    /**
     * @param qName parametro qName a actualizar
     */
    public void setqName(String qName) {
        this.qName = qName;
    }

    /**
     * @return el atributo sName
     */

    public String getsName() {
        return sName;
    }

    /**
     * @param sName parametro sName a actualizar
     */
    public void setsName(String sName) {
        this.sName = sName;
    }

    /**
     * @return el atributo wS_URL
     */

    public String getWS_URL() {
        return WS_URL;
    }

    /**
     * @param wS_URL parametro wS_URL a actualizar
     */
    public void setWS_URL(String wS_URL) {
        WS_URL = wS_URL;
    }

}
