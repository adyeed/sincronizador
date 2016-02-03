/**
 * ConsultasService.java
 * Fecha de creaci�n: 28/10/2015, 14:33:15
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

package mx.ine.sscc.servicios.siirfe.service;

import mx.ine.sscc.modelo.entidad.siirfe.ProcesoSincronizacion;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
public interface ProcesoSincronizacionService {

    /**
     * TODO [Agregar documentacion del m�todo]
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @param bitacora
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion guardaBitacora(ProcesoSincronizacion bitacora);

    /**
     * TODO [Agregar documentacion del m�todo]
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @param bitacora
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion actualizaBitacora(ProcesoSincronizacion bitacora);

    /**
     * TODO [Agregar documentacion del m�todo]
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @param id
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion getBitacora(Long id);

}
