/**
 * ConfirmacionCPVEServiceImpl.java
 * Fecha de creaci�n: 16/12/2015, 19:03:34
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

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.entidad.ConfirmacionCPVE;
import mx.ine.sscc.servicios.unicom.dao.ConfirmacionCPVEDAO;
import mx.ine.sscc.servicios.unicom.servicio.ConfirmacionCPVEService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service("ConfirmacionCPVEService")
public class ConfirmacionCPVEServiceImpl implements ConfirmacionCPVEService {

    @Resource
    @Qualifier("confirmacionCPVEDAO")
    ConfirmacionCPVEDAO confirmacionCPVEDAO;

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.ConfirmacionCPVEService#obtieneConfirmacionCPVE()
     */
    @Override
    public ConfirmacionCPVE obtieneConfirmacionCPVE() {
        return confirmacionCPVEDAO.getConfirmacionCPVE();
        // TODO [codificar el cuerpo del m�todo]
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.ConfirmacionCPVEService#datosDisponibles()
     */
    @Override
    public long datosDisponibles() {
        return confirmacionCPVEDAO.getDatosDisponibles();
        // TODO [codificar el cuerpo del m�todo]
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.ConfirmacionCPVEService#actualizaEstatus(java.lang.String, java.lang.String)
     */
    @Override
    public void actualizaEstatus(String folio, String estatus, String nuevoEstatus) {
        // TODO [codificar el cuerpo del m�todo]
        confirmacionCPVEDAO.updateEstatus(folio, estatus, nuevoEstatus);
    }

}
