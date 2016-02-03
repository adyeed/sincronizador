/**
 * ConfirmacionInvocador.java
 * Fecha de creaci�n: 18/12/2015, 14:00:49
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

package mx.ine.sscc.servicios.unicom.invocador.impl;

import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.unicom.command.Command;
import mx.ine.sscc.servicios.unicom.invocador.Invocador;

/**
 * TODO [Implementaci�n de la interface Invocador. Por medio de un objeto de tipo Command
 * obtiene el objeto Callable<?>.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component("ConfirmacionInvocador")
public class ConfirmacionInvocador implements Invocador {
    @Resource
    @Qualifier("ConfirmacionCommand")
    Command confirmacionCommand;

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.invocador.Invocador#initAssemble()
     */
    @Override
    public Callable<?> initAssemble() {
        return confirmacionCommand.execute();
        // TODO [codificar el cuerpo del m�todo]

    }

}
