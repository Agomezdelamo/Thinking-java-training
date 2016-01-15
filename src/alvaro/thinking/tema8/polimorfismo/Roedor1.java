package alvaro.thinking.tema8.polimorfismo;

class Characteristic {
	private String s;
	Characteristic(String s) {
		this.s = s;
		System.out.println("Caracteristica creada: " + s);
	}	
}

class Description {
	private String s;
	Description(String s) {
		this.s = s;
		System.out.println("Descripcion creada: " + s);
	}
}

class Roedor1_base {
	private String name = "Roedor1_base";
	private Characteristic c = new Characteristic("tiene cola");
	private Description d = new Description("pequeño mamifero");
	Roedor1_base() { System.out.println("CONSTRUCTOR --> Roedor1_base()\r\n---------------------------"); }
	protected void eat() { System.out.println("Roedor1_base.eat()"); }
	protected void run() { System.out.println("Roedor1_base.run()"); }
	protected void sleep() { System.out.println("Roedor1_base.sleep()"); }
	public String toString() { return name; }
}

class Raton1 extends Roedor1_base {
	private String name = "Raton1";
	private Characteristic c = new Characteristic("le gusta el queso");
	private Description d = new Description("nocturno");
	Raton1() { System.out.println("CONSTRUCTOR --> Raton1()"); }
	protected void eat() { System.out.println("Raton1.eat()"); }
	protected void run() { System.out.println("Raton1.run()"); }
	protected void sleep() { System.out.println("Raton1.sleep()"); }
	public String toString() { return name; }
}

class Rata1 extends Roedor1_base {
	private String name = "Rata1";
	private Characteristic c = new Characteristic("grande");
	private Description d = new Description("negro");
	Rata1() { System.out.println("CONSTRUCTOR --> Rata1()"); }
	protected void eat() { System.out.println("Rata1.eat()"); }
	protected void run() { System.out.println("Rata1.run()"); }
	protected void sleep() { System.out.println("Rata1.sleep()"); }
	public String toString() { return name; }
}

class Jerbo1 extends Roedor1_base {
	private String name = "Jerbo1";
	private Characteristic c = new Characteristic("Escala arboles");
	private Description d = new Description("le gustan las nueces");
	Jerbo1() { System.out.println("CONSTRUCTOR --> Jerbo1()"); }
	protected void eat() { System.out.println("Jerbo1.eat()"); }
	protected void run() { System.out.println("Jerbo1.run()"); }
	protected void sleep() { System.out.println("Jerbo1.sleep()"); }
	public String toString() { return name; }
}

public class Roedor1 {
	private static RandomRoedor1Generator gen = new RandomRoedor1Generator();
	public static void main(String[] args) {
		Roedor1_base[] Roedor1_bases = new Roedor1_base[10];
		for(Roedor1_base r : Roedor1_bases) {
			r = gen.next();
			System.out.println("por ultimo imprimo el toString del objeto --> "+r+"\r\n");
		}		
	}
}