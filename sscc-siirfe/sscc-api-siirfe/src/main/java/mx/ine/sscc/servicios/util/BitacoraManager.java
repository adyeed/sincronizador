/**
 * BitacoraManager.java
 * Fecha de creación: 01/12/2015, 11:07:31
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

package mx.ine.sscc.servicios.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import mx.ine.sscc.modelo.catalogo.TipoEstatusSincronizacion;
import mx.ine.sscc.modelo.catalogo.TipoEstatusSubproceso;
import mx.ine.sscc.modelo.entidad.siirfe.ControlProcesoSincronizacion;
import mx.ine.sscc.modelo.entidad.siirfe.ProcesoSincronizacion;
import mx.ine.sscc.servicios.siirfe.service.ProcesoSincronizacionService;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
@Scope("prototype")
public class BitacoraManager {
    private static final Logger logger = LoggerFactory.getLogger(BitacoraManager.class);

    @Resource
    private ProcesoSincronizacionService procesoSincronizacionService;

    private ProcesoSincronizacion bitacoraMaster;
    private ControlProcesoSincronizacion bitacoraSlaveExtraccion;
    private ControlProcesoSincronizacion bitacoraSlaveEnvio;
    private ControlProcesoSincronizacion bitacoraSlaveSincronizado;

    private List<ControlProcesoSincronizacion> listaBitacorasSlave =
        Collections.synchronizedList(new ArrayList<ControlProcesoSincronizacion>());

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public BitacoraManager() {
    }

    /**
     * TODO [Método que sirve para instaciar y dar valores inciales al objeto de
     * ProcesoSincronizacion para la creación de la bitacora.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param nombreProceso
     */
    public synchronized void creaBitacoraPrincipal(String nombreProceso) {
        bitacoraMaster = new ProcesoSincronizacion();
        bitacoraMaster.setNombreProceso(nombreProceso);
        bitacoraMaster.setFechaInicio(new Date());
        bitacoraMaster.setEstatus(TipoEstatusSincronizacion.PROCESANDO.toString()); //
        bitacoraMaster
            .setSecuencia(new Long(TipoEstatusSubproceso.EXTRAE_DE_CONCILIACIONES.getId()));
        bitacoraMaster.setControlProcesoSincronizacion(listaBitacorasSlave);

        try {
            setBitacoraMaster(guardaBitacoraMaster(bitacoraMaster));
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error al crear la bitacora principal -->" + e.getMessage());

            e.printStackTrace();
        }
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public synchronized void actualizaBitacoraPrincipal() {
        getBitacoraMaster().setControlProcesoSincronizacion(listaBitacorasSlave);
        actualizaBitacoraMaster(getBitacoraMaster());
        limpiaObjetos();
    }

    private synchronized ProcesoSincronizacion guardaBitacoraMaster(
        ProcesoSincronizacion bitacoraMaster) {
        return procesoSincronizacionService.guardaBitacora(bitacoraMaster);
    }

    private synchronized void actualizaBitacoraMaster(ProcesoSincronizacion bitacoraMaster) {
        procesoSincronizacionService.actualizaBitacora(bitacoraMaster);
    }

    /*
     * ************************************ SUB BITACORAS
     */

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param registros
     */
    public synchronized void creaSubBitacoraExtraccion(int registros) {
        bitacoraSlaveExtraccion = new ControlProcesoSincronizacion();
        bitacoraSlaveExtraccion.setProcesoSincronizacion(getBitacoraMaster());
        bitacoraSlaveExtraccion
            .setSecuencia(new Long(TipoEstatusSubproceso.EXTRAE_DE_CONCILIACIONES.getId()));
        bitacoraSlaveExtraccion.setDescripcionSecuencia(
            TipoEstatusSubproceso.EXTRAE_DE_CONCILIACIONES.getClave());
        bitacoraSlaveExtraccion.setFechaInicio(new Date());
        bitacoraSlaveExtraccion.setFechaFin(new Date());
        bitacoraSlaveExtraccion.setRegistros(new Long(registros));
        bitacoraSlaveExtraccion.setRegistrosProcesados(new Long(registros));
        listaBitacorasSlave.add(bitacoraSlaveExtraccion);

    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param error
     */
    public synchronized void creaSubBitacoraExtraccion(String error) {
        getBitacoraMaster().setEstatus(TipoEstatusSincronizacion.ERROR.toString());
        getBitacoraMaster().setRespuesta("1.0");
        getBitacoraMaster().setFechaFin(new Date());

        bitacoraSlaveExtraccion = new ControlProcesoSincronizacion();
        bitacoraSlaveExtraccion.setProcesoSincronizacion(getBitacoraMaster());
        bitacoraSlaveExtraccion
            .setSecuencia(new Long(TipoEstatusSubproceso.EXTRAE_DE_CONCILIACIONES.getId()));
        bitacoraSlaveExtraccion.setDescripcionSecuencia(
            TipoEstatusSubproceso.EXTRAE_DE_CONCILIACIONES.getClave());
        bitacoraSlaveExtraccion.setError(error);
        bitacoraSlaveExtraccion.setFechaInicio(new Date());
        bitacoraSlaveExtraccion.setFechaFin(new Date());
        listaBitacorasSlave.add(bitacoraSlaveExtraccion);
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param registros
     */
    public synchronized void creaSubBitacoraEnvioUnicom(int registros) {
        bitacoraSlaveEnvio = new ControlProcesoSincronizacion();

        // Se actualiza la secuencia del registro principal de la bitacora Master.
        getBitacoraMaster()
            .setSecuencia(new Long(TipoEstatusSubproceso.ENVIO_A_UNICOM.getId()));

        // Se asignan los valores a la nueva sub bitacora.
        bitacoraSlaveEnvio.setProcesoSincronizacion(getBitacoraMaster());
        bitacoraSlaveEnvio
            .setSecuencia(new Long(TipoEstatusSubproceso.ENVIO_A_UNICOM.getId()));
        bitacoraSlaveEnvio
            .setDescripcionSecuencia(TipoEstatusSubproceso.ENVIO_A_UNICOM.getClave());
        bitacoraSlaveEnvio.setFechaInicio(new Date());
        bitacoraSlaveEnvio.setFechaFin(new Date());
        bitacoraSlaveEnvio.setRegistros(new Long(registros));
        bitacoraSlaveEnvio.setRegistrosProcesados(new Long(registros));
        listaBitacorasSlave.add(bitacoraSlaveEnvio);
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param error
     */
    public synchronized void creaSubBitacoraEnvioUnicom(String error) {
        getBitacoraMaster().setEstatus(TipoEstatusSincronizacion.ERROR.toString());
        getBitacoraMaster().setRespuesta("2.0");
        getBitacoraMaster().setFechaFin(new Date());

        bitacoraSlaveEnvio = new ControlProcesoSincronizacion();

        // Se actualiza la secuencia del registro principal de la bitacora Master.
        getBitacoraMaster()
            .setSecuencia(new Long(TipoEstatusSubproceso.ENVIO_A_UNICOM.getId()));
        // Se da por terminado el primer proceso de laSub Bitacora.
        listaBitacorasSlave.get(0).setFechaFin(new Date());

        bitacoraSlaveEnvio.setProcesoSincronizacion(getBitacoraMaster());
        bitacoraSlaveEnvio
            .setSecuencia(new Long(TipoEstatusSubproceso.ENVIO_A_UNICOM.getId()));
        bitacoraSlaveEnvio
            .setDescripcionSecuencia(TipoEstatusSubproceso.ENVIO_A_UNICOM.getClave());
        bitacoraSlaveEnvio.setError(error);
        bitacoraSlaveEnvio.setFechaInicio(new Date());
        bitacoraSlaveEnvio.setFechaFin(new Date());
        listaBitacorasSlave.add(bitacoraSlaveEnvio);
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param registros
     * @param registrosProcesados
     */
    public synchronized void creaSubBitacoraSincronizadoUnicom(int registros,
        int registrosProcesados) {
        getBitacoraMaster().setEstatus("EXITOSO");
        bitacoraSlaveSincronizado = new ControlProcesoSincronizacion();

        getBitacoraMaster()
            .setSecuencia(new Long(TipoEstatusSubproceso.SINCRONIZADO_EN_UNICOM.getId()));

        bitacoraSlaveSincronizado.setProcesoSincronizacion(getBitacoraMaster());
        bitacoraSlaveSincronizado
            .setSecuencia(new Long(TipoEstatusSubproceso.SINCRONIZADO_EN_UNICOM.getId()));
        bitacoraSlaveSincronizado
            .setDescripcionSecuencia(TipoEstatusSubproceso.SINCRONIZADO_EN_UNICOM.getClave());
        bitacoraSlaveSincronizado.setFechaInicio(new Date());
        bitacoraSlaveSincronizado.setFechaFin(new Date());
        bitacoraSlaveSincronizado.setRegistros(new Long(registros));
        bitacoraSlaveSincronizado.setRegistrosProcesados(new Long(registrosProcesados));
        if (registrosProcesados < registros) {
            bitacoraSlaveSincronizado.setError(
                "Hubo errores al procesar algunos registros. Verificar logs en unicom");
        }
        listaBitacorasSlave.add(bitacoraSlaveSincronizado);

    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param error
     */
    public synchronized void creaSubBitacoraSincronizadoUnicom(String error) {
        getBitacoraMaster().setEstatus(TipoEstatusSincronizacion.ERROR.toString());
        getBitacoraMaster().setRespuesta("3.0");
        getBitacoraMaster().setFechaFin(new Date());

        bitacoraSlaveSincronizado = new ControlProcesoSincronizacion();

        getBitacoraMaster()
            .setSecuencia(new Long(TipoEstatusSubproceso.SINCRONIZADO_EN_UNICOM.getId()));

        bitacoraSlaveSincronizado.setProcesoSincronizacion(getBitacoraMaster());
        bitacoraSlaveSincronizado
            .setSecuencia(new Long(TipoEstatusSubproceso.SINCRONIZADO_EN_UNICOM.getId()));
        bitacoraSlaveSincronizado
            .setDescripcionSecuencia(TipoEstatusSubproceso.SINCRONIZADO_EN_UNICOM.getClave());
        bitacoraSlaveSincronizado.setFechaInicio(new Date());
        bitacoraSlaveSincronizado.setError(error);
        bitacoraSlaveSincronizado.setFechaFin(new Date());
        listaBitacorasSlave.add(bitacoraSlaveSincronizado);
    }

    private synchronized void limpiaObjetos() {
        bitacoraMaster = null;
        bitacoraSlaveExtraccion = null;
        bitacoraSlaveEnvio = null;
        bitacoraSlaveSincronizado = null;
    }

    /*
     * GETTERS Y SETTERS
     */
    /**
     * @return el atributo bitacoraMaster
     */
    public ProcesoSincronizacion getBitacoraMaster() {
        return bitacoraMaster;
    }

    /**
     * @param bitacoraMaster parametro bitacoraMaster a actualizar
     */

    public void setBitacoraMaster(ProcesoSincronizacion bitacoraMaster) {
        this.bitacoraMaster = bitacoraMaster;
    }

}
