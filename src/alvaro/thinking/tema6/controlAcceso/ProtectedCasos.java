package alvaro.thinking.tema6.controlAcceso;
/**
 * Simplemente se muestra que puedes acceder desde otra clase a un campo protected y modificarlo.
 * @author agomez
 *
 */

class SomeData {
	protected int a = 13;
}

class DataChanger {
	static void change(SomeData sd, int i) { sd.a = i; }
}

public class ProtectedCasos {
	public static void main(String[] args) {
		SomeData x = new SomeData();
		System.out.println(x.a);					
		DataChanger.change(x, 99);
		System.out.println(x.a);		
	}	
}
