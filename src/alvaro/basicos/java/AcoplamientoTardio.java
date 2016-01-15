package alvaro.basicos.java;

import alvaro.thinking.tema8.polimorfismo.RandomShapeGenerator;
import alvaro.thinking.tema8.polimorfismo.Shape;

public class AcoplamientoTardio {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		//Array de 10 posiciones del tipo génerico formas.
		Shape[] s = new Shape[10];
		
		// Rellenamos cada posición con un puntero a un objeto:
		for(int i = 0; i < s.length; i++)
			s[i] = gen.next();//como next es un case con un número random, no hay forma de saber que objeto es hasta que se ejecuta.
		// llamada polimorfica a un método:
		for(Shape shp : s)
			/**
			 * Acoplamiento tardío, no sabemos que tipo de forma llama a draw, hasta el tiempo de ejecución.
			 * En el tiempo de ejecución, se realiza el acomplamiento (unir llamada al método con su codigo interior)
			 * tardío porque en la compilación esto no se hace, se pospone, y sólo por detrás en la ejecución el sistema
			 * sabe que objeto es el que llama a ese método y acopla tardiamente su código correspondiente.
			 */
			shp.draw();	
	}
}