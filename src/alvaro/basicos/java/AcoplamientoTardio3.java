package alvaro.basicos.java;

/**
 * En este ejercicio se muestra que si el método admite la clase base
 * todas las derivadas pasan por el aro porque heredan de ahi,
 * pero siguen siendo ellas mismas como demuestra su atributo name.
 * 
 */
class Cycle2 {
	private String name = "Cycle";
	public static void viajando(Cycle2 c) {
		System.out.println("Cycle.ride() " + c);
	}
	private int wheels = 0;
	public int wheels() { return wheels; }
	public String toString() {
		return this.name;
	}
}

class Unicycle2 extends Cycle2 {
	private String name = "Unicycle";
	private int wheels = 1;
	@Override public int wheels() { return wheels; }
	public String toString() {
		return this.name;
	}	
}

class Bicycle2 extends Cycle2 {
	private String name = "Bicycle";
	private int wheels = 2;
	@Override public int wheels() { return wheels; }
	public String toString() {
		return this.name;
	}	

}

class Tricycle2 extends Cycle2 {
	private String name = "Tricycle";
	private int wheels = 3;
	@Override public int wheels() { return wheels; }
	public String toString() {
		return this.name;
	}	
}

public class AcoplamientoTardio3 {
	public static void paseando2(Cycle2 c) {
		/**
		 * aqui se realiza acomplamiento tardio
		 * Acoplamiento: es la acción de unir la llamada al método con el código que el método tiene dentro.
		 * Tardío: no se produce al compilar, se produce al ejecturar.
		 * 
		 * En este caso el metodo viajando no sabe que objeto le invoca hasta que en tiempo de ejecución
		 * internamente se le dice que objeto es pasandole un código especial.
		 */
		c.viajando(c);
		System.out.println("wheels: " + c.wheels());
	}
	public static void main(String[] args) {
		Unicycle2 u = new Unicycle2();
		Bicycle2 b = new Bicycle2();
		Tricycle2 t = new Tricycle2();
		paseando2(u);
		paseando2(b);
		paseando2(t);		
	}
}
