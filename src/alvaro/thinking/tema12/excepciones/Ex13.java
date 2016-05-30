package alvaro.thinking.tema12.excepciones;

//exceptions/Ex13.java
//TIJ4 Chapter Exceptions, Exercise 13, page 476
/* Modify Exercise 9 by adding a finally clause. Verify that your 
* finally clause is executed, even if a NullPointerException is thrown.
*/

class ExceptionaA extends Exception {
	ExceptionaA(String msg) { super(msg); } 	
}

class ExceptionaB extends Exception {
	ExceptionaB(String msg) { super(msg); } 	
}

class ExceptionaC extends Exception {
	ExceptionaC(String msg) { super(msg); } 		
}

public class Ex13 {
	// array element will be initialized to null:
	private static Integer[] x = new Integer[1];
	public static void f(int x) throws ExceptionaA, ExceptionaB, ExceptionaC {		
		Integer[] xs = new Integer[16];
		if(x < 0) throw new ExceptionaA("x < 0");
		if(x == 0) throw new ExceptionaB("x == 0");
		if(x > 0) throw new ExceptionaC("x > 0");
	}
	public static void main(String[] args) {
		try {
			// para lanzar NullPointerException pasamos como argumento el valor del array en su posición 0 que es un null:
			f(x[0]);
			f(0);
			f(1);
			f(-1);
		// will catch any Exception type:
		} catch(Exception e) {
			System.out.println("Excepcion atrapada");
			e.printStackTrace(System.err);
		} finally {
			System.out.println("Se ejecuta al final incluso si hay un null pointer");
		}
	}	
}
