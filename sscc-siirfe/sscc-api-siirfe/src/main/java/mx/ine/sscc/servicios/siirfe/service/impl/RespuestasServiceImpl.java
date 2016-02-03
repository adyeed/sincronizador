/**
 * RespuestasServiceImpl.java
 * Fecha de creación: 28/12/2015, 18:43:15
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
package mx.ine.sscc.servicios.siirfe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import mx.ine.sscc.modelo.bean.RespuestaSituacionRegistral;
import mx.ine.sscc.modelo.catalogo.TipoInstrumento;
import mx.ine.sscc.modelo.entidad.siirfe.ArchivoSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.HechosSiirfe;
import mx.ine.sscc.modelo.entidad.siirfe.RespuestasSiirfe;
import mx.ine.sscc.modelo.entidad.unicom.Respuestas;
import mx.ine.sscc.servicios.siirfe.dao.RespuestasDAO;
import mx.ine.sscc.servicios.siirfe.service.RespuestasService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
@Service("respuestasService")
@Transactional
public class RespuestasServiceImpl implements RespuestasService {

    @Resource
    private RespuestasDAO respuestasDAO;

    /*
     * La documentación de este método se encuentra en la clase o interface que lo declara
     * (non-Javadoc)
     * @see
     * mx.ine.sscc.servicios.siirfe.service.RespuestasService#recibeDatosDeUnicom(java.util
     * .List)
     */
    @Override
    public RespuestaSituacionRegistral recibeDatosDeUnicom(List<Respuestas> respuestasList) {
        RespuestaSituacionRegistral respuestaSituacion = new RespuestaSituacionRegistral();

        try {
            respuestaSituacion.setRespuestas(respuestasList);
            for (Respuestas resp : respuestasList) {
                RespuestasSiirfe respuesta = new RespuestasSiirfe();
                if (resp.getId() != null) {
                    respuesta.setFuar(!StringUtils.isBlank(resp.getId().getFolioSi()) ? resp.getId()
                        .getFolioSi()
                        : "");
                    if (resp.getId().getCuestionarioId() != null) {
                        respuesta.setInstrumentoId(convierteAInstrumento(resp.getId()
                            .getCuestionarioId()));
                    }

                }

                if (resp.getId().getPreguntaId() != null) {
                    respuesta.setPreguntaId(resp.getId().getPreguntaId());
                }

                respuesta.setCandidatoId(!StringUtils.isBlank(resp.getId().getCandidatoId()) ? resp.getId()
                    .getCandidatoId()
                    : "");
                if (resp.getRespAfirmativa() != null) {
                    respuesta.setRespAfirmativa(resp.getRespAfirmativa());
                }
                if (resp.getFechaAlta() != null) {
                    respuesta.setFechaAlta(resp.getFechaAlta());
                }

                respuesta.setEstatus(!StringUtils.isBlank(resp.getEstatus()) ? resp.getEstatus()
                    : "");
                if (resp.getRespAnio() != null) {
                    respuesta.setRespAnio(resp.getRespAnio());
                }

                respuesta.setRespNombre(!StringUtils.isBlank(resp.getRespNombre()) ? resp.getRespNombre()
                    : "");
                respuesta.setRespApellidoP(!StringUtils.isBlank(resp.getRespApellidoP()) ? resp.getRespApellidoP()
                    : "");
                respuesta.setRespApellidoM(!StringUtils.isBlank(resp.getRespApellidoM()) ? resp.getRespApellidoM()
                    : "");
                respuesta.setRespEntNac(!StringUtils.isBlank(resp.getRespEntNac()) ? resp.getRespEntNac()
                    : "");
                if (resp.getRespFecNac() != null) {
                    respuesta.setRespFecNac(resp.getRespFecNac());
                }

                if (resp.getArchivo() != null) {
                    ArchivoSiirfe archivo = new ArchivoSiirfe();
                    if (resp.getArchivo().getArchivoId() != null) {
                        archivo.setArchivoId(resp.getArchivo().getArchivoId());
                    }
                    if (resp.getArchivo().getDocumento() != null) {
                        archivo.setDocumento(resp.getArchivo().getDocumento());
                    }

                    respuesta.setArchivo(archivo);
                }
                if (resp.getHechos() != null) {
                    HechosSiirfe hechos = new HechosSiirfe();
                    if (resp.getHechos().getHechosId() != null) {
                        hechos.setHechosId(resp.getHechos().getHechosId());
                    }
                    if (resp.getHechos().getDescripcion() != null) {
                        hechos.setDescripcion(resp.getHechos().getDescripcion());
                    }

                    respuesta.setHechos(hechos);
                }

                respuestasDAO.saveRespuesta(respuesta);

            }

        } catch (Exception e) {
            e.printStackTrace();
            respuestaSituacion.setMensajeError(e.getMessage());

        }
        return respuestaSituacion;
    }

    /**
     * TODO [Agregar documentacion del método]
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param cuestionarioId
     * @return
     */
    private Integer convierteAInstrumento(Integer cuestionarioId) {

        switch (cuestionarioId) {
        case 1:
            return TipoInstrumento.INSTRUMENTO_DPI.getId();

        case 2:
            return TipoInstrumento.INSTRUMENTO_USI.getId();

        case 3:
            return TipoInstrumento.INSTRUMENTO_SUS.getId();
        }
        return null;

    }

}
