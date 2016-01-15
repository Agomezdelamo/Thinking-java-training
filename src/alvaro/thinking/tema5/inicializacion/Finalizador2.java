package alvaro.thinking.tema5.inicializacion;


class WebBank2 {
	boolean loggedIn = false;
	WebBank2(boolean logStatus) {
		loggedIn = logStatus;
	}
	void logOut() {
		loggedIn = false;
	}
	protected void finalize() {
		if(loggedIn)
			System.out.println("Error: still logged in");
		// Normally, you'll also call the base-class version:
		// super.finalize(); 
	}
}

public class Finalizador2 {
	public static void main(String[] args) {
		WebBank2 bank1 = new WebBank2(true);
		WebBank2 bank2 = new WebBank2(true);
		new WebBank2(true);
		// Proper cleanup: log out of bank1 before going home:
		bank1.logOut();
		// Olvide deslogarme de bank2 y del banco sin puntero.
		// Intento finalizar cualquier banco perdido:
		
		/**
		 * fuerzo la finalización de cuatro formas distintas.
		 */
		System.out.println("Try 1: "); 
		System.runFinalization();
		System.out.println("Try 2: "); 	
		Runtime.getRuntime().runFinalization();
		System.out.println("Try 3: "); 
		System.gc();
		System.out.println("Try 4: ");
		// using deprecated since 1.1 method:
		System.runFinalizersOnExit(true);		
	}	
}