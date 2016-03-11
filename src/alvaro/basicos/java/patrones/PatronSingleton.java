package alvaro.basicos.java.patrones;

/**
 * PATRÓN SINGLETON o SOLITARIO.
 * Sólo instancias una vez en una variable static.
 * A partir de ahi accedes a ella desde un método static visible para toda la aplicación.
 * 
 * Es una forma de programar, no generas instancias innecesarias de ese objeto y el programa
 * va más ligero.
 */

class Soup {
	//constructor privado
	private Soup() {}

	// Singleton o una sola instancia.
	private static Soup ps1 = new Soup();
	
	public static Soup ps2 = ps1;
	
	//método para recuperar la instancia.
	public static Soup accessoSoup() {
		return ps1;
	}
	
	public void f() {System.out.println("método de objeto singleton Soup");}
}

class Sandwich { 
  void f() { new PatronSingleton(); }
}

// Only one public class allowed per file:
public class PatronSingleton {
  public static void main(String[] args) {
	//accedo al método del objeto soup a través de su única instancia.
    Soup.accessoSoup().f();
    
    //otra manera de acceder, esta vez con un puntero publico, que apunta a la objeto instanciado privado.
    Soup.ps2.f();
  }
} 

