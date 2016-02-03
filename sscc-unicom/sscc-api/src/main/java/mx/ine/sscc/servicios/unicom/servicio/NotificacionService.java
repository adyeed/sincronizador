/**
 * Notificacion.java
 * Fecha de creación: 17/12/2015, 11:41:37
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

package mx.ine.sscc.servicios.unicom.servicio;

import mx.ine.sscc.servicios.unicom.jaxb.DatosEntregaCredencial;
import mx.ine.sscc.servicios.unicom.jaxb.DetalleEstatusCredencial;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface NotificacionService {

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     */
    void init();

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @return String XML
     */
    String obtieneNotificacion();

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param datosEntregaCredencial
     * @param datosEntregaCredencial
     */
    void setContenido(DatosEntregaCredencial datosEntregaCredencial);

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param detalleEstatusCredencial
     */
    void setContenido(DetalleEstatusCredencial detalleEstatusCredencial);

}
