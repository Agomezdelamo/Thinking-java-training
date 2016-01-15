package alvaro.basicos.java;
import java.util.*;

public class Aleatorio {
	public static void main(String[] args) {
		Random aleatorio = new Random();
		int moneda = aleatorio.nextInt(20);
		if(moneda % 2 == 0) {
			System.out.println("Ha salido "+moneda+" osea que es cara");
		}
		else {
			System.out.println("Ha salido "+moneda+" osea que es cruz");
		}
	}

}
