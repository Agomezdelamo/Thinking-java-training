package alvaro.basicos.java.excepciones;

/**
 * @author agomez
 *
 */
public class excepcionExample {
	/**
	 * Excepciones, o sencillamente problemas.
	 * En la programaci�n siempre se producen errores, 
	 * m�s o menos graves, pero que hay que gestionar y
	 * tratar correctamente. Por ello en java disponemos
	 * de un mecanismo consistente en el uso de bloques
	 * try/catch/finally. La t�cnica b�sica consiste en
	 * colocar las instrucciones que podr�an provocar
	 * problemas dentro de un bloque try, y colocar a
	 * continuaci�n uno o m�s bloques catch, de tal forma
	 * que si se provoca un error de un determinado tipo,
	 * lo que haremos ser� saltar al bloque catch capaz de
	 * gestionar ese tipo de error espec�fico. El bloque catch
	 * contendr� el codigo necesario para gestionar ese tipo
	 * espec�fico de error. Suponiendo que no se hubiesen
	 * provocado errores en el bloque try, nunca se ejecutar�an
	 * los bloques catch.
	 */

//	Veamos ahora la estructura del bloque try/catch/finally:

     /*try
     {
     //C�digo que puede provocar errores
     }
     catch(Tipo1 var1)
     {
         //Gesti�n del error var1, de tipo Tipo1
     }
     [  

     catch(TipoN varN)
     {
         //Gesti�n del error varN, de tipo TipoN
     } ]
     [
     finally
     {
         //C�digo de finally
     }*/
	/**
	 * 	Como podemos ver es obligatorio que exista la zona try,
	 * o zona de pruebas, donde pondremos las instrucciones 
	 * problem�ticas. Despu�s vienen una o m�s zonas catch, cada 
	 * una especializada en un tipo de error o excepci�n. Por �ltimo 
	 * est� la zona finally, encargada de tener un c�digo que se 
	 * ejecutar� siempre, independientemente de si se produjeron o no errores.
	 * 
	 * Se puede apreciar que cada catch se parece a una funci�n en la cu�l
	 * s�lo recibimos un objeto de un determinado tipo, precisamente el tipo del error.
	 * Es decir s�lo se llamar� al catch cuyo argumento sea coincidente en tipo con
	 * el tipo del error generado.
	 */

     class Try1
     {
         public void main()
         {
	         int [] array = new int[20];
	         array[-3] = 24;	
         }
     }
	/**
	 * Como podremos comprobar al ejecutar se generar� el siguiente error:
	 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
	 * 		at Try1.main(Try1.java:6)
	 * El cu�l indica que se ha generado una excepci�n del tipo 
	 * java.lang.ArrayIndexOutOfBoundsException en la funci�n Try1.main,
	 * dentro del fichero Try1.java y en la l�nea 6 del c�digo. 
	 * Esta excepci�n en particular se lanza cuando intentamos 
	 * acceder a una posici�n de un array y no existe dicha posici�n.
	 * Vamos a gestionar esta interrupci�n mediante un bloque try/catch, 
	 * el fichero crear es Try2.java, con el siguiente c�digo:
	 *
	 */
     public class Try2
     {
         public void main()
         {
	         int [] array = new int[20];
	         try
	         {
		         array[-3] = 24;	
	         }
	         catch(ArrayIndexOutOfBoundsException excepcion)
	         {
		         System.out.println(" Error de �ndice en un array");
	         }
         }
     }
	/**
	 *	Intentemos provocar tambien un error de tipo divisi�n por cero y pongamos 
	 *	un catch espec�fico para dicho error (fichero Try3.java):
	 */
     public class Try3
     {
         public void main()
         {
	         int [] array = new int[20];
	         try
	         {
     //			array[-3] = 24;	
		         int b = 0;
		         int a = 23/b;
	         }
	         catch(ArrayIndexOutOfBoundsException excepcion)
	         {
		         System.out.println(" Error de �ndice en un array");
	         }
	         catch(ArithmeticException excepcion)
	         {
		         System.out.println(" Error de �ndice en un array");
	         }

         }
     }
	
