/**
 * ConfirmacionCPVEDAO.java
 * Fecha de creación: 09/12/2015, 13:14:17
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Nacional Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */
package mx.ine.sscc.servicios.unicom.dao;

import java.util.List;

import mx.ine.sscc.modelo.entidad.ConfirmacionCPVE;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public interface ConfirmacionCPVEDAO {

    /**
     * obtiene una lista de objetos confirmacionCPVE con estatus en 'p'
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return List
     */
    List<ConfirmacionCPVE> getListConfirmacionCPVE();

    /**
     * obtiene un objeto confirmacionCPVE con estatus en 'p'
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @return ConfirmacionCPVE
     */
    ConfirmacionCPVE getConfirmacionCPVE();

    /**
     * Actualiza el estatus de un registro de acuerdo al folio dado
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param folio
     * @param estatus
     * @param nuevoEstatus
     */
    void updateEstatus(String folio, String estatus, String nuevoEstatus);

    /**
     * TODO [obtiene el número de registros disponibles para generar notificación.]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @return Número de datos.
     */
    long getDatosDisponibles();

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param confirmacionCPVE
     */
    void update(ConfirmacionCPVE confirmacionCPVE);

}
