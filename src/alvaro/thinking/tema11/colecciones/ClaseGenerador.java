package alvaro.thinking.tema11.colecciones;

//holding/Ex4.java
//TIJ4 Chapter Holding, Exercise 4, page 401
/* Crear una clase generadora que produzca nombres de caracteres (como Strings)
* de tus peliculas favoritas.
* Cada vez que llames a next(), que vuelva el bucle al principio de la lista de caracteres
* cuando se salga del nombre.
* 
* Usa este generador para rellenar 
* 	1. un array, 
* 	2. un arrayList, 
* 	3. un linkedList, 
*	4. un hashSEt, 
* 	5. un linkedHashSet y un 
* 	6. TreeSEt, 
* 
* después pinta cada contenedor.
*/
import java.util.*;

class Generador {
	int key = 0;//clave
	
	public String next() { //metodo que itera con un switch para el next en un determinado número de casos.
		switch(key) {
			default:
			case 0 : key++; return "Snow White"; //incremento la clave y devuelvo un caso
			case 1 : key++; return "Bashful";
			case 2 : key++; return "Doc";
			case 3 : key++; return "Dopey";
			case 4 : key++; return "Grumpy";
			case 5 : key++; return "Happy";
			case 6 : key++; return "Sleepy";
			case 7 : key = 0; return "Sneezy";	//reset de la clave		
		}
	} 

	/***************** RELLENAR ARRAY[] **********************/
	public void fillA(String[] stringParams) { //metodo que rellena un array clasico
		for(int i = 0; i < stringParams.length; i++)
			stringParams[i] = next(); //relleno la siguiente posición del parametro con el siguiente caso de next()
	}
	
	/***************** RELLENAR COLECCION **********************/
	public Collection fill(Collection<String> collectionParam, int numberOfItems) { //método que rellena una colección
		for(int i = 0; i < numberOfItems; i++) collectionParam.add(next());
		return collectionParam;
	}
}

public class ClaseGenerador {
	public static void main(String[] args) {
		Generador gen = new Generador(); //instancio el objeto generador.
		
		String[] a = new String[10];//Array antiguo de strings
		gen.fillA(a); //lo relleno con pelis strings.
		for(String s : a) System.out.print(s + ", ");//lo pinto
		System.out.println("");	
		System.out.println("");	
		
		//relleno colecciones
		System.out.println("ArrayList -->        " + gen.fill(new ArrayList<String>(), 10)); //10 itemns de ArrayList
		System.out.println("LinkedList  -->        " + gen.fill(new LinkedList<String>(), 10)); //10 itemns de LinkedList
		System.out.println("HashSet  -->        " + gen.fill(new HashSet<String>(), 10)); //10 itemns de HashSet
		System.out.println("LinkedHashSet  -->        " + gen.fill(new LinkedHashSet<String>(), 10)); //10 itemns de LinkedHashSet
		System.out.println("TreeSet  -->        " + gen.fill(new TreeSet<String>(), 10));  //10 itemns de TreeSet				
	}
}