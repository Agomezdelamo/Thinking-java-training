package alvaro.thinking.tema9.interfaces;

//Demostrar que aunque no se definan, todos los m�todos de un interface tienen acceso public.

interface Ex6 {
	//si es un interfaz autom�ticamente son m�todos p�blicos.
	void sayOne();
	void sayTwo();
	void sayThree();
}
 
class Ex6b implements Ex6 {
	// Error: no puedes asignar acceso m�s d�bil que p�blico por ser un interface
	
	// void sayOne() { System.out.println("one"); } // si no pones na es acceso de paquete y falla.
	// protected void sayTwo() { System.out.println("two"); } // no puede ser protected
	// private void sayThree() { System.out.println("three"); } // no puede ser private
	
	// debe mantenerse en acceso p�blico y especificarse aunque en el interface no se ahga.:
	public void sayOne() { System.out.println("one"); }
	public void sayTwo() { System.out.println("two"); }
	public void sayThree() { System.out.println("three"); }
} 


public class Interface2 {	
	public static void main(String[] args) {
		Ex6b x = new Ex6b();
		x.sayOne();
		x.sayTwo();
		x.sayThree();
	}
}