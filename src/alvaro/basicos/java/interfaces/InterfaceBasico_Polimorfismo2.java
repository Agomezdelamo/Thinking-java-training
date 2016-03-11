package alvaro.basicos.java.interfaces;

//interfaces/InterfaceBasico_Polimorfismo2.java
//TIJ4 Chapter Interfaces, Exercise 14, page 330
/**
 * Crear tres interfaces, cada uno con 2 metodos.
 * 
 * INTERFACE GLOBAL: Heredar un nuevo interface que combine esos 3, y añada un nuevo metodo.
 * 
 * CLASE HIJA:  Crear una clase que implemente este último interfaz y admeas herede de una clase PADRE.
 * 
 * Ahora escribe 4 metodos, cada uno de los cuales coja uno de los 4 interfaces como argumento.
 * 
 * En main() crea un objeto de tu clase y pasale cada uno de esos métodos.
 */


/**************** INTERFACES ********************/
interface Historial {
	void u();
	void v();
}

interface Examenes {
	void w();
	void x();
}

interface Laboratorios {
	void y();
	void z();
}

/**************** INTERFAZ GLOBAL ********************/
interface Elaborar extends Historial, Examenes, Laboratorios {
	void zz();
}


/**************** CLASE PADRE ********************/
class Doctor {
	private int i = 0;
	public void doc() {}
}

/**************** CLASE HIJA E INTERFAZ GLOBAL ********************/
class Anestesista extends Doctor implements Elaborar {
	private int j = 0;
	public void u() { System.out.println("Interfaz ---> Historial"); }	//Historial
	public void v() { System.out.println("Interfaz ---> Historial"); }	//Historial
	public void w() { System.out.println("Interfaz ---> Examenes"); }	//Examenes
	public void x() { System.out.println("Interfaz ---> Examenes"); }	//Examenes
	public void y() { System.out.println("Interfaz ---> Laboratorios"); }	//Laboratorios
	public void z() { System.out.println("Interfaz ---> Laboratorios"); }	//Laboratorios
	public void zz() { System.out.println("Interfaz ---> Elaborar"); }	//Elaborar
}

public class InterfaceBasico_Polimorfismo2 {
	public static void method1(Historial Historial) { Historial.v(); }
	public static void method2(Examenes Examenes) { Examenes.w(); }
	public static void method3(Laboratorios Laboratorios) { Laboratorios.y(); } 
	public static void method4(Elaborar elaborar) { elaborar.zz(); }
	
	public static void main(String[] args) {
		Anestesista anes = new Anestesista();
		
		// Me permite pasar un anestesista porque a heredado todos esos interfaces.
		method1(anes);
		method2(anes);
		method3(anes);
		method4(anes);
	}
}