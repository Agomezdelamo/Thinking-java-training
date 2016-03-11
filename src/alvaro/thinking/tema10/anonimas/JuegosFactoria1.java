package alvaro.thinking.tema10.anonimas;

import java.util.Random;

//innerclasses/Games17.java
//TIJ4 Chapter Innerclasses, Exercise 17, page 364
/* Modify the solution to Exercise 19 from the Interfaces chapter to use
* anonymous inner classes. 
* 
*/

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
	
	public static FactoriaDeJuegos factoria = //genero un campo donde se instancia el mismo juego a traves de factoria.
		new FactoriaDeJuegos() {
			public Juegos getJuegos() { return new LanzarMoneda(); }	
		};
}

class LanzarDados implements Juegos {
	Random rand = new Random();
	
	public void play() { //2. implemento el metodo del interface JUEGOS de otra forma
		System.out.println("Lanzar dados: " + (rand.nextInt(6) + 1));		
	}
	
	public static FactoriaDeJuegos factoria = //genero un campo donde se instancia el mismo juego a traves de factoria.
		new FactoriaDeJuegos() {
			public Juegos getJuegos() { return new LanzarDados(); }
		};
}

/********************** main *****************************/
public class JuegosFactoria1 {
	/* POTENCIA DEL PATRON FACTORIA */
	//GENERALIZO UN METODO QUE VALE PARA CREAR Y JUGAR A CUALQUIER JUEGO
	public static void jugarJuego(FactoriaDeJuegos factoria) {
		Juegos j = factoria.getJuegos();
		j.play();
	}
	public static void main(String [] args) {
		jugarJuego(LanzarMoneda.factoria);
		jugarJuego(LanzarDados.factoria);			
	}
}