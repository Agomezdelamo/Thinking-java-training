package alvaro.basicos.java.polimorfismo;



public class PolimorfismoBasico {
	public static void main(String[] args) {
/********************************* UPCASTING ****************************************/
		//LA NECESIDAD DEL UPCASTING ES PASAR POR UN MÉTODO GENERALIZADO, 
		//AÑADIR A UN ARRAY DE CLASE PADRE, OBJETOS PADRES E HIJOS...
		/**UPCASTING - 1 interfaz - pierdes interfaz, ganas un objeto polimorfico, pasa por metodos que acepten al padre **/
		/** ALMACENAS EN UN PUNTERO DE CLASE padre UN OBJETO DE CLASE hijo **/
		/** TIENES LA INTERFAZ DEL PADRE **/
		Empleado emp = new Ejecutivo("Máximo Dueño" , 2000); // upcasting automáticamente sabe el tipo en compilacion
		/** Con lo cual podemos acceder a los métodos de Empleado
		 *  pero no de Ejecutivo salvo
		 *  el caso que tengan un método con el mismo nombre,
		 *   en cuyo caso accederemos al del Ejecutivo (Ejemplo toString se ejecuta el de Ejecutivo).*/
		emp.aumentarSueldo(8); //metodo Empleado
		//emp.asignarPresupuesto(29); //metodo Ejecutivo NO SE PUEDE, EL PUNTERO ES CLASE EMPLEADO.
		
		//toString de ejecutivo aunque la clase es empleado por ligadura tardia, en tiempo de ejecucion
		System.out.println(emp);
		
		
/********************************* DOWNCASTING ****************************************/
		//LA NECESIDAD DEL DOWNCASTING es para acceder a métodos que solo estan accesibles en el hijo porque este a aumentado
		//los métodos de los que disponia el padre.
		/**DOWNCASTING - 2 interfaces - pierdes la clase del puntero, ganas 2 interaces, puedes usar métodos de padre e hijo **/
		/** CONVIERTES LA CLASE del puntero que apunta al objeto DE EMPLEADO A EJECUTIVO
		 * Y TIENES LA INTERFAZ DEL padre y del hijo**/
		Ejecutivo ej = (Ejecutivo)emp; //downcasting yo manualmente le asigno un tipo en tiempo de ejecución
		
		/** Entonces podemos acceder a todos los métodos de ejecutivo, 
		 */
		ej.aumentarSueldo(100); //metodo clase Empleado
		ej.asignarPresupuesto(1500); //metodo clase Ejecutivo
		System.out.println(ej);
	}
}

class Empleado {
	String nombre;
	int numEmpleado, sueldo;
	
	static private int contador = 0;
	
	Empleado(String nombre, int sueldo) {
		this.nombre = nombre;
		this.sueldo = sueldo;
		numEmpleado = ++contador;
	}
	
	public void aumentarSueldo(int porcentaje) {
		sueldo += (int)(sueldo * porcentaje / 100);
	}

	public String toString() {
        return "Num. empleado " + numEmpleado + " Nombre: " + nombre +
                " Sueldo: " + sueldo;
    }
}
	

class Ejecutivo extends Empleado {
    int presupuesto;

    Ejecutivo (String n, int s) {
        super(n,s);
    }

    void asignarPresupuesto(int p) {
        presupuesto = p;
    }

    public String toString() {
        String s = super.toString();
        s = s + " Presupuesto: " + presupuesto;
        return s;
    }
}

