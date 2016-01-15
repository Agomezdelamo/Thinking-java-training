package alvaro.thinking.tema10.anonimas;

class Palabra {
	String guardoPalabra;
	public Palabra(String guardoPalabra){
		this.guardoPalabra = guardoPalabra;
	}
	
	@Override
	public String toString() {
		return "Este es mi String -->"+guardoPalabra;
	};
}

interface Selector2 {
	boolean end();
	Object current();
	void next();
	int getIndex();
}
	
public class Ej2InnerSequence {
	private Object[] items;
	private int next = 0;
	public Ej2InnerSequence (int tamañoArray) { items = new Object[tamañoArray];}
	//en el constructor le damos tamaño, con lo que
	//en add siempre el next sera menor que el tamaño la primera vez.
	public void add(Object x){
		if(next < items.length)
			items[next++] = x;
	}

	
	private class SequenceSelector implements Selector2 {
		//una clase interna que itera sobre propiedades de su padre que es clase externa.
		private int index = 0;
		public boolean end() { return index == items.length; }
		public Object current() { return items[index]; }
		public void next() { if(index < items.length) index++; }
		public int getIndex() {return index;}
	}
	
	public Selector2 selector() {
		return new SequenceSelector();
	}
	
	public static void main (String[] args){
		Ej2InnerSequence outterSequence = new Ej2InnerSequence(10);
		for(int i = 0; i < 10; i++)
			outterSequence.add(new Palabra(" esta es la palabra número "+Integer.toString(i)));
		
		Selector2 innerSelector = outterSequence.selector();
		
		while(!innerSelector.end()) {
			System.out.print(innerSelector.current() + "\n");
			innerSelector.next();
		}
		
		Palabra palabra1 = new Palabra("hola");
		Palabra palabra2 = new Palabra("que");
		Palabra palabra3 = new Palabra("tal");
		Palabra palabra4 = new Palabra("estas");
		
		Ej2InnerSequence outterSequence2 = new Ej2InnerSequence(4);
		
		outterSequence2.add(palabra1);
		outterSequence2.add(palabra2);
		outterSequence2.add(palabra3);
		outterSequence2.add(palabra4);
		
		Selector2 innerSelector2 = outterSequence2.selector(); 
		while(!innerSelector2.end()) {
			System.out.print("La palabra numero "+innerSelector2.getIndex()+" contiene "+innerSelector2.current()+"\n");
			innerSelector2.next(); 
		}
	}
}
