package alvaro.thinking.tema11.colecciones;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

/********************************** COLLECTION INTERFACE ***********************************/
/**
 * Contenedor simple de objetos no ordenados.Los duplicados son permitidos.
 * 
 * El interface de collection esta en lo alto de la jerarquia, 
 * aunque java no te permite implementarlo directamente,
 * lo haces implicitamente con List, Set y Queue.
 */
/********************************** COLLECTION INTERFACE ***********************************/


/**** LIST Interface ****/
/*
 * Una lista es una coleccion ordenada que puede contener valores duplicados.
 * 
 * Proporciona 3 tipos de implementaciones generales.
	1) ArrayList
	2) LinkedList
	3) Vector
 */
/**** LIST Interface ****/

public class InterfaceCollectionList {
	
	public static void main(String[] args) {
		//ArrayList
		ArrayListEx aList = new ArrayListEx();
		aList.muestra();

		//ArrayList
		LinkedListEx lList = new LinkedListEx();
		lList.muestra();
		
		//Vector
		VectorEx vList = new VectorEx();
		vList.muestra();
		
		//Stack
		StackEx sList = new StackEx();
		sList.muestra();
		
	
	}
}	

// 1) ArrayList
/* ArrayList es la mejor forma de implementar una lista en condiciones normales.
 * En palabras simples podemos decir que arrayList es un array expansible de objetos.
 */  

class ArrayListEx {  
    public void muestra(){  
  
    	ArrayList<String> arrayList = new ArrayList<String>();  
    	
    	System.out.println("****** ARRAYLIST () *******");
    	System.out.println("add arrayList");
         arrayList.add("element1");  
         arrayList.add("element2");  
         arrayList.add("element3");  
         System.out.println(arrayList);  
   
     	System.out.println("remove arrayList element3");
         arrayList.remove("element3");  
         System.out.println(arrayList);  
         System.out.println("");

    }  
} 

// 2) LinkedList
/**
 * Linked list es un poco mas lento que ArrayList pero trabaja mejor en ciertas condiciones.
 * 
 * Se basa en la implementación de listas doblemente enlazadas. 
 * Si tenemos una lista y lo que nos importa no es buscar la información lo más rápido posible,
 * sino que la inserción o eliminación se hagan lo más rápidamente posible,
 * LinkedList resulta una implementación muy eficiente.
 * <br/>
 * <br/>
 * La clase Linkedlist no permite posicionarse de manera absoluta (acceder directamente a un elemento de la lista)
 * y por tanto no es conveniente para búsquedas 
 * pero en cambio sí permite una rápida inserción al inicio/final
 * de la lista y funciona mucho más rápido que Arraylist por ejemplo para la posición 0.
 * <br/>
 * <br/>
 * En un ArrayList, insertar en la posición cero continuamente es mas lento que en
 * LinkedList, donde el elemento simplemente “se enlaza” al principio,
 * sin necesidad de realizar desplazamientos en cadena de todos los demás elementos.
 * <br/>
 * <br/>
 * Por el contrario si pensamos a priori que la mayoría de las operaciones
 * sobre esta lista de objetos van a ser inserciones o eliminaciones sobre
 * listas grandes escribiremos: List listaObjetos = new LinkedList();
 * 
 * 
 */
class LinkedListEx {  
  
    public void muestra(){  
        LinkedList<String> linkedList = new LinkedList<String>();  
    	System.out.println("****** LINKEDLIST () *******");
    	System.out.println("add linkedList");

    	linkedList.add("b. element2");  
        linkedList.add("a. element1");  
        linkedList.add("c. element3");  
        System.out.println(linkedList);  
        
     	System.out.println("remove linkedList element3");

        linkedList.remove("c. element3");  
        System.out.println(linkedList);  
        System.out.println("");  
    }  
}  

//3) Vector
/**
 * Vector es también una matriz de objetos que pueda crecer, 
 * pero a diferencia de ArrayList,
 * Vector es sincronizado, lo que permite que se pueda usar en entornos concurrentes.
 */

class VectorEx {  
  
    public void muestra(){  
  
        Vector<String> vector = new Vector<String>();  
    	System.out.println("****** VECTOR () *******");
    	System.out.println("add vector");

        vector.add("1. element1");  
        vector.add("3. element3");  
        vector.add("2. element2");  
        System.out.println(vector);  
        
     	System.out.println("remove linkedList element1");

        vector.remove("1. element1");  
        System.out.println(vector);
        System.out.println("");  

    }  
}  


//4) Stack

/**
 * La clase Stack es una clase de las llamadas de tipo LIFO
 * (Last In - First Out, o último en entrar - primero en salir).
 * Esta clase hereda de la clase Vector y con 5 operaciones permite
 * tratar un vector a modo de pila o stack.
 * 
 * Las operaciones básicas son:
 * <ol>
 * <li>push (que introduce un elemento en la pila),</li>
 * <li>pop (que saca un elemento de la pila),</li>
 * <li>peek (consulta el primer elemento de la cima de la pila),</li>
 * <li>empty (que comprueba si la pila está vacía)</li>
 * <li>search (que busca un determinado elemento dentro de la pila y devuelve su posición dentro de ella).</li>
 * </ol>
*/


class StackEx {  
  
    public void muestra(){  
  
        Stack<String> stack = new Stack<String>();  
    	System.out.println("****** STACK () *******");
    	System.out.println("add vector");

    	stack.push("3. element3");  
    	stack.push("1. element1");  
    	stack.push("2. element2");  
        System.out.println(stack);  
        
     	System.out.println("ultimo en entrar, primero en salir linkedList 2. element2");

     	stack.pop();  
        System.out.println(stack);  
    }  
}  
