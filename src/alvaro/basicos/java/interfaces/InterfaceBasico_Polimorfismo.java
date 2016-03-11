package alvaro.basicos.java.interfaces;

interface Formas {
	void pintar();
}

class Cuadrado implements Formas {
	public void pintar() { System.out.println("pinto un cuadrado"); }
}

class Triangulo implements Formas {
	public void pintar() { System.out.println("pinto un triangulo"); }
}

public class InterfaceBasico_Polimorfismo {
	public static void main(String[] args) {
//		Formas interf = new Formas(); //no se puede instanciar un interface
		
		/* usando el mismo tipo para ambos casos, puedo darle al método pintar
		   diferentes cuerpos en tiempo de ejecución. */
		Formas cuadrado = new Cuadrado();
		cuadrado.pintar();

		Formas triangulo = new Triangulo();
		triangulo.pintar();
	}
}
