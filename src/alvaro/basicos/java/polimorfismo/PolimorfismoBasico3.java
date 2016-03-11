package alvaro.basicos.java.polimorfismo;

class Cycle1 {
	private String name = "Cycle1";
	public static void travel(Cycle1 c) {
		System.out.println("Cycle1.ride() " + c);
	}
	public String toString() {
		return this.name;
	}
}

class UniCycle1 extends Cycle1 {
	private String name = "UniCycle1";
	public void balance() { System.out.println("Balance UniCycle1"); }
	public String toString() {
		return this.name;
	}	
}

class BiCycle1 extends Cycle1 {
	private String name = "BiCycle1";
	public void balance() { System.out.println("Balance BiCycle1"); }
	public String toString() {
		return this.name;
	}	

}

class TriCycle1 extends Cycle1 {
	private String name = "TriCycle1";
	public String toString() {
		return this.name;
	}	
}

public class PolimorfismoBasico3 {
	public static void main(String[] args) {
		Cycle1[] ride = {
			new UniCycle1(),
			new BiCycle1(),
			new TriCycle1(),
		};
		// error en tiempo de compilacion: pese a que es un método de sus hijos 
		// no puede encontrar balance() en el puntero ride de clase Cycle1:
		
		// for(Cycle1 c : ride) {
		//	c.balance();
		// }
		
		//necesito especificar manualmente que hijo posee ese método balance al compilador.
		((UniCycle1)ride[0]).balance();
		((BiCycle1)ride[1]).balance();
		
		// Compile time error: no balance() in TriCycle1:
		// ((TriCycle1)ride[2]).balance();
		
		// RTTI: ClassCastException: TriCycle1 cannot be cast to BiCycle1:
		// ((BiCycle1)ride[2]).balance();	
	}
}
