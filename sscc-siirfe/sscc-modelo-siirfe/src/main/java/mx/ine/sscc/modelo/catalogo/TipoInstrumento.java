/**
 * TipoInstrumento.java
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
 * Enum
 * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public enum TipoInstrumento {
    /**
     * Registro INSTRUMENTO_DPI
     */
    INSTRUMENTO_DPI(91, "INSTRUMENTO DE DPI", true),
    /**
     * Registro INSTRUMENTO_USI
     */
    INSTRUMENTO_USI(92, "INSTRUMENTO DE USI", true),

    /**
     * Registro INSTRUMENTO_SUS
     */
    INSTRUMENTO_SUS(93, "INSTRUMENTO DE SUS", true);

    private int id;
    private String descripcion;
    private boolean activo;

    /**
     * TODO [Agregar documentacion del m�todo]
     * @author Esther Flores Rodriguez (esther.fr03@gmail.com)
     * @param id
     * @param descripcion
     * @param activo
     */
    private TipoInstrumento(int id, String descripcion, boolean activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    /**
     * Regresa la representaci�n TipoInstrumento del argumento <code>int</code>
     * @param id un <code>int</code> que representa el id del {@link TipoInstrumento}
     * @return {@link TipoInstrumento}
     */
    public static TipoInstrumento valueOf(int id) {
        for (TipoInstrumento TipoInstrumento : values()) {
            if (TipoInstrumento.getId() == id) {
                return TipoInstrumento;
            }
        }
        throw new IllegalArgumentException("Id '" + id
            + "' inv�lido para obtener enum TipoInstrumento");
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
