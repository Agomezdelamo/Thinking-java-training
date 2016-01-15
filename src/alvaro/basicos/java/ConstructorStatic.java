package alvaro.basicos.java;


class Cup {
	Cup(int marker) {
		System.out.println("Cup(" + marker + ")");
	}
	void f(int marker) {
		System.out.println("f(" + marker + ")");
	}
}
/**
 * Un constructor estático nos da la ventaja de que en la primera llamada a cualquier cosa
 * que este dentro de ese constructor, va a instanciar e inicializar todo lo que este ahí dentro.
 * 
 * Es una manera de que algún tipo de objeto u información común para toda la aplicación, se 
 * arranque una sola vez y este disponible para toda la aplicación.
 * @author agomez
 *
 */
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
		System.out.println("INICIO STATIC: \r\n");
		cup1 = new Cup(1);
		cup2 = new Cup(2);
		System.out.println("\r\nFIN STATIC: \r\nsoy el constructor static, y ahora que estoy llamado,\r\ntodo lo que esta dentro de mi, esta inicializado y disponible\r\n");
	}
	
	Cups() {
		System.out.println("Constructor general de Cups()");
	}
}

public class ConstructorStatic {
	public static void main(String[] args) {
		System.out.println("Dentro del método main()");
//		Cups.cup1.f(99); // (1)		
	}
	static Cups cups1 = new Cups(); // (2)
//	static Cups cups2 = new Cups(); // (2)
}