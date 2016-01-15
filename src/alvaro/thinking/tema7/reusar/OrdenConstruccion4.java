package alvaro.thinking.tema7.reusar;

/** Crear una clase base con constructor definido con 2 argumentos,
 * y dos clases derivadas una con constructor por defecto y otro con constructor
 * definido y que los dos llamen a la clase base.
*/

class Father { 
	Father(char c, int i) { System.out.println("Father(char, int)");} 
}

public class OrdenConstruccion4 extends Father { 
	private char c;
	private int i;
	OrdenConstruccion4() { 
		super('z', 3);
		System.out.println("SIN ---> OrdenConstruccion4()\r\n"); 
	} 
	OrdenConstruccion4(char a, int j) { 	
		super(a, j); 
		c = a;
		i = j;
		System.out.println("CON ---> OrdenConstruccion4(char,int)\r\n");
	}
	public static void main(String[] args) {
		//Orden llamadas...
		OrdenConstruccion4 ex1 = new OrdenConstruccion4();
		OrdenConstruccion4 ex2 = new OrdenConstruccion4('b', 2); 
	}
}