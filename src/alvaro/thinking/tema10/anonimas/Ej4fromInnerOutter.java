package alvaro.thinking.tema10.anonimas;


	class Palabra2 {
		String guardoPalabra;
		public Palabra2(String guardoPalabra){
			this.guardoPalabra = guardoPalabra;
		}
		
		@Override
		public String toString() {
			return "Este es mi String -->"+guardoPalabra;
		};
	}

	interface Selector3 {
		boolean end();
		Object current();
		void next();
		int getIndex();
	}
		
	public class Ej4fromInnerOutter {
		private Object[] items;
		private String llamadaConstructorExternoDesdeInterno;
		private int next = 0;
		public Ej4fromInnerOutter (int tamañoArray) { 
			items = new Object[tamañoArray];
		}
		//en el constructor le damos tamaño, con lo que
		//en add siempre el next sera menor que el tamaño la primera vez.
		public void add(Object x){
			if(next < items.length)
				items[next++] = x;
		}

		
		private class SequenceSelector implements Selector3 {
			//una clase interna que itera sobre propiedades de su padre que es clase externa.
			private int index = 0;
			public boolean end() { return index == items.length; }
			public Object current() { return items[index]; }
			public void next() { if(index < items.length) index++; }
			public int getIndex() {return index;}
			
			public Ej4fromInnerOutter getEj4fromInnerOutter(int tamañoClassOutter) {
				llamadaConstructorExternoDesdeInterno=" creado desde un objeto interno";
				System.out.print("Objeto externo"+llamadaConstructorExternoDesdeInterno);
				return new Ej4fromInnerOutter(tamañoClassOutter);
			}
		}
		
		public Selector3 selector() {
			return new SequenceSelector();
		}
		

		public static void main (String[] args){
			Ej4fromInnerOutter outterSequence = new Ej4fromInnerOutter(10);
			for(int i = 0; i < 10; i++)
				outterSequence.add(new Palabra2(" esta es la palabra número "+Integer.toString(i)));
			
			Selector3 innerSelector = outterSequence.selector();
			
			while(!innerSelector.end()) {
				System.out.print(innerSelector.current() + "\n");
				innerSelector.next();
			}
			
			Palabra2 palabra1 = new Palabra2("hola");
			Palabra2 palabra2 = new Palabra2("que");
			Palabra2 palabra3 = new Palabra2("tal");
			Palabra2 palabra4 = new Palabra2("estas");
			
			Ej4fromInnerOutter outterSequence2 = new Ej4fromInnerOutter(4);
			
			outterSequence2.add(palabra1);
			outterSequence2.add(palabra2);
			outterSequence2.add(palabra3);
			outterSequence2.add(palabra4);
			
			Selector3 innerSelector2 = outterSequence2.selector(); 
			while(!innerSelector2.end()) {
				System.out.print("La palabra numero "+innerSelector2.getIndex()+" contiene "+innerSelector2.current()+"\n");
				innerSelector2.next(); 
			}
			
			//downcasting outterSequence2.selector() devuelve un tipo "Selector3"
			//como la clase SequenceSelector implementa Selector3 puedo hacer downcasting desde Selector3 a SequenceSelector
			SequenceSelector a = (SequenceSelector) outterSequence2.selector(); 
			a.getEj4fromInnerOutter(3);
		}
	}
