package alvaro.thinking.tema8.polimorfismo;

public class Rectangle extends Shape {
	@Override public void draw() { System.out.println("Rectangle.draw()"); }
	@Override public void erase() { System.out.println("Rectangle.erase()"); }
	@Override public void amend() { System.out.println("Rectangle.amend()"); }
}