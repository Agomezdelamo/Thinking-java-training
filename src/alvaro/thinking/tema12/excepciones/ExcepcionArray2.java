package alvaro.thinking.tema12.excepciones;

//exceptions/Ex5.java
//TIJ4 Chapter Exceptions, Exercise 5, page 452
/* Create you own resumption-like behavior using a while loop that repeats
* until an exception is no longer thrown.
*/

public class ExcepcionArray2 {
	private static int[] ia = new int[2];
	static int x = 5;
	
	public static void main(String[] args) {
		//este while se va a producir siempre hasta que salte por los aires un break.
		while(true) {
			try {
				System.out.println("El valor de x ahora es "+x+" y el tamaño del array es "+ia.length);
				//pruebo a meter en la posición x un valor, como x empieza en 5, da excepción y no  saldre hasta que x sea 1
				ia[x] = 1;
				//este syso produce la excepción, no puedes imprimir un array fuera de sus límites
				System.out.println(ia[x]);
				//cuando el bucle haya podido imprimir salta el break.
				break;	
			} catch(ArrayIndexOutOfBoundsException e) {
				System.err.println("ArrayIndexOutOfBoundsException cogida");
					e.printStackTrace();
					System.err.println("-----------------------------------");
				//voy restando a x hasta que el tamaño sea igual a x
				x--;
			} finally {
				System.out.println("Hemos terminado ya?");		
			}
		}
		System.out.println("Ahora hemos terminado de verdad.");
	}	
}