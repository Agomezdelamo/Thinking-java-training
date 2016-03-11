package alvaro.thinking.tema11.colecciones;

import java.util.ArrayList;

//TIJ4 Chapter Holding, Exercise 1, page 394

/* Crea una nueva clase llamada gerbil con un int que diga el numero de gerbil en el constructor.
 * 
 * Crea un metodo llamado saltar() que muestre cual es el numero de gerbil, y este sea saltarping.
 * 
 * Crear un arraylist y añade objetos Gerbil a la lista.
 * 
 * Ahora usa el metodo get() para mover a traves de la lista y llamar a saltar() para cada Gerbil.
 * 
*/
class Gerbil {
	private int gerbilNumber;
	
	public Gerbil(int i) {
		gerbilNumber = i;
	}
	
	public void saltar() { System.out.println("Gerbil " + gerbilNumber + " saltan"); }
}

public class holding1 {
	public static void main(String[] args) {
		//lista de array de gerbils.
		ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
		
		//itero con for para añadir nuevos gerbils
		for(int i = 0; i < 10; i++)
			gerbils.add(new Gerbil(i));
		
		
		//	OPCION1
		//itero con for para llamar a su metodo saltar
		for(int i = 0; i < 10; i++) 
			gerbils.get(i).saltar();

		//	OPCION2
		// o, alternativamente, usa la sintaxis foreach:
		for(Gerbil g : gerbils)
			g.saltar();
	}
}