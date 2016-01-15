package alvaro.thinking.tema4.controlandoEjecucion;

public class BitTest {
	static void binaryPrint (int q) {
		if(q == 0) System.out.print("el entero que entra es un cero ----> "+0);
		else {
			int nlz = Integer.numberOfLeadingZeros(q); 
			q <<= nlz;
			for(int p = 0; p < 32 - nlz; p++) {
				int n = (Integer.numberOfLeadingZeros(q) == 0) ? 1 : 0;
				System.out.print(n);		
				q <<= 1;
			}		
		}
		System.out.println("");
	}
	
	/**
	 * Estudiar a fondo el tema de los binarios.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
//		loop para imprimir la secuencia de binarios del 1 al 100.
		for (int i = 0; i < 100; i++) System.out.println("el numero entero "+i+" es en binario "+Integer.toBinaryString(i));
		
		int i = 1 + 4 + 16 + 64;
		int j = 2 + 8 + 32 + 128;
		int k = 0x100;
		int m = 0;
		System.out.println("Vamos a usar la impresora de int a binarios \r\nInteger.toBinaryString():");
		System.out.println("i = " +i+" y en binario es "+ Integer.toBinaryString(i));
		System.out.println("j = " + Integer.toBinaryString(j));
		System.out.println("k = " + Integer.toBinaryString(k));
		System.out.println("m = " + Integer.toBinaryString(m));		
		System.out.println("i & j = " + (i & j) + " = " + Integer.toBinaryString(i & j));
		System.out.println("i | j = " + (i | j) + " = " + Integer.toBinaryString(i | j));
		System.out.println("i ^ j = " + (i ^ j) + " = " + Integer.toBinaryString(i ^ j));
		System.out.println("~i = " + Integer.toBinaryString(~i));
		System.out.println("~j = " + Integer.toBinaryString(~j));
		System.out.println("Using binaryPrint():");
		System.out.println("i = " + i + " = ");
		binaryPrint(i);		
		System.out.println("j = " + j + " = ");
		binaryPrint(j);
		System.out.println("k = " + k + " = ");
		binaryPrint(k);		
		System.out.println("m = " + m + " = ");
		binaryPrint(m);
		System.out.println("i & j = " + (i & j) + " = ");
		binaryPrint(i & j);
		System.out.println("i | j = " + (i | j) + " = ");
		binaryPrint(i | j);
		System.out.println("i ^ j = " + (i ^ j) + " = ");
		binaryPrint(i ^ j);
		System.out.println("~i = " + ~i + " = ");
		binaryPrint(~i);		
		System.out.println("~j = " + ~j + " = ");
		binaryPrint(~j);
	}	
}