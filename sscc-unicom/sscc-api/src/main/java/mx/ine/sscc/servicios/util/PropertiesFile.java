/**
 * PropertiesFile.java
 * Fecha de creaci�n: 27/10/2015, 14:43:02
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

package mx.ine.sscc.servicios.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO [Agregar documentacion de la clase]
 * @author Hugo A. Cruz Trujillo (hugo.cruzt@gmail.com)
 * @version 1.0
 * @since CREDEXT 1.0
 */
public class PropertiesFile {

    private static final Logger logger = LoggerFactory.getLogger(PropertiesFile.class);
    /**
     * TODO [Agregar documentaci�n del atributo]
     */

    private final static String ARCHIVO_PROPERTIES = "unicom.properties";

    private static Properties propiedades;

    /**
     * @return Properties
     */
    public static Properties getFilepropiedad() {
        try {
            String ruta = System.getenv("SSCC_PROP").trim();
            // String ruta = "C:\\sscc\\unicom\\recursos\\";

            logger.info("Properties path: " + ruta + ARCHIVO_PROPERTIES);
            File file = new File(ruta + ARCHIVO_PROPERTIES);
            FileInputStream fileInput = new FileInputStream(file);
            propiedades = new Properties();
            propiedades.load(fileInput);
            fileInput.close();

        } catch (FileNotFoundException e) {
            logger.error("No se encuentra el archivo " + ARCHIVO_PROPERTIES);
            e.printStackTrace();

        } catch (IOException e) {
            logger.error("Error al buscar  archivo " + ARCHIVO_PROPERTIES);
            e.printStackTrace();

        }

        return propiedades;
    }

}
