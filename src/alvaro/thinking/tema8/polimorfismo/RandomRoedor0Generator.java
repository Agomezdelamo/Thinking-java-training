package alvaro.thinking.tema8.polimorfismo;

import java.util.Random;

public class RandomRoedor0Generator {
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