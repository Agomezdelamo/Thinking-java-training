package alvaro.basicos.java.excepciones;

/**
 * @author agomez
 *
 */
public class excepcionExample {
	/**
	 * Excepciones, o sencillamente problemas.
	 * En la programación siempre se producen errores, 
	 * más o menos graves, pero que hay que gestionar y
	 * tratar correctamente. Por ello en java disponemos
	 * de un mecanismo consistente en el uso de bloques
	 * try/catch/finally. La técnica básica consiste en
	 * colocar las instrucciones que podrían provocar
	 * problemas dentro de un bloque try, y colocar a
	 * continuación uno o más bloques catch, de tal forma
	 * que si se provoca un error de un determinado tipo,
	 * lo que haremos será saltar al bloque catch capaz de
	 * gestionar ese tipo de error específico. El bloque catch
	 * contendrá el codigo necesario para gestionar ese tipo
	 * específico de error. Suponiendo que no se hubiesen
	 * provocado errores en el bloque try, nunca se ejecutarían
	 * los bloques catch.
	 */

//	Veamos ahora la estructura del bloque try/catch/finally:

     /*try
     {
     //Código que puede provocar errores
     }
     catch(Tipo1 var1)
     {
         //Gestión del error var1, de tipo Tipo1
     }
     [  

     catch(TipoN varN)
     {
         //Gestión del error varN, de tipo TipoN
     } ]
     [
     finally
     {
         //Código de finally
     }*/
	/**
	 * 	Como podemos ver es obligatorio que exista la zona try,
	 * o zona de pruebas, donde pondremos las instrucciones 
	 * problemáticas. Después vienen una o más zonas catch, cada 
	 * una especializada en un tipo de error o excepción. Por último 
	 * está la zona finally, encargada de tener un código que se 
	 * ejecutará siempre, independientemente de si se produjeron o no errores.
	 * 
	 * Se puede apreciar que cada catch se parece a una función en la cuál
	 * sólo recibimos un objeto de un determinado tipo, precisamente el tipo del error.
	 * Es decir sólo se llamará al catch cuyo argumento sea coincidente en tipo con
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
	 * Como podremos comprobar al ejecutar se generará el siguiente error:
	 * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
	 * 		at Try1.main(Try1.java:6)
	 * El cuál indica que se ha generado una excepción del tipo 
	 * java.lang.ArrayIndexOutOfBoundsException en la función Try1.main,
	 * dentro del fichero Try1.java y en la línea 6 del código. 
	 * Esta excepción en particular se lanza cuando intentamos 
	 * acceder a una posición de un array y no existe dicha posición.
	 * Vamos a gestionar esta interrupción mediante un bloque try/catch, 
	 * el fichero crear es Try2.java, con el siguiente código:
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
		         System.out.println(" Error de índice en un array");
	         }
         }
     }
	/**
	 *	Intentemos provocar tambien un error de tipo división por cero y pongamos 
	 *	un catch específico para dicho error (fichero Try3.java):
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
		         System.out.println(" Error de índice en un array");
	         }
	         catch(ArithmeticException excepcion)
	         {
		         System.out.println(" Error de índice en un array");
	         }

         }
     }
	
	/**
	 * 	Podemos comprobar que se ejecuta el catch correspondiente
	 *  al tipo de error generado. La línea que lanza el error de 
	 *  índice la hemos comentado para que no lo genere y podamos 
	 *  generar el error de división por cero. Los tipos de error
	 *  que se generan son todos ellos clases, que heredan de la 
	 *  clase java.lang.Exception, por lo tanto podríamos crear 
	 *  nuestro propios errores personalizados. Al igual que podríamos 
	 *  tener un solo catch que capture todos los errores, 
	 *  independientemente del tipo del error.
	 *  Prácticas:
	 *  Construyamos la clase Try4 y agreguemos el siguiente código:
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
		         System.out.println(" Error de índice en un array");
	         }
	         catch(ArithmeticException excepcion)
	         {
		         System.out.println(" Error de índice en un array");
	         }
	         catch(Exception excepcion)
	         {
		         System.out.println("Se ha generado un error que no es de índices, ni Aritmético");
		         System.out.println("El objeto error es de tipo " + excepcion);
	         }
         }
     }
	         
	/**
	 * Podemos comprobar que el catch que captura el error es el correspondiente 
	 * a la clase base Exception, el orden de selección del catch es desde arriba a 
	 * abajo, se comprueba el tipo del error con el del argumento del primer catch, 
	 * luego con el del segundo, Hasta que uno de los catch tenga el mismo tipo y 
	 * pueda gestionarlo. Por ello el catch de la clase base debe de ser el último, 
	 * y los de las clases derivadas deben de estar antes.
	 * 
	 * Al transformar un objeto que herede de Exception a un String el resultado
	 * es el nombre de la excepción. La clase Exception proporciona algunos métodos 
	 * de utilidad, por ejemplo printStackException que muestra el volcado de pila 
	 * con todas las funciones que estan siendo llamadas en el momento en el que se 
	 * lanzó el error:

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
	  * Prácticas: Creemos Try5.java con el siguiente código:
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
	 * y lancemos un error, como en el código del fichero Try6.java:
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
	 * en esos casos se pueden lanzar excepciones, pero la única manera de liberar 
	 * recursos independientemente de si se lanza una excepción o no consiste en 
	 * emplear una claúsula finally, que será ejecutada siempre, haya o no haya 
	 * lanzamiento de excepciones.
	 * Prácticas: 
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
