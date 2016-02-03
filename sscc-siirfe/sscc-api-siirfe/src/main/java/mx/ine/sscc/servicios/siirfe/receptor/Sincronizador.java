/**
 * Sincronizador.java
 * Fecha de creación: 27/11/2015, 14:41:13
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

package mx.ine.sscc.servicios.siirfe.receptor;

import org.springframework.dao.DataAccessException;

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;

/**
 * TODO [Interfaz que define el comportamiento para el objeto encargado de sincronizar los
 * registros entre bases de datos.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface Sincronizador {

    /**
     * TODO [Objeto que contiene los datos que serán enviados a UNICOM para ser procesados.]
     */
    DatosEntrada datosEntrada = null;
    /**
     * TODO [Objeto que contiene los datos de respuesta que fueron procesados en UNICOM.]
     */
    RespuestaSincronizacion respuestaSincronizacion = null;

    /**
     * TODO [Método en el cuál se obtiene el bloque de registros que serán enviados a UNICOM.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return true or false.
     * @throws DataAccessException
     */
    boolean obtieneBloque(DatosEntrada datosEntrada);

    /**
     * TODO [Método que envia el bloque de información obtenido al servidor de UNICOM.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return true or false.
     */
    boolean enviaBloque(DatosEntrada datosEntrada);

    /**
     * TODO [Método que procesa los registros de respuesta del servidor UNICOM.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param respuestaSincronizacion
     */
    void procesaRespuesta(RespuestaSincronizacion respuestaSincronizacion);

    /**
     * TODO [Método que procesa los registros a su estado inicial en caso de que exista error
     * de comunicación entre cliente y servidor, regresando los registros del bloque a su
     * estado inicial.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param datosEntrada
     */
    void actualizaBloqueError(DatosEntrada datosEntrada);

    /**
     * TODO [Método que procesa el bloque de registros a un estado exitoso cuando la
     * comunicación entre cliente y servidor sea efectiva.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @param bitacoraId
     */
    void actualizaBloqueExito(Long bitacoraId);

    /**
     * TODO [Método que obtiene los registros disponibles para sincronizar.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     * @return registros disponibles para sincronizar.
     */
    Long obtieneRegistrosSincronizables();

    /**
     * TODO [Método que sirve para validar el número de errores que se han presentado durante
     * el proceso de sincronización, si existen más de 3 errores de Base de Datos o de
     * comunicación con el Servicio Web expuesto se detiene el proceso hasta que sea activado
     * de nuevo por el Listener.]
     * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
     */
    void validaErrores();

}
