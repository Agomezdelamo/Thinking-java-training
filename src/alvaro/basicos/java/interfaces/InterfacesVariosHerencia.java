package alvaro.basicos.java.interfaces;

import alvaro.thinking.tema8.polimorfismo.Note;


//interfaces/music10/Music10.java
//TIJ4 Chapter Interfaces, Exercise 10, page 320
/* 
 * Modifica musica para añdir un interface interpretable.
 * Mueve la declaración de play de instrumento a interpretable.
 * 
 * Añade interpretable a las clases derivadas despues de implements.
*/

/*********************** INTERFACES ************************/
interface Instrumento {
	// constante de tiempo de compilacion:
	int VALUE = 5; // un campo o propiedad en un interface es implicitamente static y final
	// no puede tener definiciones de los métodos:	
	void ajustar(); 
}

interface Interpretable {
	void play(Note n); // Automatically public
}

/*********************** IMPLEMENTACION INTERFACES ************************/
class Viento implements Instrumento, Interpretable {
	public void play(Note n) { System.out.println(this + ".play() " + n); }
	public String toString() { return "Viento"; }
	public void ajustar() { System.out.println(this + ".ajustar()"); }
}


class Percusion implements Instrumento, Interpretable {
	public void play(Note n) { System.out.println(this + ".play() " + n); }
	public String toString() { return "Percusion"; }
	public void ajustar() { System.out.println(this + ".ajustar()"); }
}

class DeCuerda implements Instrumento, Interpretable {
	public void play(Note n) { System.out.println(this + ".play() " + n); }
	public String toString() { return "DeCuerda"; }
	public void ajustar() { System.out.println(this + ".ajustar()"); }
}


/*********************** HERENCIA ************************/
class Metales extends Viento {
	public String toString() { return "Metales"; }
}

class VientoMadera extends Viento {
	public String toString() { return "VientoMadera"; }
}

public class InterfacesVariosHerencia {
	// Da igual el tipo, todos los que se agregen funcionaran bien.
	static void tune(Interpretable i) { i.play(Note.MIDDLE_C); }
	
	//1. metodo que recibe arrays de interpretables
	static void tuneAll(Interpretable[] InterpretableArray) {
		for(Interpretable i : InterpretableArray)
			//2. llamo al método que recibe interpretables
			tune(i);
	}
	
	public static void main(String[] args) {
		// Upcasting mientras añado los instrumentos:
		Interpretable[] orchestra = {
			new Viento(),
			new Percusion(),
			new DeCuerda(),
			new Metales(),
			new VientoMadera()
		};
		tuneAll(orchestra);
	}
}