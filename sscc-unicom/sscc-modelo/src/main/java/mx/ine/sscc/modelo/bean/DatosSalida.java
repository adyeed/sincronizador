/**
 * DatosSalida.java
 * Fecha de creaci�n: 11/11/2015, 18:12:38
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

package mx.ine.sscc.modelo.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */

public class DatosSalida implements Serializable {

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     */
    public DatosSalida() {
        // TODO Auto-generated constructor stub
        datosRegistro = new ArrayList<DatosRegistro>();
    }

    private static final long serialVersionUID = 1L;

    ArrayList<DatosRegistro> datosRegistro;
    private String mensajeError;

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @return
     */
    public ArrayList<DatosRegistro> getDatosRegistro() {
        return datosRegistro;
    }

    /**
     * TODO [Agregar documentacion al m�todo]
     * @author Orlando Adri�n Ramos Galv�n (orlandoa.ramos@outlook.com)
     * @param datosRegistro
     */
    public void setDatosRegistro(ArrayList<DatosRegistro> datosRegistro) {
        this.datosRegistro = datosRegistro;
    }

    /**
     * @return el atributo mensajeError
     */

    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * @param mensajeError parametro mensajeError a actualizar
     */
    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

}
