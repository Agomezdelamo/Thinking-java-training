package alvaro.thinking.tema9.interfaces;

/* Crea una interface de un Ciclo. Implementala con Uniciclo, Biciclo, y Triciclo.
 * 
 * Crea factorias para cada tipo de ciclo y codifica que usan estas factorias.
*/

interface Cycle {
	void ride();
}

/***** INTERFAZ FACTORIA ******/
interface CycleFactory { 
	//metodo que devuelve objeto upcasting a Cyclo.
	Cycle getCycle();
}

class Unicycle implements Cycle { public void ride() { System.out.println("Ride Unicycle"); } }

/*** FACOTRIA UNICICLO ***/
class UnicycleFactory implements CycleFactory { public Cycle getCycle() { return new Unicycle(); } }

class Bicycle implements Cycle { public void ride() { System.out.println("Ride Bicycle"); } }

/*** FACOTRIA BICICLO ***/
class BicycleFactory implements CycleFactory { public Cycle getCycle() { return new Bicycle(); } }

class Tricycle implements Cycle { 
	Tricycle() { System.out.println("primero --- > Tricycle()"); }
	public void ride() { System.out.println("segundo ----> Ride Tricycle"); }
}

/*** FACOTRIA TRICICLO ***/
class TricycleFactory implements CycleFactory { public Cycle getCycle() { return new Tricycle(); } }

public class Ciclos {
	
/**	PATRÓN FACTORIA, en lugar de llamar al constructor, 
 * invocamos un metodo de creacion en un OBJETO FACTORIA, 
 * que une IMPLEMENTACIÓN con INTERFAZ.
 * @param factory
 */
	public static void rideCycle(CycleFactory factory) {
		//construyo patron factoria
		Cycle c = factory.getCycle();
		
		//acoplo el metodo ride a su implementación correspondiente.
		c.ride();
	}
	public static void main(String [] args) {
		rideCycle(new UnicycleFactory());
		rideCycle(new BicycleFactory());
		//siempre primero construye y luego llama a su metodo ride.
		rideCycle(new TricycleFactory());	
	}
}