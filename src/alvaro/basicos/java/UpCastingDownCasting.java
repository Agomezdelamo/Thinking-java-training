package alvaro.basicos.java;

public class UpCastingDownCasting {
	public static void main(String[] args) {
		class Empleado {
			private String rangeP = " y poseo acceso a la CLASE padre";
			public void quien(String name) { System.out.println("Soy un"+name+rangeP); }
		}
		
		class Ejecutivo extends Empleado {
			private String rangeH = " y poseo acceso a la CLASE hija";
			public void quien2(String name) { System.out.println("Soy un"+name+rangeH); }
		}
		
		
		/**
		 * UPCASTING - Desde arriba especializamos abajo.
		 * Un puntero de clase empleado que especializa su objeto a un descendiente, ejecutivo.
		 * podemos acceder a los métodos de empleado pero no de ejecutivo a no ser que se llamen igual, en ese caso
		 * el método que se usa es el de ejecutivo.
		 */
		Empleado emp = new Ejecutivo();
		
		/**
		 * DOWNCASTING - Desde abajo generalizamos arriba.
		 * Un puntero de clase HIJA apuntamos a un objeto de clase PADREy  podemos acceder a todos
		 * los métodos del padre y del hijo. Esto se denomina downcasting.
		 */
		
		Ejecutivo ej = (Ejecutivo) emp;

		emp.quien(" Empleado ");
//		este da error porque no tenemos acceso a los metodos en un upcasting, el puntero es de clase padre
//		emp.quien2(" Empleado ");
		ej.quien(" Ejecutivo ");
		ej.quien2(" Ejecutivo ");
	}

}
