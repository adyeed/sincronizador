/**
 * ConfirmacionCPVEDAO.java
 * Fecha de creaci�n: 09/12/2015, 13:14:17
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
     * TODO [obtiene el n�mero de registros disponibles para generar notificaci�n.]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @return N�mero de datos.
     */
    long getDatosDisponibles();

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param confirmacionCPVE
     */
    void update(ConfirmacionCPVE confirmacionCPVE);

}
