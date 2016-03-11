package alvaro.thinking.tema9.interfaces;

import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

//TIJ4 Chapter Interfaces, Exercise 16, page 334

/* Create a class that produces a sequence of chars. Adapt this class so
* that it can be an input to a AdaptedRandomChars object.
*/


class CaracteresRandom {
	private static Random rand = new Random();
	
	//genero un numero aleatorio y lo casteo a letra.
	public char next() { return (char)rand.nextInt(128); }
	
	public static void main(String[] args) {		
		CaracteresRandom cr = new CaracteresRandom();
		for(int i = 0; i < 10; i++) { System.out.println(cr.next() + "  <-- caracter aleatorio CaracteresRandom"); }
	}
}

/* PATRON ADAPTADOR: ADAPTO LA CLASE CARACTERESRANDOM A READABLE MEDIANTE HERENCIA E INTERFAZ */
public class Adaptando_CaracteresRandom extends CaracteresRandom implements Readable {
	
	private int count;
	
	//constructor
	public Adaptando_CaracteresRandom(int count) { this.count = count; }
	
	//INTERFAZ //metodo de la interfaz de java.lang readable, recibe un caracter CharBuffer.
	public int read(CharBuffer cb) {
		if(count-- == 0) return -1;
		
		//HERENCIA //uso el metodo next() heredado de CaracteresRandom para generar un char aleatorio.
		String result = Character.toString(next());
		
		cb.append(result); // INTERFAZ //añadimos el resultado con append, que es un método de Readable.
		
		return result.length();
	}
	
	
	public static void main(String[] args) {
		/**
		 * Scanner recibe como parametro en el constructor la interfaz readable.
		 * 
		 * como adaptedRandomChars la implementa puede entrar por esa puerta.
		 */
		Scanner s = new Scanner(new Adaptando_CaracteresRandom(10)); //PATRON ADAPTADOR CaracteresRandom--->Readable
		while(s.hasNext())
			System.out.println(s.next() + " <-- Flujo de caracteres readables");
	}
}

