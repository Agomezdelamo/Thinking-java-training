package alvaro.thinking.tema7.reusar;

/**
 * Este ejercicio demuestra que
 * si el constructor base tiene argumentos, hay que invocar super() con
 * los argumentos, porque el constructor por defecto no sabe que se le va a pasar
 * y se lia.
 * 
 * Si hay argumentos en el constructor, OBLIGATORIO invocar a super lo primero
 * en la clase descendiente.
*/

class Juego {
	Juego(int i) {
		System.out.println("Juego constructor");
	}	
}

class JuegoMesa extends Juego {
	JuegoMesa(int i) {
		// Hay que invocar a la clase base con super porque 
		// tiene argumentos y es obligatoria, si no tuviese no seria necesario.
		super(i); 
		System.out.println("JuegoMesa constructor");
	}
}

public class Ajedrez extends JuegoMesa {
	Ajedrez() {
		super(11);
		System.out.println("Ajedrez constructor");
	}
	public static void main(String[] args) {
		/**
		 * aquí se invoca a ajedrez y empieza a construir desde juego,
		 * gracias a la llamada super por lo de los argumentos.
		 */
		Ajedrez x = new Ajedrez();
	}
}