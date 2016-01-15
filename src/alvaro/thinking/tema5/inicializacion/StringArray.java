package alvaro.thinking.tema5.inicializacion;

/**
 * Crea un array de objetos string y asigna un stringa a cada elemento.
 * imprimir el array usando un for.
 * @author agomez
 *
 */


public class StringArray {
	public static void main(String[] args) {				
		String[] s = { "one", "two", "three", };		
		for(int i = 0; i < s.length; i++)
			System.out.println("s[" + i + "] = " + s[i]);
	}
}
