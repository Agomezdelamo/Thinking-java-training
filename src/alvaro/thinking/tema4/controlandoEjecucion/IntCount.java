package alvaro.thinking.tema4.controlandoEjecucion;

public class IntCount {
	static void Count1(int n) {
		for(int i = 0; i < n; i++)
			System.out.println(i + 1);
		
	}
	static void Count2(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println(i + 1);
			if(i == 99)
				break;
		}
		System.out.println("Salgo del bucle en el momento que aparece la palabra break pero continuo en el metodo");
	}
	static void Count3(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println(i + 1);
			if(i == 99)
				return;
		}
		System.out.println("return te echa del metodo, por eso este mensaje nunca saldra por consola");
	}
	public static void main(String[] args) {
		Count1(100);	
		Count2(100);
		Count3(100);
	}
}