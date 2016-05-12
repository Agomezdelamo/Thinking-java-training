package alvaro.thinking.tema11.colecciones;


//TIJ4 Chapter Holding, Exercise 13, page 412
/* In the innerclasses/GreenhouseController.java example, the class
* Controller uses an ArrayList. Change the code to use a LinkedList
* instead, and use an Iterator to cycle through the set of events.
*/
import java.util.*;


abstract class Event {
	private long eventoTime; //el tiempo en el que se ejecuta el evento
	protected final long delayTime; //tiempo de retardo
	
	//CONSTRUCTOR
	public Event(long delayTime) { 
		this.delayTime = delayTime; //setea el tiempo de retardo y
		start(); //arranca
	}
	
	public void start() { // Permite reiniciar
	}
	
	public boolean ready() { //retorna el nanosegundo que sea mayor o igual que el tiempo del evento.
		return System.nanoTime() >= eventoTime;
	}
	
	public abstract void action();
}


public class Controller13 {
	// A class from java.util to hold Event objects:
	private LinkedList<Event> eventList = new LinkedList<Event>();
	public void addEvent(Event c) { eventList.add(c); }		
	public void run() {		
		LinkedList<Event> eventListCopy = 
			new LinkedList<Event>(eventList);
		ListIterator<Event> it 
			= eventListCopy.listIterator();
		while(it.hasNext()) {	
			it.next().action();
			it.previous();		
			System.out.println(it.next());		
		}
	}	
}