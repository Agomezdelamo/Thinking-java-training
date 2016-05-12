package alvaro.thinking.tema11.colecciones;

//holding/Roedor10.java
//TIJ4 Chapter Holding, Exercise 10, page 409
/* Change Exercise 9 in the Polymorphism chapter to use an ArrayList to
* hold the Roedors and an Iterator to move through the sequence of 
* Roedors.
*/
import java.util.*;

class RandomRoedorGenerator {
	private Random rand = new Random();
	public Roedor next() {
		switch(rand.nextInt(3)) {
			default:
			case 0: return new Raton();
			case 1: return new Rata();
			case 2: return new Ardilla();			
		}
	}
}

class Roedor {
	private String nombre = "Roedor";
	protected void come() { System.out.println("Roedor.come()"); }
	protected void corre() { System.out.println("Roedor.corre()"); }
	protected void duerme() { System.out.println("Roedor.duerme()\r\n"); }
	public String toString() { return nombre; }
}

class Raton extends Roedor {
	private String nombre = "Raton";
	protected void come() { System.out.println("Raton.come()"); }
	protected void corre() { System.out.println("Raton.corre()"); }
	protected void duerme() { System.out.println("Raton.duerme()\r\n"); }
	public String toString() { return nombre; }
}

class Rata extends Roedor {
	private String nombre = "Rata";
	protected void come() { System.out.println("Rata.come()"); }
	protected void corre() { System.out.println("Rata.corre()"); }
	protected void duerme() { System.out.println("Rata.duerme()\r\n"); }
	public String toString() { return nombre; }
}

class Ardilla extends Roedor {
	private String nombre = "Ardilla";
	protected void come() { System.out.println("Ardilla.come()"); }
	protected void corre() { System.out.println("Ardilla.corre()"); }
	protected void duerme() { System.out.println("Ardilla.duerme()\r\n"); }
	public String toString() { return nombre; }
}

public class RoedorIterador {
	private static RandomRoedorGenerator gen = 
		new RandomRoedorGenerator();
	
	public static void main(String[] args) {
		
		List<Roedor> rodentList = new ArrayList<Roedor>(); //lista de roedores
		
		for(int i = 0; i < 10; i++)
			rodentList.add(gen.next()); //añado a roden list por cada iteracción un roedor aleatorio
		
		Iterator<Roedor> it = rodentList.iterator(); //iterador de roedores
		while(it.hasNext()) { //mientras haya uno más en el iterador.
			Roedor r = it.next();
			System.out.println(r + ": "); //lo pinto y ejecuto sus métodos
			r.come();
			r.corre();
			r.duerme();
		}
	}
}


