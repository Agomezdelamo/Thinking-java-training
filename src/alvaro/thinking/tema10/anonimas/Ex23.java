package alvaro.thinking.tema10.anonimas;

//innerclasses/Ex23.java
//TIJ4 Chapter Innerclasses, Exercise 23, page 371

//1.Crea un interface U con 3 métodos.
interface U {
	void f();
	void g();
	String toString();
}

/**
 * 2.Crea una clase A con un método que retorne un objeto 
 * del interface U construyendo una clase interna anónima.
 */
class Aclass {
	U buildU() {
		return new U() {
			public void f() { System.out.println("f()"); }
			public void g() { System.out.println("g()"); }
			public String toString() { return "I'm a U"; }
		};
	}
}

/**
 * 3. Crea una segunda clase B que contenga un array del interface U
 */
class Bclass {
	private U[] us;
	
	Bclass(int i) {//CONSTRUCTOR
		us = new U[i];
	}
	
	// 4. B deberia tener un metodo que acepte y almacene una referencia de U en el array,
 	void addU(U u, int i) {
		us[i] = u;
	}
 	
 	//5. un segundo método que setee la referencia en el array a null, 
 	void eraseU(int i) {
		us[i] = null;	
	}
 	
	//6. y un tercer método que se mueva a través del array y llame a los métodos de U.
	void testUs() {
		for(U u : us) {
			u.f();
			u.g();
			u.toString();
		}		
	}
	void showUs() {
		for(U u : us) { 
			if(u != null) System.out.println(u.toString());
			else System.out.println("I'm null");
		}
	}
}
/**
* 7. En main, crea un grupo de objetos A, Y un solo objeto B.
*/
public class Ex23 {
	public static void main(String[] args) {
		Aclass a0 = new Aclass();
		Aclass a1 = new Aclass();
		Aclass a2 = new Aclass();
		Bclass b = new Bclass(3);
		
		//8. Rellena el B con referencias a U producidas con objetos A.
		b.addU(a0.buildU(), 0);
		b.addU(a1.buildU(), 1);
		b.addU(a2.buildU(), 2);
		
		//9. Usa el B para llamar a todos los objetos A.
		b.showUs();
		b.testUs();
		
		//10. Borra algunas de las referencias a U de B.
		b.eraseU(0);
		b.eraseU(1);
		b.showUs();
	}
}