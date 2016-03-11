package alvaro.thinking.tema9.interfaces;

import java.util.Random;

//Modificar el ejercicio de Roedor en polimorfismo para que sea un interface.

class RandomRodentGenerator2 {
	private Random rand = new Random();
	public RoedorInterface next() {
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Raton2();
			case 1: return new Rata2();
			case 2: return new Jerbo2();			
		}
	}
}

interface RoedorInterface {
	String name = "Roedor";
	void eat(); 
	void run(); 
	void sleep();
	String toString(); 
}

class Raton2 implements RoedorInterface {
	private String name = "Raton2";
	public void eat() { System.out.println("Raton2.eat()"); }
	public void run() { System.out.println("Raton2.run()"); }
	public void sleep() { System.out.println("Raton2.sleep()"); }
	public String toString() { return name; }
}

class Rata2 implements RoedorInterface {
	private String name = "Rata2";
	public void eat() { System.out.println("Rata2.eat()"); }
	public void run() { System.out.println("Rata2.run()"); }
	public void sleep() { System.out.println("Rata2.sleep()"); }
	public String toString() { return name; }
}

class Jerbo2 implements RoedorInterface {
	private String name = "Jerbo2";
	public void eat() { System.out.println("Jerbo2.eat()"); }
	public void run() { System.out.println("Jerbo2.run()"); }
	public void sleep() { System.out.println("Jerbo2.sleep()"); }
	public String toString() { return name; }
}

public class Roedor4 {
	private static RandomRodentGenerator2 gen = new RandomRodentGenerator2();
	public static void main(String[] args) {
		// Error: cannot instantiate (abstract) interface:
		// Rodent x = new Rodent();
		// But OK to create array of implementing objects:
		RoedorInterface[] roedoresInterface = new RoedorInterface[10];
		int i = 0;
		for(RoedorInterface r : roedoresInterface) {
			i++;
			r = gen.next();
			System.out.println(r + ": ");
			r.eat();
			r.run();
			r.sleep();
			System.out.println("---->" + i + "<----" + " \r\n");
		}		
	}
}