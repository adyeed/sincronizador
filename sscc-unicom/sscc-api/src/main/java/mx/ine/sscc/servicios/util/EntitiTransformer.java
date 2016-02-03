/**
 * EntitiTransformer.java
 * Fecha de creación: 09/01/2016, 13:55:56
 *
 * Copyright (c) 2016 Instituto Federal Electoral. Dirección
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

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Component
public class EntitiTransformer {

    /**
     * TODO Convierte una entidad AnalisisRegistralSiirfe a AnalisisRegistralUnicom
     * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
     * @param analisisRegistralSiirfe
     * @param procesoSincronizacionId
     * @return AnalisisRegistralUnicom
     */
    public AnalisisRegistralUnicom tranformaAnalisisRegistralSirfeAUnicom(
        AnalisisRegistralSiirfe analisisRegistralSiirfe, Long procesoSincronizacionId) {
        AnalisisRegistralUnicom analisisUnicom = new AnalisisRegistralUnicom();
        if (analisisRegistralSiirfe != null) {

            if (procesoSincronizacionId != null) {
                analisisUnicom.setProcesoSincronizacionId(procesoSincronizacionId);
            }

            if (analisisRegistralSiirfe.getSolicitudMacId() != null) {
                analisisUnicom.setSolicitudMacId(analisisRegistralSiirfe.getSolicitudMacId());
            }
            if (analisisRegistralSiirfe.getCiudadanoId() != null) {
                analisisUnicom.setCiudadanoId(analisisRegistralSiirfe.getCiudadanoId());
            }

            analisisUnicom.setTipoSituacionAnalisisRegistral(!StringUtils.isBlank(analisisRegistralSiirfe.getTipoSituacionAnalisisRegistral()) ? analisisRegistralSiirfe.getTipoSituacionAnalisisRegistral()
                : "");

            if (analisisRegistralSiirfe.getInicioTramite() != null) {
                analisisUnicom.setInicioTramite(analisisRegistralSiirfe.getInicioTramite());
            }

            analisisUnicom.setAdscripcionAutJud(!StringUtils.isBlank(analisisRegistralSiirfe.getAdscripcionAutJud()) ? analisisRegistralSiirfe.getAdscripcionAutJud()
                : "");

            analisisUnicom.setTipoResolucion(!StringUtils.isBlank(analisisRegistralSiirfe.getTipoResolucion()) ? analisisRegistralSiirfe.getTipoResolucion()
                : "");

            if (analisisRegistralSiirfe.getFechaComunico() != null) {
                analisisUnicom.setFechaComunico(analisisRegistralSiirfe.getFechaComunico());
            }

            analisisUnicom.setJuzgado(!StringUtils.isBlank(analisisRegistralSiirfe.getJuzgado()) ? analisisRegistralSiirfe.getJuzgado()
                : "");

            analisisUnicom.setCausaPenal(!StringUtils.isBlank(analisisRegistralSiirfe.getCausaPenal()) ? analisisRegistralSiirfe.getCausaPenal()
                : "");

            analisisUnicom.setNombreOfiRepMexicoExt(!StringUtils.isBlank(analisisRegistralSiirfe.getNombreOfiRepMexicoExt()) ? analisisRegistralSiirfe.getNombreOfiRepMexicoExt()
                : "");

            analisisUnicom.setPaisResidencia(!StringUtils.isBlank(analisisRegistralSiirfe.getPaisResidencia()) ? analisisRegistralSiirfe.getPaisResidencia()
                : "");

            analisisUnicom.setNombre(!StringUtils.isBlank(analisisRegistralSiirfe.getNombre()) ? analisisRegistralSiirfe.getNombre()
                : "");

            analisisUnicom.setApellidoPaterno(!StringUtils.isBlank(analisisRegistralSiirfe.getApellidoPaterno()) ? analisisRegistralSiirfe.getApellidoPaterno()
                : "");

            analisisUnicom.setApellidoMaterno(!StringUtils.isBlank(analisisRegistralSiirfe.getApellidoMaterno()) ? analisisRegistralSiirfe.getApellidoMaterno()
                : "");

            if (analisisRegistralSiirfe.getFechaNacimiento() != null) {
                analisisUnicom.setFechaNacimiento(analisisRegistralSiirfe.getFechaNacimiento());
            }

            analisisUnicom.setLugarNacimiento(!StringUtils.isBlank(analisisRegistralSiirfe.getLugarNacimiento()) ? analisisRegistralSiirfe.getLugarNacimiento()
                : "");

            analisisUnicom.setAdscripcionAutJudC(!StringUtils.isBlank(analisisRegistralSiirfe.getAdscripcionAutJudC()) ? analisisRegistralSiirfe.getAdscripcionAutJudC()
                : "");

            analisisUnicom.setTipoResolucionC(!StringUtils.isBlank(analisisRegistralSiirfe.getTipoResolucionC()) ? analisisRegistralSiirfe.getTipoResolucionC()
                : "");

            analisisUnicom.setNumeroExpediente(!StringUtils.isBlank(analisisRegistralSiirfe.getNumeroExpediente()) ? analisisRegistralSiirfe.getNumeroExpediente()
                : "");

            analisisUnicom.setNumeroOficioRespC(!StringUtils.isBlank(analisisRegistralSiirfe.getNumeroOficioRespC()) ? analisisRegistralSiirfe.getNumeroOficioRespC()
                : "");

            if (analisisRegistralSiirfe.getFechaTramite() != null) {
                analisisUnicom.setNumeroTramite(analisisRegistralSiirfe.getNumeroTramite());

            }

            analisisUnicom.setCalleTramite(!StringUtils.isBlank(analisisRegistralSiirfe.getCalleTramite()) ? analisisRegistralSiirfe.getCalleTramite()
                : "");

            analisisUnicom.setColoniaTramite(!StringUtils.isBlank(analisisRegistralSiirfe.getColoniaTramite()) ? analisisRegistralSiirfe.getColoniaTramite()
                : "");

            analisisUnicom.setMunicipioTramite(!StringUtils.isBlank(analisisRegistralSiirfe.getMunicipioTramite()) ? analisisRegistralSiirfe.getMunicipioTramite()
                : "");

            analisisUnicom.setEstadoTramite(!StringUtils.isBlank(analisisRegistralSiirfe.getEstadoTramite()) ? analisisRegistralSiirfe.getEstadoTramite()
                : "");

            analisisUnicom.setPaisTramite(!StringUtils.isBlank(analisisRegistralSiirfe.getPaisTramite()) ? analisisRegistralSiirfe.getPaisTramite()
                : "");

            analisisUnicom.setFuar(!StringUtils.isBlank(analisisRegistralSiirfe.getFuar()) ? analisisRegistralSiirfe.getFuar()
                : "");

        }
        return analisisUnicom;
    }

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param consultaExternaSiirfe
     * @param procesoSincronizacionId
     * @return Consulta ExternaUNICOM
     */
    public ConsultaExternaUnicom tranformaConsultaSirfeAUnicom(
        ConsultaExternaSiirfe consultaExternaSiirfe, Long procesoSincronizacionId) {
        ConsultaExternaUnicom consultaUnicom = new ConsultaExternaUnicom();
        if (consultaExternaSiirfe != null) {

            if (procesoSincronizacionId != null) {
                consultaUnicom.setProcesoSincronizacionId(procesoSincronizacionId);
            }

            if (consultaExternaSiirfe.getCiudadanoId() != null) {
                consultaUnicom.setCiudadanoId(consultaExternaSiirfe.getCiudadanoId());
            }
            if (consultaExternaSiirfe.getCredencialId() != null) {
                consultaUnicom.setCredencialId(consultaExternaSiirfe.getCredencialId());
            }

            consultaUnicom.setClaveElector(!StringUtils.isBlank(consultaExternaSiirfe.getClaveElector()) ? consultaExternaSiirfe.getClaveElector()
                : "");
            if (consultaExternaSiirfe.getNumeroEmisionCredencial() != null) {
                consultaUnicom.setNumeroEmisionCredencial(consultaExternaSiirfe.getNumeroEmisionCredencial());
            }

            consultaUnicom.setOcr(!StringUtils.isBlank(consultaExternaSiirfe.getOcr()) ? consultaExternaSiirfe.getOcr()
                : "");
            consultaUnicom.setCic(!StringUtils.isBlank(consultaExternaSiirfe.getCic()) ? consultaExternaSiirfe.getCic()
                : "");
            consultaUnicom.setCurp(!StringUtils.isBlank(consultaExternaSiirfe.getCurp()) ? consultaExternaSiirfe.getCurp()
                : "");
            if (consultaExternaSiirfe.getFechaInscripcionPadron() != null) {
                consultaUnicom.setFechaInscripcionPadron(consultaExternaSiirfe.getFechaInscripcionPadron());
            }

            consultaUnicom.setNombre(!StringUtils.isBlank(consultaExternaSiirfe.getNombre()) ? consultaExternaSiirfe.getNombre()
                : "");
            consultaUnicom.setApellidoPaterno(!StringUtils.isBlank(consultaExternaSiirfe.getApellidoPaterno()) ? consultaExternaSiirfe.getApellidoPaterno()
                : "");
            consultaUnicom.setApellidoMaterno(!StringUtils.isBlank(consultaExternaSiirfe.getApellidoMaterno()) ? consultaExternaSiirfe.getApellidoMaterno()
                : "");
            if (consultaExternaSiirfe.getEstatusCiudadanoId() != null) {
                consultaUnicom.setEstatusCiudadanoId(consultaExternaSiirfe.getEstatusCiudadanoId());
            }
            if (consultaExternaSiirfe.getTipoBajaPadronId() != null) {
                consultaUnicom.setTipoBajaPadronId(consultaExternaSiirfe.getTipoBajaPadronId());
            }
            if (consultaExternaSiirfe.getResidenteExtranjero() != null) {
                consultaUnicom.setResidenteExtranjero(consultaExternaSiirfe.getResidenteExtranjero());
            }
            if (consultaExternaSiirfe.getFechaCreacion() != null) {
                consultaUnicom.setFechaCreacion(consultaExternaSiirfe.getFechaCreacion());
            }
            if (consultaExternaSiirfe.getFechaUltimoTramite() != null) {
                consultaUnicom.setFechaUltimoTramite(consultaExternaSiirfe.getFechaUltimoTramite());
            }
            if (consultaExternaSiirfe.getVigenciaCredencial() != null) {
                consultaUnicom.setVigenciaCredencial(consultaExternaSiirfe.getVigenciaCredencial());
            }
            if (consultaExternaSiirfe.getEntidad() != null) {
                consultaUnicom.setEntidad(consultaExternaSiirfe.getEntidad());
            }

            consultaUnicom.setSeccion(!StringUtils.isBlank(consultaExternaSiirfe.getSeccion()) ? consultaExternaSiirfe.getSeccion()
                : "");
            if (consultaExternaSiirfe.getTipoReincorporacionPadronId() != null) {
                consultaUnicom.setTipoReincorporacionPadronId(consultaExternaSiirfe.getTipoReincorporacionPadronId());
            }
            if (consultaExternaSiirfe.getReporteRoboExtravioId() != null) {
                consultaUnicom.setReporteRoboExtravioId(consultaExternaSiirfe.getReporteRoboExtravioId());
            }
            if (consultaExternaSiirfe.getEstatusRoboExtravioId() != null) {
                consultaUnicom.setEstatusRoboExtravioId(consultaExternaSiirfe.getEstatusRoboExtravioId());
            }

            if (consultaExternaSiirfe.getCausaRoboExtravioId() != null) {
                consultaUnicom.setCausaRoboExtravioId(consultaExternaSiirfe.getCausaRoboExtravioId());
            }

        }
        return consultaUnicom;
    }

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param fuarExtranjeroSiirfe
     * @param procesoSincronizacionId
     * @return FuarExtranjero
     */
    public FuarExtranjeroUnicom tranformaFuarExtranjeroSiirfeAUnicom(
        FuarExtranjeroSiirfe fuarExtranjeroSiirfe, Long procesoSincronizacionId) {
        FuarExtranjeroUnicom respuesta = new FuarExtranjeroUnicom();
        if (fuarExtranjeroSiirfe != null) {

            if (procesoSincronizacionId != null) {
                respuesta.setProcesoSincronizacionId(procesoSincronizacionId);
            }

            respuesta.setFuar(!StringUtils.isBlank(fuarExtranjeroSiirfe.getFuar()) ? fuarExtranjeroSiirfe.getFuar()
                : "");
            if (fuarExtranjeroSiirfe.getEstatusFuarId() != null) {
                respuesta.setEstatusFuarId(fuarExtranjeroSiirfe.getEstatusFuarId());
            }
            respuesta.setNombre(!StringUtils.isBlank(fuarExtranjeroSiirfe.getNombre()) ? fuarExtranjeroSiirfe.getNombre()
                : "");
            respuesta.setApellidoPaterno(!StringUtils.isBlank(fuarExtranjeroSiirfe.getApellidoPaterno()) ? fuarExtranjeroSiirfe.getApellidoPaterno()
                : "");
            respuesta.setApellidoMaterno(!StringUtils.isBlank(fuarExtranjeroSiirfe.getApellidoMaterno()) ? fuarExtranjeroSiirfe.getApellidoMaterno()
                : "");
            respuesta.setClaveElector(!StringUtils.isBlank(fuarExtranjeroSiirfe.getClaveElector()) ? fuarExtranjeroSiirfe.getClaveElector()
                : "");
            respuesta.setPais(!StringUtils.isBlank(fuarExtranjeroSiirfe.getPais()) ? fuarExtranjeroSiirfe.getPais()
                : "");
            if (fuarExtranjeroSiirfe.getFechaNacimiento() != null) {
                respuesta.setFechaNacimiento(fuarExtranjeroSiirfe.getFechaNacimiento());
            }
            respuesta.setEstado(!StringUtils.isBlank(fuarExtranjeroSiirfe.getEstado()) ? fuarExtranjeroSiirfe.getEstado()
                : "");
            respuesta.setCiudad(!StringUtils.isBlank(fuarExtranjeroSiirfe.getCiudad()) ? fuarExtranjeroSiirfe.getCiudad()
                : "");
            respuesta.setTelefono(!StringUtils.isBlank(fuarExtranjeroSiirfe.getTelefono()) ? fuarExtranjeroSiirfe.getTelefono()
                : "");
            respuesta.setCorreoElectronico(!StringUtils.isBlank(fuarExtranjeroSiirfe.getCorreoElectronico()) ? fuarExtranjeroSiirfe.getCorreoElectronico()
                : "");
            respuesta.setGuiaPaqueteria(!StringUtils.isBlank(fuarExtranjeroSiirfe.getGuiaPaqueteria()) ? fuarExtranjeroSiirfe.getGuiaPaqueteria()
                : "");
            if (fuarExtranjeroSiirfe.getSolicitudMacId() != null) {
                respuesta.setSolicitudMacId(fuarExtranjeroSiirfe.getSolicitudMacId());
            }
            if (fuarExtranjeroSiirfe.getFechaTramite() != null) {
                respuesta.setFechaTramite(fuarExtranjeroSiirfe.getFechaTramite());
            }
            if (fuarExtranjeroSiirfe.getFechaUltimaActualizacion() != null) {
                respuesta.setFechaUltimaActualizacion(fuarExtranjeroSiirfe.getFechaUltimaActualizacion());
            }
            respuesta.setCurp(!StringUtils.isBlank(fuarExtranjeroSiirfe.getCurp()) ? fuarExtranjeroSiirfe.getCurp()
                : "");
            respuesta.setCalle(!StringUtils.isBlank(fuarExtranjeroSiirfe.getCalle()) ? fuarExtranjeroSiirfe.getCalle()
                : "");
            respuesta.setNumeroInterior(!StringUtils.isBlank(fuarExtranjeroSiirfe.getNumeroInterior()) ? fuarExtranjeroSiirfe.getNumeroInterior()
                : "");
            respuesta.setNumeroExterior(!StringUtils.isBlank(fuarExtranjeroSiirfe.getNumeroExterior()) ? fuarExtranjeroSiirfe.getNumeroExterior()
                : "");
            respuesta.setCodigoPostal(!StringUtils.isBlank(fuarExtranjeroSiirfe.getCodigoPostal()) ? fuarExtranjeroSiirfe.getCodigoPostal()
                : "");
            respuesta.setEscolaridad(!StringUtils.isBlank(fuarExtranjeroSiirfe.getEscolaridad()) ? fuarExtranjeroSiirfe.getEscolaridad()
                : "");
            respuesta.setOcupacion(!StringUtils.isBlank(fuarExtranjeroSiirfe.getOcupacion()) ? fuarExtranjeroSiirfe.getOcupacion()
                : "");
            respuesta.setSexo(!StringUtils.isBlank(fuarExtranjeroSiirfe.getSexo()) ? fuarExtranjeroSiirfe.getSexo()
                : "");
            respuesta.setLugarNacimiento(!StringUtils.isBlank(fuarExtranjeroSiirfe.getLugarNacimiento()) ? fuarExtranjeroSiirfe.getLugarNacimiento()
                : "");
            respuesta.setColonia(!StringUtils.isBlank(fuarExtranjeroSiirfe.getColonia()) ? fuarExtranjeroSiirfe.getColonia()
                : "");
            respuesta.setMunicipio(!StringUtils.isBlank(fuarExtranjeroSiirfe.getMunicipio()) ? fuarExtranjeroSiirfe.getMunicipio()
                : "");

            if (fuarExtranjeroSiirfe.getFechaEntrega() != null) {
                respuesta.setFechaEntrega(fuarExtranjeroSiirfe.getFechaEntrega());
            }
        }
        return respuesta;
    }

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param fuarRechazadoSiirfe
     * @param procesoSincronizacionId
     * @return fuarRechazado
     */
    public FuarRechazadoUnicom transformaFuarRechazadoSiirfeAUnicom(
        FuarRechazadoSiirfe fuarRechazadoSiirfe, Long procesoSincronizacionId) {
        FuarRechazadoUnicom respuesta = new FuarRechazadoUnicom();
        if (fuarRechazadoSiirfe != null) {

            if (procesoSincronizacionId != null) {
                respuesta.setProcesoSincronizacionId(procesoSincronizacionId);
            }

            respuesta.setFuar(!StringUtils.isBlank(fuarRechazadoSiirfe.getFuar()) ? fuarRechazadoSiirfe.getFuar()
                : "");

            if (fuarRechazadoSiirfe.getFechaAudit() != null) {
                respuesta.setFechaRechazoSi(fuarRechazadoSiirfe.getFechaAudit());
            }

            respuesta.setClave(!StringUtils.isBlank(fuarRechazadoSiirfe.getClave()) ? fuarRechazadoSiirfe.getClave()
                : "");

            respuesta.setDescripcion(!StringUtils.isBlank(fuarRechazadoSiirfe.getDescripcion()) ? fuarRechazadoSiirfe.getDescripcion()
                : "");
        }
        return respuesta;
    }

    /**
     * TODO [Agregar documentacion del método]
     * @author Jorge Alberto López Herrera (jorge.lopez.he@gmail.com)
     * @param fuarSiirfe
     * @param procesoSincronizacionId
     * @return FuarUnicom
     */
    public FuarUnicom transformaFuarSiirfeAUnicom(FuarSiirfe fuarSiirfe,
        Long procesoSincronizacionId) {
        FuarUnicom respuesta = new FuarUnicom();
        if (fuarSiirfe != null) {

            if (procesoSincronizacionId != null) {
                respuesta.setProcesoSincronizacionId(procesoSincronizacionId);
            }

            if (fuarSiirfe.getFuar() != null) {
                respuesta.setFuar(fuarSiirfe.getFuar());
            }
            if (fuarSiirfe.getFechaTraminte() != null) {
                respuesta.setFechaTraminte(fuarSiirfe.getFechaTraminte());
            }
            if (fuarSiirfe.getFechaUltimaActualizacion() != null) {
                respuesta.setFechaUltimaActualizacion(fuarSiirfe.getFechaUltimaActualizacion());
            }
            if (fuarSiirfe.getEstatusFuarId() != null) {
                respuesta.setEstatusFuarId(fuarSiirfe.getEstatusFuarId());
            }
            if (fuarSiirfe.getSolicitudMac() != null) {
                respuesta.setSolicitudMac(fuarSiirfe.getSolicitudMac());
            }

            if (fuarSiirfe.getModulo() != null) {
                respuesta.setModulo(!StringUtils.isBlank(fuarSiirfe.getModulo().getModulo()) ? fuarSiirfe.getModulo()
                    .getModulo()
                    : "");
            }

            respuesta.setFolioEntregaCredencial(!StringUtils.isBlank(fuarSiirfe.getFolioEntregaCredencial()) ? fuarSiirfe.getFolioEntregaCredencial()
                : "");

            if (fuarSiirfe.getFechaNacimiento() != null) {
                respuesta.setFechaNacimiento(fuarSiirfe.getFechaNacimiento());
            }
            respuesta.setTelefono(!StringUtils.isBlank(fuarSiirfe.getTelefono()) ? fuarSiirfe.getTelefono()
                : "");
            respuesta.setCorreoElectronico(!StringUtils.isBlank(fuarSiirfe.getCorreoElectronico()) ? fuarSiirfe.getCorreoElectronico()
                : "");
            respuesta.setCodigoPostal(!StringUtils.isBlank(fuarSiirfe.getCodigoPostal()) ? fuarSiirfe.getCodigoPostal()
                : "");
            respuesta.setGuiaPaqueteria(!StringUtils.isBlank(fuarSiirfe.getGuiaPaqueteria()) ? fuarSiirfe.getGuiaPaqueteria()
                : "");
            respuesta.setNombre(!StringUtils.isBlank(fuarSiirfe.getNombre()) ? fuarSiirfe.getNombre()
                : "");
            respuesta.setApellidoPaterno(!StringUtils.isBlank(fuarSiirfe.getApellidoPaterno()) ? fuarSiirfe.getApellidoPaterno()
                : "");
            respuesta.setApellidoMaterno(!StringUtils.isBlank(fuarSiirfe.getApellidoMaterno()) ? fuarSiirfe.getApellidoMaterno()
                : "");
        }

        return respuesta;
    }

    // public void actualizaFuarExtranjero(FuarExtranjeroUnicom fuarExtranjeroUnicom) {
    // unicomDAO.actualizaFuarExtranjero(fuarExtranjeroUnicom);
    // }

    // public void guardaFuarRechazadoUnicom(FuarRechazadoUnicom fuarRechazadoUnicom) {
    // unicomDAO.guardaFuarRechazadoUnicom(fuarRechazadoUnicom);
    // }

}
