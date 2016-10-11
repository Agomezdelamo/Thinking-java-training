package sockets.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;


/**
 * Esta clase gestiona el envio de datos entre el 
 * servidor y el cliente al que atiende.
 * 
 * Y finalmente la clase ConexionCliente que solo tiene dos
 * métodos, el método run que hereda de Thread y que es el 
 * que se encarga de recibir los mensajes del cliente y el 
 * método update que es necesario implementar por implementar 
 * la interfaz Observer y que es el encargado de enviar el 
 * mensaje al cliente. 
 */

public class ConexionCliente extends Thread implements Observer{
    private Socket socket; 
    private MensajesChat mensajes;
    private DataInputStream entradaDatos;
    private DataOutputStream salidaDatos;
    
    public ConexionCliente (Socket socket, MensajesChat mensajes){
        this.socket = socket;
        this.mensajes = mensajes;
        
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
            salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
        	System.err.println("Error al crear los stream de entrada y salida : " + ex.getMessage());
        }
    }
    /**
     * En el método run hay que tener en cuenta 2 detalles,
     * el primero es que hay que apuntarse a la lista de observadores
     * de mensajes para que posteriormente cuando mensajes contenga
     * un nuevo mensaje sea notificado y pueda enviar el mensaje
     * al cliente gracias al método update, independientemente
     * de si el mensaje lo ha enviado el cliente que es atendido
     * por ese mismo hilo o por otro distinto. Y lo segundo es que
     * hay que hacer uso de setMensaje para que mensajes cambie su
     * estado y lo notifique a sus observadores.
     * 
     * En el método run aunque teóricamente hay que tener un
     * bucle infinito para recibir mensajes, en la practica no
     * es así puesto que si el cliente que es atendido por ese 
     * hilo se desconecta este hilo se continuaría ejecutando 
     * indefinidamente de forma absurda porque estaría lanzando 
     * una IOException continuamente por lo que cuando se lance 
     * esta excepción cerraremos el bucle y se terminara la 
     * ejecución del hilo liberando al servidor de una tarea absurda.
     * 
     * Con estas 3 clases ya tenemos un servidor capaz de permitir
     * que se puedan conectar múltiples clientes y que cuando uno 
     * envié un mensaje todos los reciban.
     */
    @Override
    public void run(){
        String mensajeRecibido;
        boolean conectado = true;
        // Se apunta a la lista de observadores de mensajes
        mensajes.addObserver(this);
        
        while (conectado) {
            try {
                // Lee un mensaje enviado por el cliente
                mensajeRecibido = entradaDatos.readUTF();
                // Pone el mensaje recibido en mensajes para que se notifique 
                // a sus observadores que hay un nuevo mensaje.
                mensajes.setMensaje(mensajeRecibido);
            } catch (IOException ex) {
                System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " desconectado.");
                conectado = false; 
                // Si se ha producido un error al recibir datos del cliente se cierra la conexion con el.
                try {
                    entradaDatos.close();
                    salidaDatos.close();
                } catch (IOException ex2) {
                	System.err.println("Error al cerrar los stream de entrada y salida :" + ex2.getMessage());
                }
            }
        }   
    }
    
    @Override
    public void update(Observable o, Object arg) {
        try {
            // Envia el mensaje al cliente
            salidaDatos.writeUTF(arg.toString());
        } catch (IOException ex) {
        	System.err.println("Error al enviar mensaje al cliente (" + ex.getMessage() + ").");
        }
    }
} 