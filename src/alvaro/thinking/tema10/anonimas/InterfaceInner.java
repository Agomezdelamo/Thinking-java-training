package alvaro.thinking.tema10.anonimas;

/* Crear un interface con un sólo método, e implementarlo definiendo una clase inner dentro de un método que retorne
 * una referencia al interface.
*/

interface Ex9Interface {
	void say(String s); //metodo del interface
}

public class InterfaceInner {	
	Ex9Interface f() {
		class Inner implements Ex9Interface {
			public void say(String s) {	System.out.println(s); } //implementación del método.
		}	
		return new Inner();
	}
	
	public static void main(String[] args) {
		InterfaceInner iInner = new InterfaceInner();
		iInner.f().say("hi");
	} 
}