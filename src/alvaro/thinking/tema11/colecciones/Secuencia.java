package alvaro.thinking.tema11.colecciones;


//holding/Sequence9.java
//TIJ4 Chapter Holding, Exercise 9, page 409
//Modify innerclasses/Sequence.java so that Sequence works with an Iterator
//instead of a Selector.
import java.util.*;

public class Secuencia {
	private ArrayList<Object> items = new ArrayList<Object>(); //creo una lista con ArrayList.
	
	public void add(Object x) { //método que añade un objeto a la lista
		items.add(x);
	}
	
	public Iterator iterator() { //método que devuelve un iterador de la lista
		return items.iterator();
	}
	
	public static void main(String[] args) {
		Secuencia secuencia = new Secuencia();//creo una objeto secuencia (por dentro ya se ha inicializado items, la lista).
		
		for(int i = 0; i < 10; i++)
			secuencia.add(Integer.toString(i)); //relleno la lista con 10 strings
		
		
		Iterator it = secuencia.iterator(); //obtengo un iterador de esa lista.
		
		while(it.hasNext()) {	//mientras haya un objeto en la lista contenida en secuencia lo imprimo								
			System.out.print(it.next() + " ");
		}
	}
}



