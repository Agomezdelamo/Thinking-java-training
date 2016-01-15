package alvaro.thinking.tema4.controlandoEjecucion;

public class NumerosPrimos {
	public static void main(String[] args){
		for(int i = 1; i < 1000; i++) {
			int factores = 0;
				/**
				 * los bucles anidados funcionan asi.
				 * mientras la condición del bucle es verdadera no hay un break, en este caso
				 * si entra en el bucle interno, hasta que la condición no sea falsa no sale al externo.
				 */
				for(int j = 1; j < (i + 2)/2; j++ ) {
					if((i % j) == 0) factores++; 			
				}
			
			if(factores < 2) System.out.println(i + " ES PRIMO");
		}
	}
}
