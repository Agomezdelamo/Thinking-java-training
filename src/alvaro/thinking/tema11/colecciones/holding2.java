package alvaro.thinking.tema11.colecciones;

//holding/Ex2.java
//TIJ4 Chapter Holding, Exercise 2, page 396
//Generamos un Set.
import java.util.*;

public class holding2 {
	public static void main(String[] args) {
		//set de clase HashSet, no tiene orden pero es rápido
		Set<Integer> c = new HashSet<Integer>(); 
		
		for(int i = 0; i < 10; i++) { //for para rellenar la colección set
			c.add(i); // Autoboxing
		}
		
		for(Integer i : c) { //for each para imprimirlo
			System.out.print(i + ", ");
		}
	}	
}