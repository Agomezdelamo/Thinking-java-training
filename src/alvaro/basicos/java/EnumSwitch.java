package alvaro.basicos.java;

/**
 * uso tipico de un enum en un switch
 * @author agomez
 *
 */

public class EnumSwitch {
	public static void main(String[] args) {
		for(EnumBasico b : EnumBasico.values()) {
			System.out.print("Cantidad: ");
			switch(b) {
				case DIEZ: System.out.println("10€"); break; 
				case VEINTE: System.out.println("20€"); break;
				case CINCUENTA: System.out.println("50€"); break;
				case CIEN: System.out.println("100€"); break; 
				case DOSCIENTOS: System.out.println("200€"); break;
				case QUINIENTOS: System.out.println("500€"); break;
				default: break;
			}
		}	
	}
}