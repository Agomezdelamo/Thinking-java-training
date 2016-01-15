package alvaro.thinking.tema5.inicializacion;
/**
 * Crear una clase llamada tanque que pueda ser rellenada y vaciada y pueda tener una 
 * condición de terminación que deba estar vacia cuando el objeto es limpiado.
 * 
 * Escribe un finalize() que verifique esta condición de terminación.
 * En main(), prueba los posibles escenarios que pueden ocurrir cuando tanque es usado.
 * @author agomez
 *
 */

class Tank {
	int howFull = 0;
	static int UNIQUE_ID = 0;
    int uid = ++UNIQUE_ID;
	Tank() { 
		//El constructor por defecto llama a la sobrecarga pasando un int 0.
		this(0);
	}
	
	Tank(int fullness) {
		howFull = fullness;		
	}
	void sayHowFull() {
		if(howFull == 0) System.out.println("Tanque "+this.uid+": El tanque esta vacio \r\n");
		else System.out.println("Tanque "+this.uid+": Estado de relleno del tanque = " + howFull +" \r\n");
	}
	void empty() {
		howFull = 0;
		System.out.println("-----> Tanque "+this.uid+" vaciado <------\r\n");
	}
	protected void finalize() {
		if(howFull != 0)
			System.out.println("Tanque "+this.uid + ": Error: Tanque no vacio " );
		// Normally, you'll also do this:
		// super.finalize(); // Call the base-class version
	}
}

public class Finalizador3 {
	public static void main(String[] args) {
		Tank tank1 = new Tank();
		Tank tank2 = new Tank(3);
		Tank tank3 = new Tank(5);
		// Proper cleanup: empty tank before going home
		// Drop the reference, forget to cleanup:
		new Tank(6);
		System.out.println("Comprobamos tanques:\r\n");
		tank1.sayHowFull();
		tank2.empty();
		tank2.sayHowFull();
		tank3.sayHowFull();
		System.out.println("primer forzado del garbage recolector gc():\r\n");
		System.gc();
		// Force finalization on exit but using method
		// deprecated since JDK 1.1:
		System.out.println("probamos el deprecado runFinalizersOnExit(true)");
		System.runFinalizersOnExit(true);
		System.out.println("\r\nultimo forzado del garbage recolector gc():");
		System.gc();
	}
}