package alvaro.thinking.tema6.controlAcceso;

/*ENTORNO DEBUG*/
import alvaro.thinking.tema6.controlAcceso.entornoDebug.Coche;

/*ENTORNO PRODUCCI�N*/
//import alvaro.thinking.controlAcceso.tema6.entornoSinDebug.Coche;

public class PruebaEntornosTest {
	public static void main (String[] args) {
//		Es un experimento usando distintos paquetes que llaman a una misma Clase.
//		Con el mismo c�digo simplemente cambiando el paquete que importa, puedo pasar de producci�n a test.
//		Es la base de lo que se hace ahora con los frameworks para testear c�digo.
		Coche ibiza = new Coche("---> ibiza <---");
	}
	
}
