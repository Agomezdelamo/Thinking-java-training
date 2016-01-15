package alvaro.thinking.tema4.controlandoEjecucion;

public class IfElseTest {
	static int test(int testval, int begin, int end) {
		if(end < begin) {
			System.out.println("end --> "+end+" es menor que begin  --> "+begin+" y devuelvo  --> 0");
			return 0;
		} 
		
		if((testval > (begin - 1)) && (testval < (end + 1))) {
			System.out.println("OPERADOR Y: se cumplen las 2 condiciones. testval --> "+testval+" es mayor que  --> "+(begin - 1)+" y menor que --> "+(end+1)+" y devuelvo 1");
			return +1;
		}
		
		if((testval < begin) || (testval > end)) {
			System.out.println("operador O: solo se cumple una condición. testval --> "+testval+" es menor que --> "+begin+" o es mayor que --> "+end+" y devuelvo -1");
			return -1;
		}
		
		System.out.println("exceptional case");
		return 13;
	}	
	public static void main(String[] args) {
		/**
		 * devuelven un entero que se imprime por consola.
		 */
		
		System.out.println(test(10, 5, 4));
		System.out.println(test(5, 4, 10));
		System.out.println(test(5, 5, 6));
		System.out.println(test(10, 5, 7));	
		System.out.println(test(5, 5, 5));	
	}
}