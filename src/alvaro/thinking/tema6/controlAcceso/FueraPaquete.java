package alvaro.thinking.tema6.controlAcceso;

/**
 * Crear una instancia de una clase desde otro paquete
 * sin importar el paquete.
 * @author agomez
 *
 */
public class FueraPaquete {
	public static void main(String[] args) {
		alvaro.thinking.tema5.inicializacion.DogTalk perrrito = new alvaro.thinking.tema5.inicializacion.DogTalk();
	}
}
