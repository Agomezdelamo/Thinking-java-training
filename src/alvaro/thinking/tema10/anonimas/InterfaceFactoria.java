package alvaro.thinking.tema10.anonimas;

//innerclasses/Cycles.java
//TIJ4 Chapter Innerclasses, Exercise 16, page 364

interface Cycle {
	void ride();
}

interface CycleFactory {
	Cycle getCycle();
}

class Unicycle implements Cycle {
	private Unicycle() { System.out.println("Unicycle()"); }
	public void ride() { System.out.println("Ride Unicycle"); }
	public static CycleFactory factory =
		new CycleFactory() { // instancio un interface Factoria y lo devuelvo en un campo de la clase.
			public Cycle getCycle() { return new Unicycle(); }
		};
}

class Bicycle implements Cycle {
	private Bicycle() { System.out.println("Bicycle()"); }
	public void ride() { System.out.println("Ride Bicycle"); }
	public static CycleFactory factory =
		new CycleFactory() { // instancio un interface Factoria y lo devuelvo en un campo de la clase.
			public Cycle getCycle() { return new Bicycle(); }
		};
}

class Tricycle implements Cycle {
	private Tricycle() { System.out.println("Tricycle()"); }
	public void ride() { System.out.println("Ride Tricycle"); }
	public static CycleFactory factory =
		new CycleFactory() { // instancio un interface Factoria y lo devuelvo en un campo de la clase.
			public Cycle getCycle() { return new Tricycle(); }
		}; 
}

public class InterfaceFactoria {
	public static void rideCycle(CycleFactory factory) {//recibe un interface factoria
		Cycle c = factory.getCycle();//con la factoria obtengo el hijo de cycle.
		c.ride(); //conduzco.
	}
	public static void main(String [] args) {
		rideCycle(Unicycle.factory);//al llamar a la propiedad static factory
									//ya estoy creando un objeto interface factory
									//que devuelve un objeto del tipo esperado.
		rideCycle(Bicycle.factory);
		rideCycle(Tricycle.factory);	
	}
}