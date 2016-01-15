package alvaro.thinking.tema5.inicializacion;

//Verify the statements in the previous paragraph.

class Cup {
	Cup(int marker) {
		System.out.println("Cup(" + marker + ")");
	}
	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	/**
	 * esta es una inicialización estatica.
	 * con solo llamar, o a un metodo de uno de los objetos que estan dentro del constructor static,
	 * o a un constructor de uno de esos objetos, todo lo que esta en static se inicializa.
	 * 
	 * Probar descomentando las diferentes llamadas.
	 */
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	
	Cups() {
		System.out.println("Constructor general de Cups()");
	}
}

public class ExplicitStatic {
	public static void main(String[] args) {
		System.out.println("Inside main()");
//		Cups.cup1.f(99); // (1)		
	}
	static Cups cups1 = new Cups(); // (2)
//	static Cups cups2 = new Cups(); // (2)
}