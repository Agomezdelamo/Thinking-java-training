package alvaro.thinking.tema11.colecciones;

//holding/Ex7.java
//TIJ4 Chapter Holding, Exercise 7, page 406
/* Create a class, then make an initialized array of objects of your class
* Fill a List from your array. Create a subset of your List by using 
* subList(), then remove this subset from your List.
*/

import java.util.*;

class Tester {
	public static int counter = 0;
	private int id = counter++;
	public String toString() { return String.valueOf(id); }	
}

public class holding3 {
	public static void main(String[] args) {		
		Tester[] t = new Tester[10]; //genero una lista con un array antiguo de la clase tester
		
		for(int i = 0; i < t.length; i++)
			t[i] = new Tester(); //inicializo cada puntero del array con un objeto tester
		
		List<Tester> lt = new ArrayList<Tester>(); //ahora genero una lista con un array nuevo de tipo lista de tester.
		for(Tester x : t) lt.add(x); //recorro la lista con un for each y la inicializo
			System.out.println("list of Tester: " + lt);
			
		List<Tester> sub = lt.subList(2, 6); //genero un puntero a una sublista de "lt"
		System.out.println("subList: " + sub);
		
		// lt.removeAll(sub) produce en tiempo de ejecución la excepcion ConcurrentModificationException:
		// asi que primero hacemos una copia, borramos sub y reasignamos el puntero lt:
		
		List<Tester> copy = new ArrayList<Tester>(lt); //hacemos una copia de la lista con un nuevo objeto de arraylist, ahora ya no es un simple puntero, es un objeto.
		copy.removeAll(sub); //borro todos los objetos de la lista de copy que coincidan con la sublista que paso.
		System.out.println("copy: " + copy);
	
		lt = copy; //reasignamos lt al objeto residente en copia, ahora hemos borrado la sublista sin error en tiempo de ejecución.
		System.out.println("list of Tester: " + lt);
	}
}