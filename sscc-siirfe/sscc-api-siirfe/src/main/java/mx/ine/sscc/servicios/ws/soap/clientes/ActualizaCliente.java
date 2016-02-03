/**
 * ActualizaCliente.java
 * Fecha de creación: Oct 30, 2015, 5:14:10 PM
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

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;
import mx.ine.sscc.servicios.util.PropertiesFile;
import mx.ine.sscc.servicios.ws.soap.endpoint.ActualizaWS;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
public class ActualizaCliente {

    private String userValue;
    private String passValue;
    private String qName;
    private String sName;
    private String WS_URL;

    private void config() {
        Properties prop = PropertiesFile.getFilepropiedad();
        setUserValue(prop.getProperty("siirfe.ws.user"));
        setPassValue(prop.getProperty("siirfe.ws.pass"));
        setqName(prop.getProperty("siirfe.ws.actualiza.qname"));
        setsName(prop.getProperty("siirfe.ws.actualiza.service"));
        setWS_URL(prop.getProperty("siirfe.ws.actualiza.port"));

    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     * @throws MalformedURLException
     * @throws WebServiceException
     */
    public RespuestaSincronizacion obtieneRespuestaAnalisis(DatosEntrada datosEntrada)
        throws MalformedURLException, WebServiceException {

        config();
        URL url = new URL(getWS_URL());
        QName qname = new QName(getqName(), getsName());
        Service service = Service.create(url, qname);
        ActualizaWS servicioActualizaWS = service.getPort(ActualizaWS.class);

        /******************* UserName & Password ******************************/
        Map<String, Object> req_ctx =
            ((BindingProvider) servicioActualizaWS).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList(userValue));
        headers.put("Password", Collections.singletonList(passValue));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        /** Ejecución de servicios de consulta. */
        return servicioActualizaWS.actualizaAnalisis(datosEntrada);
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     * @throws MalformedURLException
     * @throws WebServiceException
     */
    public RespuestaSincronizacion obtieneRespuestaConsulta(DatosEntrada datosEntrada)
        throws MalformedURLException, WebServiceException {
        config();
        URL url = new URL(getWS_URL());
        QName qname = new QName(getqName(), getsName());
        Service service = Service.create(url, qname);

        ActualizaWS servicioActualizaWS = service.getPort(ActualizaWS.class);

        /******************* UserName & Password ******************************/
        Map<String, Object> req_ctx =
            ((BindingProvider) servicioActualizaWS).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList(userValue));
        headers.put("Password", Collections.singletonList(passValue));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        /** Ejecución de servicios de consulta. */
        return servicioActualizaWS.actualizaConsulta(datosEntrada);
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     * @throws MalformedURLException
     * @throws WebServiceException
     */
    public RespuestaSincronizacion obtieneRespuestaFuarRech(DatosEntrada datosEntrada)
        throws MalformedURLException, WebServiceException {
        config();
        URL url = new URL(getWS_URL());
        QName qname = new QName(getqName(), getsName());
        Service service = Service.create(url, qname);

        ActualizaWS servicioActualizaWS = service.getPort(ActualizaWS.class);

        /******************* UserName & Password ******************************/
        Map<String, Object> req_ctx =
            ((BindingProvider) servicioActualizaWS).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList(userValue));
        headers.put("Password", Collections.singletonList(passValue));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        /** Ejecución de servicios de consulta. */
        return servicioActualizaWS.actualizaFuarRech(datosEntrada);

    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     * @throws MalformedURLException
     * @throws WebServiceException
     */
    public RespuestaSincronizacion obtieneRespuestaFuarExtr(DatosEntrada datosEntrada)
        throws MalformedURLException, WebServiceException {
        config();
        URL url = new URL(getWS_URL());
        QName qname = new QName(getqName(), getsName());
        Service service = Service.create(url, qname);

        ActualizaWS servicioActualizaWS = service.getPort(ActualizaWS.class);

        /******************* UserName & Password ******************************/
        Map<String, Object> req_ctx =
            ((BindingProvider) servicioActualizaWS).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList(userValue));
        headers.put("Password", Collections.singletonList(passValue));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        /** Ejecución de servicios de consulta. */
        return servicioActualizaWS.actualizaFuarExtr(datosEntrada);
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return
     * @throws MalformedURLException
     * @throws WebServiceException
     */
    public RespuestaSincronizacion obtieneRespuestaFuar(DatosEntrada datosEntrada)
        throws MalformedURLException, WebServiceException {
        config();
        URL url = new URL(getWS_URL());
        QName qname = new QName(getqName(), getsName());
        Service service = Service.create(url, qname);

        ActualizaWS servicioActualizaWS = service.getPort(ActualizaWS.class);

        /******************* UserName & Password ******************************/
        Map<String, Object> req_ctx =
            ((BindingProvider) servicioActualizaWS).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, WS_URL);

        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        headers.put("Username", Collections.singletonList(userValue));
        headers.put("Password", Collections.singletonList(passValue));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);

        /** Ejecución de servicios de consulta. */
        return servicioActualizaWS.actualizaFuar(datosEntrada);
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
