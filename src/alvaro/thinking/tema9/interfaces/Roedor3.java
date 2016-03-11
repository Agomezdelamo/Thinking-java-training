package alvaro.thinking.tema9.interfaces;

/* 
* Haz los métodos de Roedor abstract siempre que sea posible
*/

/**RONDENT - ROEDOR
 * una clase abstracta:
 * 
 * 1. Es obligatoriamente abstracta con sólo un método que tenga abstracto.
 * 2. No se puede instanciar,
 * 3. Cada clase que la herede debe implementar todos sus métodos abstractos.
 * @author agomez
 *
 */
abstract class Roedor {
	private String name = "Roedor";
	abstract protected void eat(); 
	abstract protected void run(); 
	abstract protected void sleep();
	abstract public String toString(); 
}

class Raton extends Roedor {
	private String name = "Raton";
	protected void eat() { System.out.println("Raton.eat()"); }
	protected void run() { System.out.println("Raton.run()"); }
	protected void sleep() { System.out.println("Raton.sleep()"); }
	public String toString() { return name; }
}

class Rata extends Roedor {
	private String name = "Rata";
	protected void eat() { System.out.println("Rata.eat()"); }
	protected void run() { System.out.println("Rata.run()"); }
	protected void sleep() { System.out.println("Rata.sleep()"); }
	public String toString() { return name; }
}

class Jerbo extends Roedor {
	private String name = "Jerbo";
	protected void eat() { System.out.println("Jerbo.eat()"); }
	protected void run() { System.out.println("Jerbo.run()"); }
	protected void sleep() { System.out.println("Jerbo.sleep()"); }
	public String toString() { return name; }
}

public class Roedor3 {
	private static RandomRoedorGenerator1 gen = new RandomRoedorGenerator1();
	public static void main(String[] args) {
		// Error: No puedes instanciar una abstract class:
		// Roedor x = new Roedor();
		// Pero si puedes crear un Array[] para hacer un downcast al objeto derivado.
		Roedor[] Roedors = new Roedor[10];
		byte index = 0;
		
		System.out.println("Pintamos el array de objetos derivados de Roedor");
		//itero por el array.
		for(Roedor r : Roedors) {
			index++;
			
			//método que devuelve una instancia de un objeto aleatoria entre los 3
			//que heredan de Roedor.
			r = gen.next();
			System.out.println(r + ": ");
			r.eat();
			r.run();
			r.sleep();			
			System.out.println("-----------------"+index);
		}		
	}
}