package alvaro.thinking.tema7.reusar;

import alvaro.thinking.soluciones.Device;
import alvaro.thinking.tema6.controlAcceso.entornoSinDebug.BasicDevice;

/**
 * Crear una clase dentro de un paquete distinto a este.
 * Tu clase deberia contener un m�todo protected�.
 * Desde este otro paquete, prueba a llamar al m�todo protected y muestra los resultados.
 * 
 * Ahora hereda desde tu clase y llama al m�todo protegido desde dentro de un m�todo de tu clase derivada.
*/


class DeviceFail {	
	public static void main(String[] s) {
		BasicDevice fail = new BasicDevice();
		fail.showS();
		// fail.changeS("good-bye"); // cannot access protected method 	
	}
}

public class Dispositivo extends BasicDevice {
	void changeBasic(String t) {
		super.changeS(t); // calls protected method
	}	
	public static void main(String[] args) {
		Dispositivo d = new Dispositivo();
		d.showS();
		//m�todo protected que modifica el string que muestra showS
		//Como heredo de esa clase puedo usar ese m�todo aunque este en un paquete distinto.
		d.changeBasic("Cambiado");
		d.showS();
		DeviceFail.main(args);
	}
}