package alvaro.thinking.tema11.colecciones;
//holding/Ex24.java
//TIJ4 Chapter Holding, Exercise 24, page 423
/* Fill a LinkedHashMap with String keys and objects of your choice.
* Now extract the pairs, sort them based on the keys, and reinsert
* them into the Map.
*/
//see also solution - holding/Ex24b.java
import java.util.*;

public class Ex24{	
	public static void main(String[] args) {
		Map<String,Integer> m = new LinkedHashMap<String,Integer>();
		m.put("ten", 10);
		m.put("nine", 9);
		m.put("eight", 8);
		m.put("seven", 7);
		m.put("six", 6);
		m.put("five", 5);
		m.put("four", 4);
		m.put("three", 3);
		m.put("two", 2);
		m.put("one", 1);
		m.put("zero", 0);
		System.out.println("Mapa para odenar: " + m);
		
		// Mapa temporal para mantener las entradas:
		Map<String,Integer> mTemp = new LinkedHashMap<String,Integer>();
		
		// pasamos las claves del mapa original para ordenarlas a un conjunto(Set)
		Set<String> ss = new TreeSet<String>(m.keySet());
		
		// Movemos el conjunto a un mapa temporal ya ordenados,
		//y borramos el contenido del mapa original
		Iterator<String> itss = ss.iterator();
		while(itss.hasNext()) {
			String s = (String)itss.next();
			Integer i = m.get(s);
			m.remove(s);
			mTemp.put(s, i);
		}
		
		// Obtener una lista ordenada de claves temporales:
		Set<String> ssTemp = new TreeSet<String>(mTemp.keySet());
		
		// Muevelas ordenadas al mapa original:
		//y borramos el temporal
		Iterator<String> itssTemp = ssTemp.iterator();
		while(itssTemp.hasNext()) {
			String s = (String)itssTemp.next();
			Integer i = mTemp.get(s);
			mTemp.remove(s);
			m.put(s, i);
		}
		// acabamos con el temp:
		mTemp.clear();
		System.out.println("Mapa ordenado alfabéticamente por claves: " + m);
	}
}	
