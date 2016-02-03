/**
 * Fuar.java
 * Fecha de creaci�n: 28/11/2015, 15:19:07
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
import mx.ine.sscc.modelo.entidad.siirfe.FuarSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.FuarSiirfeDAO;
import mx.ine.sscc.servicios.siirfe.service.FuarService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class FuarServiceImpl implements FuarService {

    @Resource
    private FuarSiirfeDAO fuarSiirfeDAO;

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.FuarService#obtieneListaFuar(java.lang.Long)
     */
    @Override
    public List<FuarSiirfe> obtieneListaFuar(Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
        List<FuarSiirfe> fuarList = Collections.synchronizedList(new LinkedList<FuarSiirfe>());

        fuarList = fuarSiirfeDAO.getFuarSiirfe();
        if (fuarList.size() > 0) {
            for (FuarSiirfe registro : fuarList) {
                fuarSiirfeDAO.updateFuarById(registro.getFuar(),
                    TipoControlSincronizacion.ENVIADO.getClave(), bitacoraId);
            }
        }
        return fuarList;
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.FuarService#getAvailableRecordsFuar()
     */
    @Override
    public long getAvailableRecordsFuar() {
        // TODO [codificar el cuerpo del m�todo]
        long aux = 0;
        try {
            aux = fuarSiirfeDAO.hasAvailableRecords();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return aux;

    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.FuarService#actualizaFuar(java.lang.Long, java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaFuar(Long id, String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
        fuarSiirfeDAO.updateFuarById(id, nuevoEstatus, bitacoraId);

    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.FuarService#actualizaBloqueFuar(java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaBloqueFuar(String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
        fuarSiirfeDAO.updateFuarBySincId(nuevoEstatus, bitacoraId);
    }
}
