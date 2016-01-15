package alvaro.thinking.tema3.operadores;

public class DogCompare {
	/**
	 * tengo que operar dentro de un m�todo, en la clase a pelo da problemas.
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * para usar una clase a nivel paquete tiene que tener constructor.
		 * */
		Dog rufus = new Dog();
		rufus.setName("rufus");
		rufus.setSays("guauuu");
		
		Dog jakes = new Dog();
		jakes.setName("jakess");
		jakes.setSays("ssasa");
		
		System.out.println("Comparacion: ");
		
		/**
		 * La comparaci�n usando == no se debe usar para comparar el �contenido� de los objetos,
		 * sino �nicamente para comparar la informaci�n de las variables apuntadoras, si ocupan 
		 * el mismo lugar en el espacio de memoria f�sico. 
		 */
		System.out.println("rufus == jakes: si apuntan a news (objetos) distintos deberia ser false: --- " + (rufus == jakes));
		
		/**
		 * Para comparar el contenido de los objetos hemos de usar equals,
		 * se basa en una definici�n de igualdad que ha de estar establecida.
		 * Por ejemplo, podr�amos definir que dos objetos son iguales si contienen el
		 * mismo n�mero de bol�grafos, de la misma marca, modelo y color.
		 * 
		 * Sin embargo, si hemos definido un tipo Deposito y tratamos de utilizar if (deposito1.equals (deposito2))
		 * no obtendremos un resultado satisfactorio puesto que no hemos definido cu�l es el criterio de igualdad.
		 */
		System.out.println("rufus.equals(jakes) si apuntan (objetos) con contenidos distintos deberia ser false: ----" + rufus.equals(jakes));
		System.out.println("jakes.equals(rufus) si apuntan (objetos) con contenidos distintos deberia ser false: ----" + jakes.equals(rufus));
		
		System.out.println("\r\nAhora apuntamos los 2 punteros al objeto jakes: rufus = jakes");
		rufus = jakes;
		
		System.out.println("\r\nComparamos de nuevo: ");
		System.out.println("rufus == jakes: " + (rufus == jakes));
		System.out.println("rufus.equals(jakes): " + rufus.equals(jakes));
		System.out.println("jakes.equals(rufus): " + jakes.equals(rufus));

		System.out.print("\r\n");
		System.out.print("rufus: ");
		rufus.showName();
		rufus.showSays();
		System.out.print("\r\n");

		System.out.print("jakes: "); 
		jakes.showName();
		jakes.showSays();
	
	}
}
