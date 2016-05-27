package alvaro.basicos.java.excepciones;

//exceptions/Ex2.java
//TIJ4 Chapter Exceptions, Exercise 2, page 452
/* Define an object reference and initialize it to null. Try to call a method
* through this reference. Now wrap the code in a try-catch clause to catch the
* exception.
*/

public class ExceptionNull {
	//defino un integer vacio
	private static Integer i = null; 
	
	public static void main(String[] args) {
		// lleva a NullPointerException:
		// System.out.println(i.toString());
		try {
			System.out.println(i.toString());
		} catch(NullPointerException e) {
			System.err.println("NullPointerException Cogida");
			System.err.println("--------------------------");
			e.printStackTrace();
			System.err.println("--------------------------");
		} 
		
		try {
			i = 10;
			System.out.println("Ahora si puedo hacer el toString porque tiene valor que es "+i.toString());
		} catch(NullPointerException e) {
			System.err.println("NullPointerException Cogida");
			e.printStackTrace();
		} finally {
			System.out.println("Finalizado");
		}
	}	
}