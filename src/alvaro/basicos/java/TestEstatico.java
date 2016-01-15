package alvaro.basicos.java;
/**
 * Da igual cuantos objetos hagamos de la clase StaticTest2.
 * 
 * Como su propiedad es "static", sólo esta en la definición de la clase, no se clona,
 * con lo que si redefines esta propiedad todos los objetos de esa clase son afectados.
 * 
 * @author agomez
 *
 */

class StaticTest2 {
	static int i = 47;
}

class Incrementable2 {
	static void increment() { StaticTest2.i++; }
}

public class TestEstatico {
	public static void main(String[] args) {
		System.out.println("StaticTest2.i= " + StaticTest2.i);
		StaticTest2 st1 = new StaticTest2();
		StaticTest2 st2 = new StaticTest2();
		System.out.println("st1.i= " + st1.i);
		System.out.println("st2.i= " + st2.i);
		
		Incrementable2.increment();
		System.out.println("After Incrementable2.increment() called: ");
		System.out.println("st1.i = " + st1.i);
		System.out.println("st2.i = " + st2.i);
		
		Incrementable2.increment();
		System.out.println("After Incrementable2.increment called: ");
		System.out.println("st1.i = " + st1.i);
		System.out.println("st2.i = " + st2.i);
		
		st1.i = 3;
		System.out.println("After st1.i = 3, como la propiedad es estatica cambian todos");
		System.out.println("st1.i = " + st1.i);
		System.out.println("st2.i = " + st2.i);
		System.out.println("Create another StaticTest2, st3.");
		
		StaticTest2 st3 = new StaticTest2();
		System.out.println("st3.i = " + st3.i);
	}
}