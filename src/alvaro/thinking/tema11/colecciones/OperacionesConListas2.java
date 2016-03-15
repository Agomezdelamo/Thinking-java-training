package alvaro.thinking.tema11.colecciones;

//holding/Ex6.java
//TIJ4 Chapter Holding, Exercise 6, page 406
/* Modify listFeatures.java so that it uses String instead of Pets, 
* and explain any difference in results.
*/
import java.util.*;

public class OperacionesConListas2 {
	public static void main(String[] args) {
		Random rand = new Random();
		
		List<String> ls = new ArrayList<String>(); //array de Strings
		System.out.println("0: " + ls);
		
		Collections.addAll(ls, "oh", "what", "a", "beautiful", "Manila", "Monday", "morning"); //añado al arrayList varios strings con collections.
		System.out.println("1: " + ls);
		
		String h = new String("hi"); 
		ls.add(h); //añado un String de otra forma, con un método de ArrayList.
		System.out.println("2: " + ls);
		System.out.println("3: " + ls.contains(h)); //compruebo que ls contiene a h
		
		// borro la primera instancia dentro de la lista que contenga la variable "h"
		ls.remove(h);
		System.out.println("3.5: " + ls);
		
		String p = ls.size() > 2 ? ls.get(2) : null; //me guardo la segunda posicion si no es nula.
		System.out.println("4: " + p + " " +  ls.indexOf(p)); //pinto la variable y su posición en la lista.
		
		String cy = new String("cy");
		System.out.println("5: " + cy +" " + ls.indexOf(cy)); //compruebo que cy no existe en la lista(devuelve -1)
		System.out.println("6: " + ls.remove(cy)); //no puedo borrar cy(false)
		System.out.println("7: " + ls.remove(p)); //borro p(true)
		System.out.println("8: " + ls); //pinto la lista
		
		if(ls.size() > 3) //si la lista es mayor de 3...
			ls.add(3, "wonderful"); //añado en la 3 "wonderful"
		System.out.println("9: " + ls);
		
		if(ls.size() < 4) { //si la lista es menor de 4...
			List<String> s = 
			   Arrays.asList("let's", "jump", "in", "here"); //guardo un array como lista de strings...
			ls.addAll(0, s); //y lo añado a la lista.
		}
		
		List<String> sub = ls.subList(1, 4); //genero una sublista con las posiciones 1 a la 3.
		System.out.println("sublist: " + sub);
		System.out.println("10: " + ls.containsAll(sub)); //true, la contiene.
		
		// will also sort sub elements within ls:
		Collections.sort(sub); //ordeno la sublista con sort, ojo, esta sublista afecta a la lista, no es una copia,
								//es un puntero que apunta a una parte de la lista, y si lo modificas afecta a la lista.
		
		System.out.println("sorted sublist: " + sub);
		System.out.println("11: " + ls.containsAll(sub));
		System.out.println("11.25: " + ls);

		// will also shuffle sub elements within ls:
		Collections.shuffle(sub, rand); //reordena la sublista con random
		System.out.println("11.5: " + ls);
		System.out.println("shuffled sublist: " + sub);
		System.out.println("12: " + ls.containsAll(sub)); //true la contiene
		
		List<String> copy = new ArrayList<String>(ls); //hago una copia
		System.out.println("12.5: " + ls);
		
		if(ls.size() < 5) { //si la lista es menor que cinco añado dos strings.
			ls.add("two");
			ls.add("more");
		}
		
		sub = Arrays.asList(ls.get(1), ls.get(4)); //reasigno el puntero de "sub" la posición 1 y 4 de la lista.
		System.out.println("sub: " + sub);	
		
		copy.retainAll(sub); //conservar todos
		System.out.println("13: " + copy);
		
		copy = new ArrayList<String>(ls); //copio la lista
		copy.remove(2); //borro la posición 2
		System.out.println("14: " + copy);
		
		copy.removeAll(sub);  //borro toda la sublista y por tanto, afecta a la lista
		System.out.println("15: " + copy);
		
		if(copy.size() > 1) // Si es mayor de uno el tamaño de la lista, para evitar(avoid) la excepción fuera de los limites(out of bounds)
			copy.set(1, "excellent"); //seteo la posición 1 con un nuevo string
		System.out.println("16: " + copy);
		
		if(copy.size() > 2) //si es mayor de dos
			copy.addAll(2, sub); //añado toda la sublista desde la posición 2
		System.out.println("17: " + copy);
		System.out.println("18: " + ls.isEmpty()); //no esta vacia
		
		ls.clear(); //limpio la lista entera
		System.out.println("19: " + ls);
		System.out.println("20: " + ls.isEmpty()); //ahora es true
		
		ls.addAll(0, sub); //añado a la posición 0 y a la 2 la sublista, como tiene 2 strings, por eso la posición 0 y luego la 2
		ls.addAll(2, sub);
		System.out.println("21: " + ls);
		
		Object[] o = ls.toArray(); //genero un puntero array que apunte a la lista.
		System.out.println("22: " + o[3]); //escojo la posición 3 y la imprimo
		
		String[] sa = ls.toArray(new String[0]); //hago un puntero a la lista
		System.out.println("23: " + sa[3]); //imprimo la posición 3 de la lista
	}
}