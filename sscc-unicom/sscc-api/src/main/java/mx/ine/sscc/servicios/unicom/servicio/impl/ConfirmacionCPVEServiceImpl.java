/**
 * ConfirmacionCPVEServiceImpl.java
 * Fecha de creación: 16/12/2015, 19:03:34
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

package mx.ine.sscc.servicios.unicom.servicio.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.entidad.ConfirmacionCPVE;
import mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO;
import mx.ine.sscc.servicios.unicom.servicio.ConfirmacionCPVEService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service("ConfirmacionCPVEService")
public class ConfirmacionCPVEServiceImpl implements ConfirmacionCPVEService {

    @Resource
    @Qualifier("confirmacionCPVEDAO")
    ConfirmacionCPVEDAO confirmacionCPVEDAO;

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.ConfirmacionCPVEService#obtieneConfirmacionCPVE()
     */
    @Override
    public ConfirmacionCPVE obtieneConfirmacionCPVE() {
        return confirmacionCPVEDAO.getConfirmacionCPVE();
        // TODO [codificar el cuerpo del método]
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.ConfirmacionCPVEService#datosDisponibles()
     */
    @Override
    public long datosDisponibles() {
        return confirmacionCPVEDAO.getDatosDisponibles();
        // TODO [codificar el cuerpo del método]
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.ConfirmacionCPVEService#actualizaEstatus(java.lang.String, java.lang.String)
     */
    @Override
    public void actualizaEstatus(String folio, String estatus, String nuevoEstatus) {
        // TODO [codificar el cuerpo del método]
        confirmacionCPVEDAO.updateEstatus(folio, estatus, nuevoEstatus);
    }

}
