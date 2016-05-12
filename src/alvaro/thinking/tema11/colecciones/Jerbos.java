package alvaro.thinking.tema11.colecciones;

//holding/Ex8.java
//TIJ4 Chapter Holding, Exercise 8, page 409

//Modifica el ejercicio 1 para que use un iterador para moverse 
//através de la lista mientras llama al método salta().
import java.util.*;

class JerboSalvaje {
	private int numeroJerboSalvaje;
	public JerboSalvaje(int i) {
		numeroJerboSalvaje = i;
	}
	public void salta() {
		System.out.println("Jerbo Salvaje nº " + numeroJerboSalvaje + " salta");
	}
}

public class Jerbos {
	public static void main(String[] args) {
		ArrayList<JerboSalvaje> variosJerbos = new ArrayList<JerboSalvaje>();
		for(int i = 0; i < 10; i++)
			variosJerbos.add(new JerboSalvaje(i));
		
		Iterator<JerboSalvaje> it = variosJerbos.iterator();
		while(it.hasNext()) 
			it.next().salta();
	}
}

