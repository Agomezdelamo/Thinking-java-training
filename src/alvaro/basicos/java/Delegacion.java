package alvaro.basicos.java;

/**
 * Delegar es combinar el tema de composición (instanciar clases de un mismo paquete en una, y herencia.
 * 
 * La combinación se produce cuando instancias una clase dentro de otra, y en los métodos públicos,
 * usas el mismo interface pero dentro se llama al mismo método de la clase externa.
 * @author Dj nezhod
 */

class Cleanser2 {
	private String s = "Cleanser";
	public void append(String a) { s += a; }
	public void dilute() { append(" dilute()"); }
	public void apply() { append(" apply()"); }
	public void scrub() { append(" scrub()"); }
	public String toString() { return s; }
	public static void main(String[] args) {
		Cleanser2 x = new Cleanser2();
		System.out.println(x);
	}
}

public class Delegacion {
	private String s = "DelegacionDetergente \r\n";
	Cleanser2 c = new Cleanser2();
	public void append(String a) { s += a; }
	
	// dilute y apply se delegan a la instancia c de cleanser.
	public void dilute() { c.dilute(); }
	public void apply() { c.apply(); }
	
	// método delegado parcialmente a Cleanser c:
	public void scrub() {
		append("\r\nDelegacion de detergente.scrub()");
		c.scrub(); 
	}
	public void foam() { append(" foam()"); } 
	public String toString() { return s + " " + c; }	
	public static void main(String[] args) {
		Delegacion x = new Delegacion();
		x.dilute();
		x.apply();
		x.scrub();
		x.foam();
		System.out.println(x);
		System.out.println("\r\nProbando la clase base:");
		Cleanser2.main(args);
	}
}