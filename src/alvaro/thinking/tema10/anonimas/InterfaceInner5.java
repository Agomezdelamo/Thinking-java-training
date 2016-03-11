package alvaro.thinking.tema10.anonimas;


//innerclasses/Ex21.java
//TIJ4 Chapter Innerclasses, Exercise 21, page 367
/* Create an interface that contains a nested class that has a static method that
* calls the methods of your interface and displays the results. Implement your
* interface and pass an instance of your implementation to the method. 
*/

interface In2 {
	String f();
	String g(); 
	class Nested {
		static void testIn(In2 i) { 
			System.out.println(i.f() + i.g());
		}		
	}		
}

public class InterfaceInner5 implements In2 {
	public String f() { return "hello "; }
	public String g() { return "friend"; }
	
	public static void main(String[] args) {
		InterfaceInner5 x = new InterfaceInner5();
		
		//El método de la clase interna del interface, recibe el propio interface para ejuctar los métodos de este.
		In2.Nested.testIn(x); 
	}
}