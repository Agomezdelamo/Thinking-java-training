package alvaro.basicos.java.herencia;

/**
 * Demuestre que los constructores de la clase A, se invocan siempre
 * y los de B antes que las clases derivadas.
 */

class A { A(){ System.out.println("A()");} }

class B extends A { B(){ System.out.println("B()");} }

class C extends B { C(){ System.out.println("C()");} }

class D extends C {
	D() { System.out.println("D()"); }
	public static D makeD() { return new D(); }
	public static void main(String[] args) {
		//Construyo D, pero primero se construye el abuelo A, 
		//el padre B, y el hijo C, y por ultimo el nieto D.
		System.out.println("\r\nconstrucción desde d con instancia");
		D d = new D();
		System.out.println("\r\nconstrucción desde d con método");
		//aqui pasa exactamente lo mismo pero construyendo desde un método.
		D d2 = makeD();
	}
}

public class OrdenDeConstruccion extends D {
	OrdenDeConstruccion() { System.out.println("E orden de construccion()"); } 
	public static void main(String[] args) {
		//aqui lo mismo, el primero que se construye siempre es la base.
		OrdenDeConstruccion e = new OrdenDeConstruccion();
		// test D:
		D.main(args);
	}
}