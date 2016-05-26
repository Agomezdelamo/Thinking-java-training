package alvaro.thinking.tema11.colecciones;

//holding/Queue27.java
//TIJ4 Chapter Holding, Exercise 27, page 424
/* Escribe una clase llamada command que contenga un string y tenga un método operation() 
 * que muestre el string.
 * 
 * Escribe una segunda clase con un metodo que rellene la cola con objetos command y los retorne.
 * 
 * Pasa la cola rellena al metodo en una tercera clase que consuma los objetos en la cola y llame a su método operacion.
 * 
*/

import java.util.*;

class Command {
	String s;
	Command(String s) { this.s = s; }
	void operation() { System.out.print(s); }
}

class Construccion {	
	Queue<Command> crearCola() {
		Queue<Command> c = new LinkedList<Command>();
		for(int i = 0; i < 10; i++)
			c.offer(new Command(i + " commands\r\n"));
		return c;
	}
}

public class Cola {
	//método que 
	public static void zampaCommands(Queue<Command> qc) {
		while(qc.peek() != null)
			qc.poll().operation();
	}
	
	public static void main(String[] args) {
		Construccion b = new Construccion();
		zampaCommands(b.crearCola());	
	}
}