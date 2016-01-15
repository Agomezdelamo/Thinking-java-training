package alvaro.thinking.tema2.todoEsUnObjeto;

public class Rainbow {
	public static void main (String[] args) {
		AlltheColorsOfTheRainbow todos = new AlltheColorsOfTheRainbow();
		
		System.out.print("AlltheColorsOfTheRainbow: colors----> "+todos.getColors()+"\r\n");
		System.out.print("AlltheColorsOfTheRainbow: hue----> "+todos.getHueTono()+"\r\n");
		
		todos.setColors(7);
		todos.setHueTono(77);
	
		System.out.print("After change, AlltheColorsOfTheRainbow: colors----> "+todos.getColors()+"\r\n");
		System.out.print("After change, AlltheColorsOfTheRainbow: hue----> "+todos.getHueTono()+"\r\n");
	}
}

class AlltheColorsOfTheRainbow {
	private int colors = 0;
	private int hueTono = 0;
	
	public int setColors(int changeColor) { return colors = changeColor; }
	public int setHueTono(int changeHueTono) { return hueTono = changeHueTono; }

	public int getColors() { return colors; }
	public int getHueTono() { return hueTono; }
	
	
}