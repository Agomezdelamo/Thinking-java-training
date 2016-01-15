package alvaro.thinking.tema3.operadores;

class Tube {
	float level;
}


/**
 * Clase que nos muestra el manejo de punteros.
 * @author Dj nezhod
 *
 */
public class Assign {
	public static void main(String[] args) {
		Tube t1 = new Tube();
		Tube t2 = new Tube();
		t1.level = 0.32f;
		t2.level = 1.55f;
		
		System.out.println("1: t1.level "+t1.level+"   ---->    t2.level "+t2.level);
		
		/**
		 * el puntero t1 apunta al objeto al que apunta el puntero t2, el objeto creado en t1 se queda solo sin punteros.
		 */
		t1 = t2;
		System.out.println("2: t1.level "+t1.level+"   ---->    t2.level "+t2.level);
		
		/**
		 * como el puntero t1 apunta al objeto del puntero t2, la propiedad level que estamos cambiando aqui
		 * realmente es la del objeto del puntero t2, por eso al imprimirlos son iguales la de t1 y t2.
		 */
		t1.level = 0.27f;
		System.out.println("3: t1.level "+t1.level+"   ---->    t2.level "+t2.level);
	}
}
