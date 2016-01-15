package alvaro.thinking.tema7.reusar;

class WithFinal {
	final void f() { System.out.println("WithFinal.f()"); } // 1. 
	void g() { System.out.println("WithFinal.g()"); } // 2.
	final void h() { System.out.println("WitFinal.h()\r\n"); } // 3.
} 

class OverrideFinal extends WithFinal {
	// Intentando sobreescribir:
	// public final void f() { System.out.println("OverrideFinal.f()"); } // 1. no se puede
	
	@Override 
	public void g() { System.out.println("OverrideFinal.g()"); } // 2. OK, not final

	// final void h(); { System.out.println("OVerrideFinal.h()"); } // 3. no se puede sobreescribir final 	
}

public class FinalOverride2 {
	public static void main(String[] args) {
		OverrideFinal of = new OverrideFinal();
		of.f();
		of.g();
		of.h();
		// Upcasting, generalizamos el puntero de overrideFinal a su padre:
		// puede acceder a los métodos publicos del padre pero si ha sobreescrito alguno, tira del sobreescrito en el hijo.
		WithFinal wf = of;
		wf.f(); 
		//método sobreescrito en el hijo, va a tirar de este en vez de el del padre.
		wf.g();
		wf.h(); 
	}
}
