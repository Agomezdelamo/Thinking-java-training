package alvaro.thinking.tema7.reusar;

//Crea una clase final y trata de heredarla.
/**
 * Clase final
 * no queremos que nadie herede la clase ni la modifique por razones de seguridad.
 * @author Dj nezhod
 *
 */
class SmallBrain {} 

//clase final
final class Dinosaur {
	SmallBrain x = new SmallBrain();
}

//class Further extends Dinosaur {} // error: no se puede heredar de la clase "final" Dinosaur.

public class FinalClase {
	public static void main(String[] args) {
		Dinosaur d = new Dinosaur();
	}
}
