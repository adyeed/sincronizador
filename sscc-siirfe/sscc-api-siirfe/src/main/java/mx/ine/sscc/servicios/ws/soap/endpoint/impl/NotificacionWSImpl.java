/**
 * NotificacionWSImpl.java
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

import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import mx.ine.sscc.modelo.bean.NotificacionDTO;
import mx.ine.sscc.modelo.entidad.siirfe.Notificacion;
import mx.ine.sscc.servicios.siirfe.service.NotificacionService;
import mx.ine.sscc.servicios.util.PropertiesFile;
import mx.ine.sscc.servicios.ws.soap.endpoint.NotificacionWS;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@WebService(endpointInterface = "mx.ine.sscc.servicios.ws.soap.endpoint.NotificacionWS")
public class NotificacionWSImpl extends SpringBeanAutowiringSupport implements NotificacionWS {

    private static final Logger logger = LoggerFactory.getLogger(NotificacionWSImpl.class);

    @Resource
    WebServiceContext wsctx;
    @Autowired
    NotificacionService notificacionService;

    private String userValue;
    private String passValue;

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     */
    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    public int guardaNotificacion(NotificacionDTO notificacionDTO) {
        logger.info("Servicio de Notificacion");

        if (validaSeguridad()) {
            Notificacion notificacion = converteDTO(notificacionDTO);
            logger.info("persisitiendo notifiacion siirfe - " + notificacion.getFuar());
            notificacionService.guardaNotificacion(notificacion);
            return 1;
        }
        logger.error("*** Error de seguridad en el servicio");
        return 0;
    }

    private Notificacion converteDTO(NotificacionDTO notificacionDTO) {
        Notificacion notificacion = new Notificacion();

        notificacion.setEstatusCredencialId(notificacionDTO.getEstatusCredencial());
        notificacion.setTipoNotificacionId(notificacionDTO.getTipoNotificacion_id());
        notificacion.setEstatusNotificacionId(notificacionDTO.getEstatusNotificacion());
        notificacion.setFolioMRE("0");

        if (notificacionDTO.getProcesoDigitalizacion() != null) {
            notificacion.setProcesoDigitalizacionId(
                Long.parseLong(notificacionDTO.getProcesoDigitalizacion()));
        }

        notificacion.setModulo(notificacionDTO.getModuloIFEID());
        notificacion.setFuar(notificacionDTO.getFuar());

        notificacion.setFechaIngresoCecyrd(notificacionDTO.getFechaDeIngresocecyrd());

        if (notificacionDTO.getXmlNotificacion() != null) {

            try {
                notificacion
                    .setNotificacion(stringToClob(notificacionDTO.getXmlNotificacion()));
            } catch (SerialException e) {

                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("No se pudo realizar la conversión de STRING A CLOB");
                e.printStackTrace();
            }
        }

        return notificacion;
    }

    /**
     * TODO Convierte un objeto String a Clob
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param cadena
     * @return clob
     * @throws SerialException
     * @throws SQLException
     */
    private Clob stringToClob(String cadena) throws SerialException, SQLException {
        Clob notificacion = new SerialClob(cadena.toCharArray());
        return notificacion;
    }

    @SuppressWarnings("unchecked")
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
