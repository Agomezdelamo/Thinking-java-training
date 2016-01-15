package alvaro.basicos.java;


/* 
* Haz los métodos de rodent abstract siempre que sea posible
*/

/**
 * una clase abstracta:
 * 
 * 1. Es obligatoriamente abstracta con sólo un método que tenga abstracto.
 * 2. No se puede instanciar,
 * 3. Cada clase que la herede debe implementar todos sus métodos abstractos.
 * @author agomez
 *
 */
abstract class Rodent {
	private String name = "Rodent";
	abstract protected void eat(); 
	abstract protected void run(); 
	abstract protected void sleep();
	abstract public String toString(); 
}

class Mouse extends Rodent {
	private String name = "Mouse";
	protected void eat() { System.out.println("Mouse.eat()"); }
	protected void run() { System.out.println("Mouse.run()"); }
	protected void sleep() { System.out.println("Mouse.sleep()"); }
	public String toString() { return name; }
}

class Rat extends Rodent {
	private String name = "Rat";
	protected void eat() { System.out.println("Rat.eat()"); }
	protected void run() { System.out.println("Rat.run()"); }
	protected void sleep() { System.out.println("Rat.sleep()"); }
	public String toString() { return name; }
}

class Squirrel extends Rodent {
	private String name = "Squirrel";
	protected void eat() { System.out.println("Squirrel.eat()"); }
	protected void run() { System.out.println("Squirrel.run()"); }
	protected void sleep() { System.out.println("Squirrel.sleep()"); }
	public String toString() { return name; }
}

public class Abstract1 {
	private static AbstractRandomGenerator1 gen = new AbstractRandomGenerator1();
	public static void main(String[] args) {
		// Error: No puedes instanciar una abstract class:
		// Rodent x = new Rodent();
		// Pero si puedes crear un Array[] para hacer un downcast al objeto derivado.
		Rodent[] rodents = new Rodent[10];
		byte index = 0;
		
		System.out.println("Pintamos el array de objetos derivados de Rodent");
		//itero por el array.
		for(Rodent r : rodents) {
			index++;
			
			//método que devuelve una instancia de un objeto aleatoria entre los 3
			//que heredan de rodent.
			r = gen.next();
			System.out.println(r + ": ");
			r.eat();
			r.run();
			r.sleep();			
			System.out.println("-----------------"+index);
		}		
	}
}