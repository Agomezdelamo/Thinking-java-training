package alvaro.thinking.tema11.colecciones;

//holding/Ex25.java
//TIJ4 Chapter Holding, Exercise 25, page 423
/* Create a Map<String, ArrayList<Integer>>. Use net.mindview.TextFile
* to open a text file and read it in a word at a time (use "\\W+\" as
* the second argument to the TextFile constructor). Count the words as
* you read them in, and for each word in the file, record in the
* ArrayList<Integer> the word count associated with that word - that is,
* in effect, the location in the file where that word was found.
*/
import java.util.*;

public class Ex25 {
	public static void main(String[] args) {
		//mapa con un string y un array de integers
		Map<String,ArrayList<Integer>> m =	new LinkedHashMap<String,ArrayList<Integer>>();
		List<String> words = new LinkedList<String>();
		words.addAll(new TextFile("src\\alvaro\\thinking\\tema11\\colecciones\\Frases.txt", "\\W+"));
		System.out.println("Words en el archivo: " + words);
		
		Iterator itWords = words.iterator();
		int count = 0;
		while(itWords.hasNext()) {
			String s = (String)itWords.next();
			count++;			
			if(!m.keySet().contains(s)) {	
				ArrayList<Integer> ai = 
					new ArrayList<Integer>();		
				ai.add(0, count);
				m.put(s, ai);
			}
			else {
				m.get(s).add(count);
				m.put(s, m.get(s));  	
			}
		}
		System.out.println("Mapa con las palabras localizadas: " + m);			
	}	
}