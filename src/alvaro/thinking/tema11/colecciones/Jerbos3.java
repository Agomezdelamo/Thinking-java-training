package alvaro.thinking.tema11.colecciones;


//holding/Ex18.java
//TIJ4 Chapter Holding, Exercise 18, page 422
/* Fill a HashMap with key-value pairs. Print the results to show ordering
* by hash code. Extract the pairs, sort by key, and place the result into a 
* LinkedHashMap. Show that the insertion order is maintained. 
*/
import java.util.*;

class Jerbo3 {
	private int jerbos2Number;
	public Jerbo3(int i) {
		jerbos2Number = i;
	}
	public void hop() {
		System.out.println(jerbos2Number + "Jerbos Saltan");
	}
}

public class Jerbos3 {
	public static void main(String[] args) {
		Map<String, Jerbo3> jerbos = new HashMap<String, Jerbo3>();
		jerbos.put("Tonto", new Jerbo3(0));
		jerbos.put("Listo", new Jerbo3(1));
		jerbos.put("Rapido", new Jerbo3(2));
		jerbos.put("Lento", new Jerbo3(3));
		jerbos.put("Dormilon", new Jerbo3(4));
		jerbos.put("Feliz", new Jerbo3(5));
		jerbos.put("Divertido", new Jerbo3(6));
		jerbos.put("Aburrido", new Jerbo3(7));
		jerbos.put("Risueño", new Jerbo3(8));
		jerbos.put("Flipao", new Jerbo3(9));
		//imprimo los jerbos desde el mapa
		System.out.println("HASHMAP, orden de insercion");
		System.out.println("------------------------------------------");
		System.out.println(jerbos);
		System.out.println();
		
		
		Set<String> sortedKeys = 
			new TreeSet<String>(jerbos.keySet());
		//imprimo los jerbos desde el mapa
		System.out.println("TREESET, conjunto en orden natural");
		System.out.println("------------------------------------------");
		System.out.println(sortedKeys);
		System.out.println();
		
		Map<String, Jerbo3> sortedJerbo3s = 
			new LinkedHashMap<String, Jerbo3>();
		System.out.println("Generamos un map linkedhash y le añadimos el set ordenado ");
		System.out.println("------------------------------------------");
		for(String s : sortedKeys) {
			System.out.print(s + ", ");
			sortedJerbo3s.put(s, jerbos.get(s));			
		}

		System.out.println("LinkedHashMap CON EL ORDEN DE UN TREESET");
		System.out.println("------------------------------------------");
		System.out.println();
		System.out.println(sortedJerbo3s);
		System.out.println();
		
		// or, just:
		Map<String, Jerbo3> sortedJerbo3s2 =
			new TreeMap<String, Jerbo3>(jerbos);
		System.out.println("TreeMap tambiein los ordena");
		System.out.println(sortedJerbo3s2);		
	}
}
