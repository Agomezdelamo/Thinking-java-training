package alvaro.thinking.tema10.anonimas;

//innerclasses/Outer7.java
//TIJ4 Chapter Innerclasses, Exercise 7, page 354
/* Create a class with a private field and a private method. Create an
* inner class with a method that modifies the outer-class field and calls
* the outer class method. In a second outer-class method, create an object
* of the inner class and call its method, then show the effect on the
* outer-class object. 
*/

public class Outer3 {
	private int oi = 1;
	public void showOi() { System.out.println("campo privado outer oi: "+oi); }
	
	private void hi() { System.out.println("Outer hi()"); }
	
	class Inner {
		void modifyOuter() { 
			oi *= 2; //modifico campo privado outer
			hi(); //ejecuto metodo privado outer
		}
	}
	
	void testInner() {
		Inner in = new Inner();
		in.modifyOuter();
	}
	
	public static void main(String[] args) {
		Outer3 out = new Outer3();
		out.showOi(); //muestro el campo inicial
		out.testInner(); //creo objeto inner y ejecuto un metodo de inner modifyOuter.
		out.showOi(); //muestro campo de outer.
	}
}