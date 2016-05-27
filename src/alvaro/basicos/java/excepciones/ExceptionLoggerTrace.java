package alvaro.basicos.java.excepciones;

//exceptions/Ex6.java
//TIJ4 Chapter Exceptions, Exercise 6, page 456
/* Create two exception classes, each of which performs its own logging
* automtically. Demonstrate that these work.
*/
import java.util.logging.*;
import java.io.*;

class Oops1 extends Exception {
	private static Logger logger = Logger.getLogger("LoggingException");
	public Oops1() { 
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		System.out.println("LOGGER IMPRIME ESTO");
		logger.severe("");
		System.out.println("TRACE IMPRIME ESTO -- \r\n"+trace.toString());
		
		
		logger.severe(trace.toString()); 		
	}
}

class Oops2 extends Exception {
	private static Logger logger = Logger.getLogger("LoggingException");
	public Oops2() {
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	} 
}

public class ExceptionLoggerTrace {
	//**** DOS MÉTODOS ESTÁTICOS PARA GENERAR LAS EXCEPCIONES *******//
	static void firstMetodo() throws Oops1, Oops2 { throw new Oops1(); }
	static void secondMetodo() throws Oops2 { throw new Oops2(); }
	//**** EJECUTO EL PROGRAMA *******//
	public static void main(String[] args) {
		try {
			firstMetodo();
		} catch(Exception Oops1) {}
		
		try {
			secondMetodo();
		} catch(Exception Oops2) {}
	}
}
