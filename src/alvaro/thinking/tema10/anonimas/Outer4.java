package alvaro.thinking.tema10.anonimas;

/* Determina cuando una clase outer puede tener acceso a los campos privados de una inner.
* its inner class. 
*/

public class Outer4 {	
	class Inner {
		private int ii1 = 1;
		private int ii2 = 2;
		private void showIi2() { System.out.println(ii2); } //metodo que pinta un campo privado de inner
		private void hi() { System.out.println("Inner hi"); }
	}
	
	// Es necesario crear un objeto inner para acceder a su campo privado
	int oi = new Inner().ii1;
	void showOi() { System.out.println(oi); }
	void showIi2() { new Inner().showIi2(); } //este peta porque no crea un objeto para acceder al privado.
	void outerHi() { new Inner().hi(); }
	public static void main(String[] args) {
		Outer4 out = new Outer4();
		out.showOi();
//		out.showIi2();  //no puede pintar un campo privado inner porque no existe el objeto inner.
		out.outerHi();
	}
}