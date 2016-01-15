package alvaro.thinking.tema7.reusar;

/**
 * Crear una clase llamada root que contenga una instancia de cada una de las
 * clases llamadas, component1, component2 y component3.
 * 
 * Hereda root desde una clase llamada stem que contenga una instancia de cada
 * componente.
 * Todas las clases deben tener constructores por defecto que impriman su nombre.
 */

//s.t.e.m. Science technology engineering and mathematics
class Component12 {
	Component12(byte b) { System.out.println("Component12(byte)"); }
}

class Component22 {
	Component22(short s) { System.out.println("Component22(short)"); }
}

class Component32 {
	Component32(int i) { System.out.println("Component32(int)"); }
}

class Root2 { 
	Component12 c1root;
	Component22 c2root;
	Component32 c3root;
	Root2(float f) { //1.
		c1root = new Component12((byte)0);
		c2root = new Component22((short)0);
		c3root = new Component32(0);
		System.out.println("Root2(foat)\r\n"); 
	} 
}

class Stem2 extends Root2 { 
	Component12 c1stem2;
	Component22 c2stem2;
	Component32 c3stem2;
	Stem2(double d) { //2.
		super(2.78f);
		c1stem2 = new Component12((byte)1);
		c2stem2 = new Component22((short)1);
		c3stem2 = new Component32(1);
		System.out.println("Stem2(double)\r\n"); 
	} 
	public static void main(String[] args) {
		/**
		 * primero se ejecuta el padre Root2 y todo lo que tiene en su constructor, 3 instancias.
		 * luego Stem2 con sus 3 instancias.
		 */
		Stem2 x = new Stem2(2.78);
	}
}