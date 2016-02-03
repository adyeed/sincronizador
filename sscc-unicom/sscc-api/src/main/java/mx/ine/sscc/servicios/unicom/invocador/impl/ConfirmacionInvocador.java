/**
 * ConfirmacionInvocador.java
 * Fecha de creación: 18/12/2015, 14:00:49
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

package mx.ine.sscc.servicios.unicom.invocador.impl;

import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.unicom.command.Command;
import mx.ine.sscc.servicios.unicom.invocador.Invocador;

/**
 * TODO [Implementación de la interface Invocador. Por medio de un objeto de tipo Command
 * obtiene el objeto Callable<?>.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component("ConfirmacionInvocador")
public class ConfirmacionInvocador implements Invocador {
    @Resource
    @Qualifier("ConfirmacionCommand")
    Command confirmacionCommand;

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.invocador.Invocador#initAssemble()
     */
    @Override
    public Callable<?> initAssemble() {
        return confirmacionCommand.execute();
        // TODO [codificar el cuerpo del método]

    }

}
