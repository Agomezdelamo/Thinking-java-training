package alvaro.thinking.tema8.polimorfismo;



class Roedor {
	private String name = "Roedor";
	protected void eat() { System.out.println("Roedor.eat()"); }
	protected void run() { System.out.println("Roedor.run()"); }
	protected void sleep() { System.out.println("Roedor.sleep()"); }
	public String toString() { return name; }
}

class Raton extends Roedor {
	private String name = "Raton";
	protected void eat() { System.out.println("Raton.eat()"); }
	protected void run() { System.out.println("Raton.run()"); }
	protected void sleep() { System.out.println("Raton.sleep()"); }
	public String toString() { return name; }
}

class Rata extends Roedor {
	private String name = "Rata";
	protected void eat() { System.out.println("Rata.eat()"); }
	protected void run() { System.out.println("Rata.run()"); }
	protected void sleep() { System.out.println("Rata.sleep()"); }
	public String toString() { return name; }
}

class Jerbo extends Roedor {
	private String name = "Jerbo";
	protected void eat() { System.out.println("Jerbo.eat()"); }
	protected void run() { System.out.println("Jerbo.run()"); }
	protected void sleep() { System.out.println("Jerbo.sleep()"); }
	public String toString() { return name; }
}

public class Roedor0 {
	private static RandomRoedor0Generator gen = new RandomRoedor0Generator();
	public static void main(String[] args) {
		Roedor[] Roedors = new Roedor[10];
		for(Roedor r : Roedors) {
			r = gen.next();
			System.out.println(r + ": ");
			r.eat();
			r.run();
			r.sleep();			
		}		
	}
}