package sockets.chat;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import sockets.basico.ConexServidor;

/**
 * Clase principal del cliente del chat
 * 
 * En esta ocasión vamos a ver como hacer un chat
 * en java capaz de atender múltiples clientes.
 * Hacer un chat para comunicarse entre 2 es sencillo siempre y cuando se entienda bien
 * como funcionan los sockets que dicho sea de paso no tienen mucha
 * complicación pero hacer que se pueda mantener una comunicación entre
 * más de dos hace que sean necesarias algunas cosas más puesto que un
 * socket se comunica con un único socket y hay esta el obstáculo
 * ¿Como poder enviar un mensaje que se envía entre 2 sockets a un tercero?
 * pues voy a dar un ejemplo de como solucionar esto de una forma bastante sencilla.
 * Para hacer el chat vamos a hacer 2 aplicaciones independientes, una actuara
 * de servidor y la otra de cliente.
 *  
 * La función del servidor de forma resumida se puede decir que es 
 * mantenerse en un bucle infinito a la espera de nuevas conexiones 
 * y cuando se produzca una nueva conexión se crea un hilo para 
 * atenderla donde dentro de otro bucle infinito se recibirán los 
 * mensajes enviados por los clientes y se renviarán. Y el cliente 
 * lo que hace es crear un bucle infinito para recibir los mensajes 
 * del servidor (previamente enviados por un cliente) y una función 
 * para poder enviar mensajes al servidor.
 * 
 * Visto que es lo que tienen que hacer el servidor y el cliente “solo” 
 * queda escribir el código java, que no será muy complicado puesto que 
 * el problema tampoco lo es y se puede explicar en 1 minuto.
 */
public class ClienteChat extends JFrame {
    
    private JTextArea mensajesChat;
    private Socket socket;
    
    private int puerto;
    private String host;
    private String usuario;
    
    ////////////////////////////////////////
    //CONFIGURACION DE LA VENTANA DEL CHAT//
    ///////////////////////////////////////
    
    
    
    /**
     * El cliente para el chat
     * 
     * El servidor aunque es sencillo, puede ser más difícil 
     * de comprender sobretodo por el uso del patrón observer 
     * que mezclado con hilos y sockets por lo que es un buen 
     * ejemplo del uso de ese patrón aunque no era esa la idea, 
     * pero en el cliente no hay ninguna dificultad especial y 
     * si se entiende el servidor el cliente es trivial.
     * 
     * He hecho que clienteChat herede de JFrame por lo que 
     * será una ventana, en el constructor se crean y se 
     * colocan los componentes necesarios (JTextArea, JTextField
     * y JButton) y un JScrollPane para que se pueda ver toda la 
     * conversación aunque sea muy larga y para colocar las cosas 
     * he usado un GridBagLayout que me parece que es bastante 
     * sencillo de usar para colocar las cosas de una forma bastante 
     * sencilla y no tener que recurrir a meter varios JPanels 
     * incluso para casos como este en el que solo hay 3 elementos, 
     * si no lo has usado nunca quizás el tener que usar 
     * GridBagConstraints puede parecer algo engorroso aunque 
     * con un par de veces que lo usas ya te acostumbras.
     * 
     * Después de colocar los componentes en la línea 80 se crea 
     * una VentanaConfiguracion que no es más que un JDialog para 
     * pedir un nombre de usuario y el puerto y el host del servidor 
     * por si se quieren modificar. Y finalmente se crea el socket 
     * para conectar con el servidor del chat y en la ultima línea 
     * se añade un actionListener al botón para que cuando se pulse 
     * enviar se envié el mensaje al servidor.
     * 
     * Y en el main se instancia un ClienteChat y se llama al método 
     * recibirMensajesServidor() que dentro de un bucle infinito 
     * recibe los mensajes enviados por el servidor y los va 
     * añadiendo al JTextArea para mostrarlos.
     */
    public ClienteChat(){
        super("Cliente Chat");
        
        // Elementos de la ventana
        mensajesChat = new JTextArea();
        mensajesChat.setEnabled(false); // El area de mensajes del chat no se debe de poder editar
        mensajesChat.setLineWrap(true); // Las lineas se parten al llegar al ancho del textArea
        mensajesChat.setWrapStyleWord(true); // Las lineas se parten entre palabras (por los espacios blancos)
       
        JScrollPane scrollMensajesChat = new JScrollPane(mensajesChat);
        JTextField tfMensaje = new JTextField("");
        JButton btEnviar = new JButton("Enviar");
        
        
        // Colocacion de los componentes en la ventana
        Container c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.insets = new Insets(20, 20, 20, 20);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        c.add(scrollMensajesChat, gbc);
        // Restaura valores por defecto
        gbc.gridwidth = 1;        
        gbc.weighty = 0;
        
        gbc.fill = GridBagConstraints.HORIZONTAL;        
        gbc.insets = new Insets(0, 20, 20, 20);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        c.add(tfMensaje, gbc);
        // Restaura valores por defecto
        gbc.weightx = 0;
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        c.add(btEnviar, gbc);
        
        this.setBounds(400, 100, 400, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        
        // Ventana de configuracion inicial
        VentanaConfiguracion vc = new VentanaConfiguracion(this);
        host = vc.getHost();
        puerto = vc.getPuerto();
        usuario = vc.getUsuario();
        
        System.out.println("Quieres conectarte a " + host + " en el puerto " + puerto + " con el nombre de ususario: " + usuario + ".");
        
        // Se crea el socket para conectar con el Sevidor del Chat
        try {
            socket = new Socket(host, puerto);
        } catch (UnknownHostException ex) {
            System.err.println("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        } catch (IOException ex) {
            System.err.println("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        }
        
        ////////////////////////////////
        /////CONEXION SERVIDOR//////////
        ////////////////////////////////
        // Accion para el boton enviar
        //crea una conexion con el servidor con el socket definido de parte del cliente
        //y manda un mensaje, de parte de un usuario.
        btEnviar.addActionListener(new ConexionServidor(socket, tfMensaje, usuario));
        
    }
    
    /**
     * Recibe los mensajes del chat reenviados por el servidor
     */
    public void recibirMensajesServidor(){
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.err.println("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.err.println("El socket no se creo correctamente. ");
        }
        
        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
            	//pinta los mensajes en la ventana del chat
                mensaje = entradaDatos.readUTF();
                mensajesChat.append(mensaje + System.lineSeparator());
                System.out.println(mensaje);
            } catch (IOException ex) {
                System.err.println("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                System.err.println("El socket no se creo correctamente. ");
                conectado = false;
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ClienteChat c = new ClienteChat();
        c.recibirMensajesServidor();
    }

}  