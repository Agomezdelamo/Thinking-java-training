package alvaro.thinking.tema11.colecciones;

import java.util.HashMap;
import java.util.TreeMap;


/********************************** MAP INTERFACE ***********************************/

/**
 * La interface Map, representa un objeto que sirve para ligar (“hacer un mapeo”)
 * un valor clave (Key en inglés) y un valor u objeto (value en inglés).
 * 
 * Así podemos pensar que un mapa es una especie de diccionario donde a un objeto clave
 * le asignamos un objeto valor.
 * 
 * Eso sí, un mapa no puede tener claves duplicadas.
 * La clave funciona como un identificador único.
 * 
 * Tiene 3 maneras de verse o de uso.
 * Podemos ver un mapa como un conjunto de claves (por ejemplo todos los números de pasaportes en el sistema),
 * colecciones de valores (por ejemplo todas las personas),
 * o un conjunto de pares claves-valor mapeados (todos los números de pasaporte vinculados cada uno a su persona correspondiente).
 * 
 * En principio hay que tener especial cuidado con los métodos equals y hashCode
 * ya que estos en general no están bien definidos o no resultan útiles sobre un map 
 * genérico o recién creado, por lo que hay que sobreescribir estos métodos para que tengan
 * un funcionamiento acorde a nuestras necesidades.
 * 
 */
/********************************** MAP INTERFACE ***********************************/

/**
* En resumen, Map es:
* Colección de pares clave/valor.
* La clave es usada para indexar el elemento.
* Las claves duplicadas no son permitas.
 * 
 * Proporciona 3 tipos de implementaciones generales.
 * 1) HashMap
 * 2) TreeMap
 * 3) LinkedHashMap
 */
public class InterfaceMap {
	public InterfaceMap() {
		System.out.println("Un map interface no permite duplicados en las claves.");
	}
	
	public static void main(String[] args) {
		//HashMap
		HashMapEx hMap = new HashMapEx();
		hMap.muestra();
		
		//TreeMap
		TreeMapEx tMap = new TreeMapEx();
		tMap.muestra();
		
		//LinkedHashMap
		LinkedHashMapEx lhMap = new LinkedHashMapEx();
		lhMap.muestra();
	}
}	


//1) HashMap

/**
 * HashMap.
 * Los elementos que inserta en el map no tendrán un orden específico.
 * No aceptan claves duplicadas ni valores nulos.
 *
 */

class HashMapEx {  
  
    public void muestra() {  
  
    System.out.println("****** HASHMAP (NO ORDENA) *******");
    System.out.println("add HashMap");

    HashMap<Integer, String> hashMap = new HashMap<Integer, String>();  
  
    hashMap.put(0,"value1");  
    hashMap.put(1,"value2");  
    hashMap.put(2,"value3");  
    System.out.println(hashMap);  
    
    System.out.println("remove HashMap 0");

    hashMap.remove(0);  
    System.out.println(hashMap);  
    System.out.println("");

    }  
}  

//2) TreeMap
/**
 * El Mapa lo ordena de forma “natural”.
 * Por ejemplo, si la clave son valores enteros (como luego veremos), los ordena de menos a mayor.
 */
 
class TreeMapEx {  
  
    public void muestra() {  
  
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();  
        System.out.println("****** TREEMAP (ORDENA ORDEN NATURAL LAS CLAVES) *******");
        System.out.println("add TreeMap");

        treeMap.put("3key3",435);  
        treeMap.put("1key1",123);  
        treeMap.put("2key2",654);  
        System.out.println(treeMap);  
        
        System.out.println("delete TreeMap 2key2");
        treeMap.remove("2key2");  
        System.out.println(treeMap);  
        System.out.println("");
    }  
}  

//3) LinkedHashMap

/**
 * Inserta en el Map los elementos en el orden en el que se van insertando;
 * es decir, que no tiene una ordenación de los elementos como tal,
 * por lo que esta clase realiza las búsquedas de los elementos
 * de forma más lenta que las demás clases.
 */

class LinkedHashMapEx {  
  
    public void muestra() {  
        System.out.println("****** LINKEDHASHMAP (ORDENA POR ORDEN DE INSERCIÓN) *******");
        System.out.println("add linkedHashMap");
        HashMap<Integer, String> linkedHashMap = new HashMap<Integer, String>();  
        linkedHashMap.put(0,"value1");  
        linkedHashMap.put(1,"value2");  
        linkedHashMap.put(2,"value3");  
        

        System.out.println(linkedHashMap);  
        System.out.println("delete linkedHashMap 0");
        linkedHashMap.remove(0);  
        System.out.println(linkedHashMap);  
        System.out.println("");

        }  
}  


