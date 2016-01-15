package alvaro.thinking.tema5.inicializacion;

	/* Create a class with a String field that is initialized at the point of
	* definition, and another one that is initialized by the constructor. What is
	* the difference between the two approaches.
	*/

class Tester2 {
	String s1;
	String s2 = "hello";
	String s3;
	Tester2() { s3 = "good-bye"; }
}

public class ConstructorTest2 {
	public static void main(String[] args) {
		
		/**
		 * en este momento se construye el objeto, se inicializan los campos 
		 * y se pasa por el constructor. s1 es null, s2 hello y s3 goodbye.
		 * 
		 * da igual en el orden que se impriman, puesto que ya todos tienen valor.
		 */
		Tester2 t = new Tester2();
		System.out.println("t.s1: " + t.s1);
		System.out.println("t.s2: " + t.s2);
		System.out.println("t.s3: " + t.s3);
	}
}
