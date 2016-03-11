package alvaro.thinking.tema9.interfaces;

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
interface Historial1 {
	void u();
	void v();
}

interface Examenes1 {
	void w();
	void x();
}

interface Laboratorios1 {
	void y();
	void z();
}

/**************** INTERFAZ GLOBAL ********************/
interface Elaborar1 extends Historial1, Examenes1, Laboratorios1 {
	void zz();
}


/**************** CLASE PADRE ********************/
abstract class Doctor1 {
	private int i = 0;
	public void doc() { System.out.println("abstract ---> doctor"); }
}

/**************** CLASE HIJA E INTERFAZ GLOBAL ********************/
class Anestesista1 extends Doctor1 implements Elaborar1 {
	private int j = 0;
	public void u() { System.out.println("Interfaz ---> Historial"); }	//Historial
	public void v() { System.out.println("Interfaz ---> Historial"); }	//Historial
	public void w() { System.out.println("Interfaz ---> Examenes"); }	//Examenes
	public void x() { System.out.println("Interfaz ---> Examenes"); }	//Examenes
	public void y() { System.out.println("Interfaz ---> Laboratorios"); }	//Laboratorios
	public void z() { System.out.println("Interfaz ---> Laboratorios"); }	//Laboratorios
	public void zz() { System.out.println("Interfaz ---> Elaborar"); }	//Elaborar
	
	@Override
	public void doc() { System.out.println("abstract ---> Anestesista1"); } // tiene que sobreescribir el método de la clase abstracta 
}

public class PolimorfismoHerencia2 {
	public static void method1(Historial1 Historial1) { Historial1.v(); }
	public static void method2(Examenes1 Examenes1) { Examenes1.w(); }
	public static void method3(Laboratorios1 Laboratorios1) { Laboratorios1.y(); } 
	public static void method4(Elaborar1 elaborar1) { elaborar1.zz(); }
	
	public static void main(String[] args) {
		Anestesista1 anes = new Anestesista1();
		
		// Me permite pasar un anestesista porque a heredado todos esos interfaces.
		method1(anes);
		method2(anes);
		method3(anes);
		method4(anes);
	}
}