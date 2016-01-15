package alvaro.thinking.tema7.reusar;

/**
 * Crea una clase llamada anfibio. Desde ella, hereda una clase llamada Rana. 
* Pon los m�todos apropiados en la clase base.
* En main(), crea una rana y haz upcasting(generalizaci�n) a Anfibio, y demuestra que todos los m�todos funcionan.
*/
//UPCASTING, PROYECCION HACIA ARRIBA.
class Anfibio2 {
	protected void swim() {
		System.out.println("Anfibio swim");		
	}
	protected void speak() {
		System.out.println("Anfibio speak");
	}
	void eat() {
		System.out.println("Anfibio eat");
	}
	static void grow(Anfibio2 a) {
		System.out.println("Anfibio grow\r\n");
		a.eat();
	}
}

public class Rana2 extends Anfibio2 {
	@Override protected void swim() {
		System.out.println("Frog swim");		
	}
	@Override protected void speak() {
		System.out.println("Frog speak");
	}
	@Override void eat() {
		System.out.println("Frog eat");
	}
	static void grow(Anfibio2 a) {
		System.out.println("Frog grow");
		a.eat();
	}
	
	
	public static void main(String[] args) {
		Rana2 r = new Rana2();
		// llamo a los m�todos de la clase base.
		r.swim();
		r.speak();
		r.eat();
		// upcasting o proyecci�n hacia arriba de rana a anfibio via argumento.
		//llama a grow de anfibio pero a eat() de rana2
		//porque ese m�todo esta sobreescrito en rana y se esta llamando desde rana.
		Anfibio2.grow(r);
	}
}