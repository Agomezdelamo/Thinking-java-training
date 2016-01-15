package alvaro.basicos.java;

class Usable {
	public void f() {System.out.println("usable.f()");}
	public void g() {System.out.println("usable.g()");}
}

class MasUsable extends Usable {
	public void f() {System.out.println("masUsable.f()");}
	public void g() {System.out.println("masUsable.g()");}
	public void metodoAmpliado1() {System.out.println("masUsable.h()");}
	public void metodoAmpliado2() {System.out.println("masUsable.i()");}
}

public class PolimorfismoBasico2 {
	public static void main(String[] args){
		//UPCASTING, generalizo para almacenar padres e hijos
		Usable[] usablesGeneralizados = {
				new Usable(),
				new MasUsable()
		};
		//puedo almacenar 2 objetos distintos sobre puntero de una clase.
		usablesGeneralizados[0].f();
		usablesGeneralizados[1].f();
		
		//DOWNCASTING, le indico ala ejecución que tipo es para usar metodos ampliados
		((MasUsable) usablesGeneralizados[1]).metodoAmpliado1();
		/** Si no le digo que es (masUsable) la operacion de arriba no es posible*/
		// (usablesGeneralizados[1]).metodoAmpliado1(); 
		
	}
}
