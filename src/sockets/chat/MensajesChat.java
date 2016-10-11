package sockets.chat;

import java.util.Observable;
 
/**
 * Objeto observable del patron observer.
 * 
 * En el código anterior se crea un objeto (de la clase MensajesChat)
 * que será el que se utilizará para permitir que se puedan intercambiar
 * mensajes entre múltiples clientes que es la idea de un chat.
 * 
 * Esta clase es muy sencilla porque únicamente tiene un set y get
 * aunque puesto que hereda de Observable hay que saber de que va el
 * patrón Observer.
 * 
 * En el patrón observer hay 2 tipos de elementos los
 * observadores y los observados (MensajesChat es un observado).
 * Si un objeto quiere observar a otro se apunta a su lista de 
 * observadores para avisarle de que quiere saber cuando cambia su
 * estado para realizar alguna acción, por ejemplo mostrar el cambio,
 * y el objeto observado lo que hace es informar a todos los objetos
 * que lo están observando para decirles que su estado ha cambiado.
 * 
 * Una vez entendido el funcionamiento del patrón 
 * observer únicamente hay que decir que mediante 
 * la función setChanged() se indica que el estado 
 * del objeto observable a cambiado y además hay que 
 * notificárselo a sus observadores con notifyObservers(Object o) 
 * que le pasará al objeto observador el objeto o que se 
 * quiera enviar, en nuestro caso un mensaje de un cliente. 
 */
public class MensajesChat extends Observable{
 
    private String mensaje;
    
    public MensajesChat(){
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
        // Indica que el mensaje ha cambiado
        this.setChanged();
        // Notifica a los observadores que el mensaje ha cambiado y se lo pasa
        // (Internamente notifyObservers llama al metodo update del observador)
        this.notifyObservers(this.getMensaje());
    }
}