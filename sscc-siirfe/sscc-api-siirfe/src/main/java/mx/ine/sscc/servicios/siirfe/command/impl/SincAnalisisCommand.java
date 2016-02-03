/**
 * InitSincConsultaExternaCommand.java
 * Fecha de creación: 18/11/2015, 10:57:37
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
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
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
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public SincAnalisisCommand() {
        // TODO [codificar el cuerpo del método]
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.command.Command#execute()
     */
    @Override
    public Callable<?> execute() {
        // TODO [codificar el cuerpo del método]
        return (Callable<?>) sincronizadorAnalisisReg;
    }
}
