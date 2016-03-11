package alvaro.thinking.tema10.anonimas;


//innerclasses/Ex20.java
//TIJ4 Chapter Innerclasses, Exercise 20, page 367
/* Create an interface containing a nested class. Implement this interface and 
* create an instance of the nested class.
*/

interface In {
	class Nested {//clase interna en un interface
		Nested() { System.out.println("Nested()"); }
		public void hi() { System.out.println("hi"); } //metodo de la clase interna del interface
	}
}

public class InterfaceInner4 implements In {
	public static void main(String[] args) {
		In.Nested in = new In.Nested(); //genero la clase interna del interface
		in.hi(); //llamo a su método.
	}
}