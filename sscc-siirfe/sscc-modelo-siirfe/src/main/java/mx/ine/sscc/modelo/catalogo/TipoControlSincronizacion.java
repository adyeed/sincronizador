/**
 * TipoControlSincronizacion.java
 * Fecha de creación: 09/11/2015, 12:54:46
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
 * Enum que menciona los estatus en los que se puede encontrar un registro a sincronizar
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoControlSincronizacion {
    /**
     * Registro Pendiente
     */
    PENDIENTE(1, "P",
        "Registro con estatus pendiente, registros pendientes de sincronizar a UNICOM", true),
    /**
     * Registro Procesado
     */
    ENVIADO(2, "E", "Registro con estatus Enviado, ha sido enviados a UNICOM", true),

    /**
     * Registro Terminado
     */
    TERMINADO(3, "T", "Registro con estatus Procesado, ha sido sincronizado en UNICOM", true),
    /**
     * Registro Reprocesado
     */
    REPROCESADO(4, "R", "Registro con estatus Reprocesado, no ha sido sincronizado en UNICOM",
        true);

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
    private TipoControlSincronizacion(int id, String clave, String descripcion, boolean activo) {
        this.id = id;
        this.clave = clave;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representación TipoControlSincronizacion del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoControlSincronizacion}
     * @return {@link TipoControlSincronizacion}
     */
    public static TipoControlSincronizacion valueOf(int id) {
        for (TipoControlSincronizacion TipoControlSincronizacion : values()) {
            if (TipoControlSincronizacion.getId() == id) {
                return TipoControlSincronizacion;
            }
        }
        throw new IllegalArgumentException("Id '" + id
            + "' inválido para obtener enum TipoControlSincronizacion");
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
