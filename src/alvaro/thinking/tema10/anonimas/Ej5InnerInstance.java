package alvaro.thinking.tema10.anonimas;

	
	class OutterOne {
		private int contador;
		public OutterOne() {
//			Constructor outter
		}
		
		class InnerOne {
			public InnerOne() {
				contador++;
				System.out.print("objeto nº"+contador+" de clase inner creado\n");
			}
		}
		
		public InnerOne getInnerOne() {
			return new InnerOne();
		}
	}
	
public class Ej5InnerInstance {
	
	public static void main(String[] args) {
		
		OutterOne InstanciaOutter = new OutterOne();
		
		//dos formas de crear un puntero a un objeto de clase inner
			//1 con un metodo de la clase outter
			OutterOne.InnerOne InstanciaInner = InstanciaOutter.getInnerOne();
			
			//2 con un puntero a outter que construya un inner
			OutterOne.InnerOne oi = InstanciaOutter.new InnerOne();	
	}
	
}
