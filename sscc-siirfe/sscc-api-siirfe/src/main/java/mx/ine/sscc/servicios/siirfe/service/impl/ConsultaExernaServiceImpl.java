/**
 * ConsultaExernaService.java
 * Fecha de creación: 28/11/2015, 15:43:29
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
import mx.ine.sscc.modelo.entidad.siirfe.ConsultaExternaSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.ConsultaExternaSiirfeDAO;
import mx.ine.sscc.servicios.siirfe.service.ConsultaExternaService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class ConsultaExernaServiceImpl implements ConsultaExternaService {

    @Resource
    private ConsultaExternaSiirfeDAO consultaExternaSiirfeDAO;

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.ConsultaExternaService#obtieneListaConsultaExtr(java.lang.Long)
     */
    @Override
    public List<ConsultaExternaSiirfe> obtieneListaConsultaExtr(Long bitacoraId) {
        List<ConsultaExternaSiirfe> consultaExternaList =
            Collections.synchronizedList(new LinkedList<ConsultaExternaSiirfe>());

        consultaExternaList = consultaExternaSiirfeDAO.getConsultaExterna();
        if (consultaExternaList.size() > 0) {
            for (ConsultaExternaSiirfe registro : consultaExternaList) {
                consultaExternaSiirfeDAO.updateConsultaExternaById(registro.getCiudadanoId(),
                    TipoControlSincronizacion.ENVIADO.getClave(), bitacoraId);
            }
        }
        return consultaExternaList;

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.ConsultaExternaService#getHasAvailableRecordsConsultaExtr()
     */
    @Override
    public long getHasAvailableRecordsConsultaExtr() {
        // TODO [codificar el cuerpo del método]
        long aux = 0;
        try {
            aux = consultaExternaSiirfeDAO.hasAvailableRecords();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return aux;
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.ConsultaExternaService#actualizaConsultaExtr(java.lang.String, java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaConsultaExtr(Long id, String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        consultaExternaSiirfeDAO.updateConsultaExternaById(id, nuevoEstatus, bitacoraId);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.ConsultaExternaService#actualizaBloqueConsultaExtr(java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaBloqueConsultaExtr(String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        consultaExternaSiirfeDAO.updateConsultaExtBySincId(nuevoEstatus, bitacoraId);

    }

}
