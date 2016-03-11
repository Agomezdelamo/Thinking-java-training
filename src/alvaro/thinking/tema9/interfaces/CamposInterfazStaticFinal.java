package alvaro.thinking.tema9.interfaces;

//Prueba que los campos de una interfaz son implicitamente static y final.


/******** INTERFAZ ********/
interface Days {
	int SUNDAY = 1, MONDAY = 2, TUESDAY = 3, WEDNESDAY = 4, 
		THURSDAY = 5, FRIDAY = 6, SATURDAY = 7; 
}

/******** CLASE QUE IMPLEMENTA ********/
class Week implements Days {
	private static int count = 0;
	private int id = count++;
	public Week() { System.out.println("Week() " + id); }
}

public class CamposInterfazStaticFinal {
	public static void main(String[] args) {
		// Sin ningun objeto, los campos static fields existen:
		System.out.println("SUNDAY = " + Days.SUNDAY);
		System.out.println("MONDAY = " + Days.MONDAY);
		
		/** INSTANCIO LOS OBJETOS **/
		Week w0 = new Week();
		Week w1 = new Week();
			
		// Error: cannot assign a value to final variable SUNDAY:
		// w.SUNDAY = 2;
		// Error: cannot assign a value to final variable MONDAY: 
		// w1.MONDAY = w0.MONDAY;
	}
}