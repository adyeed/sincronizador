/**
 * GeneradorNotificacion.java
 * Fecha de creaci�n: 16/12/2015, 12:35:13
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

package mx.ine.sscc.servicios.unicom.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import mx.ine.sscc.servicios.util.GeneralConstants;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "datosEntregaCredencial", "detalleEstatusCredencial" })
@XmlRootElement(name = "ns2:NotificacionEstatusCredencial")
public class Notificacion {

    /*
     * CABECERA
     */
    @XmlAttribute(name = "tipoNotificacionId")
    protected String tipoNotificacionId = GeneralConstants.TIPO_NOTIFICACION_ID;
    @XmlAttribute(name = "versionXML")
    protected String versionXML = GeneralConstants.VERSION_XML;
    @XmlAttribute(name = "xsi:schemaLocation")
    protected String schemaLocation = GeneralConstants.SCHEMA_LOCATION;
    @XmlAttribute(name = "xmlns:con")
    protected String container = GeneralConstants.CONTAINER;
    @XmlAttribute(name = "xmlns:ns2")
    protected String ns2 = GeneralConstants.NS2;
    @XmlAttribute(name = "xmlns:xsi")
    protected String xsi = GeneralConstants.XSI;

    /*
     * CONTENIDO
     */
    protected DatosEntregaCredencial datosEntregaCredencial;
    protected DetalleEstatusCredencial detalleEstatusCredencial;

    /**
     * @return el atributo datosEntregaCredencial
     */

    public DatosEntregaCredencial getDatosEntregaCredencial() {
        return datosEntregaCredencial;
    }

    /**
     * @param datosEntregaCredencial parametro datosEntregaCredencial a actualizar
     */
    public void setDatosEntregaCredencial(DatosEntregaCredencial datosEntregaCredencial) {
        this.datosEntregaCredencial = datosEntregaCredencial;
    }

    /**
     * @return el atributo detalleEstatusCredencial
     */

    public DetalleEstatusCredencial getDetalleEstatusCredencial() {
        return detalleEstatusCredencial;
    }

    /**
     * @param detalleEstatusCredencial parametro detalleEstatusCredencial a actualizar
     */
    public void setDetalleEstatusCredencial(
        DetalleEstatusCredencial detalleEstatusCredencial) {
        this.detalleEstatusCredencial = detalleEstatusCredencial;
    }

}
