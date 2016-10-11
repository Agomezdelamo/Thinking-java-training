package sockets.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor para el chat.
 * 
 * En el código de la clase principal del servidor hay poco que
 * explicar puesto que únicamente se crea el ServerSocket y un 
 * bucle infinito en el que se esperan conexiones y cuando se 
 * producen se crea una ConexionCliente y se pone a correr el 
 * hilo para que atienda la conexión con el cliente.
 */
public class ServidorChat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	int puerto = 1234;
        int maximoConexiones = 10; // Maximo de conexiones simultaneas
        ServerSocket servidor = null; 
        Socket socket = null;
        MensajesChat mensajes = new MensajesChat();
        
        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(puerto, maximoConexiones);
            
            // Bucle infinito para esperar conexiones
            while (true) {
                System.out.println("Servidor a la espera de conexiones.");
                //el servidor escucha si hay una petición pendiente y la acepta,
                //y en el momento que hay una conexión, utiliza los datos de ese cliente que se conecta
                //para guardarlos en un socket, y apartir de ahi arrancar la conexion con el cliente.
                socket = servidor.accept();
                System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");
                
                
                //arrancamos la conexion de la parte del cliente
                ConexionCliente cc = new ConexionCliente(socket, mensajes);
                cc.start();
           
            }
        } catch (IOException ex) {
        	System.err.println("Error: " + ex.getMessage());
        } finally{
            try {
                socket.close();
                servidor.close();
            } catch (IOException ex) {
            	System.err.println("Error al cerrar el servidor: " + ex.getMessage());
            }
        }
    }
}