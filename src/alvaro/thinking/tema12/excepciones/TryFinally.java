package alvaro.thinking.tema12.excepciones;

//exceptions/Frog17.java
//TIJ4 Chapter Exceptions, Exercise 17, page 477
/* Modify pholymorphism/Frog.java so that it uses try-finally to 
* guarantee proper cleanup, and show that this works even if you
* return from the middle of the try-finally.
*/

//CLASES PARA LOS 2 CAMPOS DE UN SER VIVO//
class Characteristic {
	private String s;
	Characteristic(String s) {
		this.s = s;
		System.out.println("Creando caracteristica " + s);
	}
	protected void acabar() {
		System.out.println("acabando caracteristica " + s);
	}
}

class Description {
	private String s;
	Description(String s) {
		this.s = s;
		System.out.println("Creando Description " + s);
	}
	protected void acabar() {
		System.out.println("acabando Description " + s);
	}
}
//CLASES PARA LOS 2 CAMPOS DE UN SER VIVO//




//HERENCIA//
class LivingCreature {
	private Characteristic p = new Characteristic("esta viva");
	private Description t = new Description("Criatura viva básica");
	LivingCreature() {
		System.out.println("LIVINGCREATURE()");
	}		
	protected void acabar() {
		System.out.println("CRIATURA VIVA acabar");
		t.acabar();
		p.acabar();
	}
}

class Animal extends LivingCreature {
	private Characteristic p = new Characteristic("Tiene corazón");
	private Description t = new Description("Animal no vegetal");
	Animal() { System.out.println("ANIMAL()"); }
	protected void acabar() {
		System.out.println("ANIMAL acabar");
		t.acabar();
		p.acabar();
		super.acabar();
	}
}

class Amphibian extends Animal {
	private Characteristic p = new Characteristic("puede vivir en el agua");
	private Description t = new Description("Agua y tierra.");
	Amphibian() { System.out.println("AMPHIBIAN()"); }
	protected void acabar() {
		System.out.println("AMPHIBIAN acabar");
		t.acabar();
		p.acabar();
		super.acabar();
	}
}
//HERENCIA//


public class TryFinally extends Amphibian {
	private Characteristic p = new Characteristic("Croa");
	private Description t = new Description("Come insectos");
	
	public TryFinally() { System.out.println("TRYFINALLY() crear rana"); }
	
	public static void jump() { System.out.println("rana salta"); }
	
	protected void acabar() {
		System.out.println("TRYFINALLY() acabar rana");
		t.acabar();
		p.acabar();
		super.acabar();
	}
	////////////////////
	//MÉTODO PRINCIPAL//
	////////////////////
	public static void main(String[] args) {
		System.out.println("CREAMOS UNA RANA Y ESO LLAMA A LOS CONSTRUCTORES PATERNOS");
		System.out.println("----------------------------------------------------------");
		TryFinally frog = new TryFinally();
		try {
			System.out.println("");
			System.out.println("BLOQUE TRY");
			frog.jump();
			System.out.println("Saliendo del try-finally");
			return;			
		} finally {
			System.out.println("");
			System.out.println("BLOQUE FINALLY");
			System.out.println("finalmente Bye!");
			
			System.out.println("");
			System.out.println("ACABAMOS CON LOS OBJETOS EN ORDEN INVERSO");
			frog.acabar();
		}
	}
}