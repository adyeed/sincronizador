/**
 * BuscaRegistrosSincronizables.java
 * Fecha de creación: 27/11/2015, 19:24:23
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

package mx.ine.sscc.servicios.siirfe.service.impl;

import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables;
import mx.ine.sscc.servicios.siirfe.service.FuarExtrService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class BuscaRegistrosSincronizablesImpl implements BuscaRegistrosSincronizables {

    @Resource
    FuarExtrService fuarExtrService;

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosAnalisisReg()
     */

    @Override
    public Callable<?> buscaRegistrosAnalisisReg() {
        // TODO [codificar el cuerpo del método]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del método]
                return new Long(222);

            }
        };
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosConsultaExt()
     */

    @Override
    public Callable<?> buscaRegistrosConsultaExt() {
        // TODO [codificar el cuerpo del método]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del método]
                return new Long(333);
            }
        };

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosFuarExtr()
     */

    @Override
    public Callable<Long> buscaRegistrosFuarExtr() {
        // TODO [codificar el cuerpo del método]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del método]
                return fuarExtrService.getHasAvailableRecordsFuarExtr();

            }
        };

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosFuarRech()
     */

    @Override
    public Callable<?> buscaRegistrosFuarRech() {
        // TODO [codificar el cuerpo del método]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del método]
                return new Long(444);
            }
        };

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.service.BuscaRegistrosSincronizables#buscaRegistrosFuar()
     */

    @Override
    public Callable<?> buscaRegistrosFuar() {
        // TODO [codificar el cuerpo del método]
        return new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                // TODO [codificar el cuerpo del método]
                return new Long(555);
            }
        };

    }

}
