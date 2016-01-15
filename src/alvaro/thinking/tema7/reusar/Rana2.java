package alvaro.thinking.tema7.reusar;

/**
 * Crea una clase llamada anfibio. Desde ella, hereda una clase llamada Rana. 
* Pon los métodos apropiados en la clase base.
* En main(), crea una rana y haz upcasting(generalización) a Anfibio, y demuestra que todos los métodos funcionan.
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
		// llamo a los métodos de la clase base.
		r.swim();
		r.speak();
		r.eat();
		// upcasting o proyección hacia arriba de rana a anfibio via argumento.
		//llama a grow de anfibio pero a eat() de rana2
		//porque ese método esta sobreescrito en rana y se esta llamando desde rana.
		Anfibio2.grow(r);
	}
}