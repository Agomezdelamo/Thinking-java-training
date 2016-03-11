package alvaro.thinking.tema9.interfaces;

/* Crear un framework que use metodos factoria
*/
import java.util.*;


/**
 * ESTE EJERCICIO MUESTRA COMO CON EL PATRON FACTORIA, PUEDES GENERALIZAR USANDO 2 INTERFACES
 * 1 PARA DEVOLVER EL OBJETO DE JUEGO CORRESPONDIENTE, Y OTRO PARA JUGAR A ESE JUEGO.
 */

/***************** INTERFACES *************************/
interface JuegosI1 { void play(); }

//FACTORIA, PATRON QUE MEDIANTE UN METODO DE UN INTERFACE DEVUELVE UN OBJETO.
interface FactoriaJuegos { JuegosI1 getJuegos(); }


/***************** IMPLEMENTACION *************************/
class LanzarMoneda1 implements JuegosI1 {
	
	Random rand = new Random();
	
	public void play() { //1. metodo que lanza una moneda, da cuerpo al play() del interface juego
		System.out.println("Lanzar Moneda: ");
		switch(rand.nextInt(2)) {
			case 0 : System.out.println("cara"); return;
			case 1 : System.out.println("cruz"); return;
			default: System.out.println("deCanto"); return;
		} 
	}
}

/***************** FACTORIA *************************/
class LanzarMonedaFactoria implements FactoriaJuegos {
	public JuegosI1 getJuegos() { return new LanzarMoneda1(); }
}

class LanzarDados1 implements JuegosI1 {
	Random rand = new Random();
	 
	public void play() { //2. metodo que lanza una moneda, da un cuerpo distinto al play() del interface juego
		System.out.println("Lanzar Dados: " + (rand.nextInt(6) + 1));		
	}
}


/***************** FACTORIA *************************/
class LanzarDadosFactoria implements FactoriaJuegos {
	public JuegosI1 getJuegos() {	return new LanzarDados1(); }
}


public class Juegos1 {
	public static void jugarJuego(FactoriaJuegos Factoria) { //metodo static que:
		JuegosI1 g = Factoria.getJuegos(); //1. obtiene un juego a traves de su factoria. INTERFACE FACTORIA
		g.play(); //2. juega al juego. INTERFACE JUEGO.
	}
	public static void main(String [] args) {
		jugarJuego(new LanzarMonedaFactoria()); //introduzco la factoria correspondiente como parametro
		jugarJuego(new LanzarDadosFactoria());			
	}
}
