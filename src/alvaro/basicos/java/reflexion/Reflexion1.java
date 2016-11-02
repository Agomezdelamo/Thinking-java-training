package alvaro.basicos.java.reflexion;

/**
 * Una de las funcionalidades m�s potentes y poco conocidas de Java es su
 * soporte para reflexi�n. Mediante la Java Reflection API el programador puede
 * inspeccionar y manipular clases e interfaces (as� como sus m�todos y campos)
 * en tiempo de ejecuci�n, sin conocer a priori (en tiempo de compilaci�n) los
 * tipos y/o nombres de las clases espec�ficas con las que est� trabajando.
 * 
 * Quiz�s pueda parecernos en una primera impresi�n una funcionalidad con usos
 * limitados. Pero debemos saber que, por ejemplo, muchos frameworks de alto
 * nivel como Hibernate, Spring o Tapestry hacen un uso extensivo de esta API
 * para facilitarle la vida al programador al permitirle que use simples clases
 * POJO para trabajar con ellas.
 **/
public class Reflexion1 {
	/**
	 * CLASE Cuando en nuestro programa queremos usar reflexi�n para poder
	 * trabajar con un objeto del que desconocemos su tipo (en el caso de Java,
	 * esto es lo mismo que decir que desconocemos el nombre de su clase), lo
	 * primero que debemos hacer es averiguar la clase a la que pertenece. En
	 * situaciones normales conoceremos el tipo de un objeto en tiempo de
	 * compilaci�n, con lo que obtendr�amos su clase de la forma:
	 **/
	 
	Class userClass = User.class;

	 /** En aquellas situaciones en las que no conozcamos el nombre de una clase
	 * en tiempo de compilaci�n, podemos obtener su clase en tiempo de ejecuci�n
	 * a partir de un String que contenga el nombre completo de la clase
	 * (incluyendo los paquetes, lo que se conoce como nombre de clase
	 * totalmente calificado) usando la funci�n
	 */
	 Class.forName():
	  
	 /** Class userClass = Class.forName("com.test.model.AdminUser"); En nuestro
	 * ejemplo, la clase es AdminUser que pertenece al paquete com.test.model.
	 * 
	 * Si por alg�n motivo la clase no existiese, se lanzar�a una excepci�n
	 * ClassNotFoundException para indicarlo.
	 * 
	 * En sentido inverso, teniendo la clase de un objeto tambi�n podremos
	 * obtener una cadena con el nombre de la clase:
	 */
	 String className = userClass.getName();
	  
	 /** Este ejemplo nos devuelve el nombre totalmente calificado de la clase.
	 * 
	 * Si queremos s�lo el nombre simple (sin el paquete), debemos usar el
	 * m�todo **/
	 String className = userClass.getSimpleName().
	 

	/**
	 * INFORMACI�N ADICIONAL Podemos obtener el paquete de una clase mediante:
	 * 
	 **/
	Package userPackage = userClass.getPackage();
	/**
	 * N�tese que no devuelve un simple String con el nombre del paquete, sino
	 * un objeto de tipo Package que contiene informaci�n sobre el paquete y
	 * m�todos para su manipulaci�n.
	 * 
	 * Tambi�n podemos acceder a la superclase de una clase (que ser� nuevamente
	 * un objeto Class, de forma que podemos seguir haciendo reflexi�n sobre �l)
	 * mediante el m�todo:
	 **/
	Class userSuperclass = userClass.getSuperclass();
	/**
	 * Podemos obtener una lista de los interfaces que implementa una clase (en
	 * forma de array de objetos Class) mediante:
	 **/
	Class[] userInterfaces = userClass.getInterfaces();
	/**
	 * Debe tenerse en cuenta que s�lo se incluyen los interfaces implementados
	 * directamente por esta clase, no los que se heredan porque son
	 * implementados por alguna superclase de la jerarqu�a.
	 **/
	/**
	 * CONSTRUCTORES Podemos acceder a la lista de todos los constructores de
	 * una clase mediante el m�todo:
	 **/
	 Constructor[] userConstructors = userClass.getConstructors(); 
	 /** Si conocemos los tipos de los par�metros de un constructor en particular,
	 * podemos acceder a ese constructor concreto sin tener que recorrer toda la
	 * lista. Esto se hace mediante el m�todo getConstructor(), que admite como
	 * par�metros un array con los tipos espec�ficos de ese constructor (en el
	 * mismo orden en el que est�n declarados). Por ejemplo, si sabemos que
	 * nuestra clase de ejemplo contiene un constructor que acepta los
	 * par�metros (String, String, Integer) podemos acceder a �l mediante:
	 **/
	 Constructor userConstructor = userClass.getConstructor(new Class[]
	 {String.class, String.class, Integer.class}); 
	 
	 /**Si no existiera un
	 * constructor con esos par�metros, se lanzar�a una excepci�n de tipo
	 * NoSuchMethodException.
	 * 
	 * A la inversa, para un constructor tambi�n podemos obtener sus par�metros
	 * mediante:
	 **/
	 
	 Class[] params = userConstructor.getParameterTypes();
	 /**Una vez hallamos
	 * conseguido el constructor deseado, podemos instanciar un objeto mediante
	 * el m�todo newInstance() con los par�metros adecuados. En nuestro ejemplo:
	 * 
	 * Constructor userConstructor = userClass.getConstructor(new Class[]
	 * {String.class, String.class, Integer.class}); User user = (User)
	 * userConstructor.newInstance("Antonio Gonz�lez", "agonzalez@mimail.com",
	 * 12); Puedes leer m�s sobre este tema en nuestro art�culo Java Reflection
	 * (parte 2).
	 **/
}
