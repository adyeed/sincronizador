/**
 * SincronizaConsultaExternaSiirfeCallable.java
 * Fecha de creación: 17/11/2015, 17:06:04
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

package mx.ine.sscc.servicios.siirfe.receptor.impl;

import java.net.MalformedURLException;
import java.util.Map.Entry;
import java.util.concurrent.Callable;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.xml.ws.WebServiceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.DatosRegistro;
import mx.ine.sscc.modelo.bean.DatosSalida;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;
import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.catalogo.TipoTablaActualizacion;
import mx.ine.sscc.servicios.siirfe.receptor.Sincronizador;
import mx.ine.sscc.servicios.siirfe.service.FuarExtrService;
import mx.ine.sscc.servicios.util.BitacoraManager;
import mx.ine.sscc.servicios.util.GeneralConstants;
import mx.ine.sscc.servicios.ws.soap.clientes.ActualizaCliente;

/**
 * TODO [Clase que recibe la peticion del invocador por medio de un comando concreto.Esta clase
 * contiene la unidad de trabajo necesaria para la sincronización de la tabla FUAR EXTRANGERO.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component("SincronizadorFuarExtr")
public class SincronizadorFuarExtr implements Callable<Object>, Sincronizador {

    private static final Logger logger = LoggerFactory.getLogger(SincronizadorFuarExtr.class);

    private DatosEntrada datosEntrada;
    private RespuestaSincronizacion respuestaSincronizacion;
    @Resource
    private FuarExtrService fuarExtrService;
    @Resource
    private ActualizaCliente actualizaCliente;
    private Long bitacoraId;
    private Long registros;
    private int regBloque;
    private int errorDB = 0;
    private int errorWS = 0;

    @Resource
    BitacoraManager bitacoraManager;

    /**
     * TODO [Constructor]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public SincronizadorFuarExtr() {
        // TODO [codificar el cuerpo del método]
    }

    /**
     * TODO [Método para configuración de la clase. [Creación de objetos por ejemplo]]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    @PostConstruct
    private void conf() {
        logger.info("::: Configurando sincronizador " + this.getClass().getSimpleName());
        datosEntrada = new DatosEntrada();
        respuestaSincronizacion = new RespuestaSincronizacion();
    }

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see java.util.concurrent.Callable#call()
     */
    @Override
    public Object call() {
        // TODO [codificar el cuerpo del método]
        /*
         * Método principal, en este método se encuentra la unidad de trabajo principal para
         * la sincronziación de cada tabla.
         */
        setThreadName();
        datosEntrada.setThreadName(Thread.currentThread().getName());
        setRegistros(obtieneRegistrosSincronizables());

        do {
            try {
                // Se crea el registro principal de la bitacora.
                bitacoraManager
                    .creaBitacoraPrincipal(TipoTablaActualizacion.FUAREXTRANJERO.getClave());
                logger.info("Bitacora ID ---> "
                    + bitacoraManager.getBitacoraMaster().getProcesoSincronizacionId());
                if (obtieneBloque(getDatosEntrada())) {
                    if (enviaBloque(getDatosEntrada())) {
                        procesaRespuesta(getRespuestaSincronizacion());
                    }
                }
                bitacoraManager.actualizaBitacoraPrincipal();
                setRegistros(obtieneRegistrosSincronizables());
                validaErrores();
                // setRegistros(new Long(0));
            } catch (Exception e) {
                // TODO: handle exception
                logger.error("**** Error en bitacora principal " + " - " + e.getMessage()
                    + " - " + e.getCause().toString());
                setErrorDB(getErrorDB() + 1);
                validaErrores();
            }
        } while (getRegistros() > 0);
        return null;
    }

    /**
     * TODO [Actualiza los registros que retornan del servicio web Actuliza UNICOM.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param respuestaSincronizacion
     */
    @Override
    public void procesaRespuesta(RespuestaSincronizacion respuestaSincronizacion) {
        logger.info(">> procesando respuesta -- "
            + bitacoraManager.getBitacoraMaster().getProcesoSincronizacionId());
        if (respuestaSincronizacion.getMensajeError() == null) {
            int registrosBien = 0;
            try {

                for (Entry<Long, DatosSalida> datosRespuesta : respuestaSincronizacion
                    .getResponseHashMapObject().entrySet()) {
                    bitacoraId = datosRespuesta.getKey();

                    for (DatosRegistro datosRegistro : datosRespuesta.getValue()
                        .getDatosRegistro()) {
                        if (TipoControlSincronizacion.REPROCESADO.getClave()
                            .equals(datosRegistro.getControlSinc())) {
                            fuarExtrService.actualizaFuarExt(datosRegistro.getIdTxt(),
                                datosRegistro.getControlSinc(),
                                datosRegistro.getProcesoSincronizacionId());
                        }
                        if (TipoControlSincronizacion.TERMINADO.getClave()
                            .equals(datosRegistro.getControlSinc())) {
                            registrosBien++;
                        }
                    }
                }
                actualizaBloqueExito(bitacoraId);
                bitacoraManager.creaSubBitacoraSincronizadoUnicom(getRegBloque(),
                    registrosBien);

            } catch (Exception e) {
                // TODO: handle exception
                logger.error("error al procesar respuesta del ws --> "
                    + bitacoraManager.getBitacoraMaster().getProcesoSincronizacionId() + " - "
                    + e.getMessage() + " - " + e.getCause().toString());
                setErrorDB(getErrorDB() + 1);
                bitacoraManager.creaSubBitacoraSincronizadoUnicom(e.getCause().toString());
            }
        } else {
            logger.error("error con el ws --> "
                + bitacoraManager.getBitacoraMaster().getProcesoSincronizacionId() + " - "
                + respuestaSincronizacion.getMensajeError());
            actualizaBloqueError(datosEntrada);
            setErrorWS(getErrorWS() + 1);
            bitacoraManager
                .creaSubBitacoraSincronizadoUnicom(respuestaSincronizacion.getMensajeError());
        }

    }

    /**
     * TODO [Método que asigna el nombre al hilo encargado de ejecutar la unidad de trabajo.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public void setThreadName() {
        Thread.currentThread()
            .setName(GeneralConstants._BLOQUE_FUAREXTRANGERO + Thread.currentThread().getId());
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.receptor.Sincronizador#obtieneBloque()
     */
    @Override
    public synchronized boolean obtieneBloque(DatosEntrada datosEntrada) {
        // TODO [codificar el cuerpo del método]
        logger.info(">> obtiene bloque de registros -- "
            + bitacoraManager.getBitacoraMaster().getProcesoSincronizacionId());
        /*
         * OBTIENE REGISTROS FUAR EXTRANGERO
         */
        try {
            setBitacoraId(bitacoraManager.getBitacoraMaster().getProcesoSincronizacionId());
            datosEntrada.setFuarExtranjeroSiirfe(
                fuarExtrService.obtieneListaFuarExtranjero(getBitacoraId()));
            datosEntrada.setProcesoSincronizacioId(getBitacoraId());
            setRegBloque(datosEntrada.getFuarExtranjeroSiirfe().size());
            bitacoraManager.creaSubBitacoraExtraccion(getRegBloque());
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("error al obtener registros --> "
                + bitacoraManager.getBitacoraMaster().getProcesoSincronizacionId() + " - "
                + e.getMessage() + " - " + e.getCause().toString());

            bitacoraManager.creaSubBitacoraExtraccion(e.getCause().toString());
            setErrorDB(getErrorDB() + 1);
            actualizaBloqueError(datosEntrada);
            return false;
        }
        // FIN OBTIENE REGISTROS FUAR EXTRANGERO
    }

    @Override
    public synchronized boolean enviaBloque(DatosEntrada datosEntrada) {
        logger.info(">> envia bloque de registros -- "
            + bitacoraManager.getBitacoraMaster().getProcesoSincronizacionId());
        /*
         * "ENVIA REGISTROS AL UNICOM"
         */
        try {
            setRespuestaSincronizacion(
                actualizaCliente.obtieneRespuestaFuarExtr(datosEntrada));
            bitacoraManager.creaSubBitacoraEnvioUnicom(getRegBloque());
            return true;
        } catch (WebServiceException e) {
            // TODO: handle exception
            logger.error("*** error al consumir ws --> "
                + datosEntrada.getProcesoSincronizacioId() + " - " + e.getMessage());
            e.getCause().toString();
            actualizaBloqueError(datosEntrada);
            bitacoraManager.creaSubBitacoraEnvioUnicom(e.getCause().toString());
            setErrorWS(getErrorWS() + 1);
            return false;
        } catch (MalformedURLException e) {
            // TODO [Manejar la excepcion de forma correcta]
            logger.error("*** error al consumir ws --> "
                + datosEntrada.getProcesoSincronizacioId() + " - " + e.getMessage());
            actualizaBloqueError(datosEntrada);
            bitacoraManager.creaSubBitacoraEnvioUnicom(e.getCause().toString());
            setErrorWS(getErrorWS() + 1);
            return false;
        }
        // * "ENVIA REGISTROS AL UNICOM"

    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.receptor.Sincronizador#actualizaBloqueExito()
     */
    @Override
    public synchronized void actualizaBloqueError(DatosEntrada datosEntrada) {
        if (datosEntrada != null) {
            fuarExtrService.actualizaBloqueFuarExt(
                TipoControlSincronizacion.PENDIENTE.getClave(),
                datosEntrada.getProcesoSincronizacioId());
        }
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.receptor.Sincronizador#actualizaBloqueExito()
     */
    @Override
    public synchronized void actualizaBloqueExito(Long bitacoraId) {
        // TODO [codificar el cuerpo del método]
        fuarExtrService.actualizaBloqueFuarExt(TipoControlSincronizacion.TERMINADO.getClave(),
            bitacoraId);
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.receptor.Sincronizador#obtieneRegistrosSincronizables()
     */
    @Override
    public Long obtieneRegistrosSincronizables() {
        // TODO [codificar el cuerpo del método]
        try {
            return fuarExtrService.getHasAvailableRecordsFuarExtr();
        } catch (Exception e) {
            // TODO: handle exception
            logger.error("*** error al obtener los datos --> " + e.getMessage());
            return (long) 0;
        }
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.siirfe.receptor.Sincronizador#validaErrores()
     */

    @Override
    public void validaErrores() {
        // TODO [codificar el cuerpo del método]
        if (getErrorDB() >= 4 || getErrorWS() >= 4) {
            setRegistros(new Long(0));
            setErrorDB(0);
            setErrorWS(0);
            logger.error(
                "*** se detectaron varios errores, el sincronizador ha sido detenido para evitar inconsistencia en los datos.***");
        }
    }

    /*
     * GETTER Y SETTERS
     */

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return bitacoraId
     */
    public Long getBitacoraId() {
        return bitacoraId;
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param bitacoraId
     */
    public void setBitacoraId(Long bitacoraId) {
        this.bitacoraId = bitacoraId;
    }

    /**
     * @return el atributo respuestaSincronizacion
     */
    public RespuestaSincronizacion getRespuestaSincronizacion() {
        return respuestaSincronizacion;
    }

    /**
     * @param respuestaSincronizacion parametro respuestaSincronizacion a actualizar
     */
    public void setRespuestaSincronizacion(RespuestaSincronizacion respuestaSincronizacion) {
        this.respuestaSincronizacion = respuestaSincronizacion;
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return
     */
    public DatosEntrada getDatosEntrada() {
        return datosEntrada;
    }

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param datosEntrada
     */
    public void setDatosEntrada(DatosEntrada datosEntrada) {
        this.datosEntrada = datosEntrada;
    }

    /**
     * @return el atributo registros
     */

    public Long getRegistros() {
        return registros;
    }

    /**
     * @param registros parametro registros a actualizar
     */

    public void setRegistros(Long registros) {
        this.registros = registros;
    }

    /**
     * @return el atributo regBloque
     */

    public int getRegBloque() {
        return regBloque;
    }

    /**
     * @param regBloque parametro regBloque a actualizar
     */

    public void setRegBloque(int regBloque) {
        this.regBloque = regBloque;
    }

    /**
     * @return el atributo errorDB
     */

    public int getErrorDB() {
        return errorDB;
    }

    /**
     * @param errorDB parametro errorDB a actualizar
     */

    public void setErrorDB(int errorDB) {
        this.errorDB = errorDB;
    }

    /**
     * @return el atributo errorWS
     */

    public int getErrorWS() {
        return errorWS;
    }

    /**
     * @param errorWS parametro errorWS a actualizar
     */

    public void setErrorWS(int errorWS) {
        this.errorWS = errorWS;
    }

}
