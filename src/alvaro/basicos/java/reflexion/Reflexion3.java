package alvaro.basicos.java.reflexion;

public class Reflexion3 {

}
En las anteriores entradas Java Reflection parte 1 y Java Reflection parte 2) hemos comentado conceptos b�sicos sobre c�mo obtener en tiempo de ejecuci�n los tipos, atributos y m�todos de un objeto, y las manipulaciones b�sicas sobre los mismos (acceder y cambiar sus valores). Tambi�n hemos explicado algunas manipulaciones m�s complejas (obtenci�n de instancias a partir de constructores espec�ficos, acceder y modificar elementos privados, ...).

En esta tercera parte nos dedicaremos a explicar c�mo trabajar con reflexi�n con dos elementos un poco m�s avanzados de Java: arrays y tipos gen�ricos (Java Generics). Aunque quiz�s puedan ser considerados elementos b�sicos del lenguaje de programaci�n (los arrays deben ser el primer tipo complejo que se ense�a en las clases de programaci�n), la manipulaci�n v�a Java Reflection de los mismos es un poco m�s compleja que los elementos vistos hasta el momento, aunque descubriremos que una vez aprendidos los conceptos b�sicos tal complejidad es s�lo aparente.

ARRAYS
La manipulaci�n de arrays mediante Java Reflection se efect�a usando la clase java.lang.reflect.Array. Para crear un array debemos usar el m�todo Array.newInstance(Class arrayClass, int size), siendo el primer par�metro la clase de los elementos del array y el segundo el tama�o del array. De esta forma, para crear un array de 3 cadenas:

String[] names = (String[]) Array.newInstance(String.class, 3);
Una vez tenemos nuestro array creado, podremos acceder y asignar sus elementos mediante los respectivos m�todos Array.get(Object array, int index) y Array.set(Object array, int index, Object value), donde los par�metros son: array = el array en cuesti�n, index = el elemento dentro del array (notaci�n est�ndar de arrays, el primer elemento tendr� siempre el �ndice 0), value = el valor a asignar.

Adem�s de estos dos m�todos gen�ricos, la clase Array contiene unos m�todos get y set espec�ficos para los tipos primitivos de Java. De esta forma tenemos Array.getBoolean() y Array.setBoolean() para arrays de tipo boolean, Array.getLong() y Array.setLong() para arrays de tipo long, ... Los par�metros para estos m�todos son los mismos que para los m�todos gen�ricos, con la �nica salvedad de que el �ltimo par�metro del set() (value, el que contiene el valor a asignar) ser� del tipo primitivo en cuesti�n en vez de tipo gen�rico Object.

Como ejemplo, supongamos que tenemos una cadena almacenada en una variable storedName, y queremos guardarla en el segundo elemento (�ndice 1) de nuestro array anterior y almacenar en ella el siguiente valor del array:

String storedName;

/* ... */

Array.set(names, 1, storedName);
storedName = (String) Array.get(names, 2);
Obtener la clase de un array es ligeramente m�s complejo que con el resto de objetos, puesto que hay que utilizar una notaci�n un tanto especial. Para obtener la clase de un array mediante el conocido m�todo Class.forName(String className), debemos saber que para indicar un array debemos iniciar la cadena del par�metro className con el car�cter '[' seguido del tipo de clase de los elementos del array. Para tipos primitivos se usar� una letra de la siguiente lista:

boolean: Z
byte: B
short: S
int: I
long: J
char: C
float: F
double: D
En cambio, para elementos de tipo "objetual" se debe usar la letra L, seguida del nombre calificado completo de la clase y finalizado con el car�cter ';'.

As�, si queremos obtener la clase de un array de enteros y un array de cadenas, usaremos:

Class intArrayClass = Class.forName("[I");
Class stringArrayClass = Class.forName("[Ljava.lang.String;");
Una vez tenemos la clase del array, podemos obtener el tipo del componente (es decir, el tipo de los elementos del array) mediante el m�todo Class.getComponentType(). Por ejemplo, para nuestro array anterior:

Class namesClass = names.getClass();
Class componentClass = namesClass.getComponentType();
En este ejemplo, la variable componentClass contendr� la clase java.lang.String .

