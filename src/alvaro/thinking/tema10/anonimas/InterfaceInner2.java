package alvaro.thinking.tema10.anonimas;

/*
 * Crea una clase privada inner que implemente un interface publico.
* Escribe un método que devuelva una referencia a una instancia de la clase privada, 
* haciendo upcasting al interface.
* 
* Muestra que la clase inner esta completamente oculta probando a hacer downcast sobre ella.
* */

//lo suyo que este fuese publico.
interface Ex11Interface {
	void say(String s); 
}


class Test {
	private class Inner implements Ex11Interface {
		public void say(String s) {
			System.out.println(s); 
		}
	}
	Ex11Interface f() { return new Inner(); } //metodo que devuelve la inner haciendo upcasting al interface.
}
public class InterfaceInner2 {	
	public static void main(String[] args) {
		Test t = new Test();
		t.f().say("hi"); //puedo hacer esto porque f devuelve un objeto de clase del interface y este es público.
		
		// Si intento hacer lo mismo pero haciendo downcasting a inner, revienta porque inner es privada.
		// ((Inner)t.f()).say("hello");
	} 
}
