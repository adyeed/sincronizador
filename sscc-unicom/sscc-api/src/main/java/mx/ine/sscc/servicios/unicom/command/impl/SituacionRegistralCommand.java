/**
 * SituacionRegistralCommand.java
 * Fecha de creaci�n: 04/01/2016, 10:20:53
 *
 * Copyright (c) 2016 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Federal Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */

package mx.ine.sscc.servicios.unicom.command.impl;

import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.unicom.command.Command;
import mx.ine.sscc.servicios.unicom.receptor.Ensamblador;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component("SituacionRegistralCommand")
public class SituacionRegistralCommand implements Command {

    @Resource
    @Qualifier("SituacionEnsamblador")
    Ensamblador situacionEnsamblador;

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.command.Command#execute()
     */
    @Override
    public Callable<?> execute() {
        return (Callable<?>) situacionEnsamblador;
        // TODO [codificar el cuerpo del m�todo]
    }

}
