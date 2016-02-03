/**
 * AspectoLogger.java
 * Fecha de creaci�n: 29/06/2015, 12:31:20
 *
 * Copyright (c) 2015 Instituto Nacional Electoral. Direcci�n
 * Ejecutiva del Registro Federal de Electores.
 * Perif�rico Sur 239, M�xico, D.F., C.P. 01010.
 * Todos los derechos reservados.
 *
 * Este software es informaci�n confidencial, propiedad del
 * Instituto Nacional Electoral. Esta informaci�n confidencial
 * no deber� ser divulgada y solo se podr� utilizar de acuerdo
 * a los t�rminos que determine el propio Instituto.
 */
package mx.ine.sscc.aspecto;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Encargado de los logs del sistema
 * @author Edgardo Zavala Vargas (edgardo.zavala@gmail.com)
 * @version 1.0
 */
@Aspect
public class AspectoLogger {

    @SuppressWarnings("javadoc")
    Logger logger = LoggerFactory.getLogger(AspectoLogger.class);

    private final int longitudMaximaCaracteres = 1000;
    private final String patternPackage = "mx.ine.sscc..*";

    /**
     * Log que proporciona informaci�n de la clase y m�todo que est� por ejecutarse
     * @param joinPoint
     */
    @Before("within(" + patternPackage + ")")
    public void logBefore(JoinPoint joinPoint) {

        String argumentos = getArgumentos(joinPoint);

        if (argumentos.length() > longitudMaximaCaracteres) {
            argumentos = argumentos.substring(0, longitudMaximaCaracteres) + "...";
        }

        logger.debug("-> Entra a: " + getClaseMetodo(joinPoint.getSignature()) + "("
            + argumentos + ")");

    }

    /**
     * Log que proporciona informacion sobre el m�todo que termina de ejecutarse
     * @param joinPoint
     * @param resultado
     */
    @AfterReturning(pointcut = "within(" + patternPackage + ")", returning = "resultado")
    public void logAfter(JoinPoint joinPoint, Object resultado) {

        String respuesta = null;

        if (resultado != null && resultado.toString().length() > longitudMaximaCaracteres) {
            respuesta = resultado.toString().substring(0, longitudMaximaCaracteres) + "...";
        } else if (resultado != null) {
            respuesta = resultado.toString();
        }

        logger.debug("<- Sale de: " + getClaseMetodo(joinPoint.getSignature()) + "()"
            + ", valor de retorno: " + respuesta);

    }

    /**
     * Log que muestra informaci�n sobre los errores lanzados en el sistema
     * @param joinPoint
     * @param error
     */
    @AfterThrowing(pointcut = "within(" + patternPackage + ")", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("(!) Error en : " + getClaseMetodo(joinPoint.getSignature())
            + "\n\tExcepcion : " + error);
        error.printStackTrace();
    }

    /*
    * M�todos privados �tiles:
    */

    /**
     * A partir del <code>Signature</code> obtiene el nombre simple de la clase y el m�todo
     * @param signature
     * @return El nombre de la clase y el m�todo
     */
    private String getClaseMetodo(Signature signature) {
        String[] splits = StringUtils.split(signature.getDeclaringTypeName(), '.');
        String clase = splits[splits.length - 1];
        String metodo = signature.getName();
        return clase + "." + metodo;
    }

    /**
     * Obtiene la lista de argumentos a partir del <code>JoinPoint</code>
     * @param joinPoint
     * @return argumentos que recibe un m�todo
     */
    private String getArgumentos(JoinPoint joinPoint) {
        return Arrays.toString(joinPoint.getArgs());
    }
}
