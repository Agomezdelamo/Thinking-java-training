package alvaro.thinking.tema7.reusar;

import java.util.Random;


class Test {
	Test() { System.out.println("Test()"); }
}

public class FinalStatic {
	private String name;
	/*CONSTRUCTOR*/
	public FinalStatic(String s) { name = s;  } 
	// constante de ejecución, la constante es sólo el puntero, y como es static, sólo ocupa un espacio en memoria,
	//es decir, arranca una vez y nunca puede apuntar a otro objeto.
	static final Test FINAL_STATIC_EJECUCION = new Test(); 
	
	//lo mismo, es constante en tiempo de ejecución, el puntero nunca puede apuntar a otro objeto,
	//pero en este caso al hacer varias instancias, como no es static, si se generan diferentes objetos, es decir,
	//ocupan más de un espacio en memoria.
	private final Test FINAL_EJECUCION = new Test();
	
	// Cosntante de compilación, se compacta en compilación para ahorrar tiempo de ejecución.
	//ARRANCA UNA VEZ Y NUNCA SE MODIFICA.
	static final String STATIC_FINAL_STRING = "static final"; 
	
	//ARRANCA VARIAS VECES, O LO QUE ES LO MISMO, OCUPA DIFERENTES ESPACIOS DE MEMORIA,
	//PERO NUNCA PUEDE SER MODIFICADA UNA VEZ CREADA.
	private final String FINAL_STRING = "final";
	
	// SE GENERA UN RANDOM EN STATIC,SÓLO SE GENERA UNA VEZ,
	//UN SOLO ESPACIO EN MEMORIA.
	private static Random staticRandom = new Random();
	
	// Cosntante de compilación, se compacta en compilación para ahorrar tiempo de ejecución.
	//ARRANCA UNA VEZ Y NUNCA SE MODIFICA.
	static final int FINAL_STATIC_INT = staticRandom.nextInt(); 
	
	//ARRANCA VARIAS VECES, O LO QUE ES LO MISMO, OCUPA DIFERENTES ESPACIOS DE MEMORIA,
	//PERO NUNCA PUEDE SER MODIFICADA UNA VEZ CREADA.
	private final int FINAL_INT = staticRandom.nextInt();
	
	public String toString() {
		return (name + ": " + FINAL_STATIC_EJECUCION + ", " + FINAL_EJECUCION + ", " + STATIC_FINAL_STRING + ", " + FINAL_STRING + ", " + FINAL_STATIC_INT + ", " + FINAL_INT);   
	}
	
	public static void main(String[] args) {
		FinalStatic d1 = new FinalStatic("d1");
		FinalStatic d2 = new FinalStatic("d2");
		FinalStatic d3 = new FinalStatic("d3");
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}
}