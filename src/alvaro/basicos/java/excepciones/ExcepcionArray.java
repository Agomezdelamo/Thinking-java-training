package alvaro.basicos.java.excepciones;
//exceptions/Ex3.java
//TIJ4 Chapter Exceptions, Exercise 3, page 452
//Write code to generate and catch an ArrayIndexOutOfBoundsException.

public class ExcepcionArray {
	
	private static int[] ia = new int[2];
	
	public static void main(String[] args) {
		try {
			//al intentar acceder a la posición tercera de un array,
			//da una excepcion de indice fuera de los límites
			ia[2] = 3;	
		} catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("ArrayIndexOutOfBoundsException Cogida");
			System.err.println("--------------------------------------");
			e.printStackTrace();
			System.err.println("--------------------------------------");
		} 
	}	
}