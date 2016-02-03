/**
 * SituacionRegistralWSImpl.java
 * Fecha de creación: Dec 18, 2015, 12:37:08 PM
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

import mx.ine.sscc.modelo.bean.RespuestaSituacionRegistral;
import mx.ine.sscc.modelo.entidad.unicom.Respuestas;
import mx.ine.sscc.servicios.siirfe.service.RespuestasService;
import mx.ine.sscc.servicios.util.PropertiesFile;
import mx.ine.sscc.servicios.ws.soap.endpoint.SituacionRegistralWS;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@WebService(endpointInterface = "mx.ine.sscc.servicios.ws.soap.endpoint.SituacionRegistralWS", serviceName = "SituacionRegWSService", portName = "SituacionRegWSPort")
public class SituacionRegistralWSImpl extends SpringBeanAutowiringSupport
    implements SituacionRegistralWS {
    private static final Logger logger =
        LoggerFactory.getLogger(SituacionRegistralWSImpl.class);

    @Resource
    WebServiceContext wsctx;

    @Autowired
    RespuestasService respuestasService;
    private String userValue;
    private String passValue;

    @SuppressWarnings({ "unchecked", "null" })
    @Override
    public RespuestaSituacionRegistral guardaSituacionRegistral(
        List<Respuestas> respuestasList) {
        logger.info("Servicio de Situacion Registral");

        if (validaSeguridad()) {
            return respuestasService.recibeDatosDeUnicom(respuestasList);
        }
        RespuestaSituacionRegistral respuestaError = new RespuestaSituacionRegistral();
        respuestaError.setMensajeError("Error de autenticación");
        return respuestaError;

    }

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     */
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @SuppressWarnings("unchecked")
    private boolean validaSeguridad() {
        /*
         * Se obtienen las credenciales del archivo properties.
         */
        Properties pro = PropertiesFile.getFilepropiedad();
        userValue = pro.getProperty("siirfe.ws.user");
        passValue = pro.getProperty("siirfe.ws.pass");

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

    }

}
