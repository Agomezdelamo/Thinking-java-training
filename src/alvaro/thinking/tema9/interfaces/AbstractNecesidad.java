package alvaro.thinking.tema9.interfaces;

/**
 * Crear una clase abstracta sin metodos.
 * Deriva una clase con un método.
 * (1) Crea un método statico que haga referencia a la clase base, haz downcasting en el hacia la derivada,
 *	   y llama al método. En main() demuestra que funciona.
 *	
 * (2) Ahora pon una declaracion abstracta en la clase base, eso elimina la necesidad de hacer downcasting.
 * 
 */ 

abstract class Dad1 {}

class Son1 extends Dad1 { protected void print() { System.out.println("Son1"); } }

/* si el método es abstracto en origen, no es necesario hacer
 * downcasting para usarlo, porque el padre también lo tiene.*/
abstract class SecondDad { abstract protected void print(); }

class SecondSon extends SecondDad {	protected void print() { System.out.println("SecondSon"); } }


public class AbstractNecesidad {
	public static void testPrint(Dad1 d) { ((Son1)d).print(); }
	public static void secondTestPrint(SecondDad sd) { sd.print(); }
	
	public static void main(String[] args) {
		Son1 s1 = new Son1();
		AbstractNecesidad.testPrint(s1); //(1)
		
		SecondSon ss = new SecondSon();
		AbstractNecesidad.secondTestPrint(ss);//(2)			
	}
}