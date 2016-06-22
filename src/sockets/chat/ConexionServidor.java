package sockets.chat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextField;

/**
 * Esta clase gestiona el envio de datos entre el cliente y el servidor.
 * 
 * @author Ivan Salas Corrales <http://programando-o-intentandolo.blogspot.com.es/>
 */
public class ConexionServidor implements ActionListener {
    
    private Socket socket; 
    private JTextField tfMensaje;
    private String usuario;
    private DataOutputStream salidaDatos;
    private String prevUsuario;
    
    public ConexionServidor(Socket socket, JTextField tfMensaje, String usuario) {
    	
        this.socket = socket;
        this.tfMensaje = tfMensaje;
        this.usuario = usuario;
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            System.err.println("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.err.println("El socket no se creo correctamente. ");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            salidaDatos.writeUTF(usuario + ": " + tfMensaje.getText() );
            tfMensaje.setText("");
        } catch (IOException ex) {
            System.err.println("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }

}