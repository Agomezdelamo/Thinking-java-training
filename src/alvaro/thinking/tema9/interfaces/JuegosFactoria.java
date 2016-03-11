package alvaro.thinking.tema9.interfaces;

/* Create a framework using factoria Methods that performs both coin
* tossing and dice tossing.
*/
import java.util.*;

/*************** INTERFACES ****************/
interface Juegos { void play(); } //interface para jugar juegos

interface FactoriaDeJuegos { Juegos getJuegos(); } //interface-factoria para crear juegos


/************* IMPLEMENTACIONES ***************/
class LanzarMoneda implements Juegos {
	Random rand = new Random();
	
	public void play() { 
		System.out.println("Lanzar moneda: ");
		switch(rand.nextInt(2)) { //1. implemento el metodo del JUEGOS juegos de una forma
			case 0 : System.out.println("Cara"); return;
			case 1 : System.out.println("Cruz"); return;
			default: System.out.println("deCanto"); return;
		} 
	}
}

class LanzarDados implements Juegos {
	Random rand = new Random();
	
	public void play() { //2. implemento el metodo del interface JUEGOS de otra forma
		System.out.println("Lanzar dados: " + (rand.nextInt(6) + 1));		
	}
}

/******************* FACTORIAS ********************/
class FactoriaLanzarMoneda implements FactoriaDeJuegos { //1. implemento el inteface FACTORIA y devuelvo un OBJETO
	public Juegos getJuegos() {	return new LanzarMoneda(); }
}

class FactoriaTirarDados implements FactoriaDeJuegos { //1. implemento el inteface FACTORIA y devuelvo otro OBJETO
	public Juegos getJuegos() { return new LanzarDados(); }
}

/********************** main *****************************/
public class JuegosFactoria {
	/* POTENCIA DEL PATRON FACTORIA */
	//GENERALIZO UN METODO QUE VALE PARA CREAR Y JUGAR A CUALQUIER JUEGO
	public static void jugarJuego(FactoriaDeJuegos factoria) { 
		Juegos g = factoria.getJuegos();// OBTENGO EL JUEGO
		g.play(); // JUEGO
	}
	
	public static void main(String [] args) {
		jugarJuego(new FactoriaLanzarMoneda());
		jugarJuego(new FactoriaTirarDados());			
	}
}