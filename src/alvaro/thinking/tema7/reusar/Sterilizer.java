package alvaro.thinking.tema7.reusar;

public class Sterilizer extends Detergent {
	//sobreescribimos m�todo
	public void scrub() { append(" Sterilizer.scrub()"); }
	
	//a�adimos un m�todo nuevo, la clase sterilizer ya no es un cleanser, 
	//es COMO un cleanser, pero con m�s m�todos.
	public void sterilize() { append(" sterilize()"); }
	public static void main(String[] args) {
		Sterilizer x = new Sterilizer();
		x.dilute();
		x.apply();	
		x.scrub();
		x.foam();
		x.sterilize();
		System.out.println(x);
		System.out.println("\r\nProbando la clase padre Detergent:");
		
		//llamada al main de la clase padre.
		Detergent.main(args);
	}
}