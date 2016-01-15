package alvaro.thinking.tema7.reusar;
/**
* Cree dos clases A y B, con constructores predeterminados que impriman su nombre.
* 
* Cree una nueva clase llamada C que herede de A y cree un miembro de clase B
* dentro de C. No cree un constructor para C. Cree un objeto de clase C y observer
* los resultados. 
*/

class Padre { Padre(){ System.out.println("Padre()");} }

class Hijo extends Padre { Hijo(){ System.out.println("Hijo()");} }

/**
 * Hijastro del padre con otra madre, no tiene que ver con el otro hijo.
 * @author Dj nezhod
 *
 */
class Hijastro extends Padre { 
	Hijo h = new Hijo(); // 2. Instancio al hijo, pero llama al constructor del padre primero y luego al suyo.
	public static void main(String[] args) {
		Hijastro c = new Hijastro(); //1. Instancio al Hijastro y construye al padre y después a el mismo e imprime al padre.
	}
}