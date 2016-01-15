package alvaro.thinking.tema3.operadores;

/**
 * Los binarios hay que repasarlos.
 * @author agomez
 *
 */
public class CharBinaryTest {
	public static void main(String [] args) {
		char c = 'a';
		System.out.println(Integer.toBinaryString(c));
		c = 'b';
		System.out.println(Integer.toBinaryString(c));
		c = 'c';
		System.out.println(Integer.toBinaryString(c));
		c = 'd';
		System.out.println(Integer.toBinaryString(c));
		c +=1;
		System.out.println(Integer.toBinaryString(c));
		c = 'A';
		System.out.println(Integer.toBinaryString(c));

		for(int i = 0; i < 26; i++) {
			c +=1;
			System.out.println(Integer.toBinaryString(c));
		}
	}
}
