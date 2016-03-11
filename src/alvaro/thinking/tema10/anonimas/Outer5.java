package alvaro.thinking.tema10.anonimas;

/* Repite el ejercicio 7 usando una clase iner anonima.
* (Exercise 7: 
* Crear una clase con un campo privado y un m�todo privado.
* Crear una clase inner con un m�todo que modfique el campo de la clase outer y llame al m�todo outer.
* 
* En una segunda clase, crea un objeto de la clse inner y llama a ese m�todo y muestra el efecto sobre la clase outer.
*/

interface Inner12 {	void modifyOuter(); } //interface inner

public class Outer5 {
	private int oi = 1; //camop privado
	private void hi() { System.out.println("Outer hi"); } //m�todo privado.
	
	public Inner12 inner() { 
		/**
		 * Ojo, aqui hago un truqi.
		 * Devuelvo un objeto inner.
		 * NO SE PUEDE guardar un puntero de un interface /Inner12 inner12 = new Inner12();/
		 * pero si devolver un objeto anonimo de el sin guardarlo en ning�n puntero.
		 */
		//m�todo outer que devuelve una referencia an�nima de una clase inner.
		return new Inner12() {
			public void modifyOuter() { //metodo inner que modifica el outer.
				oi *= 2;
				hi(); 
			}
		}; 
	}
	public void showOi() { System.out.println(oi); }
	public static void main(String[] args) {	
		Outer5 out = new Outer5();
		out.showOi(); //muestro el campo privado outer
		out.inner().modifyOuter(); //lo modifico con inner
		out.showOi(); //lo muestro de nuevo
	}
}

