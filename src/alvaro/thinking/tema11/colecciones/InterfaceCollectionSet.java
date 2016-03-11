package alvaro.thinking.tema11.colecciones;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/********************************** COLLECTION INTERFACE ***********************************/
/**
 * Contenedor simple de objetos no ordenados.Los duplicados son permitidos.
 * 
 * El interface de collection esta en lo alto de la jerarquia, 
 * aunque java no te permite implementarlo directamente,
 * lo haces implicitamente con List, Set y Queue.
 */
/********************************** COLLECTION INTERFACE ***********************************/


/**** SET Interface ****/
/*
 * Un set interface no permite duplicados. 
 * Colección desordenada de objetos.
 * 
 * Proporciona 3 tipos de implementaciones generales.
 * 	1) HashSet
 * 	2) TreeSet
 * 	3) LinkedHashSet
 */
/**** SET Interface ****/

public class InterfaceCollectionSet {
	public InterfaceCollectionSet() {
		System.out.println("Un set interface no permite duplicados. Colección desordenada de objetos.");
	}
	
	public static void main(String[] args) {
		//HashSet
		HashSetEx hSet = new HashSetEx();
		hSet.muestra();
		
		//TreeSet
		TreeSetEx tSet = new TreeSetEx();
		tSet.muestra();
		
		//HashSet
		LinkedHashSetEx lhSet = new LinkedHashSetEx();
		lhSet.muestra();
	}
}	

// 1) HashSet
/* HashSet es la mejor forma de implementar un interface de Set.
 * Almacena sus elementos en una tabla hash y no garantiza ningún tipo de orden en la iteracción. */  
class HashSetEx {  
    public void muestra(){  
  
    	HashSet<String> hashSet = new HashSet<String>();  
    	
    	System.out.println("****** HASHSET (NO ORDENA) *******");
    	System.out.println("add HashSet");
        hashSet.add("element1");  
        hashSet.add("element2");  
        System.out.println(hashSet);  
  
    	System.out.println("remove HashSet element1");
        hashSet.remove("element1");  
        System.out.println(hashSet);  
        System.out.println("");
    }  
} 


//2) TreeSet

/*
 * TreeSet es un poco mas lento que HasSet y almacena sus elementos en una estructura de arbol rojo-negro.
 * TreeSet ordena sus elementos basandose en sus valores
 */  
  
class TreeSetEx {  
  
    public void muestra(){    
        TreeSet<String> treeSet = new TreeSet<String>();  
    	System.out.println("****** TREESET (ORDENA POR EL VALOR) *******");
    	System.out.println("add TreeSet");

        treeSet.add("b. element2");  
        treeSet.add("a. element1");  
        treeSet.add("c. element3");  
        System.out.println(treeSet);  
    	
        System.out.println("remove TreeSet element2");
        treeSet.remove("b. element2");  
        System.out.println(treeSet);  
        System.out.println("");
    }      
}  


//3) LinkedHashSet
/*
 * LinkedHashSet esta implementando una tabla Hash con una lista lincada corriendo a traves de ella.
 * Ordena sus elementos basandose en el orden en el cual fueron insertados en el Set.
*/
  
class LinkedHashSetEx {  
  
    public void muestra() {  
  
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();  
    	
        System.out.println("****** LINKED HASH SET (ORDENA POR ORDEN DE LLEGADA O INSERCIÓN) *******");
    	
    	System.out.println("add LinkedHashSet");
    	
        linkedHashSet.add("b. element1");  
        linkedHashSet.add("a. element2");  
        linkedHashSet.add("c. element3");  
        System.out.println(linkedHashSet);  
        
        System.out.println("remove HashSet b. element1");
        linkedHashSet.remove("b. element1");  
        System.out.println(linkedHashSet);
    }  
}  

