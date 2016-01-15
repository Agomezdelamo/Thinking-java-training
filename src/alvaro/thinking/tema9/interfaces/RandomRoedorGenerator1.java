package alvaro.thinking.tema9.interfaces;

import java.util.Random;

public class RandomRoedorGenerator1 {
	private Random rand = new Random();
	public Roedor next() {
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Raton();
			case 1: return new Rata();
			case 2: return new Jerbo();
		}
	}
 }