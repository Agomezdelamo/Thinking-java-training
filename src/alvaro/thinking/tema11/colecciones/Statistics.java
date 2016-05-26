package alvaro.thinking.tema11.colecciones;

//holding/Statistics23.java
//TIJ4 Chapter Holding, Exercise 23, page 423
/* Starting with Statistics.java, create a program that runs the test repeatedly
* and looks to see if any one number tends to appear more than the others in the
* results.
*/
import java.util.*;


public class Statistics {
	
	private static int getBestInt20(int n) {
		Random rand = new Random();
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
		
		for(int i = 0; i < 10000; i++) {
			// Produce un número entre 0 y 20:
			int r = rand.nextInt(20);
			//la frecuencia, obtiene una posición aleatoria,
			//y si se repite, va sumando en el codigo de debajo,
			//la primera vez sera null...
			Integer freq = m.get(r);
			//e insertaremos en esa misma posición un uno.
			//el resto de veces insertaremos la frecuencia mas 1
			//y sabremos las veces q se usa la frecuencia.
			m.put(r, freq == null ? 1 : freq + 1);
		}
		
		int max = 0;
		for(int i = 0; i < m.keySet().size(); i++) {
			max = max < m.get(i) ? m.get(i) : max;
		}
		Set<Map.Entry<Integer,Integer>> me = new 
			LinkedHashSet<Map.Entry<Integer,Integer>>(m.entrySet());
		int maxKey = 0;
		Iterator<Map.Entry<Integer,Integer>> it = me.iterator();
		while(it.hasNext()) {
			Map.Entry<Integer,Integer> findMax = it.next();
			if(findMax.getValue() == max)
			maxKey = findMax.getKey();
		}
		return maxKey;			
	}
	
	
	public static void main(String[] args) {
		Map<Integer,Integer> m20 =		
			new TreeMap<Integer,Integer>();
		for(int i = 0; i < 2000; i++) {
			int x = getBestInt20(10000);
			Integer freq = m20.get(x);
			m20.put(x, freq == null ? 1 : freq + 1);
		}
		System.out.println("Most often picked ints, 0 - 19, in 2000 tests of 10,000 random picks: " + m20);
	}
}	

