package alvaro.thinking.tema6.controlAcceso;

/**
 * esta clase usa un constructor privado y devuelve el new desde un método statico, es para mostrar
 * las ventajas o no de constructores privados.
 * @author agomez
 *
 */

class Conexion {
	private static int count = 0;
	private int i = 0;
	
	//constructor privado. No puedes hacer un new.
	private Conexion() { System.out.println("Conexion()");}
	
	// Permito instanciar desde un método static
	static Conexion makeConexion() {
		count++;
		return new Conexion();
	}
	
	public static int howMany() { return count; } 
	
	public String toString() {
		return ("Conexion " + count);
	}
}

public class ProductorConexiones {
	static int cuantosQuedan = 3;
//	array de punteros a conexion
	static Conexion[] ca = new Conexion[3];	

	//	inicializador de instancia (se ejecuta sea cual sea el constructor y antes de el)
	{
	for(Conexion x : ca)
		//hago los new.
		x = Conexion.makeConexion();
	}
	
	public static Conexion getConexion() {
		if(cuantosQuedan > 0)
			//devuelve el lenght de los punteros a conexion que quedan en el array
			return ca[--cuantosQuedan];
		else {
			System.out.println("No hay mas conexiones");
			return null;
		}
	}
	public static void main(String[] args) {		
		ProductorConexiones cm = new ProductorConexiones();
		System.out.println("quedan: "+cm.cuantosQuedan);
		cm.getConexion();
		System.out.println("quedan: "+cm.cuantosQuedan);
		cm.getConexion();
		System.out.println("quedan: "+cm.cuantosQuedan);
		cm.getConexion();
		System.out.println("ahora las conexiones estan vacias --> "+ cm.getConexion());
		System.out.println("quendan: "+cm.cuantosQuedan);
	}				  	
} 