package alvaro.thinking.tema7.reusar;


class Insecto {
	private int i = 9;
	protected int j;
	Insecto() {
		System.out.println("--- Insecto Constructor");
		System.out.println("i = " + i + ", j = " + j +"\r\nCambiamos el valor de j a 39"+"\r\n");
		j = 39;
	}
	
	private static int x1 = printInit("1. Al ejecutar el método static main() se inicializan todos los \r\ncampos static que esten en la herencia desde el abuelo hacia el nieto\r\n--------------------------> " +"\r\n"
			+ "static Insecto.x1 initialized");
	
	static int printInit(String s) {
		System.out.println(s);
		return 47;
	}
}

class SuperEscarabajo extends Insecto {
	private int k = printInit("campo int k de SuperEscarabajo inicializado y recoge el valor del método que es 47");
	public SuperEscarabajo() {
		System.out.println("--- SuperEscarabajo Constructor");
		System.out.println("k = " + k);
		System.out.println("j que es protected heredado de insecto = " + j + "\r\n");
	}
	private static int x2 = printInit("static SuperEscarabajo.x2 initialized");	
}

public class Escarabajo extends SuperEscarabajo {
	private int n = printInit("Campo int n de Escarabajo initialized inicializado y recoge el valor del método que es 47");
	public Escarabajo() {
		System.out.println("--- Escarabajo Constructor");
		System.out.println("n = " + n);
		System.out.println("j que es protected heredado de insecto = " + j);
	}
	private static int x3 = printInit("static Escarabajo.x3 initialized" +"\r\n");
	
	//Arrancamos la fiesta
	public static void main(String[] args) {
		System.out.println("2. Instancio un Escarabajo y ahora se ejecuta la cadena de constructores,\r\nprimero se incializan campos y luego constructores en cada clase\r\n--------------------------> ");
		Escarabajo sc = new Escarabajo();			
	}
}
