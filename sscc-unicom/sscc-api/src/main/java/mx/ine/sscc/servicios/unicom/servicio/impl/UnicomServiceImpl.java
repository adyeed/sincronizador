/**
 * UnicomServiceImpl.java
 * Fecha de creación: Oct 28, 2015, 1:01:08 PM
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Dirección
 * Ejecutiva del Registro Federal de Electores.
 * Periférico Sur 239, México, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es información confidencial, propiedad del
 * Instituto Nacional Electoral. Esta información confidencial
 * no deberá ser divulgada y solo se podrá utilizar de acuerdo
 * a los términos que determine el propio Instituto.
 */
package mx.ine.sscc.servicios.unicom.servicio.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.hibernate.exception.GenericJDBCException;
import org.hibernate.exception.SQLGrammarException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.DatosRegistro;
import mx.ine.sscc.modelo.bean.DatosSalida;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;
import mx.ine.sscc.modelo.catalogo.TipoControlSincronizacion;
import mx.ine.sscc.modelo.entidad.siirfe.AnalisisRegistralSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.ConsultaExternaSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.FuarExtranjeroSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.FuarRechazadoSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.FuarSiirfe;
import mx.ine.sscc.modelo.entidad.unicom.AnalisisRegistralUnicom;
import mx.ine.sscc.modelo.entidad.unicom.ConsultaExternaUnicom;
import mx.ine.sscc.modelo.entidad.unicom.FuarExtranjeroUnicom;
import mx.ine.sscc.modelo.entidad.unicom.FuarRechazadoUnicom;
import mx.ine.sscc.modelo.entidad.unicom.FuarUnicom;
import mx.ine.sscc.servicios.unicom.dao.UnicomDAO;
import mx.ine.sscc.servicios.unicom.servicio.UnicomService;
import mx.ine.sscc.servicios.util.EntitiTransformer;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Service
public class UnicomServiceImpl implements UnicomService {

    private static final Logger logger = LoggerFactory.getLogger(UnicomServiceImpl.class);

    /**
     * TODO [Agregar documentación del atributo]
     */
    @Resource
    public EntitiTransformer entitiTransformer;
    @Resource
    private UnicomDAO unicomDAO;

