package alvaro.thinking.tema10.anonimas;


/*************** CLASE BASE ***************/
class Palabra {
	String guardoPalabra;
	public Palabra(String guardoPalabra){ this.guardoPalabra = guardoPalabra; }
	
	@Override
	public String toString() { return "Este es mi String -->"+guardoPalabra; };
}

/*************** INTERFAZ ***************/
interface IteratorObject {
	boolean end();
	Object current();
	void next();
	int getIndex();
}

/******** CLASE OUTTER CON IMPLEMENTACION ********/
//outterSecquence añade objetos a un array.
public class AddObject {
	private Object[] items;//arRay de items que incrementamos con add
	private int next = 0;
	public AddObject (int tamañoArray) { items = new Object[tamañoArray];}
	//en el constructor le damos tamaño, con lo que
	//en add el next que inicia en 0 SIEMPRE sera menor que el tamaño la primera vez.
	public void add(Object x){
		if(next < items.length)
			items[next++] = x;
	}

	/******** CLASE INNER CON IMPLEMENTACION ********/
	private class ReturnObject implements IteratorObject {
		//una clase interna que itera sobre propiedades de su padre que es clase externa.
		private int index = 0;
		public boolean end() { return index == items.length; }
		public Object current() { return items[index]; }
		public void next() { if(index < items.length) index++; }
		public int getIndex() {return index;}
	}
	
	public IteratorObject getReturnObject() { //DEVUELVO UN OBJETO POR SU INTERFAZ
		return new ReturnObject();
	}
	
	public static void main (String[] args){
		AddObject outter = new AddObject(10);
		for(int i = 0; i < 10; i++)
			//añade tantas palabras como el int de su constructor
			outter.add(new Palabra(" esta es la palabra número "+Integer.toString(i))); 		
		
		IteratorObject inner = outter.getReturnObject(); //OBTENGO LA INNER POR SU INTERFAZ Y UN METODO QUE DEVUELVE ESE TIPO DE INTERFAZ
		
		while(!inner.end()) {
			System.out.print(inner.current() + "\n");
			inner.next();
		}
		
		Palabra palabra1 = new Palabra("hola");
		Palabra palabra2 = new Palabra("que");
		Palabra palabra3 = new Palabra("tal");
		Palabra palabra4 = new Palabra("estas");
		
		AddObject outter2 = new AddObject(4);
		
		outter2.add(palabra1);
		outter2.add(palabra2);
		outter2.add(palabra3);
		outter2.add(palabra4);
		
		IteratorObject inner2 = outter2.getReturnObject(); 
		while(!inner2.end()) {
			System.out.print("La palabra numero "+inner2.getIndex()+" contiene "+inner2.current()+"\n");
			inner2.next(); 
		}
	}
}
