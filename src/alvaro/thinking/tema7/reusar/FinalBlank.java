package alvaro.thinking.tema7.reusar;

/**
 * Crear una clase con un puntero final y en blanco.
 * 
 * Realiza la inicialización dentro del constructor.
 * 
 * Demuestre que se garantiza que el final estara inicializado antes de usarlo
 * y que no se puede modificar una vez inicializado.
*/

class Poppet {
	private int i;
	Poppet(int k) { i = k; }
	public String toString() { 
		return ("Poppet " + i); 
	}
}


//también se pueden pasar argumentos a un método como final, de esa manera te aseguras que
//nunca pueden reasignar o reapuntar ese puntero dentro del método en caso de ser una clase,
//o modificar el valor en caso de ser un primitivo.
public class FinalBlank {
	private final Poppet p; // Referencia final en blanco.
	
	// Las referencias en blanco deben ser inicializadas en el constructor.
	public FinalBlank() {
		p = new Poppet(1); // Se inicializa la referencia final.
	}
	public FinalBlank(int x) {
		p = new Poppet(x); // Se inicializa la referencia final.
	}
	public static void main(String[] args) {
		FinalBlank b1 = new FinalBlank();
		FinalBlank b2 = new FinalBlank(47);
//		 b1.p = new Poppet(2); // Errors: cannot assign values 
//		 b2.p = new Poppet(3); // to final variables p
		System.out.println("b1.p: " + b1.p);
		System.out.println("b2.p: " + b2.p);
	}
}