package alvaro.thinking.tema11.colecciones;

import java.io.IOException;
//holding/Vowels16.java
//TIJ4 Chapter Holding, Exercise 16, page 419
/* Create a Set of the vowels. Working from UniqueWords.java, count and
* display the number of vowels in each input word, and also display the total
* number of vowels in the input file.
*/
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import com.bruceeckel.util.TextFile;

public class Vocales {
	static void vowelCounter(Set<String> st) {
		Set<Character> vowels = new TreeSet<Character>();
		Collections.addAll(vowels, 
			'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
		int allVowels = 0;
		for(String s : st) {
			int count = 0;
			for(Character v : s.toCharArray()) {		
				if(vowels.contains(v)) {
					count++;
					allVowels++; 
				}
			}
			System.out.print(s + ": " + count + ", ");		
		}
		System.out.println();	
		System.out.print("Total vowels: " + allVowels);
	}
	public static void main(String[] args) throws IOException {
		Set<String> words = new TreeSet<String>();
		words.add("hola que tal estas");
		System.out.println(words);
		System.out.println();
		vowelCounter(words);		
	}		
}