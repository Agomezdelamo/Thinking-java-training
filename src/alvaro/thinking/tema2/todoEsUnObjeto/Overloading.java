package alvaro.thinking.tema2.todoEsUnObjeto;

class Tree {
	int height;
	
	/**
	 * constructor sin argumentos
	 * asigna a height = 0
	 */
	Tree() {
		System.out.println("planto un arbol --- CONSTRUCTOR SIN ARGUMENTOS");
		height = 0;
	}
	
	/**
	 * constructor que acepta un 
	 * entero como parámetro
	 * asigna el parámetro int a height;
	 */
	Tree(int h) {
		height = h;
		System.out.println("planto un arbol cuya altura es "+h+" --- CONSTRUCTOR CON ARGUMENTOS");
	}
	
	/**
	 * método para imprimir la altura (height) del arbol
	 */
	void info() {
		System.out.println("El arbol mide "+height+" pies de altura.");
	}
	
	/**
	 * método sobrecargado para imprimir la altura (height) del arbol
	 * con un @args s que es un string.
	 */
	void info(String s) {
		System.out.println(s+": El arbol mide "+height+" pies de altura.\r\n");
	}
}

/**
 * Clase para probar la construcción de tres objetos
 * sobrecargados.
 * @author Dj nezhod
 *
 */
public class Overloading {
	public static void main (String[] args) {
		for(int i = 0; i < 5; i++) {
			Tree t = new Tree(i);
			t.info();
			t.info("Método sobrecargado");
		}
		//constructor sobrecargado:
		new Tree();
	}
}
