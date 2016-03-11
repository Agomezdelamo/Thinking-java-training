package alvaro.basicos.java.interfaces;

/* Crear un interface llamado ComidaRapida (con los métodos apropiados)
 * y cambiar sandwich para que implemente ComidaRapida
*/

interface ComidaRapida {
	void hamburguesaQueso();
	void patatas();
	void refresco();
}

class Comida1 {
	Comida1() { System.out.println("Constructor --> Comida1()"); } 
	Comida1(int i) { System.out.println("Constructor sobrecargado: ya iniciado --> Comida1("+i+")"); } 
}

class Pan1 {
	Pan1() { System.out.println("Constructor --> Pan1()"); } 
}

class Queso1 {
	Queso1() { System.out.println("Constructor --> Queso1()"); } 
}

class Lechuga1 {
	Lechuga1() { System.out.println("Constructor --> Lechuga1()"); } 
}

class Almuerzo1 extends Comida1 {
	Almuerzo1() { System.out.println("Constructor --> Almuerzo1()"); } 
	Almuerzo1(int i) { 
		super(i);
		System.out.println("Constructor sobrecargado: ya iniciado --> Almuerzo1("+i+")"); } 
}

class Tupper1 extends Almuerzo1 {
	Tupper1() { System.out.println("Constructor --> Tupper()"); } 
}	

public class InterfaceEjemplo extends Tupper1 implements ComidaRapida {
	private Pan1 b = new Pan1();
	private Queso1 c = new Queso1();
	private Almuerzo1 l = new Almuerzo1(1);
	
	public InterfaceEjemplo() { System.out.println("Constructor --> InterfaceEjemplo()"); }
	
	/* implementacion1 */
	public void hamburguesaQueso() { System.out.println("\r\n----inicio interface implementado----\r\nhamburguesaQueso"); }

	/* implementacion2 */
	public void patatas() { System.out.println("patatas"); }

	/* implementacion3 */
	public void refresco(){ System.out.println("refresco"); }
	
	public static void main(String[] args) {
		InterfaceEjemplo s = new InterfaceEjemplo();
		
		/*interface*/
		s.hamburguesaQueso();
		s.patatas();
		s.refresco();
		
	} 
}