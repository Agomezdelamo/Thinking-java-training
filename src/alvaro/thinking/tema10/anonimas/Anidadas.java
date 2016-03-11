package alvaro.thinking.tema10.anonimas;

//innerclasses/Ex18.java
//TIJ4 Chapter Innerclasses, Exercise 18, page 366
/* Create a class containing a nested class. In main(), create an instance of
* the nested class.
*/

/**
 * Las clases internas anidadas son estáticas, y pierden la conexión con su clase externa.
 * 		1. No es necesario un objeto  de la clase externa para instanciar la clase interna anidada.	
 * 		2. No se puede acceder a un campo no estático de la clase externa desde la clase interna.
 * 		3. Las clases anidadas pueden tener campos y métodos estáticos y clases anidadas.
 */
public class Anidadas {
	Anidadas() { System.out.println("Anidadas()"); }
	public static class Anidada1 {
		Anidada1() { System.out.println("Anidada1()"); }
	}
	private static class Anidada2 {
		Anidada2() { System.out.println("Anidada2()"); }
	}
	/* Instancio las calses anidadas */
	public static void main(String[] args) {
		Anidada1 en1 = new Anidada1(); //se pueden instanciar sin necesidad de tener un objeto externo.
		Anidada2 en2 = new Anidada2(); //se pueden instanciar sin necesidad de tener un objeto externo.
	}
}