	/**
	 * 	Podemos comprobar que se ejecuta el catch correspondiente
	 *  al tipo de error generado. La l�nea que lanza el error de 
	 *  �ndice la hemos comentado para que no lo genere y podamos 
	 *  generar el error de divisi�n por cero. Los tipos de error
	 *  que se generan son todos ellos clases, que heredan de la 
	 *  clase java.lang.Exception, por lo tanto podr�amos crear 
	 *  nuestro propios errores personalizados. Al igual que podr�amos 
	 *  tener un solo catch que capture todos los errores, 
	 *  independientemente del tipo del error.
	 *  Pr�cticas:
	 *  Construyamos la clase Try4 y agreguemos el siguiente c�digo:
	 */
     public class Try4
     {
         public void main()
         {
	         int [] array = new int[20];
	         try
	         {
     //			array[-3] = 24;
     /*			int b = 0;
		         int a = 23/b;
     */
		         String s = null;
		         s.equals("QQQQ");
	         }
	         catch(ArrayIndexOutOfBoundsException excepcion)
	         {
		         System.out.println(" Error de �ndice en un array");
	         }
	         catch(ArithmeticException excepcion)
	         {
		         System.out.println(" Error de �ndice en un array");
	         }
	         catch(Exception excepcion)
	         {
		         System.out.println("Se ha generado un error que no es de �ndices, ni Aritm�tico");
		         System.out.println("El objeto error es de tipo " + excepcion);
	         }
         }
     }
	         
	/**
	 * Podemos comprobar que el catch que captura el error es el correspondiente 
	 * a la clase base Exception, el orden de selecci�n del catch es desde arriba a 
	 * abajo, se comprueba el tipo del error con el del argumento del primer catch, 
	 * luego con el del segundo, Hasta que uno de los catch tenga el mismo tipo y 
	 * pueda gestionarlo. Por ello el catch de la clase base debe de ser el �ltimo, 
	 * y los de las clases derivadas deben de estar antes.
	 * 
	 * Al transformar un objeto que herede de Exception a un String el resultado
	 * es el nombre de la excepci�n. La clase Exception proporciona algunos m�todos 
	 * de utilidad, por ejemplo printStackException que muestra el volcado de pila 
	 * con todas las funciones que estan siendo llamadas en el momento en el que se 
	 * lanz� el error:

	 */
	
     /*  try
	     {
	         array[-3] = 24;
	     }
	     catch(Exception excepcion)
	     {
	         excepcion.printStackTrace();
	     }
	*/
	
	 /**	
	  * Si es necesario podemos lanzar un error siempre que 
	  * lo consideremos oportuno, para ello tenemos que usar la palabra 
	  * clave throw y especificar un objeto que sea un objeto de la clase 
	  * Exception, o de una clase derivada.
	  * Pr�cticas: Creemos Try5.java con el siguiente c�digo:
	  * 
	  */
     public class Try5
     {
         public void main()
         {
	         try
	         {
		         Exception e = new Exception("Este es mi propio error.");
		         throw e;
	         }
	         catch(Exception excepcion)
	         {
		         excepcion.printStackTrace();
	         }
         }
     }
	         
	/**
	 * 
	 * Ahora construyamos nuestra propia clase personalizada de error 
	 * y lancemos un error, como en el c�digo del fichero Try6.java:
	 * @author agomez
	 *
	 */
     public class Try6
     {
         public void main()
         {
	         try
	         {
		         MiPropioError e = new MiPropioError("Este es mi propio error.");
		         throw e;
	         }
	         catch(Exception excepcion)
	         {
		         excepcion.printStackTrace();
	         }
         }
     }
     class MiPropioError extends Exception{
         public MiPropioError(String mensaje){
	         super(mensaje);
         }
     }
	/**
	 * 	Habitualmente dentro de try solicitamos recursos y trabajamos con ellos, 
	 * en esos casos se pueden lanzar excepciones, pero la �nica manera de liberar 
	 * recursos independientemente de si se lanza una excepci�n o no consiste en 
	 * emplear una cla�sula finally, que ser� ejecutada siempre, haya o no haya 
	 * lanzamiento de excepciones.
	 * Pr�cticas: 
	 * Construyamos el fichero Tray7.java:
	 */
     public class Try7
     {
         public void main(String arg[])
         {
	         try
	         {
		         Exception e = new Exception("Este es mi propio error.");
		         throw e;
	         }
	         catch(Exception excepcion)
	         {
		         excepcion.printStackTrace();
	         }
	         finally
	         {
		         System.out.println("Se ejecuta finally");
	         }
         }
     }
}
