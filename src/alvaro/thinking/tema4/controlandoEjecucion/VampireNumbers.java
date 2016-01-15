package alvaro.thinking.tema4.controlandoEjecucion;


/**
 * Tener un n�mero par de cifras: 1260 tiene 4 cifras.
 * 
 * Es el resultado de multiplicar dos n�meros (que se llaman colmillos).
 * 
 * Estos n�meros tienen que tener la mitad de cifras que el n�mero vampiro 
 * y deben contener todas las cifras del vampiro: 1260 = 21 � 60 
 * 
 * Los dos colmillos no pueden terminar en 0: 60 acaba en cero, pero 21 no.
 * @author agomez
 *
 */
public class VampireNumbers {	
		static int a(int i) {
			return i/1000;
		}
		static int b(int i) {
			return (i%1000)/100;
		}
		static int c(int i) {
			return ((i%1000)%100)/10;
		}
		static int d(int i) {
			return ((i%1000)%100)%10;
		}
		static int com(int i, int j) {
			return (i * 10) + j;
		}
		static void productTest (int i, int m, int n) {
			if(m * n == i) System.out.println(i + " = " + m + " * " + n);
		}	
	public static void main(String[] args) {		
		for(int i = 1001; i < 9999; i++) {			
			productTest(i, com(a(i), b(i)), com(c(i), d(i)));
			productTest(i, com(a(i), b(i)), com(d(i), c(i)));
			productTest(i, com(a(i), c(i)), com(b(i), d(i)));
			productTest(i, com(a(i), c(i)), com(d(i), b(i)));
			productTest(i, com(a(i), d(i)), com(b(i), c(i)));
			productTest(i, com(a(i), d(i)), com(c(i), b(i)));
			productTest(i, com(b(i), a(i)), com(c(i), d(i)));
			productTest(i, com(b(i), a(i)), com(d(i), c(i)));
			productTest(i, com(b(i), c(i)), com(d(i), a(i)));
			productTest(i, com(b(i), d(i)), com(c(i), a(i)));
			productTest(i, com(c(i), a(i)), com(d(i), b(i)));
			productTest(i, com(c(i), b(i)), com(d(i), a(i)));
		}			
	} 
}