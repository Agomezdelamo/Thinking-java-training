package alvaro.basicos.java;

public class EqualsBasico {
	/**
	 * tengo que operar dentro de un método, en la clase a pelo da problemas.
	 * @param args
	 */
	public static void main(String[] args) {
		class Dog {
			String name;
			String says;
			
			Dog(){
				name = "empty";
				says = "empty";
			}
			
			void setName(String pname) { name = pname; }
			void setSays(String psays) { says = psays; }
			void showName() { System.out.println("me llamo "+name); }
			void showSays() { System.out.println("y digo "+says); }
		}

		
		
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
		 * La comparación usando == no se debe usar para comparar el “contenido” de los objetos, solo se 
		 * usara para saber si los dos punteros apuntan al mismo objeto o no.
		 */
		System.out.println("rufus == jakes: si apuntan a objetos distintos deberia ser false: --- " + (rufus == jakes));
		
		/**
		 * Para comparar el contenido de los objetos hemos de usar equals,
		 * se basa en una definición de igualdad que ha de estar establecida.
		 * Por ejemplo, podríamos definir que dos objetos son iguales si contienen el
		 * mismo número de bolígrafos, de la misma marca, modelo y color.
		 * 
		 * Sin embargo, si hemos definido un tipo Deposito y tratamos de utilizar if (deposito1.equals (deposito2))
		 * no obtendremos un resultado satisfactorio puesto que no hemos definido cuál es el criterio de igualdad.
		 */
		System.out.println("rufus.equals(jakes) si apuntan (objetos) con contenidos distintos deberia ser false: ----" + rufus.equals(jakes));
		System.out.println("jakes.equals(rufus) si apuntan (objetos) con contenidos distintos deberia ser false: ----" + jakes.equals(rufus));
		
		System.out.println("\r\nReasignamos los punteros, los 2 apuntan al objeto contenido en jakes---> rufus = jakes");
		rufus = jakes;
		
		System.out.println("\r\nComparamos de nuevo: ");
		System.out.println("rufus == jakes ahora es true porque los dos punteros apunta al mismo objeto ----> " + (rufus == jakes));
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
