package alvaro.thinking.tema12.excepciones;

//exceptions/TormentayTurno20.java
//TIJ4 Chapter Exceptions, Exercise 20, page 
/* MOdify TormentayTurno.java by adding an ArgumentoArbitro exception type
* and methods that throw this exception. Test the modified hierarchy. 
*/

//Métodos sustituidos pueden tirar sólo las excepciones
//Se especifica en sus versiones de la clase base, o excepciones
//Derivado de las excepciones de la clase base.

class ExcepcionBeisbol extends Exception {}
class Falta extends ExcepcionBeisbol {}
class Golpe extends ExcepcionBeisbol {}
class ArgumentoArbitro extends ExcepcionBeisbol {}
class ExpulsadoDelJuego extends ArgumentoArbitro {}

abstract class Turno {
	public Turno() throws ExcepcionBeisbol {}
	public void evento() throws ExcepcionBeisbol {
		// Doesn't actually have to throw anything
	}
	public abstract void bateando() throws Golpe, Falta, ArgumentoArbitro;
	public void questionableCall() throws ArgumentoArbitro {}
	public void caminar() {} // Throws no checked exceptions
}

class ExcepcionPorTormenta extends Exception {}
class SuspendidoPorLluvia extends ExcepcionPorTormenta {}
class PopFalta extends Falta {}


interface Tormenta {
	public void evento() throws SuspendidoPorLluvia;
	public void lloverFuerte() throws SuspendidoPorLluvia;
}

public class TormentayTurno20 extends Turno implements Tormenta {
	// OK to add new exceptions for constructors, but you
	// must deal with the base constructor exceptions:
	public TormentayTurno20()
		throws ArgumentoArbitro, SuspendidoPorLluvia, ExcepcionBeisbol {}
	public TormentayTurno20(String s)
		throws Falta, ExcepcionBeisbol {}
	// Regular methods must comform to base class:
	//! void walk() throws PopFalta {} // Compile error
	// Interface CANNOT add exceptions to existing
	// methods from the base class:
	//! public void evento() throws SuspendidoPorLluvia {}
	// If method doesn't already exist in the
	// base class, the exception is OK:
	public void lloverFuerte() throws SuspendidoPorLluvia {}
	// You can choose to not throw any exceptions,
	// even if the base class version does:
	public void evento() {}
	// Overridden methods can throw inherited exceptions:
	public void bateando() throws PopFalta, ExpulsadoDelJuego { 
		throw new ExpulsadoDelJuego();	
	}	
	public void llamadaCuestionable() throws ArgumentoArbitro {
		throw new ArgumentoArbitro();
	}
	
	/////////////////////////////////////
	///////////METODO ESTATICO///////////
	/////////////////////////////////////
	public static void main(String[] args) {
		try {
			TormentayTurno20 si = new TormentayTurno20();
			si.bateando();
			si.llamadaCuestionable();
		} catch(PopFalta e) {
			System.out.println("Pop Falta");
		} catch(ArgumentoArbitro e) {//<----------------------la primera excepción de los 2 metodos es esta
			System.out.println("Argumento arbitral (TormentayTurno20)");
		// } catch(ExpulsadoDelJuego e) {
		//	System.out.println("Expulsado del Juego");			
		} catch(SuspendidoPorLluvia e) {
			System.out.println("Lluvia fuera");
		} catch(ExcepcionBeisbol e) {
			System.out.println("Excepcion generica de beisbol");
		} 
		// Golpe sin torcer en versión derivada.
		try {
			// Que pasa si haces upCasting?
			Turno i = new TormentayTurno20();
			i.bateando(); //
			// You must catch the exceptions from
			// the base-class version of the method:
		} catch(Golpe e) {
			System.out.println("Golpe");
		} catch(Falta e) {
			System.out.println("Falta");
		} catch(ExpulsadoDelJuego e) {//<----------------------la segunda excepción es esta
			System.out.println("Expulsado del Juego (Turno)");	
		} catch(SuspendidoPorLluvia e) {
			System.out.println("Lluvia fuera");
		} catch(ExcepcionBeisbol e) {
			System.out.println("Excepcion generica de beisbol");
		}
	}
}