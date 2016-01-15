package alvaro.thinking.tema5.inicializacion;

//Create a class wih a String that is initialized using instance initialization 

class Tester3 {
	String s;
	/**
	 * inicialización de instancia, independientemente
	 * de cual de los 2 constructores del objeto se invoquen, lo que este dentro
	 * de este bloque, se ejecuta ANTES.
	 * 
	 * Es valido para las inner class.
	 */
	{
		s = "Inicializado el String en tester";
		System.out.println(s);
	}
	
	Tester3() {
		System.out.println("Constructor Tester3() \r\n");
	}
	
	Tester3(int i) {
		System.out.println("Constructor Tester3(3) con int "+i+" \r\n");
	}
}

public class InicializadorInstancia {
	public static void main(String[] args) {
//		new Tester3();				
		new Tester3(3);				
	}
}