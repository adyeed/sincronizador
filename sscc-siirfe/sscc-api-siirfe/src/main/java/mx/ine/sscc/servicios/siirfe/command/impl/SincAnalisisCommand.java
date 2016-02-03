/**
 * InitSincConsultaExternaCommand.java
 * Fecha de creaci�n: 18/11/2015, 10:57:37
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

package mx.ine.sscc.servicios.siirfe.command.impl;

import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import mx.ine.sscc.servicios.siirfe.command.Command;
import mx.ine.sscc.servicios.siirfe.receptor.Sincronizador;

/**
 * TODO [Objeto que recibe la peticion del invocador. Este responde ejecutando un comando
 * concreto.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
public class SincAnalisisCommand implements Command {

    /**
     * TODO [Objeto Sincronizador, este objeto ejecuta la unida de trabajo necesaria para
     * sincronizar los registros de una tabla entre las bases de SIIRFE y UNICOM]
     */
    @Resource
    @Qualifier("SincronizadorAnalisisReg")
    public Sincronizador sincronizadorAnalisisReg;

    /**
     * TODO [Constructor]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    public SincAnalisisCommand() {
        // TODO [codificar el cuerpo del m�todo]
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.command.Command#execute()
     */
    @Override
    public Callable<?> execute() {
        // TODO [codificar el cuerpo del m�todo]
        return (Callable<?>) sincronizadorAnalisisReg;
    }
}
