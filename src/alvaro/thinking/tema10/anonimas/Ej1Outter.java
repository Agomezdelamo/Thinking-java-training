package alvaro.thinking.tema10.anonimas;

//escribe una clase denominada outter que contenga una denominada inner.

public class Ej1Outter {
		//constructor Ejercicio1Outter
		Ej1Outter() { System.out.println("Ejercicio1Outter()"); }
	
	
		class Inner { 
			//constructor Inner
			public Inner(){System.out.println("Inner()");}
		}
		
		public Inner getInner() {return new Inner();};
	
	public static void main (String[] args){
		Ej1Outter cojoInner = new Ej1Outter();
		Inner co = cojoInner.getInner();
	}
}