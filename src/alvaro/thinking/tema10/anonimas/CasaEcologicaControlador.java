package alvaro.thinking.tema10.anonimas;

import java.util.ArrayList;
import java.util.List;
//innerclasses/GreenhouseController24.java
//TIJ4 Chapter Innerclasses, Exercise 24, page 382
/* En CasaEcologicaControlador.java, añade inner clases de eventos que cambien interruptores de on a off.
 * Configura CasaEcologicaControlador.java para usar estos nuevos objetos de eventos.
*/


class Controlador {
	// Una clase de java.util para manejar los guardar los objetos de eventos:
	private List<Evento> eventoList = new ArrayList<Evento>();
	
	public void addEvento(Evento c) { eventoList.add(c); } //añadir evento
	
	public void run() {
		while(eventoList.size() > 0) //mientras la lista de eventos sea mayor que cero los pinto y los borro.
			
			// Hago una copia haciendo un new y pasando parametrizada la lista 
			// y asi no la modifico mientras selecciono elementos de ella
			for(Evento e : new ArrayList<Evento>(eventoList))
				if(e.ready()) { //si elaaddEventoto esta listo
					System.out.println(e); //pinto en consola su nombre
					e.action(); //pinto su accion
					eventoList.remove(e); // y lo borro
				} 
	}	
}

abstract class Evento {
	private long eventoTime; //el tiempo en el que se ejecuta el evento
	protected final long delayTime; //tiempo de retardo
	
	//CONSTRUCTOR
	public Evento(long delayTime) { 
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


public class CasaEcologicaControlador {
	
	public static void main(String[] args) {
		CasaEcologicaMandos gc = new CasaEcologicaMandos(); //greenHouseControles
		
		// Instancia de red manual, tu puedes parsear la información 
		// de la configuración en un archivo de texto aqui.
		gc.addEvento(gc.new Campana(900));
		
		Evento[] eventoList = {
			gc.new TermostatoNocturno(0),
			gc.new LuzOn(200),
			gc.new VentiladorOn(300),
			gc.new LuzOff(400),
			gc.new VentiladorOff(500),
			gc.new AguaOn(600),
			gc.new VaporOn(33600),
			gc.new VaporOff(600),
			gc.new AguaOff(800),
			gc.new TermostatoDiurno(1400),
		};
		gc.addEvento(gc.new Restart(2000, eventoList));
		if(args.length == 1)
			gc.addEvento(
				new CasaEcologicaMandos.Terminate(
					new Integer(args[0])));
		gc.run();
	}
}
