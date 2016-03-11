package alvaro.basicos.java.polimorfismo;

import java.util.Random;

import alvaro.thinking.tema8.polimorfismo.Note;

//polymorphism/music6/Music6.java
//TIJ4 Chapter Polymorphism, Exercise 6, page 289
/* Simplemente sobreescribimos el método del padre Objetct toString() para
 * que pinte el nombre de la clase de objeto generado.
 * 
 * También hay un upcasting.
*/

class Instrument {
	void play(Note n) { System.out.println("Instrument.play() " + n); }
	public String toString() { return "Instrument"; }
	void adjust() { System.out.println("Adjusting Instrument"); }
}

class Wind extends Instrument {
	void play(Note n) { System.out.println(this+" play() " + n); }
	public String toString() { return "Wind"; }
	void adjust() { System.out.println("Adjusting "+this); }
}

class Percussion extends Instrument {
	void play(Note n) { System.out.println(this+" play() " + n); }
	public String toString() { return "Percussion"; }
	void adjust() { System.out.println("Adjusting "+this); } 
}

class Stringed extends Instrument {
	void play(Note n) { System.out.println(this+" play() " + n); }
	public String toString() { return "Stringed"; }
	void adjust() { System.out.println("Adjusting "+this); } 
}

class Brass extends Wind {
	void play(Note n) { System.out.println(this+" play() " + n); }
	public String toString() { return "Brass"; }
	void adjust() { System.out.println("Adjusting "+this); }
}

class Piano extends Wind {
	void play(Note n) { System.out.println(this+" play() " + n); }
	public String toString() { return "Piano"; }
	void adjust() { System.out.println("Adjusting "+this); }
}

class Woodwind extends Wind {
	void play(Note n) { System.out.println(this+" play() " + n); }
	public String toString() { return "Woodwind"; }
}

public class Polimorfismo1 {
	// Doesn't care about type, so new types
	// added to the system still work right:
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}
	public static void tuneAll(Instrument[] e) {
		for(Instrument i : e)
			tune(i);
	}
	
	/**
	 * generador de instrumentos aleatorios
	 * @param args
	 */
	public static Instrument generator() {
		int rand = new Random().nextInt(6);
		switch(rand) {
			default:
			case 0: return new Wind();
			case 1: return new Percussion();
			case 2: return new Stringed();
			case 3: return new Brass();
			case 4: return new Piano();
			case 5: return new Woodwind();
		}
	}
	
	public static void main(String[] args) {
		// Upcasting se produce mientras añadimos al array, todos son 
		// instrumentos pero no son del tipo que especifica el array, se tiene que producir un casteo hacia arriba:
		Instrument[] orchestra = {
			new Wind(),
			new Percussion(),
			new Stringed(),
			new Brass(),
			//new instrument añadido a posteriori y todo funciona igual, polimorfismo!
			new Piano(),
			new Woodwind()
		};
		tuneAll(orchestra);
		for(Instrument i : orchestra)
			System.out.println(i);
		
		/*generador automático de instrumentos*/
		Instrument[] orchestraArray = new Instrument[20];
		for(int i = 0; i<orchestraArray.length; i++) {
			orchestraArray[i] = generator();
			System.out.println("instrumento aleatorio "+i+": "+orchestraArray[i]);
		}
	}
}