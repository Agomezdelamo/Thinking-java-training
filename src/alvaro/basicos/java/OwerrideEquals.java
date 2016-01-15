package alvaro.basicos.java;

class DogTwo {
	String name;
	String says;
	
	DogTwo(){
		name = "empty";
		says = "empty";
	}
	
	void setName(String pname) { name = pname; }
	void setSays(String psays) { says = psays; }
	void showName() { System.out.println("me llamo "+name); }
	void showSays() { System.out.println("y digo "+says); }

	/**
	 * sobreescribimos equals para que compare según yo
	 * le diga
	 */
	@Override
	public boolean equals(Object obj) {
		Boolean isEquals = false;
		/**
		 * nos aseguramos que el objeto que entra como parametro sea instancia de 
		 * la clase con la que vamos a comparar
		 */
		if(obj instanceof DogTwo) {
			/**
			 * hago un downcasting, desde DogTwo generalizo a Object
			 */
			DogTwo perroTemp = (DogTwo) obj;
			
			/**
			 * personalizamos equals para que 
			 * si los dos objetos contienen un string identico son iguales.
			 */
			if(this.says.equals(perroTemp.says)) {
				isEquals = true;
			}
			else {
				isEquals = false;
			}
		}
		
		return isEquals;
	}
}

public class OwerrideEquals {
	
	public static void main(String[] args) {
		DogTwo siena = new DogTwo();
		DogTwo canelo = new DogTwo();
		DogTwo ronnie = new DogTwo();
		
		siena.setName("Siena");
		siena.setSays("Guakaguaka");
		
		canelo.setName("Canelo");
		canelo.setSays("Guakaguaka");
		
		ronnie.setName("Ronnie");
		ronnie.setSays("guaugh");
		
		/**
		 * imprimimos los resultados, al modificar equals, se comparan los objetos clase @ckass DogTwo ladridos.
		 */
		
		siena.showName();
		siena.showSays();
		System.out.println("\r\n");
		
		canelo.showName();
		canelo.showSays();
		System.out.println("\r\n");
		
		ronnie.showName();
		ronnie.showSays();
		System.out.println("\r\n");

		System.out.println("Ladra igual siena que canelo? ------- "+siena.equals(canelo));
		System.out.println("Ladra igual siena que ronnie? ------- "+siena.equals(ronnie));
		System.out.println("Ladra igual canelo que ronnie? ------- "+canelo.equals(ronnie));
	}
}
