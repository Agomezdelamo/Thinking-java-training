package alvaro.thinking.tema5.inicializacion;

/**
 * Crear una clase con un campo String static inicializado en el punto de definición y otro
 * inicilizado con el constructor static. 
 * Añade un método static con un syso de ambos campos y demuestra que ambos son inicializados
 * cuando son usados.
*/

class Vamos {
	static String s1 = "correr";
	static String s2, s3;
	//1. primero al acceder a cualquier propiedad del constructor static se inicializan todas.
	static { 
		s2 = "conducir coche";
		s3 = "volar avión";
		System.out.println("Vamos.how() inicializa los campos static y el constructor static:\r\ns1 "+s1+": inicializada aunque esta fuera.");
		System.out.println("s2 & s3 inicializados");
		System.out.println("----------------------------------------");
	}
	static void how() {
		System.out.println(s1 + " o " + s2 + " o " + s3); 
	}
	Vamos() { System.out.println("Constructor clase new Vamos()"); }	
}

public class ExplicitStaticEx {
	public static void main(String[] args) {
		//4. curioso, este syso espera a que todos los campos o métodos estaticos esten inicializados.
		System.out.println("Inside main()"); 
		Vamos.how();//1. arrancan todos los static y despúes el se ejecuta.
		System.out.println("Vamos.s1: " + Vamos.s1);		
	}
	
	//2. y 3. se inicializan estos dos campos porque son static.
	static Vamos g1 = new Vamos(); 
	static Vamos g2 = new Vamos(); 
}