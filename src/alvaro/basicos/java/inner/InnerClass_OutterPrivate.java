package alvaro.basicos.java.inner;


//escribe una clase denominada outter que contenga una denominada inner.

public class InnerClass_OutterPrivate {
		private String queSoy;
		//constructor Ejercicio1Outter
		InnerClass_OutterPrivate(String queSoy) { 
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
		InnerClass_OutterPrivate cojoInner = new InnerClass_OutterPrivate("-privado-");
		Inner co = cojoInner.getInner();
		System.out.print("Estoy pintando un campo de outter que "+co+" desde una clase inner");
	}
}