package alvaro.thinking.tema5.inicializacion;


/**
 * crea una clase con 2 métodos, desde el primero se llama al segundo con y sin this.
 * 
 * Sólo sirve para comprobar como funciona el mecanismo.
 * @author agomez
 *
 */
class Doc {	
//	1
	void intubate() {
		System.out.println("prepare patient");
		laryngoscopy();
		this.laryngoscopy();	
	}
//	2
	void laryngoscopy() {
		System.out.println("use laryngoscope");
	}	
}	

public class PassingThisEx{	
	public static void main(String[] args) {
		new Doc().intubate();		
	}
}