    /**
     * TODO [Agregar documentacion al método]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    public UnicomServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.UnicomService#actualizaAnalisis(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaAnalisis(DatosEntrada datosEntrada) {
        Map<Long, DatosSalida> responseHashMapObject =
            new ConcurrentHashMap<Long, DatosSalida>();
        RespuestaSincronizacion respuesta = new RespuestaSincronizacion();
        DatosSalida datosSalida = new DatosSalida();

        if (datosEntrada.getAnalisisRegistralSiirfe() != null) {
            for (AnalisisRegistralSiirfe analisisRegistralSiirfe : datosEntrada
                .getAnalisisRegistralSiirfe()) {
                AnalisisRegistralUnicom analisisRegistralUnicom =
                    new AnalisisRegistralUnicom();
                try {
                    analisisRegistralUnicom =
                        entitiTransformer.tranformaAnalisisRegistralSirfeAUnicom(
                            analisisRegistralSiirfe, datosEntrada.getProcesoSincronizacioId());
                    unicomDAO.actualizaAnalisisRegistral(analisisRegistralUnicom);
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(analisisRegistralSiirfe.getCiudadanoId(),
                            TipoControlSincronizacion.TERMINADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                } catch (SQLGrammarException e) {
                    // TODO: handle exception
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(analisisRegistralSiirfe.getCiudadanoId(),
                            TipoControlSincronizacion.REPROCESADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                    logger.error(
                        "ERROR_EN_PROCESO: " + datosEntrada.getProcesoSincronizacioId());
                } catch (Exception e) {
                    // TODO: handle exception
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(analisisRegistralSiirfe.getCiudadanoId(),
                            TipoControlSincronizacion.REPROCESADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                    logger.error(
                        "ERROR_EN_PROCESO: " + datosEntrada.getProcesoSincronizacioId());
                }
            }
            responseHashMapObject.put(datosEntrada.getProcesoSincronizacioId(), datosSalida);
            respuesta.setResponseHashMapObject(responseHashMapObject);
        } else {
            respuesta.setMensajeError("DATOS DE ENTRADA VACIOS");
        }
        logger.info("respuesta --> " + datosEntrada.getThreadName() + " - "
            + datosEntrada.getProcesoSincronizacioId());
        return respuesta;
        // TODO [codificar el cuerpo del método]
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.UnicomService#actualizaConsulta(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaConsulta(DatosEntrada datosEntrada) {
        Map<Long, DatosSalida> responseHashMapObject =
            new ConcurrentHashMap<Long, DatosSalida>();
        RespuestaSincronizacion respuesta = new RespuestaSincronizacion();
        DatosSalida datosSalida = new DatosSalida();

        if (datosEntrada.getConsultaExternaSiirfe() != null) {
            for (ConsultaExternaSiirfe ConsultaSiirfe : datosEntrada
                .getConsultaExternaSiirfe()) {
                ConsultaExternaUnicom consultaUnicom = new ConsultaExternaUnicom();

                try {
                    consultaUnicom = entitiTransformer.tranformaConsultaSirfeAUnicom(
                        ConsultaSiirfe, datosEntrada.getProcesoSincronizacioId());
                    unicomDAO.actualizaConsultaExterna(consultaUnicom);
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(ConsultaSiirfe.getCiudadanoId(),
                            TipoControlSincronizacion.TERMINADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                } catch (SQLGrammarException e) {
                    // TODO: handle exception
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(ConsultaSiirfe.getCiudadanoId(),
                            TipoControlSincronizacion.REPROCESADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                    logger.error(
                        "ERROR_EN_PROCESO: " + datosEntrada.getProcesoSincronizacioId());
                } catch (Exception e) {
                    // TODO: handle exception
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(ConsultaSiirfe.getCiudadanoId(),
                            TipoControlSincronizacion.REPROCESADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                    logger.error(
                        "ERROR_EN_PROCESO: " + datosEntrada.getProcesoSincronizacioId());
                }
            }
            responseHashMapObject.put(datosEntrada.getProcesoSincronizacioId(), datosSalida);
            respuesta.setResponseHashMapObject(responseHashMapObject);
        } else {
            respuesta.setMensajeError("DATOS DE ENTRADA VACIOS");
        }
        logger.info("respuesta --> " + datosEntrada.getThreadName() + " - "
            + datosEntrada.getProcesoSincronizacioId());
        return respuesta;
        // TODO [codificar el cuerpo del método]
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.UnicomService#actualizaFuarRech(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaFuarExtr(DatosEntrada datosEntrada) {
        Map<Long, DatosSalida> responseHashMapObject =
            new ConcurrentHashMap<Long, DatosSalida>();
        RespuestaSincronizacion respuesta = new RespuestaSincronizacion();
        DatosSalida datosSalida = new DatosSalida();

        if (datosEntrada.getFuarExtranjeroSiirfe() != null) {
            for (FuarExtranjeroSiirfe fuarExtranjeroSiirfe : datosEntrada
                .getFuarExtranjeroSiirfe()) {
                FuarExtranjeroUnicom fuarExtranjeroUnicom = new FuarExtranjeroUnicom();
                try {
                    fuarExtranjeroUnicom =
                        entitiTransformer.tranformaFuarExtranjeroSiirfeAUnicom(
                            fuarExtranjeroSiirfe, datosEntrada.getProcesoSincronizacioId());
                    unicomDAO.actualizaFuarExtranjero(fuarExtranjeroUnicom);
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(fuarExtranjeroSiirfe.getFuar(),
                            TipoControlSincronizacion.TERMINADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                } catch (Exception e) {
                    // TODO: handle exception
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(fuarExtranjeroSiirfe.getFuar(),
                            TipoControlSincronizacion.REPROCESADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                    logger.error(
                        "ERROR_EN_PROCESO: " + datosEntrada.getProcesoSincronizacioId());
                }
            }
            responseHashMapObject.put(datosEntrada.getProcesoSincronizacioId(), datosSalida);
            respuesta.setResponseHashMapObject(responseHashMapObject);
        } else {
            respuesta.setMensajeError("DATOS DE ENTRADA VACIOS");
        }
        logger.info("respuesta --> " + datosEntrada.getThreadName() + " - "
            + datosEntrada.getProcesoSincronizacioId());
        return respuesta;
        // TODO [codificar el cuerpo del método]
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.UnicomService#actualizaFuarExtr(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaFuarRech(DatosEntrada datosEntrada) {
        Map<Long, DatosSalida> responseHashMapObject =
            new ConcurrentHashMap<Long, DatosSalida>();
        RespuestaSincronizacion respuesta = new RespuestaSincronizacion();
        DatosSalida datosSalida = new DatosSalida();

        if (datosEntrada.getFuarRechazadoSiirfe() != null) {
            for (FuarRechazadoSiirfe fuarRechazadoSiirfe : datosEntrada
                .getFuarRechazadoSiirfe()) {
                FuarRechazadoUnicom fuarRechazadoUnicom = new FuarRechazadoUnicom();

                try {
                    fuarRechazadoUnicom =
                        entitiTransformer.transformaFuarRechazadoSiirfeAUnicom(
                            fuarRechazadoSiirfe, datosEntrada.getProcesoSincronizacioId());
                    unicomDAO.actualizaFuarRechazadoUnicom(fuarRechazadoUnicom);
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(fuarRechazadoSiirfe.getId(),
                            TipoControlSincronizacion.TERMINADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                } catch (GenericJDBCException e) {
                    // TODO: handle exception
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(fuarRechazadoSiirfe.getId(),
                            TipoControlSincronizacion.REPROCESADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                    logger.error(
                        "ERROR_EN_PROCESO: " + datosEntrada.getProcesoSincronizacioId());
                }
            }
            responseHashMapObject.put(datosEntrada.getProcesoSincronizacioId(), datosSalida);
            respuesta.setResponseHashMapObject(responseHashMapObject);
        } else {
            respuesta.setMensajeError("DATOS DE ENTRADA VACIOS");
        }
        logger.info("respuesta --> " + datosEntrada.getThreadName() + " - "
            + datosEntrada.getProcesoSincronizacioId());
        return respuesta;
        // TODO [codificar el cuerpo del método]
    }

    /* La documentación de este método se encuentra en la clase o interface que
     * lo declara  (non-Javadoc)
     * @see mx.ine.sscc.servicios.unicom.servicio.UnicomService#actualizaFuar(mx.ine.sscc.modelo.bean.DatosEntrada)
     */
    @Override
    public RespuestaSincronizacion actualizaFuar(DatosEntrada datosEntrada) {

        Map<Long, DatosSalida> responseHashMapObject =
            new ConcurrentHashMap<Long, DatosSalida>();
        RespuestaSincronizacion respuesta = new RespuestaSincronizacion();
        DatosSalida datosSalida = new DatosSalida();
        if (datosEntrada.getFuarSiirfe() != null) {
            for (FuarSiirfe fuarSiirfe : datosEntrada.getFuarSiirfe()) {
                FuarUnicom fuarUnicom = new FuarUnicom();
                try {
                    fuarUnicom = entitiTransformer.transformaFuarSiirfeAUnicom(fuarSiirfe,
                        datosEntrada.getProcesoSincronizacioId());
                    unicomDAO.actualizaFuarUnicom(fuarUnicom);
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(fuarSiirfe.getFuar(),
                            TipoControlSincronizacion.TERMINADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                } catch (Exception e) {
                    // TODO: handle exception
                    datosSalida.getDatosRegistro()
                        .add(new DatosRegistro(fuarSiirfe.getFuar(),
                            TipoControlSincronizacion.REPROCESADO.getClave(),
                            datosEntrada.getProcesoSincronizacioId()));
                    logger.error(
                        "ERROR_EN_PROCESO: " + datosEntrada.getProcesoSincronizacioId());
                }
            }
            responseHashMapObject.put(datosEntrada.getProcesoSincronizacioId(), datosSalida);
            respuesta.setResponseHashMapObject(responseHashMapObject);
        } else {
            respuesta.setMensajeError("DATOS DE ENTRADA VACIOS");
        }
        logger.info("respuesta --> " + datosEntrada.getThreadName() + " - "
            + datosEntrada.getProcesoSincronizacioId());
        return respuesta;
        // TODO [codificar el cuerpo del método]
    }
}
