package alvaro.thinking.tema12.excepciones;
//exceptions/Ex8.java
//TIJ4 Chapter Exceptions, Exercise 8, page 458
/* Write a class with a method that throws an exception of the type created
* in Exercise 4. Try compiling it without an exception specification to see
* what the compiler says. Add the appropriate exception specification. Try
* out your class and its exception inside a try-catch clause.
*/

class MyException4 extends Exception {
	private String msg;
	MyException4(String msg) {
		super(msg);
		System.out.println("Dentro del constructor de MyException4");
		this.msg = msg;
	}
	protected void showS() { 
		System.out.println("Mensaje de MyException4: " + msg);
	}
}

class Test8 {
	public static void f() throws MyException4 {
		System.out.println("metodo f()");
		throw new MyException4("echado del método f()");
	}
}

public class Ex8 {
	public static void main(String[] args) {
		try {
			Test8 t = new Test8();
			t.f();	
		} catch(MyException4 e) {
			System.err.println("MyException4 cogida");
			e.printStackTrace();
			e.showS();
		} 
	}	
}