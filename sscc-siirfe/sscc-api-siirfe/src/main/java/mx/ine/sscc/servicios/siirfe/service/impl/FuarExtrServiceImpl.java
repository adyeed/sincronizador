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
import mx.ine.sscc.modelo.entidad.siirfe.FuarExtranjeroSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.FuarExtranjeroSiirfeDAO;
import mx.ine.sscc.servicios.siirfe.service.FuarExtrService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
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
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#obtieneListaFuarExtranjero()
     */
    @Override
    public List<FuarExtranjeroSiirfe> obtieneListaFuarExtranjero(Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
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
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#getHasAvailableRecordsFuarExtr
     * ()
     */
    @Override
    public long getHasAvailableRecordsFuarExtr() {
        // TODO [codificar el cuerpo del m�todo]
        long aux = 0;
        try {
            aux = fuarExtranjeroSiirfeDAO.hasAvailableRecords();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return aux;
    }

    /*
     * La documentaci�n de este m�todo se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#actualizaFuarExt(java.lang
     * .String, java.lang.String)
     */
    @Override
    public void actualizaFuarExt(String id, String nuevoEstatus, Long boqueId) {
        // TODO [codificar el cuerpo del m�todo]
        fuarExtranjeroSiirfeDAO.updateFuarExtranjeroByFuar(id, nuevoEstatus, boqueId);
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.ConsultaSiirfeService#actualizaBloqueFuarExt(java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaBloqueFuarExt(String nuevoEstatus, Long boqueId) {
        // TODO [codificar el cuerpo del m�todo]
        fuarExtranjeroSiirfeDAO.updateFuarExtBySincId(nuevoEstatus, boqueId);
    }

}
