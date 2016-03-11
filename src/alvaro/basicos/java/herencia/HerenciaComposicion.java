package alvaro.basicos.java.herencia;

//Usamos la herencia para mostrar la diferencia del método alert.
class AlertStatus {
	public void alert() {}
}

class NormalAlert extends AlertStatus {
	public void alert() { System.out.println("AlertStatus Normal"); }
}  

class HighAlert extends AlertStatus {
	public void alert() { System.out.println("AlertStatus High"); }
} 

class MaximumAlert extends AlertStatus {
	public void alert() { System.out.println("AlertStatus Maximum"); }
}

class Starship {
	//usamos la composición para modificar el estado de alert, y eso a su vez produce un cambio de comportamiento.
	//1. COMPONEMOS un puntero de clase alertSTatus y 
	private AlertStatus alertStatus = new NormalAlert();
	
	//2. mediante polimorfismo vamos reapuntando el puntero, es decir cambiamos su estado 
	// para tener un cambio de comportamiento.
	public void normalAlert() { alertStatus = new NormalAlert(); }
	public void highAlert() { alertStatus = new HighAlert(); }
	public void maximumAlert() { alertStatus = new MaximumAlert(); }
	public void checkAlertStatus() { alertStatus.alert(); } 
}

public class HerenciaComposicion {
	public static void main(String[] args) {
		Starship ss = new Starship();
		ss.checkAlertStatus();
		ss.highAlert();
		ss.checkAlertStatus();
		ss.maximumAlert();
		ss.checkAlertStatus();
		ss.normalAlert();
		ss.checkAlertStatus();
	}
}
