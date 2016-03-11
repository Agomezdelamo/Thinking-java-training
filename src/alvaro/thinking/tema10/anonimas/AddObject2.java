package alvaro.thinking.tema10.anonimas;


/*************** CLASE BASE ***************/
class Word {
	String guardoWord;
	public Word(String guardoWord){ this.guardoWord = guardoWord; }
	
	@Override
	public String toString() { return "Este es mi String -->"+guardoWord; };
}

/*************** INTERFAZ ***************/
interface IteradorObjetos {
	boolean end();
	Object current();
	void next();
	int getIndex();
}

/******** CLASE OUTTER CON IMPLEMENTACION ********/
//outterSecquence añade objetos a un array.
public class AddObject2 {
	private Object[] items;//arRay de items que incrementamos con add
	private String secretWord;
	private int next = 0;
	public AddObject2 (int tamañoArray) { items = new Object[tamañoArray];}
	//en el constructor le damos tamaño, con lo que
	//en add el next que inicia en 0 SIEMPRE sera menor que el tamaño la primera vez.
	public void add(Object x){
		if(next < items.length)
			items[next++] = x;
	}

	/******** CLASE INNER CON IMPLEMENTACION ********/
	private class ReturnObject implements IteradorObjetos {
		//una clase interna que itera sobre propiedades de su padre que es clase externa.
		private int index = 0;
		public boolean end() { return index == items.length; }
		public Object current() { return items[index]; }
		public void next() { if(index < items.length) index++; }
		public int getIndex() {return index;}
	
		public AddObject2 getAddObject2(int size) {
			secretWord = "creada desde clase interna ReturnObject";
			return new AddObject2(size);
		}
	}
	
	public IteradorObjetos getReturnObject() { //DEVUELVO UN OBJETO POR SU INTERFAZ
		return new ReturnObject();
	}
	
	public static void main (String[] args){
		AddObject2 outter = new AddObject2(10);
		for(int i = 0; i < 10; i++)
			//añade tantas Words como el int de su constructor
			outter.add(new Word(" esta es la Word número "+Integer.toString(i))); 		
		
		IteradorObjetos inner = outter.getReturnObject(); //OBTENGO LA INNER POR SU INTERFAZ Y UN METODO QUE DEVUELVE ESE TIPO DE INTERFAZ
		
		while(!inner.end()) {
			System.out.print(inner.current() + "\n");
			inner.next();
		}
		
		Word Word1 = new Word("hola");
		Word Word2 = new Word("que");
		Word Word3 = new Word("tal");
		Word Word4 = new Word("estas");
		
		AddObject2 outter2 = new AddObject2(4);
		
		outter2.add(Word1);
		outter2.add(Word2);
		outter2.add(Word3);
		outter2.add(Word4);
		
		IteradorObjetos inner2 = outter2.getReturnObject(); 
		while(!inner2.end()) {
			System.out.print("La Word numero "+inner2.getIndex()+" contiene "+inner2.current()+"\n");
			inner2.next(); 
		}
		
		//me paseo, de la externa a la interna
		ReturnObject interna = (ReturnObject) outter2.getReturnObject(); 
		//y de la interna a la externa.
		interna.getAddObject2(3);
	}
}
