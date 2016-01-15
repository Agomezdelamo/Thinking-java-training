package alvaro.thinking.tema8.polimorfismo;

import java.util.Random;

public class RandomRoedor1Generator {
	private Random rand = new Random();
	public Roedor1_base next() {
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Raton1();
			case 1: return new Rata1();
			case 2: return new Jerbo1();
		}
	}
 }