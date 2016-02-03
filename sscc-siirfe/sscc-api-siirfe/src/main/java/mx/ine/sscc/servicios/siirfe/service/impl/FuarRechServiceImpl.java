/**
 * FuarExtrServiceImpl.java
 * Fecha de creación: 27/11/2015, 14:12:44
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
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
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
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#obtieneListaFuarRechazado()
     */
    @Override
    public List<FuarRechazadoSiirfe> obtieneListaFuarRechazado(Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
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
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#getHasAvailableRecordsFuarRecha
     * ()
     */
    @Override
    public long getAvailableRecordsFuarRech() {
        // TODO [codificar el cuerpo del método]
        long aux = 0;
        try {
            aux = fuarRechazadoSiirfeDAO.hasAvailableRecords();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return aux;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#actualizaFuarRecha(java.lang
     * .String, java.lang.String)
     */
    @Override
    public void actualizaFuarRech(Long id, String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        fuarRechazadoSiirfeDAO.updateFuarRechazadoById(id, nuevoEstatus, bitacoraId);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#actualizaBloqueFuarRecha(java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaBloqueFuarRech(String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        fuarRechazadoSiirfeDAO.updateFuarRechBySincId(nuevoEstatus, bitacoraId);
    }

}
