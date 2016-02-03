/**
 * ConsultaException.java
 * Fecha de creaci�n: Oct 28, 2015, 12:59:50 PM
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
package mx.ine.sscc.servicios.util;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Jorge Alberto L�pez Herrera (jorge.lopez.he@gmail.com)
 * @version 1.0
 * @since SIIRFE 6.1
 */
public class ConsultaException extends RuntimeException {
    private static final long serialVersionUID = 6046584611347888818L;

    /**
     * Constructor para mensaje personalizado
     * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
     * @param message
     */
    public ConsultaException(String message) {
        super(message);
    }

    /**
     * Constructor con mensaje y causa
     * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
     * @param message
     * @param cause
     */
    public ConsultaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor con causa espec�fica
     * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
     * @param cause
     */
    public ConsultaException(Throwable cause) {
        super(generaMensajePersonalizado(cause), cause);
    }

    private static String generaMensajePersonalizado(Throwable cause) {
        String mensajeDefault = "Error inesperado!";

        if (isCause(ConsultaException.class, cause)) {
            return cause.getMessage();
        }

        return mensajeDefault;
    }

    private static boolean isCause(Class<? extends Throwable> expected, Throwable exc) {
        return expected.isInstance(exc) || (exc != null && isCause(expected, exc.getCause()));
    }

}
