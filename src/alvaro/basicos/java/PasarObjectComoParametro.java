package alvaro.basicos.java;

class Box {
	float a;
}

public class PasarObjectComoParametro {
	/**
	 * Paso el parámetro
	 * @param y que es un objeto de clase Box
	 * y doy un valor al float que tiene el objeto box.
	 */
	static void f(Box y) {
		y.a = 2.71828f;
	}
	
	public static void main(String[] args){
		Box x = new Box();
		x.a = 3.1416f;
		
		System.out.println("1: x.a = " + x.a);
		
		/**
		 * este método modifica el campo "a" del objeto que pases,
		 * el resultado es que el mismo campo del objeto instanciado en el puntero x
		 * cambia de valor porque mediante el método lo modificamos.
		 */
		f(x);
		System.out.println("1: x.a = " + x.a);
	}
}
