package alvaro.thinking.tema4.controlandoEjecucion;

import java.util.Random;

public class CompararEnteros {
	public static void main(String[] args) {
		Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random();
		Random rand4 = new Random();

		for(int i = 0; i < 25; i++ ) {
			int valor1 = rand1.nextInt(10);
			int valor2 = rand2.nextInt(10);
			
			if(valor1 < valor2) System.out.println("1."+i+"--->"+valor1+" es MENOR que "+valor2);
			else if(valor1 > valor2) System.out.println("1."+i+"--->"+valor1+" es MAYOR que "+valor2);
			else if(valor1 == valor2) System.out.println("1."+i+"--->"+valor1+" es IGUAL que "+valor2);
		}
		
		for(int i = 0; i < 25; i++ ) {
			int valor3 = rand3.nextInt(20);
			int valor4 = rand4.nextInt(20);
			
			if(valor3 < valor4) System.out.println("2."+i+"--->"+valor3+" es MENOR que "+valor4);
			else if(valor3 > valor4) System.out.println("2."+i+"--->"+valor3+" es MAYOR que "+valor4);
			else if(valor3 == valor4) System.out.println("2."+i+"--->"+valor3+" es IGUAL que "+valor4);
		}
		
	}
}
