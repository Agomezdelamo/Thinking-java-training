package alvaro.thinking.tema6.controlAcceso.entornoDebug;

public class Coche {
	public Coche(String indice) { 
		System.out.println("Estoy en un entorno de test con un coche marca "+indice+", y esta clase me permite debugear.");
	}
	
	protected void printer(){ System.out.println("soy un método protegido");}
}
