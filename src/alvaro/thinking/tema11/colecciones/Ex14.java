package alvaro.thinking.tema11.colecciones;

//holding/Ex14.java
//TIJ4 Chapter Holding, Exercise 14, page 412
/* Create an empty LlinkedList<Integer>. Using a ListIterator, add Integers
* to the list by always inserting them in the middle of the list.
*/
import java.util.*;

public class Ex14 {
	static void addMiddle(LinkedList<Integer> lista, Integer[] integerArray) {
		
		for(Integer i : integerArray) { //for each
			ListIterator<Integer> it = 
					lista.listIterator((lista.size())/2); //devuelve un iterador partiendo desde el numero especificado
			it.add(i);
			System.out.println(lista);
		}
	}
	public static void main(String[] args) {
		
		LinkedList<Integer> lista = new LinkedList<Integer>();//lista linkada		
		Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7};//array def
		
		Ex14.addMiddle(lista, array);
	}	
}