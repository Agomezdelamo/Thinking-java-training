package alvaro.thinking.tema11.colecciones;

//holding/Ex12.java
//TIJ4 Chapter Holding, Exercise 12, page 410
/* Create and populate a List<Integer>. Create a second List<Integer> of the
* same size as the first, and use ListIterator to read elements of the first
* List and insert them into the second in reverse order. (You may want to 
* explore a number of different ways to solve this problem.)
*/
import java.util.*;

public class holding5 {
	public static void main(String[] args) {
		List<Integer> li1 = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
		List<Integer> li2 = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9));
		
		ListIterator<Integer> it1 = li1.listIterator();
		ListIterator<Integer> it2 = li2.listIterator();
		
		System.out.println("li1: " + li1);
		System.out.println("li2: " + li2);
		
		// move it1 to end:
		while(it1.hasNext())
			it1.next();
		
		// now use it2 to re-set li2:
		while(it2.hasNext()) {	
			it2.next();		
			//si seteas un iterador realmente cambias la colecci�n, un iterador es una copia para recorrer pero su set afecta al original.
			it2.set(it1.previous()); 
		}
		
		System.out.println("li1: " + li1);
		System.out.println("li2: " + li2);
		
	}
}