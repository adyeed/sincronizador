/**
 * AnalisisRegServiceImpl.java
 * Fecha de creación: 28/11/2015, 15:52:47
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
import mx.ine.sscc.modelo.entidad.siirfe.AnalisisRegistralSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.AnalisisRegistralSiirfeDAO;
import mx.ine.sscc.servicios.siirfe.service.AnalisisRegService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class AnalisisRegServiceImpl implements AnalisisRegService {

    @Resource
    private AnalisisRegistralSiirfeDAO analisisRegistralSiirfeDAO;

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.AnalisisRegService#obtieneListaAnalisisReg(java.lang.Long)
     */
    @Override
    public List<AnalisisRegistralSiirfe> obtieneListaAnalisisReg(Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        System.out.println("ID de bitacora  " + bitacoraId);
        List<AnalisisRegistralSiirfe> analisisRegistralList =
            Collections.synchronizedList(new LinkedList<AnalisisRegistralSiirfe>());

        analisisRegistralList = analisisRegistralSiirfeDAO.getAnalisisRegistralSiirfe();
        if (analisisRegistralList.size() > 0) {
            for (AnalisisRegistralSiirfe registro : analisisRegistralList) {
                analisisRegistralSiirfeDAO.updateAnalisisRegistralByCiudadanoId(
                    registro.getCiudadanoId(), TipoControlSincronizacion.ENVIADO.getClave(),
                    bitacoraId);
            }
        } else {
            System.out.println("No hay registros????");
        }
        return analisisRegistralList;
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.AnalisisRegService#getHasAvailableRecordsAnalisisReg()
     */
    @Override
    public long getHasAvailableRecordsAnalisisReg() {
        // TODO [codificar el cuerpo del método]
        long aux = 0;
        try {
            aux = analisisRegistralSiirfeDAO.hasAvailableRecords();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return aux;
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.AnalisisRegService#actualizaAnalisisReg(java.lang.Long, java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaAnalisisReg(Long id, String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        analisisRegistralSiirfeDAO.updateAnalisisRegistralByCiudadanoId(id, nuevoEstatus,
            bitacoraId);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.AnalisisRegService#actualizaBloqueAnalisisReg(java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaBloqueAnalisisReg(String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        analisisRegistralSiirfeDAO.updateAnalisisRegistralBySincId(nuevoEstatus, bitacoraId);
    }

}
