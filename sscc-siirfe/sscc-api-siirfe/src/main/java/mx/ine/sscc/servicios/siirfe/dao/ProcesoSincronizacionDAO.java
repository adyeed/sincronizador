/**
 * FuarSiirfeDAO.java
 * Fecha de creaci�n: 04/11/2015, 17:47:34
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */
package mx.ine.sscc.servicios.siirfe.dao;

import mx.ine.sscc.modelo.entidad.siirfe.ProcesoSincronizacion;

/**
 * Interfaz de acceso a datos para Fuar
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */

public interface ProcesoSincronizacionDAO {

    /**
     * TODO [Agregar documentacion del m�todo]
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @param procesoSincronizacion
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion guardaBitacora(ProcesoSincronizacion procesoSincronizacion);

    /**
     * TODO [Agregar documentacion del m�todo]
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @param procesoSincronizacion
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion actualizaBitacora(ProcesoSincronizacion procesoSincronizacion);

    /**
     * TODO [Agregar documentacion del m�todo]
     * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
     * @param id
     * @return ProcesoSincronizacion
     */
    ProcesoSincronizacion getBitacora(Long id);

}
