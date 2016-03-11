package alvaro.thinking.tema11.colecciones;

//holding/Ex5.java
//TIJ4 Chapter Holding, Exercise 5, page 406
/* Modify ListFeatures.java so that it uses Integers (remember 
* autoboxing!) instead of Pets, and explain any difference in
* results.
*/
import java.util.*;

public class OperacionesConListas {
	// method to make a List<Integer> with random values < n:
	public static List<Integer> listOfRandInteger(int length, int n) { //m�todo que genera una lista random de enteros
		Random rand = new Random();
		List<Integer> li = new ArrayList<Integer>(); 
		for(int i = 0; i < length; i++)
			li.add(rand.nextInt(n)); 		
		return li;	
	}
	
	public static void main(String[] args) {
		Random rand = new Random(); //random
		
		List<Integer> li = listOfRandInteger(7, 10); //genero una lista random de enteros
		System.out.println("1: " + li);
		
		Integer h = new Integer(rand.nextInt(10)); 
		li.add(h);//a�ado un entero random
		System.out.println("2: " + li);
		
		System.out.println("3: " + li.contains(h)); //contiene a random?
		
		// borro la primera instancia al entero h(9):
		li.remove(h);
		System.out.println("3.5: " + li);
		
		Integer p = li.get(2);
		System.out.println("4: " + p + " " +  li.indexOf(p)); //imprimo el valor y la posici�n 2
		
		Integer cy = new Integer(rand.nextInt(10));
		System.out.println("5: " + cy +" " + li.indexOf(cy));//imprimo el valor y la posici�n 2
		
		System.out.println("6: " + li.remove(cy)); //borro el valor (4)
		System.out.println("7: " + li.remove(p)); //borro el valor (4)
		System.out.println("8: " + li);  //lista sin los valores (4)
		
		li.add(3, new Integer(rand.nextInt(10))); //a�ado algo en la posici�n 3
		System.out.println("9: " + li);
		
		List<Integer> sub = li.subList(1, 4); //arranco de la posici�n 1 a la 4 de la lista.
		System.out.println("sublist: " + sub);
		System.out.println("10: " + li.containsAll(sub)); //La lista contiene toda la sublista?
		
		// Ordeno la sublista:
		Collections.sort(sub);
		System.out.println("sorted sublist: " + sub);
		System.out.println("11: " + li.containsAll(sub));//La lista contiene toda la sublista?
		System.out.println("11.25: " + li); //Lista entera
		
		Collections.shuffle(sub, rand); //ordenar aleatoriamente la sublista
		System.out.println("11.5: " + li); //pinto lista con sublista aleatoria
		System.out.println("shuffled sublist: " + sub); //sublista aleatoria
		System.out.println("12: " + li.containsAll(sub)); //contiene sublista?
		
		List<Integer> copy = new ArrayList<Integer>(li); //copia de li
		System.out.println("12.5: " + li); //pinto la copia
		
		sub = Arrays.asList(li.get(1), li.get(4)); //cojo dos elementos de la lista y los parseo a array
		System.out.println("sub: " + sub);	//lo imprimo
		
		copy.retainAll(sub); // retainAll borra todos los elementos que no esten la lista especificada.
		//va a reducir li a lo que coincida con lu, el resto fuera.
		System.out.println("13: " + copy);
		
		copy = new ArrayList<Integer>(li);  //copio la lista a un array list
		copy.remove(2); //borro la posicion 2 (valor ="7")
		System.out.println("14: " + copy); //lo imprimo
		
		copy.removeAll(sub); //borro de la lista todo lo que sea sublista
		System.out.println("15: " + copy);
		
		if(copy.size() > 1) // para prevenir excepci�n de fuera de los limites
			copy.set(1, 8); // autoboxing int -> Integer //a�ado en la posici�n 1 un 8
		copy.set(1, 8); // autoboxing int -> Integer //a�ado en la posici�n 1 un 8
		System.out.println("16: " + copy); 
		
		if(copy.size() > 2)
			copy.addAll(2, sub); //a�ado la sublista desde al posici�n 2
		System.out.println("17: " + copy);
		
		System.out.println("18: " + li.isEmpty()); //esta vacia?
		
		li.clear(); //la limpio
		System.out.println("19: " + li);

		System.out.println("20: " + li.isEmpty()); //esta vacia?
		
		li.addAll(listOfRandInteger(4, 10)); //a�ado cuatro n�meros random entre 1 y 10
		System.out.println("21: " + li);
		
		Object[] o = li.toArray(); //paso la lista a array viejo
		System.out.println("22: " + o[3]); //pinto la ultima posici�n
		
		Integer[] ia = li.toArray(new Integer[0]); //paso la lista a array viejo
		System.out.println("23: " + ia[3]); //pinto la ultima posici�n
	}
}
