package alvaro.thinking.tema11.colecciones;

//holding/Gerbils17.java
//TIJ4 Chapter Holding, Exercise 17, page 422
/* Take the Gerbil class in Exercise 1 and put it into a Map instead, 
* associating each Gerbil's name (e.g. "Fuzzy" or "Spot") as a String (the
* key) for each Gerbil (the value) you put in the table. Get an Iterator for
* the keySet() and use it to move through the Map, looking up the Gerbil for
* each key and printing out the key and telling the Gerbil to salta().
*/
import java.util.*;

class Jerbo {
	private int numeroJerbo;
	public Jerbo(int i) {
		numeroJerbo = i;
	}
	public void salta() {
		System.out.println(numeroJerbo + " jerbos saltan");
	}
}

public class Jerbos2 {
	public static void main(String[] args) {
		Map<String, Jerbo> jerbos = new HashMap<String, Jerbo>();
		jerbos.put("Borroso", new Jerbo(0));
		jerbos.put("Punto", new Jerbo(1));
		jerbos.put("Veloz", new Jerbo(2));
		jerbos.put("Tonto", new Jerbo(3));
		jerbos.put("Dormilon", new Jerbo(4));
		jerbos.put("Contento", new Jerbo(5));
		
		Iterator<String> it = jerbos.keySet().iterator();
		
		while(it.hasNext()) {
			String s = it.next();
			System.out.print(s + ": ");
			jerbos.get(s).salta();
		}	
	}
}
