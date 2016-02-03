/**
 * AnalisisRegServiceImpl.java
 * Fecha de creaci�n: 28/11/2015, 15:52:47
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
import mx.ine.sscc.modelo.entidad.siirfe.AnalisisRegistralSiirfe;
import mx.ine.sscc.servicios.siirfe.dao.AnalisisRegistralSiirfeDAO;
import mx.ine.sscc.servicios.siirfe.service.AnalisisRegService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class AnalisisRegServiceImpl implements AnalisisRegService {

    @Resource
    private AnalisisRegistralSiirfeDAO analisisRegistralSiirfeDAO;

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.AnalisisRegService#obtieneListaAnalisisReg(java.lang.Long)
     */
    @Override
    public List<AnalisisRegistralSiirfe> obtieneListaAnalisisReg(Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
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

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.AnalisisRegService#getHasAvailableRecordsAnalisisReg()
     */
    @Override
    public long getHasAvailableRecordsAnalisisReg() {
        // TODO [codificar el cuerpo del m�todo]
        long aux = 0;
        try {
            aux = analisisRegistralSiirfeDAO.hasAvailableRecords();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return aux;
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.AnalisisRegService#actualizaAnalisisReg(java.lang.Long, java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaAnalisisReg(Long id, String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
        analisisRegistralSiirfeDAO.updateAnalisisRegistralByCiudadanoId(id, nuevoEstatus,
            bitacoraId);
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.AnalisisRegService#actualizaBloqueAnalisisReg(java.lang.String, java.lang.Long)
     */
    @Override
    public void actualizaBloqueAnalisisReg(String nuevoEstatus, Long bitacoraId) {
        // TODO [codificar el cuerpo del m�todo]
        analisisRegistralSiirfeDAO.updateAnalisisRegistralBySincId(nuevoEstatus, bitacoraId);
    }

}
