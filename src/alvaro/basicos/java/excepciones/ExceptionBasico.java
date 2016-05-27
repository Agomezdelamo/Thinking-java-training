package alvaro.basicos.java.excepciones;

// exceptions/Ex1.java
//TIJ4 Chapter Exceptions, Exercise 1, page 452
/* Create a class with a main(0 that throws an object of class Exception
 * inside a try block. Give the constructor for Exception a String argument.
 * Catch the exception inside a catch clause and print the String argument.
 * Add a finally clause and print a message to prove you were there.
 */


//defino una excepcion que extiende de Exception, y exception extiende de trhowable
class MyExcepcion extends Exception {
	//el string que paso va en la descripción de la excepción
	public MyExcepcion(String msg) { 
		//Esta llamada a super imprime primero el nombre del paquete y la clase y luego un mensaje personalizado
		super(msg); 
		System.out.println("DENTRO DE LA EXCEPCION");
		System.out.println("MENSAJE ANEXO DEFINIDO EN MY EXCEPCION ESPECIAL");
	}
}

public class ExceptionBasico {
	public static void f() throws MyExcepcion {
		System.out.println("Lanzando mi excepcion personalizada desde método f()");
		System.out.println("------------------------------\r\n");
		throw new MyExcepcion("--------------> Error controlado por mi mismo");
	}
	public static void main(String[] args) {
		try {
			f();
		} catch(MyExcepcion e) {
			//este es el syso de un error
			System.err.println("Capturo la Exception1");
			//AQUI IMPRIMO LA TRAZA, QUE VA DESDE LO CONCRETO A LO GÉNERICO
			e.printStackTrace();
		} finally {
			System.out.println("Hago el finally pase lo que pase");
		}
		
	}	
}
