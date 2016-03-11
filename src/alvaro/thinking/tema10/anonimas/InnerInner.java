package alvaro.thinking.tema10.anonimas;

//innerclasses/Ex19.java
//TIJ4 Chapter Innerclasses, Exercise 19, page 366
/* Create a class containing an inner class that itself contains an inner
* class. Repeat this using Anidada classes. Note the names of the .class files
* produced by the compiler.
*/

public class InnerInner { //externa
	InnerInner() { System.out.println("InnerInner()"); }
	
	private class Ex19Inner {//interna1
		Ex19Inner() { System.out.println("Ex19Inner()"); } 
		private class Ex19InnerInner {//interna2
			Ex19InnerInner() {
				System.out.println("Ex19InnerInner()");
			}
		}
	}
	private static class Ex19Anidada {//anidada1
		Ex19Anidada() { System.out.println("Ex19Anidada()"); }
		private static class Ex19AnidadaAnidada {//anidada2
			Ex19AnidadaAnidada() { 
			System.out.println("Ex19AnidadaAnidada()"); 
			}
		}
	}	
	public static void main(String[] args) {
		Ex19Anidada en = new Ex19Anidada();
		Ex19Anidada.Ex19AnidadaAnidada enn = new Ex19Anidada.Ex19AnidadaAnidada();
		InnerInner e19 = new InnerInner();
		InnerInner.Ex19Inner ei = e19.new Ex19Inner();
		InnerInner.Ex19Inner.Ex19InnerInner eii = ei.new Ex19InnerInner();
	}
}

/* compiler produces:
* Ex19$Ex19Inner$Ex19InnerInner.class
* Ex19$Ex19Inner.class
* Ex19$Ex19Anidada$Ex19AnidadaAnidada.class
* Ex19$Ex19Anidada.class
* Ex19.class
*/