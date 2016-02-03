/**
 * ReenvioServiceImpl.java
 * Fecha de creación: 16/12/2015, 19:24:38
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

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.entidad.Reenvio;
import mx.ine.sscc.modelo.entidad.unicom.FuarExtranjeroUnicom;
import mx.ine.sscc.servicios.unicom.dao.FuarExtranjeroDAO;
import mx.ine.sscc.servicios.unicom.dao.ReenvioDAO;
import mx.ine.sscc.servicios.unicom.servicio.ReenvioService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service("ReenvioService")
public class ReenvioServiceImpl implements ReenvioService {

    @Resource
    @Qualifier("reenvioDAO")
    ReenvioDAO reenvioDAO;
    @Resource
    private FuarExtranjeroDAO fuarExtranjeroDAO;

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.ReenvioService#obtieneReenvio()
     */
    @Override
    public Reenvio obtieneReenvio() {
        Reenvio reenvio = reenvioDAO.getReenvio();
        FuarExtranjeroUnicom fuarExtranjeroUnicom = new FuarExtranjeroUnicom();
        if (reenvio != null) {
            fuarExtranjeroUnicom = fuarExtranjeroDAO.getFuarExtranjero(reenvio.getFolioSi());
            if (fuarExtranjeroUnicom != null) {
                reenvio.setCic(!StringUtils.isBlank(fuarExtranjeroUnicom.getCic())
                    ? fuarExtranjeroUnicom.getCic() : "");
            }
        }

        return reenvio;

    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.ReenvioService#datosDisponibles()
     */
    @Override
    public long datosDisponibles() {
        return reenvioDAO.getDatosDisponibles();
        // TODO [codificar el cuerpo del método]

    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.unicom.servicio.ReenvioService#actualizaEstatus(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void actualizaEstatus(String folio, Date fechaEnvio, String estatus,
        String nuevoEstatus) {
        // TODO [codificar el cuerpo del método]
        reenvioDAO.updateEstatus(folio, fechaEnvio, estatus, nuevoEstatus);
    }

}
