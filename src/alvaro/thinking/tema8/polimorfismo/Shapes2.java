package alvaro.thinking.tema8.polimorfismo;

public class Shapes2 {
	private static RandomShapeGenerator gen = new RandomShapeGenerator();
	public static void main(String[] args) {
		Shape[] s = new Shape[10];
		// rellenamos el array con formas.
		for(int i = 0; i < s.length; i++)
			s[i] = gen.next();
		// hacemos llamadas polimorficas:
		for(Shape shp : s) {
			shp.draw();
			
			// Da igual hacer @override o no en el método de circle o de triangle,
			// como en la generalización, se realiza acoplamiento tardio
			// el método va a saber que objeto le llama en tiempo de ejecución,
			//en este caso override sobra, no necesitamos sobreescribir el método de la clase base.
			shp.amend();
		}	
	}
}