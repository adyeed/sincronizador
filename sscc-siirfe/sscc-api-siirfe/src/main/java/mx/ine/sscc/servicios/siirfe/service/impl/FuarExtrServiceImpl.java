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
import mx.ine.sscc.modelo.entidad.siirfe.FuarExtranjeroSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.FuarExtranjeroSiirfeDAO;
import mx.ine.sscc.servicios.siirfe.service.FuarExtrService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class FuarExtrServiceImpl implements FuarExtrService {

    @Resource
    FuarExtranjeroSiirfeDAO fuarExtranjeroSiirfeDAO;

    /**********************************************************************
     * FUAR EXTRANGERO
     ***********************************************************************/
    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#obtieneListaFuarExtranjero()
     */
    @Override
    public List<FuarExtranjeroSiirfe> obtieneListaFuarExtranjero(Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        List<FuarExtranjeroSiirfe> fuarExtranjeroList =
            Collections.synchronizedList(new LinkedList<FuarExtranjeroSiirfe>());

        fuarExtranjeroList = fuarExtranjeroSiirfeDAO.getFuarExtranjero();
        if (fuarExtranjeroList.size() > 0) {
            for (FuarExtranjeroSiirfe registro : fuarExtranjeroList) {
                fuarExtranjeroSiirfeDAO.updateFuarExtranjeroByFuar(registro.getFuar(),
                    TipoControlSincronizacion.ENVIADO.getClave(), bitacoraId);
            }
        }
        return fuarExtranjeroList;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#getHasAvailableRecordsFuarExtr
     * ()
     */
    @Override
    public long getHasAvailableRecordsFuarExtr() {
        // TODO [codificar el cuerpo del método]
        long aux = 0;
        try {
            aux = fuarExtranjeroSiirfeDAO.hasAvailableRecords();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return aux;
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#actualizaFuarExt(java.lang
     * .String, java.lang.String)
     */
    @Override
    public void actualizaFuarExt(String id, String nuevoEstatus, Long boqueId) {
        // TODO [codificar el cuerpo del método]
        fuarExtranjeroSiirfeDAO.updateFuarExtranjeroByFuar(id, nuevoEstatus, boqueId);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#actualizaBloqueFuarExt(java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaBloqueFuarExt(String nuevoEstatus, Long boqueId) {
        // TODO [codificar el cuerpo del método]
        fuarExtranjeroSiirfeDAO.updateFuarExtBySincId(nuevoEstatus, boqueId);
    }

}
