package alvaro.thinking.tema7.reusar;

/**
 * Crea una clase llamada anfibio. Desde ella, hereda una clase llamada Rana. 
* Pon los métodos apropiados en la clase base.
* En main(), crea una rana y haz upcasting(generalización) a Anfibio, y demuestra que todos los métodos funcionan.
*/
//UPCASTING, PROYECCION HACIA ARRIBA.
class Anfibio {
	protected void swim() {
		System.out.println("Anfibio swim");		
	}
	protected void speak() {
		System.out.println("Anfibio speak");
	}
	void eat() {
		System.out.println("Anfibio eat");
	}
	static void grow(Anfibio a) {
		System.out.println("Anfibio grow\r\n");
		a.eat();
	}
}

public class Rana extends Anfibio {
	public static void main(String[] args) {
		Rana r = new Rana();
		// llamo a los métodos de la clase base.
		r.swim();
		r.speak();
		r.eat();
		// upcasting o proyección hacia arriba de rana a anfibio via argumento.
		Anfibio.grow(r);
	}
}