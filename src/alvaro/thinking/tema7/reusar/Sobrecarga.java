package alvaro.thinking.tema7.reusar;

/**
 * Crea una clase con un método que este sobrecargado 3 veces.
 * Hereda en una nueva clase y añade otra nueva sobrecarga al método, y muestra los
 * cuatro métodos sobrecargados en la clase derivada.
*/

class ThreeWay {
	void number(byte b) { System.out.println("number sobrecarga 1--> "+b); }
	void number(short s) { System.out.println("number sobrecarga 2--> "+s); }
	void number(int i) { System.out.println("number sobrecarga 3--> "+i); }
}

class Sobrecarga extends ThreeWay {
	void number(float f) { System.out.println("number sobrecarga 4--> "+f); }
	public static void main(String[] args) {
		Sobrecarga ov = new Sobrecarga();
		ov.number((byte)0);
		ov.number((short)1);
		ov.number(2);
		ov.number(3.0f);
	}
}