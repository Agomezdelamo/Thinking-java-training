package alvaro.basicos.java.excepciones;

//exceptions/Ex7.java
//TIJ4 Chapter Exceptions, Exercise 7, page 456
//Modify Exercise 3 so that the catch clause logs the result.
import java.util.logging.*;
import java.io.*;

public class ExcepcionLoggerTrace2 {
	private static int[] ia = new int[2];
	//con getlogger genero un objeto logger con el nombre pasado en el argumento, 
	//y una vez no esta en uso el recolector de basura lo mata.
	private static Logger logger = Logger.getLogger("Ex7 Exceptions");
	
	static void logException(Exception e) { // Exception como argumento
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
		//traza nivel grave
		logger.severe(trace.toString()); 	
	}
	public static void main(String[] args) {
		try {
			ia[2] = 3; //trato de acceder a una posición que no existe en el array y genera excecpción.
		} catch(ArrayIndexOutOfBoundsException e) {
			//1.muestro un mensaje de error
			System.err.println("ArrayIndexOutOfBoundsException Cogido"); 
			
			//2.imprimo la traza normal
			e.printStackTrace(); 
			
			//3.la imprimo con logger.
			logException(e);
		} 
	}	
}