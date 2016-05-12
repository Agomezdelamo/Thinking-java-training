package alvaro.thinking.tema11.colecciones;


//holding/Ex18.java
//TIJ4 Chapter Holding, Exercise 18, page 422
/* Fill a HashMap with key-value pairs. Print the results to show ordering
* by hash code. Extract the pairs, sort by key, and place the result into a 
* LinkedHashMap. Show that the insertion order is maintained. 
*/
import java.util.*;

class Jerbo4 {
	private int jerbos2Number;
	public Jerbo4(int i) {
		jerbos2Number = i;
	}
	public void hop() {
		System.out.println(jerbos2Number + "Jerbos Saltan");
	}
}

public class Jerbos4 {
	public static void main(String[] args) {
		Map<String, Jerbo4> jerbos = new HashMap<String, Jerbo4>();
		jerbos.put("Tonto", new Jerbo4(0));
		jerbos.put("Listo", new Jerbo4(1));
		jerbos.put("Rapido", new Jerbo4(2));
		jerbos.put("Lento", new Jerbo4(3));
		jerbos.put("Dormilon", new Jerbo4(4));
		jerbos.put("Feliz", new Jerbo4(5));
		jerbos.put("Divertido", new Jerbo4(6));
		jerbos.put("Aburrido", new Jerbo4(7));
		jerbos.put("Risueño", new Jerbo4(8));
		jerbos.put("Flipao", new Jerbo4(9));
		//imprimo los jerbos desde el mapa
		System.out.println("HASHMAP, orden de insercion");
		System.out.println("------------------------------------------");
		System.out.println(jerbos);
		System.out.println();
		
		
		Set<String> hashedKeys = 
			new HashSet<String>(jerbos.keySet());
		//imprimo los jerbos desde el mapa
		System.out.println("HASHSET, conjunto en orden de inserción obtenido del HASHMAP");
		System.out.println("------------------------------------------");
		System.out.println(hashedKeys);
		System.out.println();
		
		Map<String, Jerbo4> hashedGerbils = 
			new LinkedHashMap<String, Jerbo4>();
		System.out.println("Generamos un map LINKEDHASHMAP y le añadimos el HASHSET ");
		System.out.println("------------------------------------------");
		for(String s : hashedKeys) {
			System.out.print(s + ", ");
			hashedGerbils.put(s, jerbos.get(s));			
		}

		
		// or, just:
		Set<String> linkedHashedKeys =
			new LinkedHashSet<String>(jerbos.keySet());
		System.out.println("LINKEDHASHSET obtenemos de un HASHMAP");
		System.out.println(linkedHashedKeys);		
		
		Map<String, Jerbo4> linkedHashedGerbils = 
				new LinkedHashMap<String, Jerbo4>();
			for(String s : linkedHashedKeys) {
				System.out.print("Adding " + s + ", ");			
				linkedHashedGerbils.put(s, jerbos.get(s));
			}
			System.out.println();
			System.out.println();
			System.out.println("From LinkedHashSet: " 
				+ linkedHashedGerbils);
		}
		
}






