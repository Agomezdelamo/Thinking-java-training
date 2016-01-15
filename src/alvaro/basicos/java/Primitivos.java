package alvaro.basicos.java;

/**
 * la diferencia entre primitivos y objetos.
 * los objetos trabajan con punteros a objetos, y los primitivos con espacios de memoria.
 * 
 * un primitivo siempre va a tener el valor que se le asigna en ese momento, no cambia, mientras
 * que si un puntero apunta a un objeto y luego a otro puede ver variado su valor.
 * @author agomez
 *
 */
public class Primitivos {
	public static void main(String[] args) {
	//	Primitivas, el valor ocupa un sólo lugar en memoria, una vez lo cambias 
		System.out.println("PRIMITIVOS--------------------");
		int a = 1;
		System.out.println("a antes ----> "+a);
		int b = 2;
		System.out.println("b antes ----> "+b);
		b = a;
		System.out.println("b = a original que era 1");

		a = 3;
		System.out.println("a después --> "+a);
		System.out.println("b --> "+b+" igual al ultimo valor que se le dio, que era lo que valia a en ese momento, un uno,\r\nahora vale 3 pero no le afecta porque se graba una sola vez en memoria.");

		
	//	al ser Primitivas cada variable tiene su propio valor.
		class Clase {
			private int i;
			public Clase(int i) { this.i = i;}
			public int imprime() {
				return i;
			}
		}
		System.out.println("\r\nOBJETOS	--------------------");

	//	Referencia
		Clase c,d;
		c = new Clase(1);
		System.out.println("c antes apunta a objeto c ------> "+c.imprime());
		d = new Clase(2);
		System.out.println("d antes  apunta a objeto d -----> "+d.imprime());
		d=c;
		System.out.println("d apunta a objeto c ");
		System.out.println("c después ----> "+c.imprime());
		System.out.println("d después ----> "+d.imprime());

		
		d.i=133;
		System.out.println("d.i = 133 ");
		System.out.println("c.i después ----> "+c.imprime());
		System.out.println("d.i después ----> "+d.imprime());
	//	al ser de Referencia cada variable apunta al mismo valor.
	}
}
