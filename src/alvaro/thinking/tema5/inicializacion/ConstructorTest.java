package alvaro.thinking.tema5.inicializacion;

/**
 * un string si no se le asigna valor para 
 * inicializar es null, el resto de primitivos se les asigna un valor por defecto
 * 
 * @author agomez
 *
 */
class Tester {
	String s;
	int a;
	double c;
	float d;
}

public class ConstructorTest {
	public static void main(String[] args) {
		Tester t = new Tester();
		System.out.println(t.s);
		System.out.println(t.a);
		System.out.println(t.c);
		System.out.println(t.d);
	}
}