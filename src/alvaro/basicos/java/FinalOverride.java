package alvaro.basicos.java;

//Muestra que la antoación @Override resuelve el problema comentado en esta sección.

class WithFinals {
	// Identico a privado solamente:
	private final void f() { System.out.println("WithFinals.f()"); }
	// Además automaticamente es "final":
	private void g() { System.out.println("WithFinals.g()"); }
} 

class OverridingPrivate extends WithFinals {
	// intentando sobreescribir:
	private final void f() { System.out.println("OverridingPrivate.f()"); }
	private void g() { System.out.println("OverridingPrivate.g()"); }
	// @Override: compiler finds error - "no se puede sobreescribir"
	// @Override private final void f() { System.out.println("OverridingPrivate.f()"); }
	// @Override private void g() { System.out.println("OverridingPrivate.g()"); }
}

class OverridingPrivate2 extends OverridingPrivate {
	// intentando sobreescribir:
	public final void f() { System.out.println("OverridingPrivate2.f()"); }
	public void g() { System.out.println("OverridingPrivate2.g()"); }
	// use @Override so compiler with say "no se puede sobreescribir o implementar"
	// @Override public final void f() { System.out.println("OverridingPrivate2.f()"); }
	// @Override public void g() { System.out.println("OverridingPrivate2.g()"); }
}

public class FinalOverride {
	public static void main(String[] args) {
		OverridingPrivate2 op2 = new OverridingPrivate2();
		op2.f();
		op2.g();
		// Puedes hacer upcasting:
		OverridingPrivate op = op2;
		
		// Pero no puedes llamar a los métodos:
		//! op.f(); // f() tiene un acceso privado en OverridingPrivate
		//! op.f();
		
		// Igual aqui:
		WithFinals wf = op2;
		//! wf.f(); // f() tiene un acceso privado en WithFinals
		//! wf.g();
	}
}
