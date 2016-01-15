package alvaro.basicos.java;

class A_Upcasting {
	//1
	protected void f() { 
		System.out.println("A.f()");
		//llama al objeto construido, puede ser un hijo.
		this.g(); 
	}
	
	//2
	protected void g() {
		System.out.println("A.g()"); 
	}
}

class B_Upcasting extends A_Upcasting {
	@Override protected void g() {
		System.out.println("B.g()");
	}
}

public class Upcasting1 {
	public static void main(String[] args) {
		B_Upcasting b = new B_Upcasting();
		// Autmaticamente se actualiza y sube a la llamada al método de la clase base A.f()
		// que, por el polimorfismo, se llame al método de la clase derivada B.g ():
		b.f();
	}
}