package alvaro.basicos.java.abstractas;

import alvaro.thinking.tema8.polimorfismo.Note;

// Refactorizar Music.java moviendo los métodos comunes en viento, percusion y cuerdas en una clase abstracta.

abstract class Instrument1 {
	private int i; 
	public abstract void play(Note n);
	public String toString() { return "Instrument11"; } 
	public abstract void adjust(); 
}

class Wind1 extends Instrument1 {
	public void play(Note n) { System.out.println(this + ".play() " + n); }
	public String toString() { return "Wind1"; }
	public void adjust() { System.out.println(this + ".adjust()"); }
}

class Percussion1 extends Instrument1 {
	public void play(Note n) { System.out.println(this + ".play() " + n); }
	public String toString() { return "Percussion1"; }
	public void adjust() { System.out.println(this + ".adjust()"); }
}

class Stringed1 extends Instrument1 {
	public void play(Note n) { System.out.println(this + ".play() " + n); }
	public String toString() { return "Stringed1"; }
	public void adjust() { System.out.println(this + ".adjust()"); }
}

class Brass1 extends Wind1 { public String toString() { return "Brass1"; } }

class Woodwind1 extends Wind1 { public String toString() { return "Woodwing1"; } }

public class AbstractEjemplo {
	// no te preocupes del tipo, los nuevos instrument1os funcionaran perfectamente:
	static void afinar(Instrument1 i) { i.play(Note.MIDDLE_C); }
	
	static void afinarTodos(Instrument1[] arrayInstrument1s) {
		for(Instrument1 i : arrayInstrument1s)
			afinar(i);
	}
	
	public static void main(String[] args) {
		// Se hace upcasting al añadir al array:
		Instrument1[] orchestra = {
			new Wind1(),
			new Percussion1(),
			new Stringed1(),
			new Brass1(),
			new Woodwind1()
		};
		
		afinarTodos(orchestra);
	}
}