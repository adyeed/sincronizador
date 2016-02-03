/**
 * SwitchSincroniza.java
 * Fecha de creaci�n: 13/11/2015, 14:21:21
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

package mx.ine.sscc.servicios.siirfe.invocador.impl;

import java.util.concurrent.Callable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.ine.sscc.servicios.siirfe.command.Command;
import mx.ine.sscc.servicios.siirfe.command.impl.SincConsultaCommand;
import mx.ine.sscc.servicios.siirfe.invocador.Invocador;

/**
 * TODO [Clase que se encarga de invocar las tareas de trabajo para la sincronizaci�n para cada
 * una de las tablas SIIRFE por medio de objetos tipo command.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service("InvocadorConsultaExterImpl")
public class InvocadorConsultaExterImpl implements Invocador {

    private Command initSincCommand;

    /**
     * TODO [Constructor]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    public InvocadorConsultaExterImpl() {
        // TODO [codificar el cuerpo del m�todo]
    }

    /**
     * TODO [Constructor]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param sincConsultaCommand
     */
    @Autowired
    public InvocadorConsultaExterImpl(SincConsultaCommand sincConsultaCommand) {
        // TODO [codificar el cuerpo del m�todo]
        this.initSincCommand = sincConsultaCommand;
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.invocador.SincronizaInvocator#initSincFuar()
     */
    @Override
    public Callable<?> initSinc() {
        // TODO [codificar el cuerpo del m�todo]
        return initSincCommand.execute();
    }

}
