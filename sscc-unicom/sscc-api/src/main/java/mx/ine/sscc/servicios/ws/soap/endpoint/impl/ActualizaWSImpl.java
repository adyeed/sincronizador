/**
 * ActualizaWSImpl.java
 * Fecha de creación: Oct 30, 2015, 4:18:46 PM
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
package mx.ine.sscc.servicios.ws.soap.endpoint.impl;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;
import mx.ine.sscc.servicios.unicom.servicio.UnicomService;
import mx.ine.sscc.servicios.util.PropertiesFile;
import mx.ine.sscc.servicios.ws.soap.endpoint.ActualizaWS;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@WebService(endpointInterface = "mx.ine.sscc.servicios.ws.soap.endpoint.ActualizaWS", serviceName = "ActualizaWSImplService", portName = "ActualizaWSImplPort")
public class ActualizaWSImpl extends SpringBeanAutowiringSupport implements ActualizaWS {

    private static final Logger logger = LoggerFactory.getLogger(ActualizaWSImpl.class);

    @Resource
    WebServiceContext wsctx;

    @Autowired
    private UnicomService unicomService;

    private String userValue;
    private String passValue;

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.ws.soap.endpoint.ActualizaWS#actualizaAnalisis(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaAnalisis(DatosEntrada datosEntrada) {
        logger.info("Procesando bloque - " + datosEntrada.getThreadName());
        if (validaSeguridad()) {
            return unicomService.actualizaAnalisis(datosEntrada);
        }
        RespuestaSincronizacion respuestaError = new RespuestaSincronizacion();
        respuestaError.setMensajeError("Error de autenticación");
        return respuestaError;
        // TODO [codificar el cuerpo del método]
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.ws.soap.endpoint.ActualizaWS#actualizaConsulta(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaConsulta(DatosEntrada datosEntrada) {
        logger.info("Procesando bloque - " + datosEntrada.getThreadName());
        if (validaSeguridad()) {
            return unicomService.actualizaConsulta(datosEntrada);
        }
        RespuestaSincronizacion respuestaError = new RespuestaSincronizacion();
        respuestaError.setMensajeError("Error de autenticación");
        return respuestaError;
        // TODO [codificar el cuerpo del método]

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.ws.soap.endpoint.ActualizaWS#actualizaFuarExtr(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaFuarExtr(DatosEntrada datosEntrada) {
        logger.info("Procesando bloque - " + datosEntrada.getThreadName());
        if (validaSeguridad()) {
            return unicomService.actualizaFuarExtr(datosEntrada);
        }
        RespuestaSincronizacion respuestaError = new RespuestaSincronizacion();
        respuestaError.setMensajeError("Error de autenticación");
        return respuestaError;
        // TODO [codificar el cuerpo del método]

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.ws.soap.endpoint.ActualizaWS#actualizaFuarRech(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaFuarRech(DatosEntrada datosEntrada) {
        logger.info("Procesando bloque - " + datosEntrada.getThreadName());
        if (validaSeguridad()) {
            return unicomService.actualizaFuarRech(datosEntrada);
        }
        RespuestaSincronizacion respuestaError = new RespuestaSincronizacion();
        respuestaError.setMensajeError("Error de autenticación");
        return respuestaError;
        // TODO [codificar el cuerpo del método]
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.ws.soap.endpoint.ActualizaWS#actualizaFuar(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaFuar(DatosEntrada datosEntrada) {
        logger.info("Procesando bloque - " + datosEntrada.getThreadName());
        if (validaSeguridad()) {
            return unicomService.actualizaFuar(datosEntrada);
        }
        RespuestaSincronizacion respuestaError = new RespuestaSincronizacion();
        respuestaError.setMensajeError("Error de autenticación");
        return respuestaError;
        // TODO [codificar el cuerpo del método]
    }

    private boolean validaSeguridad() {
        /*
         * Se obtienen las credenciales del archivo properties.
         */
        Properties pro = PropertiesFile.getFilepropiedad();
        userValue = pro.getProperty("unicom.ws.user");
        passValue = pro.getProperty("unicom.ws.pass");

        /*
         * Se toman las credenciales del mensaje
         */
        String username = null;
        String password = null;
        MessageContext mctx = wsctx.getMessageContext();
        // get detail from request headers
        Map<?, ?> http_headers = (Map<?, ?>) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List<String> userList = (List<String>) http_headers.get("Username");
        List<String> passList = (List<String>) http_headers.get("Password");

        if (userList != null) {
            username = userList.get(0).toString();

            if (passList != null) {
                password = passList.get(0).toString();
            }

            if (username.equals(userValue) && password.equals(passValue)) {
                return true;
            }
        }
        logger.error("Error de autenticación");
        return false;
        // TODO [codificar el cuerpo del método]
    }

}