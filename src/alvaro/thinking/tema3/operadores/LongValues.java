package alvaro.thinking.tema3.operadores;
/**
 * Este no le entiendo, rebuscar en el thinking java capitulo 3 operadores.
 * @author Dj nezhod
 *
 */
public class LongValues {
		public static void main(String[] args) {
			long n1 = 0xffff; // hexadecimal
			long n2 = 077777; // octal
			System.out.print("long n1 in hex = " + Long.toBinaryString(n1)+"\r\n");
			System.out.print("long n2 in oct = " + Long.toBinaryString(n2)+"\r\n");
		}
}
