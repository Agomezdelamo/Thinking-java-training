package alvaro.thinking.tema5.inicializacion;

class Aso {
	void bark() {System.out.println("woof");}
} 	


class Aso2 {
	public Aso2(int i){}
	void bark() {System.out.println("woof");}
} 	

public class AutomaticConstructor {
	public static void main(String[] args) {
		Aso a = new Aso();
		a.bark();
		
		/**
		 * aqui esta petando porque, en el momento que defines un constructor,
		 * ya no vale el constructor sin argumentos por defecto, ya tienes que definir todas 
		 * las posibilidades de construcción, incluso el default.
		 */
		Aso2 b = new Aso2();
		Aso2 c = new Aso2(1);
		a.bark();
	}
}