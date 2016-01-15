package alvaro.thinking.tema11.colecciones;
import java.util.*;

public class PrintingContainers {
  
static Collection<String> fill(Collection<String> c) {
	c.add("dog");
	c.add("dog");
	c.add("cat");
	return c;
}
  
static Map<String,String> fill(Map<String,String> m) {
	m.put("klave_dog", "Bosco");
	m.put("klave_dog", "Spot");
	m.put("klave_cat", "Rags");
	return m;
}
  
  public static void main(String[] args) {
	
	 /** List, se puede duplicar sin problemas. */
		//se mantiene el orden en el que entran, pero linked list hace más operaciones.
	    System.out.println("ArrayList se mantiene el orden en el que entran --> "+fill(new ArrayList<String>()));
	    System.out.println("LinkedList se mantiene el orden en el que entran --> "+fill(new LinkedList<String>()));
	    System.out.println("\n");

    /** Set=Conjunto, No admiten duplicados de ningún elemento */
	    //es la forma más rapida de extraer elementos pero no se preocupa por el orden.
	    System.out.println("HashSet sin orden --> "+fill(new HashSet<String>()));
	    //los ordena en orden ascendente
	    System.out.println("TreeSet en orden ascendente --> "+fill(new TreeSet<String>()));
	    //los ordena en el orden que fueron añadidos, pero también es rapido.
	    System.out.println("LinkedHashSet en el orden que se añadieron --> "+fill(new LinkedHashSet<String>()));
	    System.out.println("\n");
    
    /** nunca se permiten duplicados en la klave */
	    //es más rapido pero coloca como le da la gana
	    System.out.println("HashMap sin orden --> "+fill(new HashMap<String,String>()));
	    //ordena descendente por klave
	    System.out.println("TreeMap en orden ascendente --> "+fill(new TreeMap<String,String>()));
	    //los ordena en el orden que fueron añadidos, pero también es rapido.
	    System.out.println("LinkedHashMap en el orden que se añadieron --> "+fill(new LinkedHashMap<String,String>()));
  }
}