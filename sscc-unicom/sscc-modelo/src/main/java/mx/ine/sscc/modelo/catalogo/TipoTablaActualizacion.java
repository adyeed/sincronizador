/**
 * TipoTablaActualizacion.java
 * Fecha de creación: 09/11/2015, 11:58:29
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
package mx.ine.sscc.modelo.catalogo;

/**
 * Enum que contiene el tipo de tablas que se sincronizararan
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoTablaActualizacion {
    /**
     * Tabla ANALISIS_REGISTRAL
     */
    ANALISISREGISTRAL(1, "ANALISIS REGISTRAL", "Tabla Analisis Registral", true),

    /**
     * CONSULTA_EXTERNA
     */
    CONSULTAEXTERNA(2, "CONSULTA EXTERNA", "Tabla Analisis Registral", true),
    /**
     * CONSULTA_EXTERNA
     */
    FUAREXTRANJERO(3, "FUAR EXTRANJERO", "Tabla Fuar Extranjero", true),

    /**
     * FUAR_RECHAZADO
     */
    FUAR_RECHAZADO(4, "FUAR RECHAZADO", "Tabla Fuar Rechazado", true),

    /**
     * FUAR
     */
    FUAR(5, "FUAR", "Tabla Fuar", true),

    /**
     * TODO [Agregar documentación del atributo]
     */
    TEMP(6, "TEMP", "Tabla Temp", true);

    private int id;
    private String clave;
    private String descripcion;
    private boolean activo;

    /**
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param id
     * @param clave
     * @param descripcion
     * @param activo
     */
    private TipoTablaActualizacion(int id, String clave, String descripcion, boolean activo) {
        this.id = id;
        this.clave = clave;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representación TipoTablaActualizacion del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoTablaActualizacion}
     * @return {@link TipoTablaActualizacion}
     */
    public static TipoTablaActualizacion valueOf(int id) {
        for (TipoTablaActualizacion TipoTablaActualizacion : values()) {
            if (TipoTablaActualizacion.getId() == id) {
                return TipoTablaActualizacion;
            }
        }
        throw new IllegalArgumentException(
            "Id '" + id + "' inválido para obtener enum TipoTablaActualizacion");
    }

    /**
     * @return el atributo id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id parametro id a actualizar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return el atributo clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave parametro clave a actualizar
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return el atributo descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion parametro descripcion a actualizar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return el atributo activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo parametro activo a actualizar
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
