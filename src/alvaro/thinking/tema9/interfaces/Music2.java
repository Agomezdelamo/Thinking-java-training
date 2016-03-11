package alvaro.thinking.tema9.interfaces;

import alvaro.thinking.tema8.polimorfismo.Note;

// Refactorizar Music.java moviendo los métodos comunes en viento, percusion y cuerdas en una clase abstracta.

abstract class Instrument {
	private int i; 
	public abstract void play(Note n);
	public String toString() { return "Instrument"; } 
	public abstract void adjust(); 
}

class Wind extends Instrument {
	public void play(Note n) { System.out.println(this + ".play() " + n); }
	public String toString() { return "Wind"; }
	public void adjust() { System.out.println(this + ".adjust()"); }
}

class Percussion extends Instrument {
	public void play(Note n) { System.out.println(this + ".play() " + n); }
	public String toString() { return "Percussion"; }
	public void adjust() { System.out.println(this + ".adjust()"); }
}

class Stringed extends Instrument {
	public void play(Note n) { System.out.println(this + ".play() " + n); }
	public String toString() { return "Stringed"; }
	public void adjust() { System.out.println(this + ".adjust()"); }
}

class Brass extends Wind {
	public String toString() { return "Brass"; }
}

class Woodwind extends Wind {
	public String toString() { return "Woodwing"; }
}

public class Music2 {
	// no te preocupes del tipo, los nuevos instrumentos funcionaran perfectamente:
	static void afinar(Instrument i) { i.play(Note.MIDDLE_C); }
	
	static void afinarTodos(Instrument[] arrayInstruments) {
		for(Instrument i : arrayInstruments)
			afinar(i);
	}
	
	public static void main(String[] args) {
		// Se hace upcasting al añadir al array:
		Instrument[] orchestra = {
			new Wind(),
			new Percussion(),
			new Stringed(),
			new Brass(),
			new Woodwind()
		};
		
		afinarTodos(orchestra);
	}
}