package alvaro.thinking.tema12.excepciones;
//exceptions/Ex10.java
//TIJ4 Chapter Exceptions, Exercise 10, page 468
/* Create a class with two methods, f() and g(). In g(), throw an exception of
* a new type that you define. In f(), call g(), catch its exception and, in the
* catch clause, throw a different exception (of a second type that you define).
* Test your code in main().
*/

class GException extends Exception {
	GException(String s) { super(s); }
}

class HException extends Exception {
	HException(String s) { super(s); }
}

public class Ex10 {
	static void f() {
		try {
			try {
				g();
			} catch(GException ge) {
				System.out.println("Cogida GException en f dentro del try");
				ge.printStackTrace();
				throw new HException("desde f(), dentro try");
			}
		} catch(HException he) {
			System.out.println("Cogida HException en f() fuera del try");
			he.printStackTrace(System.out);
		}
	}
	
	static void g() throws GException {
		throw new GException("desde g()");
	}
	public static void main(String[] args) {
		f();
	}	
}

	