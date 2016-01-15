package alvaro.basicos.java;

//desechar - dispose.
class Componente1 {
	Componente1() { System.out.println("Componente1()"); }
	void desechar() { System.out.println("Componente1.desechar()"); }
}

class Componente2 {
	Componente2() { System.out.println("Componente2()"); }
	void desechar() { System.out.println("Componente2.desechar()"); }
}

class Componente3 {
	Componente3() { System.out.println("Componente3()\r\n"); }
	void desechar() { System.out.println("Componente3.desechar()"); }
}

class Raiz2 { 
	Componente1 c1root;
	Componente2 c2root;
	Componente3 c3root;
	Raiz2() { 
		System.out.println("\r\nRaiz()");
		c1root = new Componente1();
		c2root = new Componente2();
		c3root = new Componente3();
	}
	//1. borrado en forma inversa
	void desechar() {
		c3root.desechar();
		c2root.desechar();
		c1root.desechar();
		System.out.println("Raiz2.desechar()");
	} 
}

class Borrado_PreguntarSobreEsto extends Raiz2 { 
	Componente1 c1stem;
	Componente2 c2stem;
	Componente3 c3stem;
	Borrado_PreguntarSobreEsto() { 
		super();
		System.out.println("Stem3()"); 
		c1stem = new Componente1();
		c2stem = new Componente2();
		c3stem = new Componente3();
	}
	//2. borrado
	void desechar() {
		c3stem.desechar();
		c2stem.desechar();
		c1stem.desechar();
		super.desechar();
		System.out.println("Stem3.desechar()");
	} 
	public static void main(String[] args) {
		//1. arranca toda la construccion
		Borrado_PreguntarSobreEsto s = new Borrado_PreguntarSobreEsto();
		try {
			// Code and exception handling...
		} finally {
			/**
			 * lo curioso de borrar objetos es que primero busca todas las instancias de ese objeto
			 * hasta que no borra todas las instancias de las clases compuestas no ejecuta el borrado entero ni en
			 * el padre ni en el hijo, me gustaria preguntar bien sobre esto.
			 */
			s.desechar();
		}
	}
}