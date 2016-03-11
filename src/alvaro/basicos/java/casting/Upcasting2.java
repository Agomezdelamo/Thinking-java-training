package alvaro.basicos.java.casting;

/**
 * Añade a upcasting la clase Conservas en Vinagre
 * @author agomez
 *
 */
class Comida {
	Comida() { System.out.println("Comida()"); } 
}

class PanDeMolde {
	PanDeMolde() { System.out.println("PanDeMolde()"); } 
}

class Queso {
	Queso() { System.out.println("Queso()"); } 
}

class Lechuga {
	Lechuga() { System.out.println("Lechuga()"); } 
}

class ConservasVinagre {
	ConservasVinagre() { System.out.println("ConservasVinagre()"); }
}

class Almuerzo extends Comida {
	Almuerzo() { System.out.println("Almuerzo"); } 
}

class AlmuerzoPortatil extends Almuerzo {
	AlmuerzoPortatil() { System.out.println("AlmuerzoPortatil()"); } 
}	

public class Upcasting2 extends AlmuerzoPortatil {
	private PanDeMolde p = new PanDeMolde();
	private Queso q = new Queso();
	private ConservasVinagre cv = new ConservasVinagre();
	private Almuerzo a = new Almuerzo();
	
	//constructor
	public Upcasting2() { System.out.println("Upcasting2()"); }
	public static void main(String[] args) {
		new Upcasting2();
	} 
}