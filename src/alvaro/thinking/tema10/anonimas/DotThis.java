package alvaro.thinking.tema10.anonimas;

//construir un objeto outter desde una clase inner con THIS.

public class DotThis {
	public DotThis() {System.out.println("constructor Outter 'DotThis' ");}

	void f() {System.out.println("DotThis.f()");};
	
	public class Inner {
		public Inner() {System.out.println("constructor Inner 'Inner' ");}
		public DotThis outter() {
//			1. devuelvo el objeto externo, poniendo el nombre de su clase y this.
			return DotThis.this;
//			2. un this a pelo haría referencia al "this" del inner
		}
	}
	
	public Inner getInner() { return new Inner();};
	
	public static void main(String[] args) {
//		construyo outter
		DotThis dt = new DotThis();
//		construyo inner a traves del metodo getInner de Outter
		DotThis.Inner dti = dt.getInner();
		/**
		 * imprimo un metodo de outter desde dentro de un inner
		 * aprovechandome de que inner tiene un metodo que retorna un outher con this.
		 */
		dti.outter().f();
	}

}
