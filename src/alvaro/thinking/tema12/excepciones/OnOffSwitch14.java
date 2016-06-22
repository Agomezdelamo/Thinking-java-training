package alvaro.thinking.tema12.excepciones;

//exceptions/OnOffSwitch14.java
//TIJ4 Chapter Exceptions, Exercise 14, page 476
//Show that the OnOffSwitch.java can fail by throwing a
//RuntimeException inside the try block.

public class OnOffSwitch14 {
	private static Switch sw = new Switch();
	//genero un array con tamaño de una posición y con valor nulo
	static Integer[] x = new Integer[1];
	
	public static void f(int i) throws OnOffException1, OnOffException2 {};
	
	public static void main(String[] args) {
		try {
			sw.on();
			// El código lanza una runtimeException, porque paso en tiempo de ejecución
			//el valor de la primera posición del array de x, y ese valor es un null
			// y deja el switch on:
			f(x[0]);
			sw.off();
		} catch(OnOffException1 e) {
			System.out.println("OnOffException1");
			sw.off();
		} catch(OnOffException2 e) {
			System.out.println("OnOffException2");
			sw.off();
		} 
	}		
} 
