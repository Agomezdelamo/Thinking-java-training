package alvaro.thinking.tema5.inicializacion;

/* El argumento String... args admite un número indeterminado de argumentos del tipo que lleva
 * los puntos suspensivos, en este caso String.
*/

public class VarArg {
	static void showStrings(String... args) {
		for(String s : args)
			System.out.print(s + " ");
		System.out.println();
	}
	public static void main(String[] args) {
//		varargs de String admite o multiples strings...
		showStrings("one", "TWO", "three", "four");
//		...o un array de Strings.
		showStrings(new String[]{"1", "2", "3", "4","5","6"});
	}
}