package alvaro.thinking.tema11.colecciones;

//holding/Ex28.java
//TIJ4 Chapter Holding, Exercise 28, page 427
/* Fill a PriorityQueue (using offer()) with Double values created using 
* java.util.Random, then remove the elements using poll() and display them.
*/
import java.util.*;

public class Ex28 {
	public static void main(String[] args) {
		Random rand = new Random(); //random
		PriorityQueue<Double> d = new PriorityQueue<Double>();
		
		//añado a la cola por prioridad 10 números doubles random.
		for(int i = 0; i < 10; i++)
			d.offer(rand.nextDouble() * i);
		
		//mientras la cabeza de la cola no este vacia la imprime.
		while(d.peek() != null)
			System.out.println(d.poll() + " "); //poll devuelve la cabeza de la cola y además la elimina.
	}
}

