package alvaro.thinking.tema3.operadores;

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

public class DogTest {
	/**
	 * tengo que operar dentro de un método, en la clase a pelo da problemas.
	 * @param args
	 */
	public static void main(String[] args) {

	Dog rufus = new Dog();
	rufus.setName("rufus");
	rufus.showName();
	rufus.setSays("guauuu");
	rufus.showSays();
	
	Dog jake = new Dog();
	jake.setName("Jake");
	jake.showName();
	jake.setSays("ssasa");
	jake.showSays();
	
	}
}
