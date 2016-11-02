package alvaro.basicos.java.reflexion;

/**
 * En nuestra anterior entrada, Java Reflection (parte 1), comentamos c�mo
 * obtener el tipo, constructores e instancias de una clase cuando no conoc�amos
 * en tiempo de compilaci�n los detalles espec�ficos de la misma.
 * 
 * En este art�culo, comentaremos c�mo obtener y manipular los atributos y
 * m�todos de una clase.
 * 
 * Como ejemplo que usaremos durante nuestra explicaci�n, definimos la siguiente
 * clase simple:
 * 
 * @author agomez
 *
 */
public class Reflexion2 {

}

class User()
{
	private String alias = null;
	public String name;
	public String address;

	public User(String name)
	{
		this.name = name;
	}

	public setAlias(String alias)
	{
		this.alias = alias;
	}

	public getAlias()
	{
		if (alias == null)
		{
			return name;
		}
		else
		{
			return alias;
		}
	}}

	Y supongamos
	que tenemos
	la clase
	almacenada en
	la variable userClass:

	Class userClass = Class.forName("com.test.model.User");
	ATRIBUTOS Para
	acceder a
	los atributos
	p�blicos de
	una clase
	tenemos dos
	posibilidades.Si conocemos
	el nombre
	del atributo
	usaremos la
	siguiente instrucci�n:

	Field userField = userClass.getField("name");
	Como en
	los casos
	anteriores se
	nos devuelve
	toda la
	informaci�n sobre
	el atributo
	mediante una
	instancia al
	objeto correspondiente, en
	este caso
	de tipo
	Field.

			Si la
	clase no
	tuviera ning�n
	atributo p�blico
	con ese nombre,
	el m�todo

	getField() lanzar� una excepci�n NoSuchFieldException.

Si por cualquier motivo no conocemos los nombres de los atributos, tenemos una forma de obtener todos los atributos p�blicos de una clase de la siguiente forma:

Field[] userFields = userClass.getFields();
La instrucci�n getFields() nos devuelve un array con un elemento de tipo Field por cada uno de los atributos p�blicos de

	la clase (en nuestro ejemplo, devolver�a un array de 2 elementos: "name" y "address").

Las dos instrucciones mencionadas hasta el momento sirven s�lo para acceder a los atributos p�blicos. Si lo que queremos es acceder a cualquier

	atributo (incluidos los privados), necesitaremos usar los m�todos Class.

	getDeclaredField(String name) (para acceder sabiendo el nombre del atributo) y Class.getDeclaredFields() (que nos devolver� un array con todos los atributos declarados en la clase: "alias", "name" y "address").

Debemos tener en cuenta que estos m�todos s�lo nos permiten acceder a los atributos declarados expresamente en la clase en cuesti�n, nunca aquellos declarados en superclases de la misma.

Ahora que disponemos de una instancia Field para un atributo, podemos proceder a manipularlo. Primero veremos c�mo obtener informaci�n sobre el mismo. Podemos obtener el nombre del atributo mediante:

String fieldName = userField.getName();
Tambi�n podemos averiguar el tipo del atributo mediante:

Object fieldType = userField.getType();
Si lo que nos interesa es el valor contenido en el atributo, deberemos usar:

Object fieldValue = userField.get(userInstance);
Como vemos, el m�todo Field.get() recibe un par�metro que es la instancia del objeto en cuesti�n del que queremos averiguar el valor de su atributo. Si estuvi�ramos intentando acceder a un m�todo est�tico, debemos llamar al m�todo con null como par�metro.

Si lo que queremos es cambiar el valor del atributo, escribiremos:

userField.set(userInstance, value);
Donde value es el valor que

	queremos asignarle (que, evidentemente, debe ser del tipo correspondiente a ese atributo) y userInstance es la instancia del objeto al que queremos asignarle el valor. Al igual que con get(), en caso de tratarse de un atributo est�tico, el valor de userInstance debe ser null.

Como parece l�gico, los m�todos anteriores (get()

	y set()) s�lo nos permiten manipular los atributos p�blicos de

	un objeto (aquellos a los que tengamos acceso desde el contexto de nuestro c�digo). Pero Java Reflection nos permite manipular incluso aquellos atributos privados a los que no tendr�amos acceso de forma normal. Para ello s�lo hay que usar el m�todo Field.setAccessible(true), que deshabilita los chequeos de acceso para ese campo en

	particular (para Java Reflections s�lo). De esta forma, si en nuestro ejemplo queremos modificar el valor del atributo privado "alias", s�lo tendremos que hacer:

Object userInstance = userClass.getConstructor(new Class[] {String.class}).newInstance(new Object[] {"Jos� Gonz�lez"});
Field aliasField = userClass.getDeclaredField("alias");
aliasField.setAccessible(true);
aliasField.set(userInstance, "Pepe");
M�TODOS
De forma totalmente an�loga a como accedimos a los atributos de una clase, podemos acceder a todos los m�todos p�blicos de una clase mediante:

Method[] userMethods = userClass.getMethods();
Como podemos adivinar del ejemplo, los m�todos de una clase se almacenan en un objeto de tipo Method.

Para acceder a un m�todo espec�fico no necesitamos saber s�lo su nombre, si no que necesitamos saber el tipo y orden de los par�metros necesarios para

	su invocaci�n (puesto que recordemos que la sobrecarga de operadores nos permite definir varios m�todos con el mismo nombre y distintos par�metros). As�, para obtener el m�todo setAlias() de nuestra clase de ejemplo, escribir�amos:

Method userMethod = userClass.getMethod("setAlias", new Class[] {String.class});
De la misma forma que ocurr�a con los atributos, estas instrucciones s�lo nos devuelven los m�todos p�blicos de una clase. Para poder acceder a los m�todos privados deberemos usar respectivamente Class.

	getDeclaredMethod(String name) y Class.getDeclaredMethods(). Tambi�n disponemos de un m�todo Method.setAccessible(true) para poder manipular m�todos privados de una clase.

Una vez tenemos el m�todo deseado en nuestro objeto de tipo Method, procedemos a manipularlo. Para obtener el nombre y tipo de retorno usaremos m�todos an�logos a los que usamos para el caso de los atributos:

String methodName = userMethod.getName();
Object methodType = userMethod.getReturnType();
Finalmente, podemos invocar el m�todo deseado mediante la orden Method.invoke():

Object userInstance = userClass.getConstructor(new Class[] {String.class}).newInstance(new Object[] {"Jos� Gonz�lez"});
Method setAliasMethod = userClass.getMethod("setAlias", String.class);
Method getAliasMethod = userClass.getMethod("getAlias", null);
setAliasMethod.invoke(userInstance, "Pepe");
String newAlias = getAliasMethod.invoke(userInstance, null);
El m�todo Method.invoke() debe recibir como primer par�metro la instancia en particular de la que queremos invocar

el m�todo (null si es un m�todo est�tico) y los par�metros del m�todo que

queremos invocar (null o array vac�o si no dispone de par�metros).

Puedes leer m�s sobre este tema en nuestro art�culo Java Reflection (parte 3).