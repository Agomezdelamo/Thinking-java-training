package alvaro.thinking.tema12.excepciones;

//exceptions/Sequence12.java
//TIJ4 Chapter Exceptions, Excercise 12, page 471
/* Modify innerclasses/Sequence.java so that it throws an appropriate
* exception if you try to put in too many elements.
*/

interface Selector {
	boolean end();
	Object current();
	void next();
}

public class SequenceException {
	private Object[] items;
	private int next = 0;
	public SequenceException(int size) { items = new Object[size]; }
	
	public void add(Object x) throws ArrayIndexOutOfBoundsException {
		// si el proximo es igual al total del array basico lanza una excepcion de fuera de los limites:
		if(next == items.length)
			throw new ArrayIndexOutOfBoundsException();
		// if not full, fill:
		if(next < items.length)
			items[next++] = x;		
	}
	
	private class SequenceSelector implements Selector {
		private int i = 0;
		public boolean end() { return i == items.length; }
		public Object current() { return items[i]; }
		public void next() { if(i < items.length) i++; } 
	}
	
	public Selector selector() {
		return new SequenceSelector();
	}
	
	
	
	
	public static void main(String[] args) {
		SequenceException sequence = new SequenceException(10);
		for(int i = 0; i < 10; i++)
			sequence.add(Integer.toString(i));
		Selector selector = sequence.selector();
		while(!selector.end()) {
			System.out.print(selector.current() + " ");
			selector.next();
		}
		System.out.println();
		// intentar añadir un objeto a un array básico completo produce
		// ArrayIndexOutOfBoundsException:
		sequence.add(Integer.toString(10));
	}
}