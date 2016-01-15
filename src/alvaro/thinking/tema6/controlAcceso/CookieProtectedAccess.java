package alvaro.thinking.tema6.controlAcceso;

import alvaro.thinking.tema6.controlAcceso.entornoDebug.Coche;

public class CookieProtectedAccess {
	public static void main(String[] args) {
		Cookie x = new Cookie();
		// acceso de paquete a este método, al estar en el mismo paquete que la clase instanciada,
		//lo puedo usar
		x.bite(); 
		
		//Ejemplo contrario, instancio coche que esta en otro paquete, de hecho lo tengo que importar
		//y no puedo acceder a su método protected.
		Coche opel = new Coche("opel");
//		opel.printer();
	}	
}
