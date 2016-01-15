package alvaro.thinking.tema8.polimorfismo;

/**
 * En este ejercicio se muestra que si el m�todo admite la clase base
 * todas las derivadas pasan por el aro porque heredan de ahi,
 * pero siguen siendo ellas mismas como demuestra su atributo name.
 * 
 */
class Cycle {
	private String name = "Cycle";
	public static void viajando(Cycle c) {
		System.out.println("Cycle.ride() " + c);
	}
	public String toString() {
		return this.name;
	}
}

class Unicycle extends Cycle {
	private String name = "Unicycle";
	public String toString() {
		return this.name;
	}	
}

class Bicycle extends Cycle {
	private String name = "Bicycle";
	public String toString() {
		return this.name;
	}	

}

class Tricycle extends Cycle {
	private String name = "Tricycle";
	public String toString() {
		return this.name;
	}	
}

public class Pedaleando {
	public static void paseando(Cycle c) {
		/**
		 * aqui se realiza acomplamiento tardio
		 * Acoplamiento: es la acci�n de unir la llamada al m�todo con el c�digo que el m�todo tiene dentro.
		 * Tard�o: no se produce al compilar, se produce al ejecturar.
		 * 
		 * En este caso el metodo viajando no sabe que objeto le invoca hasta que en tiempo de ejecuci�n
		 * internamente se le dice que objeto es pasandole un c�digo especial.
		 */
		c.viajando(c);
	}
	public static void main(String[] args) {
		Unicycle u = new Unicycle();
		Bicycle b = new Bicycle();
		Tricycle t = new Tricycle();
		paseando(u);
		paseando(b);
		paseando(t);		
	}
}
