/**
 * TipoEstatusSubproceso.java
 * Fecha de creaci�n: 09/11/2015, 12:54:46
 *
 * Copyright (c) 2015 Instituto Federal Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */
package mx.ine.sscc.modelo.catalogo;

/**
 * Tipo de estatus en los que se encuentra un subproceso en bitacora
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoEstatusSubproceso {
    /**
     * EXTRAE_DE_CONCILIACIONES
     */
    EXTRAE_DE_CONCILIACIONES(1, "EXTRAE DE CONCILIACIONES",
        "Registros extraidos de Conciliaciones", true),
    /**
     * ENVIO_A_UNICOM
     */
    ENVIO_A_UNICOM(2, "ENVIO A UNICOM", "Registros enviados a UNICOM", true),

    /**
     * SINCRONIZADO_A_UNICOM
     */
    SINCRONIZADO_EN_UNICOM(3, "SINCRONIZADO EN UNICOM", "Registros sincronizados en UNICOM",
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
    private TipoEstatusSubproceso(int id, String clave, String descripcion, boolean activo) {
        this.id = id;
        this.clave = clave;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representaci�n TipoEstatusSubproceso del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoEstatusSubproceso}
     * @return {@link TipoEstatusSubproceso}
     */
    public static TipoEstatusSubproceso valueOf(int id) {
        for (TipoEstatusSubproceso TipoEstatusSubproceso : values()) {
            if (TipoEstatusSubproceso.getId() == id) {
                return TipoEstatusSubproceso;
            }
        }
        throw new IllegalArgumentException("Id '" + id
            + "' inv�lido para obtener enum TipoEstatusSubproceso");
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
