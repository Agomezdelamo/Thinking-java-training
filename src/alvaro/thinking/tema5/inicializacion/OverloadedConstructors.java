package alvaro.thinking.tema5.inicializacion;

class Doc2 {
	Doc2() {
		this("MD",3);
		System.out.println("0 ---> Constructor por defecto");
	}
	Doc2(String s, int i) {
		this(s);
//		no se puede llamar a dos constructores desde un constructor seguidamente con this
//		this(3);
		System.out.println("1 ---> Constructor Sobrecargado string "+s+" e int "+i);
	}
	Doc2(String s) {
		this(3);
		String degree = s;
		System.out.println("2 ---> Constructor Sobrecargado string de "+s);
	}	
	Doc2(int i) {
		int yearsTraining = i;
		System.out.println("3 ---> Constructor Sobrecargado int de "+i);
	}	
	void intubate() {
		System.out.println("prepare patient");
		laryngoscopy();
	}
	void laryngoscopy() {
		System.out.println("use laryngoscope");
	}	
}
	
public class OverloadedConstructors {	
	public static void main(String[] args) {
		/**
		 * llamo al constructor por defecto, y va saltando entre llamadas
		 * al this(el propio objeto), hasta la ultima llamada,
		 * entonces ejecuta el resto de ese constructor
		 * y va volviendo sus pasos hacía atras ejecutando
		 * el resto de los constructores por donde a pasado.
		 */
		new Doc2().intubate();		
	}		
}
