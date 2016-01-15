package alvaro.thinking.tema10.anonimas;

interface Juego { boolean mover(); }
interface FactoriaJuegos { Juego getJuego(); }

	class AssasinsCreed implements Juego {
		private int movimientos = 0;
		private static final int CONSTMOVIMIENTOS = 4;
		public boolean mover(){
			System.out.print("AssasinsCreed--> Paso hacia el enemigo número "+movimientos+" \n");
			return ++movimientos != CONSTMOVIMIENTOS;
		}
		
		public static FactoriaJuegos crearAsassins = new FactoriaJuegos(){
			public Juego getJuego() {return new AssasinsCreed();}
		};
	}
	
	class BlackOps implements Juego {
		private int movimientos = 0;
		private static final int CONSTMOVIMIENTOS = 6;
		public boolean mover(){
			System.out.print("BlackOps--> Paso hacia el enemigo número "+movimientos+" \n");
			return ++movimientos != CONSTMOVIMIENTOS;
		}
		
		public static FactoriaJuegos crearBlackOps = new FactoriaJuegos(){
			public Juego getJuego() {return new BlackOps();}
		};
	}


public class claseInternaFactoria {
	public static void viciarse(FactoriaJuegos pFactoria){
		Juego uno = pFactoria.getJuego();
		while(uno.mover());
	}
	
	public static void main(String args[]){
		viciarse(AssasinsCreed.crearAsassins);
		viciarse(BlackOps.crearBlackOps);
	}
}
