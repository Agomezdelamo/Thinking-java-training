package alvaro.thinking.tema10.anonimas;

import alvaro.thinking.tema10.anonimas.Ej1Outter.Inner;

//escribe una clase denominada outter que contenga una denominada inner.

public class Ej3OutterPrivate {
		private String queSoy;
		//constructor Ejercicio1Outter
		Ej3OutterPrivate(String queSoy) { 
			this.queSoy = queSoy;
			System.out.println("Ejercicio1Outter()");
		}
	
		class Inner { 
			//constructor Inner
			public Inner(){System.out.println("Inner()");}
			
			@Override
			public String toString() {
				return "es "+queSoy;
			}
		}
		
		public Inner getInner() {return new Inner();};
	
	public static void main (String[] args){
		Ej3OutterPrivate cojoInner = new Ej3OutterPrivate("-privado-");
		Inner co = cojoInner.getInner();
		System.out.print("Estoy pintando un campo de outter que "+co+" desde una clase inner");
	}
}