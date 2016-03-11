package alvaro.thinking.tema9.interfaces;

/**
 * Lo interesante de este Ejemplo es que aunque llames a un método abstracto en el padre,
 * el cuerpo de ese método se ejecuta desde su primera implementación en el hijo.
 */ 

abstract class Dad {
	protected abstract void print();
	//este método se llama en el constructor del padre pero está definido
	//en el hijo, por lo que al llamar aqui a print va al hijo sin pasar por el constructor.
	Dad() { 
		System.out.println("constructor Dad()");
		print();
	}
}

class Son extends Dad {
	private int i = 1;
	@Override protected void print() { 
		if(i == 0)
			System.out.println("Son.i = " + i + " la primera vez es 0 porque no se a inicializado los campos de Son");
		else
			System.out.println("Son.i = " + i);
	}
	Son() {System.out.println("constructor Son()");}
}

public class AbstactInicialization {
	public static void main(String[] args) {
		/* Proceso de inicialización:
		* 1. El almacenamiento del objeto Son s esta localizado e inicializado a un cero binario.
		* 2. Se llama al constructor de Dad()
		* 3. Son.print() es llamado en Dad() (s.i = 0)
		* 4. Se hace la inicialización de campos del hijo (s.i = 1)
		* 5. El constructor de Son() es llamado.
		*/
		
		Son s = new Son();
		s.print();
	}
}