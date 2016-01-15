package alvaro.thinking.tema9.interfaces;

//Crea una clase abstract e incluye métodos abstractos y comprueba que no se puede instanciar.

/**
 * Una clase abstracta no se puede instanciar, pero aquí comprobamos instanciando a su hijo
 * que su constructor si se ejecuta.
 * @author agomez
 *
 */
abstract class Nogo1 {
	Nogo1() { System.out.println("Constructor Nogo1()"); }
	
	public void method() { System.out.println("Nogo1: method() método no abstracto, no es necesario implementarlo."); }
	abstract void aMethod();
}

abstract class Nogo2 {}

class Go1 extends Nogo1 {
	Go1() { System.out.println("Constructor Go1()"); }
	void aMethod() { System.out.println("Go1: aMethod() método abstracto y obligatorio de implementar."); }
}

public class Empty {
	public static void main(String[] args) {
		// Nogo1 y Nogo2 no pueden ser instanciados:
		// Nogo1 ng1 = new Nogo1();
		// Nogo2 ng2 = new Nogo2();
		
		// Pero el constructor Nogo1() fue llamado durante la instanciación de su hijo: 	
		Go1 g1 = new Go1();
		g1.method();
		g1.aMethod();
	}
}