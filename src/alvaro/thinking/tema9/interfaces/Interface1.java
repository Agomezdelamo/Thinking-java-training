package alvaro.thinking.tema9.interfaces;

//interfaces.TestEx5.java

//Crear un interface que contenga 3 metodos e implementarlo

interface i1 {
	void sayOne();
	void sayTwo();
	void sayThree();
}


public class Interface1 implements i1 {
	public void sayOne() { System.out.println("one"); }
	public void sayTwo() { System.out.println("two"); }
	public void sayThree() { System.out.println("three"); }
	
	public static void main(String[] args) {
		Interface1 x = new Interface1();
		x.sayOne();
		x.sayTwo();
		x.sayThree();
	}
}