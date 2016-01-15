package alvaro.thinking.tema8.polimorfismo;

//polymorphism/ReferenceCounting13.java
//TIJ4 Chapter Polymorphism, Exercise 13, page 300
/** Añade un metodo finalize() a ContandoReferencias y verifica la condicion de
 * terminación.
 */

class Compartido {
	private int refcount = 0;
	private static long counter = 0;
	private final long id = counter++;
	
	public Compartido() {
		System.out.println("Creando ---> " + this);
	}
	
	public void addRef() { refcount++; }
	
	protected void finalize() {
		//una referencia
		if(refcount > 0 && refcount < 2)
			System.out.println("Error: No puedes matar este objeto "+this+" porque existe " + refcount + " objeto vivo que hace referencia a el" );
		//mas de una referencia
		if(refcount > 1)
			System.out.println("Error: No puedes matar este objeto "+this+" porque existen " + refcount + " objetos vivos que hacen referencia a el" );
	}
	protected void dispose() {
		//aqui cada vez que borro un compuesto resto un contador de referencias
		if(--refcount == 0)
			System.out.println("Destruyendo " + this);
	}
	public String toString() { return "Compartido con id: " + id; }

	public int getRefcount() {
		return refcount;
	}

	public void setRefcount(int refcount) {
		this.refcount = refcount;
	}
}


class Compuesto {
	private Compartido Compartido;
	private static long counter = 0;
	private final long id = counter++;
	
	public Compuesto(Compartido Compartido) {
		System.out.print("Creando ---> " + this);
		this.Compartido = Compartido;
		this.Compartido.addRef();
		System.out.println(" con " + this.Compartido.getRefcount()+" referencias a el");
	}
	
	protected void dispose() {
		System.out.println("Destruyendo " + this);
		Compartido.dispose();
	}
	public String toString() { return "COMPUESTO CON ID"
			+ ": " + id; }
}

public class ContandoReferencias {
	public static void main(String[] args) {
		/*creo compartido 0*/
		Compartido CompartidoInit = new Compartido();
		
		/*Creo los compuestos, les paso como referencia el compartido inicial*/
		Compuesto[] Compuestos = { new Compuesto(CompartidoInit),
			new Compuesto(CompartidoInit), new Compuesto(CompartidoInit),
			new Compuesto(CompartidoInit), new Compuesto(CompartidoInit)			
		};
		
		/*itero sobre el array de compuestos y los destruyo*/
		for(Compuesto c : Compuestos)
			c.dispose();
		
		Compuesto compTest = new Compuesto(CompartidoInit);
		Compuesto compTest2 = new Compuesto(CompartidoInit);
		// Test finalize():
		CompartidoInit.finalize();
		
		Compartido CompartidoTest = new Compartido();
		Compuesto CompuestoTest3 = new Compuesto(CompartidoTest);
		// Test CompartidoTest finalize():
		CompartidoTest.finalize();
	}
}

