/**
 * SituacionRegistralServiceImpl.java
 * Fecha de creaci�n: 22/12/2015, 17:54:53
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */
package mx.ine.sscc.servicios.unicom.servicio.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.entidad.SituacionRegistral;
import mx.ine.sscc.modelo.entidad.SituacionRegistralPK;
import mx.ine.sscc.servicios.unicom.dao.SituacionRegistralDAO;
import mx.ine.sscc.servicios.unicom.servicio.SituacionRegistralService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Service("situacionRegistralService")
public class SituacionRegistralServiceImpl implements SituacionRegistralService {
    @Resource
    private SituacionRegistralDAO situacionRegistralDAO;

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.unicom.servicio.SituacionRegistralService#obtieneSituacionRegistral
     * ()
     */
    @Override
    public List<SituacionRegistral> obtieneSituacionRegistral() {
        return situacionRegistralDAO.getSituacion();
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.SituacionRegistralService#
     * actualizaEstatusSituacionRegistral(mx.ine.sscc.modelo.entidad.SituacionRegistralPK,
     * java.lang.String, java.lang.String)
     */
    @Override
    public void actualizaEstatusSituacionRegistral(SituacionRegistralPK id, String estatus,
        String nuevoEstatus) {
        situacionRegistralDAO.updateEstatusSituacionRegistral(id, estatus, nuevoEstatus);

    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.SituacionRegistralService#datosDisponibles()
     */
    @Override
    public long datosDisponibles() {

        return situacionRegistralDAO.getDatosDisponibles();
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.SituacionRegistralService#update()
     */
    @Override
    public void updateSituacion(List<SituacionRegistral> situacionRegistralList,
        String estatus) {
        // TODO [codificar el cuerpo del m�todo]
        situacionRegistralDAO.updateSituacion(situacionRegistralList, estatus);
    }
}
