package alvaro.thinking.tema6.controlAcceso.entornoSinDebug;

public class Coche {
	public Coche(String indice) { 
		System.out.println("Estoy en un entorno de desarrollo con un coche marca "+indice+", y esta clase es para producci�n.");
	}
	
	protected void printer(){ System.out.println("soy un m�todo protegido");}
}