GENERICS
Mediante reflexi�n tambi�n seremos capaces de obtener en tiempo de ejecuci�n informaci�n sobre tipos gen�ricos, aunque el sistema es un poco m�s complejo y no tan inmediato como cuando trat�bamos con tipos "normales".

Crearemos la siguiente clase para nuestros ejemplos, extensi�n de la clase User que definimos en nuestro art�culo Java Reflection parte 2:

package com.test.model;

public class SocialUser extends User
{
	private List<User> friends;

	public List<User> getFriends()
	{
		return friends;
	}

	public void setFriends(List<User> friends)
	{
		this.friends = friends;
	}
}
Como podemos ver, en nuestro ejemplo estamos usando Java Generics para un caso t�pico: parametrizar los elementos de una lista Java.util.List (tanto en la definici�n del atributo como los m�todos que manipulan el mismo).

Primeramente vamos a ver c�mo podemos obtener el tipo gen�rico del atributo friends mediante el m�todo Field.getGenericType(). Quedar� mejor explicado vi�ndolo directamente con un ejemplo:

Field friendsField = SocialUser.class.getDeclaredField("friends");

Type friendsGenericType = friendsField.getGenericType();
ParameterizedType friendsParameterizedType = (ParameterizedType) friendsGenericType;
Type[] friendsType = friendsParameterizedType.getActualTypeArguments();
Class userClass = (Class) friendsType[0];
El primer paso es obtener el objeto Field asociado al atributo como aprendimos en el primer art�culo sobre Java Reflection. Posteriormente obtenemos el tipo gen�rico en la variable friendsGenericType, que como vemos es del tipo Type (un interfaz gen�rico para todos los tipos de Java). Pero el tipo contenido ah� es el gen�rico (java.util.List), mientras que nosotros queremos saber el tipo espec�fico de los elementos de la lista (User). Para poder llegar hasta �l, necesitamos hacer un cast de nuestro objeto Type a ParameterizedType (un subinterfaz espec�fico de los tipos parametrizados en Java, recordemos que los tipos gen�ricos se llaman tambi�n tipos parametrizados). Finalmente obtenemos el array de los tipos espec�ficos mediante el m�todo getActualTypeArguments() (recordemos que en una declaraci�n de gen�ricos, se pueden especificar varios tipos espec�ficos). Puesto que esto es un ejemplo, sabemos que s�lo tiene un tipo espec�fico y est� en el �ndice 0 del array resultante (friendsType). Si queremos utilizarlo como un objeto Class, s�lo tenemos que asignarlo a una variable con un simple cast de Type a Class.

En nuestro ejemplo se simplific� el c�digo para facilitar la comprensi�n (y porque sab�amos desde el principio cuales iban a ser los tipos devueltos), pero en condiciones normales es una buena pr�ctica asegurarse de la correcci�n de los tipos devueltos (por ejemplo haciendo un if (friendsGenericType instanceof ParameterizedType) antes del cast de Type a ParameterizedType y no accediendo a ning�n elemento del array friendsType sin comprobar que ese �ndice existe).

Ahora que sabemos c�mo obtener y manipular tipos gen�ricos (o parametrizados), obtener el tipo gen�rico de retorno de una funci�n es tan simple como usar el m�todo Method.getGenericReturnType():

Method getFriendsMethod = SocialUser.class.getMethod("getFriends", null);
Type returnType = getFriendsMethod.getGenericReturnType();
Con este c�digo de ejemplo, hemos almacenado en la variable returnType el objeto que contiene el tipo gen�rico de retorno de la funci�n getFriends(), y cuyo procesamiento es totalmente id�ntico al ejemplo anterior.

Finalmente, podemos obtener tambi�n en tiempo de ejecuci�n los tipos gen�ricos de los par�metros de una funci�n, usando Method.getGenericParameterTypes():

Method setFriendsMethod = SocialUser.class.getMethod("setFriends", List.class);
Type[] parameterTypes = setFriendsMethod.getGenericParameterTypes();
La �nica diferencia con los dos ejemplos vistos anteriormente es que la variable parameterTypes ahora se trata de un array de objetos Type, donde cada elemento de dicho array se corresponde con el tipo gen�rico del par�metro correspondiente en la funci�n setFriends() (en nuestro ejemplo un �nico elemento, pues nuestra funci�n s�lo tiene un par�metro).