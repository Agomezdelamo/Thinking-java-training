package alvaro.basicos.java;

import java.util.Random;

class Shared {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++; 
	public Shared() { System.out.println("Creating " + this); }
	public void addRef() { refcount++; }
	public String toString() { return "Shared " + id; }
	public void showRefcount() { System.out.println("Este objeto esta refernciado en " + refcount + " objetos"); }		
 }


class Characteristic2 {
	private String s;
	Characteristic2(String s) {
		this.s = s;
		System.out.println("Caracteristica2 creada: " + s);
	}	
}

class Description2 {
	private String s;
	Description2(String s) {
		this.s = s;
		System.out.println("Descripcion2 creada: " + s);
	}
}

class Roedor2_base {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++; 
	private String name = "Roedor2_base";
	private Characteristic2 c = new Characteristic2("tiene cola");
	private Description2 d = new Description2("pequeño mamifero");
	Roedor2_base(Shared shared) { 
		System.out.println("CONSTRUCTOR --> Roedor2_base()\r\n---------------------------");
		this.shared = shared;
		this.shared.addRef();
	}
	protected void eat() { System.out.println("Roedor2_base.eat()"); }
	protected void run() { System.out.println("Roedor2_base.run()"); }
	protected void sleep() { System.out.println("Roedor2_base.sleep()"); }
	public String toString() { return name; }
}

class Raton2 extends Roedor2_base {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++; 
	private String name = "Raton2";
	private Characteristic2 c = new Characteristic2("le gusta el queso");
	private Description2 d = new Description2("nocturno");
	Raton2(Shared shared) { 
		super(shared); 
		System.out.println("CONSTRUCTOR --> Raton2()");
	}
	protected void eat() { System.out.println("Raton2.eat()"); }
	protected void run() { System.out.println("Raton2.run()"); }
	protected void sleep() { System.out.println("Raton2.sleep()"); }
	public String toString() { return name; }
}

class Rata2 extends Roedor2_base {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++; 
	private String name = "Rata2";
	private Characteristic2 c = new Characteristic2("grande");
	private Description2 d = new Description2("negro");
	Rata2(Shared shared) { 
		super(shared); 
		System.out.println("CONSTRUCTOR --> Rata2()");
	}
	protected void eat() { System.out.println("Rata2.eat()"); }
	protected void run() { System.out.println("Rata2.run()"); }
	protected void sleep() { System.out.println("Rata2.sleep()"); }
	public String toString() { return name; }
}

class Jerbo2 extends Roedor2_base {
	private Shared shared;
	private static long counter = 0;
	private final long id = counter++; 
	private String name = "Jerbo2";
	private Characteristic2 c = new Characteristic2("Escala arboles");
	private Description2 d = new Description2("le gustan las nueces");
	Jerbo2(Shared shared) { 
		super(shared); 
		System.out.println("CONSTRUCTOR --> Jerbo2()"); 
	}
	protected void eat() { System.out.println("Jerbo2.eat()"); }
	protected void run() { System.out.println("Jerbo2.run()"); }
	protected void sleep() { System.out.println("Jerbo2.sleep()"); }
	public String toString() { return name; }
}

class RandomRodent2Generator {
	// El mismo objeto compartido(shared) para cada objeto de clase roedor:
	protected Shared shared = new Shared();
	private Random rand = new Random();
	public Roedor2_base next() {
		switch(rand.nextInt(3)) {
		default:
		case 0: return new Raton2(shared);
		case 1: return new Rata2(shared);
		case 2: return new Jerbo2(shared);			
		}
	}
}

public class CompartirObjeto {
	private static RandomRodent2Generator gen = new RandomRodent2Generator();
	public static void main(String[] args) {
		Roedor2_base[] Roedor2_bases = new Roedor2_base[10];
		for(Roedor2_base r : Roedor2_bases) {
			r = gen.next();
			System.out.println("por ultimo imprimo el toString del objeto --> "+r+"\r\n");
		}	
		gen.shared.showRefcount();		

	}
}