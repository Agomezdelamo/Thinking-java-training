package alvaro.basicos.java;

import alvaro.thinking.tema8.polimorfismo.RandomShapeGenerator;
import alvaro.thinking.tema8.polimorfismo.Shape;

public class AcoplamientoTardio {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		//Array de 10 posiciones del tipo g�nerico formas.
		Shape[] s = new Shape[10];
		
		// Rellenamos cada posici�n con un puntero a un objeto:
		for(int i = 0; i < s.length; i++)
			s[i] = gen.next();//como next es un case con un n�mero random, no hay forma de saber que objeto es hasta que se ejecuta.
		// llamada polimorfica a un m�todo:
		for(Shape shp : s)
			/**
			 * Acoplamiento tard�o, no sabemos que tipo de forma llama a draw, hasta el tiempo de ejecuci�n.
			 * En el tiempo de ejecuci�n, se realiza el acomplamiento (unir llamada al m�todo con su codigo interior)
			 * tard�o porque en la compilaci�n esto no se hace, se pospone, y s�lo por detr�s en la ejecuci�n el sistema
			 * sabe que objeto es el que llama a ese m�todo y acopla tardiamente su c�digo correspondiente.
			 */
			shp.draw();	
	}
}