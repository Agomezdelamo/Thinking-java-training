package alvaro.thinking.tema5.inicializacion;

class WebBank {
	boolean loggedIn = false;
	WebBank(boolean logStatus) {
		loggedIn = logStatus;
	}
	void logIn() {
		loggedIn = true;
	}
	void logOut() {
		loggedIn = false;
	}
	protected void finalize() {
		if(loggedIn)
			System.out.println("Error: aun hay alguien logado");
//		deberia llamar a super finalize pero para eso hay que tener controladas las excepciones que se pueden lanzar.
//			super.finalize();
	}
}

public class Finalizador1 {
	public static void main(String[] args) {
		WebBank bank1 = new WebBank(true);
		WebBank bank2 = new WebBank(true);
		// la manera correcta de deslogarme.
		bank1.logOut();
		// le estoy diciendo que estoy logado a un nuevo webbank y ademas
		// es un objeto sin puntero, por lo que se cumple la condición especial
		// para que pase por finalize y por mi condición para que 
		// el recolector de basura vaya primero a por este.
		new WebBank(true);
		/**
		 * Fuerzo la llamada al
		 * recolector de basura garbage collection
		 * */
		System.gc();
	}	
}