/**
 * Fuar.java
 * Fecha de creación: 28/11/2015, 15:19:07
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
import mx.ine.sscc.modelo.entidad.siirfe.FuarSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.FuarSiirfeDAO;
import mx.ine.sscc.servicios.siirfe.service.FuarService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class FuarServiceImpl implements FuarService {

    @Resource
    private FuarSiirfeDAO fuarSiirfeDAO;

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.FuarService#obtieneListaFuar(java.lang.Long)
     */
    @Override
    public List<FuarSiirfe> obtieneListaFuar(Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
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

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.FuarService#getAvailableRecordsFuar()
     */
    @Override
    public long getAvailableRecordsFuar() {
        // TODO [codificar el cuerpo del método]
        long aux = 0;
        try {
            aux = fuarSiirfeDAO.hasAvailableRecords();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return aux;

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.FuarService#actualizaFuar(java.lang.Long, java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaFuar(Long id, String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        fuarSiirfeDAO.updateFuarById(id, nuevoEstatus, bitacoraId);

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.FuarService#actualizaBloqueFuar(java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaBloqueFuar(String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        fuarSiirfeDAO.updateFuarBySincId(nuevoEstatus, bitacoraId);
    }
}
