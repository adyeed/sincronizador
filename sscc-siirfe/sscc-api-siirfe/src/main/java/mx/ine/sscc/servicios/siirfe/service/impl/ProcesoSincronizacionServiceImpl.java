/**
 * ConsultaServiceImpl.java
 * Fecha de creaci�n: 28/10/2015, 14:34:04
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

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.entidad.siirfe.ProcesoSincronizacion;
import mx.ine.sscc.servicios.siirfe.dao.ProcesoSincronizacionDAO;
import mx.ine.sscc.servicios.siirfe.service.ProcesoSincronizacionService;

/**
 * TODO [Clase que implementa la interfaz de consultas,en ella se encutran los m�todos para la
 * consulta a las tablas del siirfe y actualizaci�n de los registros de acuerdo a su estatus.]
 * @author Orlando Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class ProcesoSincronizacionServiceImpl implements ProcesoSincronizacionService {

    @Resource
    ProcesoSincronizacionDAO procesoSincronizacionDAO;

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    public ProcesoSincronizacionServiceImpl() {
    }

    @Override
    public ProcesoSincronizacion guardaBitacora(ProcesoSincronizacion bitacora) {
        return procesoSincronizacionDAO.guardaBitacora(bitacora);
    }

    @Override
    public ProcesoSincronizacion actualizaBitacora(ProcesoSincronizacion bitacora) {
        return procesoSincronizacionDAO.actualizaBitacora(bitacora);
    }

    @Override
    public ProcesoSincronizacion getBitacora(Long id) {
        return procesoSincronizacionDAO.getBitacora(id);
    }

}
