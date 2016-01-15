package alvaro.thinking.tema7.reusar;
/**
 * clase PADRE
 * 
 * sus campos son solo suyos y no se heredan (private) a no ser que sean protected
 * sus métodos los heredan sus hijos, y los pueden sobreescribir o no (son public).
 * @author Dj nezhod
 */
class Cleanser {
  private String className = new String("Cleanser");

//  metodo para añadir el nombre de la clase
  public void append(String a) { className += a; }
  
  // métodos
  public void dilute() { append(" dilute()"); }
  public void apply() { append(" apply()"); }
  public void scrub() { append(" scrub()"); }
  
  public String toString() { return className; }
  
  public static void main(String[] args) {
    Cleanser x = new Cleanser();
    x.dilute(); x.apply(); x.scrub();
    System.out.println(x);
  }
}

/**
 * Clase HIJA
 */
public class Detergent extends Cleanser {
  String classNameChild;
  
  // Constructor, no lleva nada de retorno
  public Detergent() {
	  classNameChild = "Detergent";
  }
  // SobreEscribir el método
  public void scrub() {
	// método del padre
    append("\r\n"+classNameChild+" sobreEscribe ---> scrub()\r\n");
    //llamada a la clase padre
    super.scrub(); 
  }
  // Añadimos un método al interfaz de la clase
  public void foam() { append("\r\n"+classNameChild+" sobreEscribe ---> foam()\r\n"); }

  // probamos la clase hija
  public static void main(String[] args) {
    Detergent x = new Detergent();
    x.dilute();
    x.apply();
    x.scrub();
    x.foam();
//    Imprimimos todos los métodos desde detergente, ya sean de su padre o de este hijo
    System.out.println(x);
    System.out.println("Probamos la clase padre y origen Cleanser:");
    
    //Y la padre
    Cleanser.main(args);
  }
} ///:~
