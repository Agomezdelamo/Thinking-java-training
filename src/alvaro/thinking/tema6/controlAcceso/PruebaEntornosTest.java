package alvaro.thinking.tema6.controlAcceso;

/*ENTORNO DEBUG*/
import alvaro.thinking.tema6.controlAcceso.entornoDebug.Coche;

/*ENTORNO PRODUCCIÓN*/
//import alvaro.thinking.controlAcceso.tema6.entornoSinDebug.Coche;

public class PruebaEntornosTest {
	public static void main (String[] args) {
//		Es un experimento usando distintos paquetes que llaman a una misma Clase.
//		Con el mismo código simplemente cambiando el paquete que importa, puedo pasar de producción a test.
//		Es la base de lo que se hace ahora con los frameworks para testear código.
		Coche ibiza = new Coche("---> ibiza <---");
	}
	
}
