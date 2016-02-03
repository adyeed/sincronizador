/**
 * Sincronizador.java
 * Fecha de creaci�n: 27/11/2015, 14:41:13
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

package mx.ine.sscc.servicios.siirfe.receptor;

import org.springframework.dao.DataAccessException;

import mx.ine.sscc.modelo.bean.DatosEntrada;
import mx.ine.sscc.modelo.bean.RespuestaSincronizacion;

/**
 * TODO [Interfaz que define el comportamiento para el objeto encargado de sincronizar los
 * registros entre bases de datos.]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public interface Sincronizador {

    /**
     * TODO [Objeto que contiene los datos que ser�n enviados a UNICOM para ser procesados.]
     */
    DatosEntrada datosEntrada = null;
    /**
     * TODO [Objeto que contiene los datos de respuesta que fueron procesados en UNICOM.]
     */
    RespuestaSincronizacion respuestaSincronizacion = null;

    /**
     * TODO [M�todo en el cu�l se obtiene el bloque de registros que ser�n enviados a UNICOM.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return true or false.
     * @throws DataAccessException
     */
    boolean obtieneBloque(DatosEntrada datosEntrada);

    /**
     * TODO [M�todo que envia el bloque de informaci�n obtenido al servidor de UNICOM.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param datosEntrada
     * @return true or false.
     */
    boolean enviaBloque(DatosEntrada datosEntrada);

    /**
     * TODO [M�todo que procesa los registros de respuesta del servidor UNICOM.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param respuestaSincronizacion
     */
    void procesaRespuesta(RespuestaSincronizacion respuestaSincronizacion);

    /**
     * TODO [M�todo que procesa los registros a su estado inicial en caso de que exista error
     * de comunicaci�n entre cliente y servidor, regresando los registros del bloque a su
     * estado inicial.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param datosEntrada
     */
    void actualizaBloqueError(DatosEntrada datosEntrada);

    /**
     * TODO [M�todo que procesa el bloque de registros a un estado exitoso cuando la
     * comunicaci�n entre cliente y servidor sea efectiva.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @param bitacoraId
     */
    void actualizaBloqueExito(Long bitacoraId);

    /**
     * TODO [M�todo que obtiene los registros disponibles para sincronizar.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     * @return registros disponibles para sincronizar.
     */
    Long obtieneRegistrosSincronizables();

    /**
     * TODO [M�todo que sirve para validar el n�mero de errores que se han presentado durante
     * el proceso de sincronizaci�n, si existen m�s de 3 errores de Base de Datos o de
     * comunicaci�n con el Servicio Web expuesto se detiene el proceso hasta que sea activado
     * de nuevo por el Listener.]
     * @author Orlando Adri�n Ramos Galv�n,(orlandoa.ramos@outlook.com)
     */
    void validaErrores();

}
