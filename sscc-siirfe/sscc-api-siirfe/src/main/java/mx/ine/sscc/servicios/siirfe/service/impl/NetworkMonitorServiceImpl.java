package mx.ine.sscc.servicios.siirfe.service.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

import mx.ine.sscc.servicios.siirfe.service.NetworkMonitorService;

/**
 * TODO [Clase que realiza una petición a algun servidor para medir el tiempo de respuesta, con
 * esto se puede saber la calidad de la red.]
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
@Service
public class NetworkMonitorServiceImpl implements NetworkMonitorService {

    String ip;
    int port;
    Socket s = null;

    @Override
    public long getPromedio() {

        // Esta IP coorresponde a la base de datos UNICOM
        ip = "10.0.27.108";
        port = 15210;
        // Cuatas veces se hara el ping al servidor.
        int times = 5;
        // Nombre del host.
        String hostaddr = "";

        try {
            // Obtiene le nombre del host por medio de la IP.
            hostaddr = InetAddress.getByName(ip).getHostAddress();
        } catch (UnknownHostException e) {
            System.out.println("IP Invalida. " + e);
        }

        System.out.println("Haciendo Ping a " + ip + " (" + hostaddr + ") " + times
            + " veces en puerto " + port + "  ...\n");

        int total = 0;
        long totalping = 0;

        while (total < times) {
            total++;
            // Hora a la que inicia el ping
            long start = System.currentTimeMillis();

            try {
                SocketAddress sockaddr = new InetSocketAddress(hostaddr, port);
                s = new Socket();
                // Se establece la comunicación con el servidor por medio de un socket, la
                // peticion se realiza cada segundo.
                s.connect(sockaddr, 1000);
            } catch (SocketTimeoutException e) {
                // Error de tiempo de respuesta del servidor.
                System.out.println(
                    " Respuesta del Socket[" + total + "]: Connection timed out." + e);
                continue;
            } catch (UnknownHostException e) {
                System.out.println("IP Invalida." + e);
            } catch (IOException e) {
                System.out.println("Error de Comunicación " + e);
            }
            // Hora en la que finaliza el ping.
            long end = System.currentTimeMillis();
            // Total de tiempo que dura el ping.
            totalping += (end - start);
            long totaltime = (end - start);
            // Promedio de timpo por peticion.
            long avg = totalping / total;
            System.out.println("Respuesta del Socket[" + total + "]: Tiempo(En MS): "
                + totaltime + " Promedio: " + avg);
        }
        // Promedio general.
        long avg = (totalping / total);
        System.out.println("\nResultado Final: Promedio de peticion - " + avg);

        return avg;
    }

}
