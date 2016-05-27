package alvaro.thinking.tema12.excepciones;

//exceptions/Ex4.java
//TIJ4 Chapter Exceptions, Exercise 4, page 452
/* Create your own exception class using the extends keyword. Write a 
* constructor for this class that takes a String argument and stores it inside
* the object with a String reference. Write a method that displays the stored 
* String. Create a try-catch clause to exercise your new exception.
*/

class MyeXcepccion extends Exception {
	private String msg;
	MyeXcepccion(String msg) {
		super(msg);
		System.out.println("------------------------------------");
		System.out.println("Estoy lanzando mi MyeXcepccion()");
		System.out.println("||||||||||||||||||||||||||||||||||||");
		this.msg = msg;
	}
	protected void showS() { 
		System.out.println("Mensaje de la excepción personalizada MyeXcepcion(): " + msg);
	}
}

//aveces veo saltar los mensajes en un orden incorrecto, la excepcion antes que el try...
//En código el orden es el try, luego el catch y luego el finally, pero
//La consola de windows que envia a la pantalla el texto tiene un buffer,
//y no tiene porque mantener el orden de java.
public class ExcepcionPersonalizada1 {
	public static void f() throws MyeXcepccion {
		System.out.println("Estoy en f()");
		throw new MyeXcepccion("Echado de f()");
	}
	
	public static void main(String[] args) {
		try {
			f();	
		} catch(MyeXcepccion e) {
			System.err.println("Excepción");
			e.printStackTrace();
			//uso de un método personalizado de mi excepción personalizada
			e.showS();
		} 
	}	
}