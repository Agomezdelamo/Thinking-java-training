package alvaro.thinking.tema10.anonimas;

//escribe una clase denominada outter que contenga una denominada inner.

public class Outer1 {
		//constructor Outter1
		Outer1() { System.out.println("Outter1()"); }
	
		//constructor Inner
		class Inner { public Inner(){System.out.println("Inner()");} }
		
		//método que devuelve un inner
		public Inner getInner() {return new Inner();};
	
	public static void main (String[] args){
		Outer1 outter1 = new Outer1();
		Inner inner = outter1.getInner();
	}
}