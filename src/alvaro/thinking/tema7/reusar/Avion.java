package alvaro.thinking.tema7.reusar;

/* Crear una clase dentro de otra e inicializarla de modo lazy() --perezoso.
*/


class Motor {
	private String s;
	Motor() {
		System.out.println("Motor()");
		s = "Constructed";
	}
	public String toString() { return s; }
}

public class Avion {
	private String fuselage, wings, tail;
	private Motor e;
	public Avion() {
		System.out.println("Inside Avion()");
		fuselage = "Body";
		wings = "Airfoils";
		tail = "Empennage";				
	}
	public String toString() { 
		/*si el campo de clase motor es null, se inicializa, 
		 * es perezoso porque toString a de ser declarado para que se inicialize*/
		if(e == null) // lazy (delayed) initialization:
			e = new Motor();
		return "fuselage = " + fuselage + ", " +
			"wings = " + wings + ", " +
			"tail = " + tail + ", " +
			"Motor = " + e;
	}
	public static void main(String[] args) {
		Avion N1234 = new Avion();
		/*inicializacion perezosa.*/
		System.out.println(N1234);
	}
}