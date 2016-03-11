package alvaro.thinking.tema9.interfaces;

/* Crear un interface llamado ComidaRapida (con los métodos apropiados)
 * y cambiar sandwich para que implemente ComidaRapida
*/

interface ComidaRapida {
	void hamburguesaQueso();
	void patatas();
	void refresco();
}

class Comida {
	Comida() { System.out.println("Constructor --> Comida()"); } 
	Comida(int i) { System.out.println("Constructor sobrecargado: ya iniciado --> Comida("+i+")"); } 
}

class Pan {
	Pan() { System.out.println("Constructor --> Pan()"); } 
}

class Queso {
	Queso() { System.out.println("Constructor --> Queso()"); } 
}

class Lechuga {
	Lechuga() { System.out.println("Constructor --> Lechuga()"); } 
}

class Almuerzo extends Comida {
	Almuerzo() { System.out.println("Constructor --> Almuerzo()"); } 
	Almuerzo(int i) { 
		super(i);
		System.out.println("Constructor sobrecargado: ya iniciado --> Almuerzo("+i+")"); } 
}

class Tupper extends Almuerzo {
	Tupper() { System.out.println("Constructor --> Tupper()"); } 
}	

public class Sandwich extends Tupper implements ComidaRapida {
	private Pan b = new Pan();
	private Queso c = new Queso();
	private Almuerzo l = new Almuerzo(1);
	
	public Sandwich() { System.out.println("Constructor --> InterfaceEjemplo()"); }
	
	/* implementacion1 */
	public void hamburguesaQueso() { System.out.println("\r\n----inicio interface implementado----\r\nhamburguesaQueso"); }

	/* implementacion2 */
	public void patatas() { System.out.println("patatas"); }

	/* implementacion3 */
	public void refresco(){
		System.out.println("refresco");
	}
	public static void main(String[] args) {
		Sandwich s = new Sandwich();
		
		/*interface*/
		s.hamburguesaQueso();
		s.patatas();
		s.refresco();
		
	} 
}