package alvaro.thinking.tema11.colecciones;


// holding/Sequence3.java
// TIJ4 Chapter Holding, Exercise 3, page 396
/* Modify innerclasses/Sequence.java so that you can add any number
* of elements to it.
*/
import java.util.*;

interface Selector {
	boolean end();
	Object current();
	void next();
}

public class SecuenceSet {
	private ArrayList<Object> items = new ArrayList<Object>(); //ArrayList de items
	
	public void add(Object x) { // metodo para añadir más items
		items.add(x);
	}
	
	private class SequenceSetSelector implements Selector { //interfaz para iterar por la colección
		private int i = 0;
		
		public boolean end() { //método para saber el último elemento
			return i == items.size();			
		}
		
		public Object current() { //método para saber el elemento actual
			return items.get(i);
		}
		
		public void next() { //método para saber el elemento siguiente
			i++;
		}	
	}
	
	public Selector selector() { //método que devuelve la inner class "SecuenceSetSelector"
		return new SequenceSetSelector();
	}
	
	public static void main(String[] args) {
		SecuenceSet sSet = new SecuenceSet(); //genero el objeto
		
		for(int i = 0; i < 10; i++) { //añado items a la colección
			sSet.add(i);
		}
		
		Selector selector = sSet.selector(); //genero el selector
		
		while(!selector.end()) { //pinto todos los items
			System.out.print(selector.current() + " ");
			selector.next(); //incremento en el bucle
		}
		
		sSet.add(10); //añado nuevos items a la colección
		sSet.add(11);
		sSet.add(12);
		sSet.add(13);
		sSet.add(13);
		sSet.add("good bye");
		
		
		while(!selector.end()) { //los vuelvo a pintar
			System.out.print(selector.current() + " ");
			selector.next(); //incremento en el bucle
		}
	}
}

