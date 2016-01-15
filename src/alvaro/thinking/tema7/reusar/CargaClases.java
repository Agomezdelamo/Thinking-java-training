package alvaro.thinking.tema7.reusar;

/** Demuestre que el proceso de carga de una clase se produce una sóla vez.
 * Prueba que esta carga puede ser causada por la creación de uan primera instancia 
 * de esa clase o por el acceso a un miembro estático.
 * 
 * ojo:-- La carga de propiedades se produce una vez creas un objeto con new, o cuando llamas a un campo estático que se
 * inicializan en orden textual, es decir, el primer campo estático primero, el segundo segundo...
*/

class A1 {
//	campo statico, se inicializa en el orden de escritura.
	static int j = printInit("A1.j initialized");
	
//	método estatico.
	static int printInit(String s) {
		System.out.println(s);
		return 1;
	}
	//constructor
	A1() { System.out.println("A1() constructor"); }	
} 

class B1 extends A1 {
	//campo estático
	static int k = printInit("B1.k initialized");
	
	//Constructor estático
	B1() { System.out.println("B1() constructor"); }	
}
	
class C1 {
	//campo estático
	static int n = printInitC("C1.n initialized");
	//campo estático.
	static A1 a = new A1();	
	//constructor
	C1() { System.out.println("C1() constructor"); }
	
	//método estático
	static int printInitC(String s) {
		System.out.println(s);
		return 1;
	}
}

class D1 {
	//constructor
	D1() { System.out.println("D() constructor"); }
}

public class CargaClases extends B1 {
	//Campo estático.
	static int i = printInit("LoadClass.i initialized");
	
	//Constructor Estático
	CargaClases() { System.out.println("LoadClass() constructor \r\n"); }
	
	//INICIO
	public static void main(String[] args) {
		//Acceder a main() como es estático arranca e inicializa las clases A, B Y CargaClases que hereda de B. 
		System.out.println("hi");
		
		// Llamo al constructor para cargar las clases:
		CargaClases lc = new CargaClases();
		
		// llamo a un campo estático de C y lo inicializo:
		System.out.println("ahora imprimo el campo estático de C1 'a' y eso inicializa en orden textual todos los campos estáticos\r\n"
				+ "por eso primero se inicializa n, luego se construye lo que contiene el puntero 'a' y por ultimo se llama al toString de a\r\n"+C1.a+"\r\n");
		
		// Llamo al constructor de D:
		D1 d = new D1();
	}
}