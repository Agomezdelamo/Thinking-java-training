package alvaro.thinking.tema7.reusar;

//In Coche.java añade un método service() para motor y llamalo en main().
//Ejemplo de composición con clases.

class Motores {
	public void start() {}
	public void rev() {}
	public void stop() {}
	public void arrancar() { System.out.println("arrancar motor"); }
}

class Rueda {
	public void inflate(int psi) {}
}

class Ventana {
	public void subir() {}
	public void bajar() {}
}

class Puerta {
	/* composición llamo a ventana*/
	public Ventana ventana = new Ventana();
	public void open() {}
	public void close() {}
}

public class Coche {
	public Motores motores = new Motores();
	public Rueda[] rueda = new Rueda[4];
	public Puerta
		puertaIzq = new Puerta(),
		puertaDcha = new Puerta(); // 2-door
	public Coche() {
		for(int i = 0; i < 4; i++)
			//instancio los punteros del array de ruedas, ahora esos punteros tienen objetos dentro.
			rueda[i] = new Rueda();
	}
	public static void main(String[] args) {
		Coche car = new Coche();
		car.puertaIzq.ventana.subir();
		car.rueda[0].inflate(72);
		car.motores.arrancar();
	}	
}