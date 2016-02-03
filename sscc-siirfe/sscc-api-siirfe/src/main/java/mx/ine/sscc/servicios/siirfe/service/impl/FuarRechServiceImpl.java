/**
 * FuarExtrServiceImpl.java
 * Fecha de creaci�n: 27/11/2015, 14:12:44
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

package mx.ine.sscc.servicios.siirfe.service.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.entidad.siirfe.FuarRechazadoSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.FuarRechazadoSiirfeDAO;
import mx.ine.sscc.servicios.siirfe.service.FuarRechService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class FuarRechServiceImpl implements FuarRechService {

    @Resource
    private FuarRechazadoSiirfeDAO fuarRechazadoSiirfeDAO;

    /**********************************************************************
     * FUAR RECHAZADO
     ***********************************************************************/
    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#obtieneListaFuarRechazado()
     */
    @Override
    public List<FuarRechazadoSiirfe> obtieneListaFuarRechazado(Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
        List<FuarRechazadoSiirfe> fuarRechazadoList =
            Collections.synchronizedList(new LinkedList<FuarRechazadoSiirfe>());

        fuarRechazadoList = fuarRechazadoSiirfeDAO.getFuarRechazado();
        if (fuarRechazadoList.size() > 0) {
            for (FuarRechazadoSiirfe registro : fuarRechazadoList) {
                fuarRechazadoSiirfeDAO.updateFuarRechazadoById(registro.getId(),
                    TipoControlSincronizacion.ENVIADO.getClave(), bitacoraId);
            }
        }
        return fuarRechazadoList;
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#getHasAvailableRecordsFuarRecha
     * ()
     */
    @Override
    public long getAvailableRecordsFuarRech() {
        // TODO [codificar el cuerpo del m�todo]
        long aux = 0;
        try {
            aux = fuarRechazadoSiirfeDAO.hasAvailableRecords();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return aux;
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#actualizaFuarRecha(java.lang
     * .String, java.lang.String)
     */
    @Override
    public void actualizaFuarRech(Long id, String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
        fuarRechazadoSiirfeDAO.updateFuarRechazadoById(id, nuevoEstatus, bitacoraId);
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#actualizaBloqueFuarRecha(java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaBloqueFuarRech(String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
        fuarRechazadoSiirfeDAO.updateFuarRechBySincId(nuevoEstatus, bitacoraId);
    }

}
