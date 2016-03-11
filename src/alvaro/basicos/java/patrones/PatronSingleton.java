package alvaro.basicos.java.patrones;

/**
 * PATR�N SINGLETON o SOLITARIO.
 * S�lo instancias una vez en una variable static.
 * A partir de ahi accedes a ella desde un m�todo static visible para toda la aplicaci�n.
 * 
 * Es una forma de programar, no generas instancias innecesarias de ese objeto y el programa
 * va m�s ligero.
 */

class Soup {
	//constructor privado
	private Soup() {}

	// Singleton o una sola instancia.
	private static Soup ps1 = new Soup();
	
	public static Soup ps2 = ps1;
	
	//m�todo para recuperar la instancia.
	public static Soup accessoSoup() {
		return ps1;
	}
	
	public void f() {System.out.println("m�todo de objeto singleton Soup");}
}

class Sandwich { 
  void f() { new PatronSingleton(); }
}

// Only one public class allowed per file:
public class PatronSingleton {
  public static void main(String[] args) {
	//accedo al m�todo del objeto soup a trav�s de su �nica instancia.
    Soup.accessoSoup().f();
    
    //otra manera de acceder, esta vez con un puntero publico, que apunta a la objeto instanciado privado.
    Soup.ps2.f();
  }
} 

