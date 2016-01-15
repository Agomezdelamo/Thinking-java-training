package alvaro.basicos.java;

import java.util.Random;

public class AbstractRandomGenerator1 {
	private Random rand = new Random();
	public Rodent next() {
		//genero un n�mero aleatorio entre 0 y 2 y devuelvo un objeto instanciado diferente seg�n cada caso.
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Mouse();
			case 1: return new Rat();
			case 2: return new Squirrel();			
		}
	}
}
