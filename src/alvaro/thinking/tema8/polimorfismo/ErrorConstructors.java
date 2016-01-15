package alvaro.thinking.tema8.polimorfismo;


class Glyph {
	void draw() { System.out.println("Glyph.draw()"); }
	Glyph() {
		System.out.println("\r\nINIT CONSTRUCTOR: Glyph() before draw()");
		//mala practica llamar metodos en constructor
		draw();
		System.out.println("END CONSTRUCTOR: Glyph() after draw()"); 
	}
}

class RoundGlyph extends Glyph {
	private int radius = 1;
	RoundGlyph(int r) {
		radius = r;
		System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
	}
	void draw() {
		System.out.println("RoundGlyph.draw(), radius = " + radius);
	}
}

class RectangularGlyph extends Glyph {
	private int length = 2;
	private int width = 4;
	RectangularGlyph(int l, int w) {
		length = l;
		width = w;
		System.out.println("RectangularGlyph.RectangularGlyph(), length = " 
			+ length + ", width = " + width);
	}
	void draw() {
		System.out.println("RectangularGlyph.draw(), length = " + length 
			+ ", width = " + width);
	}
}


public class ErrorConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
		new RectangularGlyph(3, 6);
	}
}