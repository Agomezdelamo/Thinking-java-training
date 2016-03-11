package alvaro.thinking.tema10.anonimas;

/**
 * Crear una clase con una clase interna. 
 * En una clase separada hacer una instancia de la clase interna.
*/

class Outer {
	class Inner { 
		Inner() { System.out.println("Outer.Inner()"); } 
	}	
}


public class OtherOuter { 
	public static void main(String[] args) {
		// primero crea un objeto de una clase externa:
		Outer o = new Outer();
		// entonces crea un objeto de su clase interna:
		Outer.Inner oi = o.new Inner();			
	}
}