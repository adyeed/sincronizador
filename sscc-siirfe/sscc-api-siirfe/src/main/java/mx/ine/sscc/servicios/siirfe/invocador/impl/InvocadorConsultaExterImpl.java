/**
 * SwitchSincroniza.java
 * Fecha de creación: 13/11/2015, 14:21:21
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

package mx.ine.sscc.servicios.siirfe.invocador.impl;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ine.sscc.servicios.siirfe.command.Command;
import mx.ine.sscc.servicios.siirfe.command.impl.SincConsultaCommand;
import mx.ine.sscc.servicios.siirfe.invocador.Invocador;

/**
 * TODO [Clase que se encarga de invocar las tareas de trabajo para la sincronización para cada
 * una de las tablas SIIRFE por medio de objetos tipo command.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service("InvocadorConsultaExterImpl")
public class InvocadorConsultaExterImpl implements Invocador {

    private Command initSincCommand;

    /**
     * TODO [Constructor]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public InvocadorConsultaExterImpl() {
        // TODO [codificar el cuerpo del método]
    }

    /**
     * TODO [Constructor]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param sincConsultaCommand
     */
    @Autowired
    public InvocadorConsultaExterImpl(SincConsultaCommand sincConsultaCommand) {
        // TODO [codificar el cuerpo del método]
        this.initSincCommand = sincConsultaCommand;
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.invocador.SincronizaInvocator#initSincFuar()
     */
    @Override
    public Callable<?> initSinc() {
        // TODO [codificar el cuerpo del método]
        return initSincCommand.execute();
    }

}
