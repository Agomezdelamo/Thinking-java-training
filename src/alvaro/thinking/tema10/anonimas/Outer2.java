package alvaro.thinking.tema10.anonimas;

/**
 * Modfica el ejercicio Outter1 para que tenga un campo String privado
 * que se setee en el constructor, y que el inner tenga un toString que muestre
 * este campo.
 */

public class Outer2 {
		private String s;
		
		//constructor Outter1
		Outer2(String s) { 
			System.out.println("Outter1()"); 
			this.s = s;
		}
	
		//constructor Inner
		class Inner { 
			public Inner(){System.out.println("Inner()");} 
			//devuelvo un campo de outter desde inner.
			public String toString() { return s;}
		}
		
		//método que devuelve un inner
		public Inner getInner() {return new Inner();};
	
	public static void main (String[] args){
		Outer2 outter2 = new Outer2("soy un campo de outter impreso desde inner");
		Inner inner = outter2.getInner();
		System.out.println(inner.toString());
	}
}