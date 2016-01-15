package alvaro.thinking.tema7.reusar;

class Art {
	Art() { System.out.println("Art constructor"); }
}

class Drawing extends Art {
	Drawing() { System.out.println("Drawing constructor"); }
}

/**
 * Cartoon2 no tiene contstructor
 * con lo que se crea un por defecto por detrás,
 * que llama al constructor de la clase base.
 */
public class Cartoon2 extends Drawing {
	public static void main(String[] args) {
		Cartoon2 x = new Cartoon2();
	}
}
