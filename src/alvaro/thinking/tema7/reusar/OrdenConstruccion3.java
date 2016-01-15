package alvaro.thinking.tema7.reusar;

/**
 * Modificar el ejercicio Orden de construccion, para uqe padre e hijo tengan argumentos en el constructor
 *  Escribe un constructor para OrdendeConstruccion3 y realiza la inicialización.
*/
 

class Padre2 { 
	Padre2(char c, int i) { System.out.println("Padre2(char, int)");} 
}

class Hijo2 extends Padre2 { 	
	Hijo2(String s, float f){
		super(' ', 0); //llamada a super por lo de los argumentos
		System.out.println("Hijo2(String, float)");
	} 
}

public class OrdenConstruccion3 extends Padre2 { 
	private char c;
	private int i;
	//2. Se llama a este otro, que llama a padre e hijo.
	Hijo2 b = new Hijo2("hi", 1f);

	OrdenConstruccion3(char a, int j) { 	
		super(a, j); 
		c = a;
		i = j;
	}
	public static void main(String[] args) {
		// 1. Primero se llama al Padre desde esta isntancia de OrdendeConstruccion3.
		// va primero en orden proque esta dentro de un método static y lo static va primero.
		OrdenConstruccion3 c = new OrdenConstruccion3('b', 2); 
	}
}