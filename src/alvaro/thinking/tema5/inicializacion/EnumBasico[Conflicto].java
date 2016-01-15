package alvaro.thinking.tema5.inicializacion;

/**
 * Cree un enum con los seis billetes mas bajos de euro.
 * Recorralo con un loop
 * usando el metodo values() (genera una matriz de valores con las constantes del enum)
 * y imprima su orden de instanciación con ordinal()
 * 
 * @author agomez
 *
 */

		// UN ENUM ES UNA CLASE ESPECIAL CON UN NÚMERO DEFINIDO DE CONSTANTES(OBJETOS) EN SU INTERIOR.
		public enum EnumBasico {
			DIEZ(1001,"billete","diez Euros"), VEINTE(1002,"billete","veinte Euros"), CINCUENTA(1003,"billete","cincuenta Euros"),
			CIEN(1004,"billete","cien Euros"), DOSCIENTOS(1005,"billete","doscientos Euros"), QUINIENTOS(1006,"billete","quinientos Euros");
			
			/**
			 * campos y constructor privado definido para este enum
			 */
			int id;
			String name;
			String surname;
			private EnumBasico(int id, String name, String surname) {
				this.id = id;
				this.name = name;
				this.surname = surname;
			}
		
		
		public static void main(String[] args) {
//			para poder recorrer con un foreach tengo que añadir el método values() al tipo del enum,
//			esto crea un array de valores con las constantes.
			for(EnumBasico b : EnumBasico.values())
				//al imprimir cada constante del enum, hace un toString del nombre de la constante.
				System.out.println("toString() de la constante ----> " + b + ",\r\nPosición ordinal dentro del enum " + b.ordinal() + "\r\nCampos de cada constante(objeto) del enum: \r\nID: " + 
				b.id + " -- NAME: " + b.name + " -- SURNAME: " + b.surname + " \r\n");	
		}	
	}

