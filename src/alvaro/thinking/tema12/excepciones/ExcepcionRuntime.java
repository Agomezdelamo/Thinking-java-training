package alvaro.thinking.tema12.excepciones;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

//exceptions/Ex11.java
//TIJ4 Chapter Exceptions, Exercise 11, page 468
/* Repeat the previous exercise, but inside the catch clause, wrap g()'s 
* exception in a RuntimeException.
*/

class GExceptione extends Exception {
	GExceptione(String s) {
		super(s);
	}
}

public class ExcepcionRuntime {
	private static Logger logger = Logger.getLogger("Ex11 Exceptions");
	
	static void f() {
		try {
			g();
		} catch(GExceptione ge) {
			System.out.println("Cogida la excepcion GException en el metodo f bloque try");
			
			StringWriter traza = new StringWriter();
			ge.printStackTrace(new PrintWriter(traza));
			logger.severe(traza.toString());

			//envuelvo la excepción en una runtimeException que ya me da el causedBy
			throw new RuntimeException(ge);
		}
	}
	static void g() throws GExceptione {	throw new GExceptione("ERROR CAUSADO DESDE EL METODO G"); }
	
	public static void main(String[] args) {
		f();
	}	
}

	