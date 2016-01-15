package alvaro.thinking.tema2.todoEsUnObjeto;

public class Clase {
	//si voy a tirar un string a pelo desde un método static tengo que hacerlo static;
	//no puedo crear un metodo static que se graba una vez en memoria con un objeto String que no es static
	//y va al monton.
	private static String hola;

	
	public static void main(String[] args){
		hola = "hola mundo";
		escribeFrase(hola);
	}
	
	
	public static void escribeFrase(String paramTxt) {
		System.out.print("esto es "+paramTxt);
	}
}


