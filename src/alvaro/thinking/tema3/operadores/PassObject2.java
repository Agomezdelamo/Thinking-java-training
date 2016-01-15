package alvaro.thinking.tema3.operadores;

class Box {
	float a;
}

public class PassObject2 {
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
		
		f(x);
		System.out.println("1: x.a = " + x.a);
	}
}
