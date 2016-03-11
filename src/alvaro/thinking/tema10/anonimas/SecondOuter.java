package alvaro.thinking.tema10.anonimas;

	// innerclasses/SecondOuter.java
	// TIJ4 Chapter Innerclasses, Exercise 26, page 383
	/* Crea una clase con una clase inner que tenga un constructor que no sea el de por defecto(con argumentos).
	*  Crea una segunda clase con una inner clas que herede de la primera inner class
	*/

class FirstOuter {
	public class FirstInner {
		FirstInner(String s) { 
			System.out.println("FirstOuter.FirstInner() " + s ); 
		}
	}
}

public class SecondOuter {
	public class SecondInner extends FirstOuter.FirstInner { //hereda de la primera inner class
		SecondInner(FirstOuter x) { 
			x.super("hello"); 
			System.out.println("SecondOuter.SecondInner()"); 
		}		
	}
	public static void main(String[] args) {
		FirstOuter fo = new FirstOuter(); //no pinta nada
		SecondOuter so = new SecondOuter(); //no pinta nada
		SecondInner si = so.new SecondInner(fo); //pasa por el constructor de la primera inner por super()
		//y luego imprime el mensaje de secondInner
	}	
}

