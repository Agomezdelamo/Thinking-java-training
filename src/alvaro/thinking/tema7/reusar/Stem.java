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
class Component1 {
	Component1() { System.out.println("Component1()"); }
}

class Component2 {
	Component2() { System.out.println("Component2()"); }
}

class Component3 {
	Component3() { System.out.println("Component3()"); }
}

class Root { 
	Component1 c1root;
	Component2 c2root;
	Component3 c3root;
	Root() { System.out.println("Root()"); } 
}

class Stem extends Root { 
	Component1 c1stem;
	Component2 c2stem;
	Component3 c3stem;
	Stem() { System.out.println("Stem()"); } 
	public static void main(String[] args) {
		Stem s = new Stem();
	}
}
