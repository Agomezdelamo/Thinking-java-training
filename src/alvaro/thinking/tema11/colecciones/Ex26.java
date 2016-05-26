package alvaro.thinking.tema11.colecciones;

import java.util.*;

//holding/Ex26.java
//TIJ4 Chapter Holding, Exercise 26, page 423
/* Take the resulting Map from the previous exercise and re-create the 
* order of the words as they appeared in the original file.
*/

public class Ex26 {
	
	public static void main(String[] args) {
		Map<String,ArrayList<Integer>> mapa = new LinkedHashMap<String,ArrayList<Integer>>();
			List<String> words = new LinkedList<String>();
			words.addAll(new TextFile("src\\alvaro\\thinking\\tema11\\colecciones\\Frases.txt", "\\W+"));
			System.out.println("palabras en el archivo: " + words);
		//creo un iterador para la lista de palabras
		Iterator itWords = words.iterator();
		int count = 0; //contador
		//mientras haya palabras en el iterador
		while(itWords.hasNext()) {
			//guardo la iteraccion en un string
			String s = (String)itWords.next();
			count++;		
			//si el mapa aún no contiene clave valor
			if(!mapa.keySet().contains(s)) {	
				ArrayList<Integer> ai = new ArrayList<Integer>();	//genero un arraylist de integer para el valor	
				ai.add(0, count); //y en la posición cero añado el valor del contador.
				mapa.put(s, ai); // y se lo paso al mapa asociado a la clave-string
			}
			//si el mapa ya a sido inicializado con una clave-valor voy metiendo el resto.
			else {
				mapa.get(s).add(count);
				mapa.put(s, mapa.get(s));  	
			}
		}
		System.out.println();
		System.out.println("Map of word locations: " + mapa);
		
		
		// Nuevo mapa para mantener las palabras ordenadas, al reves que el anterior, con clave por localización:
		Map<Integer,String> replay = new TreeMap<Integer,String>();
		//genero un iterador del antiguo mapa
		Iterator<Map.Entry<String,ArrayList<Integer>>> it = mapa.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String,ArrayList<Integer>> me = it.next();
			for(int i = 0; i < me.getValue().size(); i++)
				replay.put(me.getValue().get(i),
					me.getKey());
		}
		System.out.println();
		System.out.println("TreeMap of ordered locations, words: " + replay);
		System.out.println();
		
		// Display words in order as TreeMap values():
		System.out.println("Words in original order: " + replay.values());
	}	
	
}