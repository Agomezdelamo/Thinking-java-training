package alvaro.thinking.tema12.excepciones;

//reusing/CADSystem16.java
//TIJ4 Chapter Exceptions, Exercise 16, page 477
//MOdify reusing/CADSystem.java to demonstrate that returning from the 
//middle of a try-finally will still perform proper cleanup.


class Shape {
	Shape(int i) { System.out.println("SHAPE CONSTRUCTOR"); }
	void acabar() { System.out.println("shape acabar"); }		
}

class Circle extends Shape {
	Circle(int i) {
		super(i);
		System.out.println("DIBUJAR CIRCLE");
	}
	void acabar() {
		System.out.println("borrar circle");
		super.acabar();
	}
}

class Triangle extends Shape {
	Triangle(int i) {
		super(i);
		System.out.println("DIBUJAR TRIANGLE");
	}	
	void dipsose() { 
		System.out.println("borrar triangle"); 
		super.acabar();	
	}
}

class Line extends Shape {
	private int start, end;
	Line(int start, int end) {
		super(start);
		this.start = start;
		this.end = end;
		System.out.println("DIBUJAR LINE: " + start + ", " + end); 
	}
	void acabar() {
		System.out.println("borrar line: " + start + ", " + end);
		super.acabar();
	}
}

public class CADSystem16 extends Shape {
	private Circle c;
	private Triangle t;
	private Line[] lines = new Line[3];
	
	//CONSTRUCTOR CADSystem16
	public CADSystem16(int i) {
		//llamo al constructor shape con un parametro
		super(i + 1);
		//construyo lineas con ese parametro
		for(int j = 0; j < lines.length; j++)
			lines[j] = new Line(j, j*j);
		c = new Circle(1);
		t = new Triangle(1);
		System.out.println("COMBINED CONSTRUCTOR");
	}
	
	public void acabar() {
		System.out.println("CADSystem.acabar()");
		// The order of cleanup is the reverse
		// of the order of initialization
		t.acabar();
		c.acabar();
		for(int i = lines.length - 1; i >= 0; i--)
			lines[i].acabar();
		super.acabar();
	}
	
	public static void main(String[] args) {
		//construye CADSystem16
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println("---------------------");

		CADSystem16 x = new CADSystem16(47);
		try {
			System.out.println("RETURNING FROM TRY BLOCK");
			System.out.println("---------------------");
			System.out.println("---------------------");
			System.out.println("---------------------");
			return;
			// unreachable statement:
			// System.out.println("You can't see this");
			// but finally block will still execute:
		} finally {
			x.acabar();
		} 
	}	
}