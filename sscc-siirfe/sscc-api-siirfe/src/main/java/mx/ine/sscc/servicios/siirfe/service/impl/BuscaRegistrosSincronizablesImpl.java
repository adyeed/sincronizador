/**
 * BuscaRegistrosSincronizables.java
 * Fecha de creaci�n: 27/11/2015, 19:24:23
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

package mx.ine.sscc.servicios.siirfe.service.impl;

import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables;
import mx.ine.sscc.servicios.siirfe.service.FuarExtrService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class BuscaRegistrosSincronizablesImpl implements BuscaRegistrosSincronizables {

    @Resource
    FuarExtrService fuarExtrService;

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosAnalisisReg()
     */

    @Override
    public Callable<?> buscaRegistrosAnalisisReg() {
        // TODO [codificar el cuerpo del m�todo]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del m�todo]
                return new Long(222);

            }
        };
    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosConsultaExt()
     */

    @Override
    public Callable<?> buscaRegistrosConsultaExt() {
        // TODO [codificar el cuerpo del m�todo]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del m�todo]
                return new Long(333);
            }
        };

    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosFuarExtr()
     */

    @Override
    public Callable<Long> buscaRegistrosFuarExtr() {
        // TODO [codificar el cuerpo del m�todo]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del m�todo]
                return fuarExtrService.getHasAvailableRecordsFuarExtr();

            }
        };

    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosFuarRech()
     */

    @Override
    public Callable<?> buscaRegistrosFuarRech() {
        // TODO [codificar el cuerpo del m�todo]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del m�todo]
                return new Long(444);
            }
        };

    }

    /* La documentaci�n de este m�todo se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosFuar()
     */

    @Override
    public Callable<?> buscaRegistrosFuar() {
        // TODO [codificar el cuerpo del m�todo]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del m�todo]
                return new Long(555);
            }
        };

    }

}
