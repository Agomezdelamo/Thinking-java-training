package alvaro.basicos.java;


/**
 * Crear una clase con un constructor que coja un string como parametro.
 * 
 * Durante la construcción imprimo el argumento.
 * 
 * Crear un array de referencias de objetos a esta clase, ver si se imprimen los mensajes de inicialización
 * correspondientes.
 * @author agomez
 *
 */


class ObjectGeneric {
	static int count = 0;
	int uniqueIndex = count++;
	ObjectGeneric(String s) {
		System.out.println(s+" "+uniqueIndex+ " inicializado");
	}
}

public class IniciarArray {
	public static void main(String[] args) {
		/**
		 * cuando generas un array de una clase, solo es un array
		 * de punteros a esa clase, la inicialización de esos objetos
		 * a de realizarse explicitamente.
		 */
		ObjectGeneric[] it = new ObjectGeneric[10];
		for (ObjectGeneric i : it) {
			System.out.println("objeto "+ i);
		}
		
		/**
		 * aquí se inicializan, sin este for, solo serian punteros null
		 */
		for (ObjectGeneric i : it) {
			i = new ObjectGeneric("ObjectGeneric");
		}
	}
}