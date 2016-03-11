package alvaro.thinking.tema9.interfaces;

/* Crea un interface y heredaolo en dos nuevos interfaces desde ese.
 * 
 * Multiplica la herencia en un tercer interface desde el segundo.
*/

interface CanDo {
	void doIt();
}

/*heredo interface*/
interface CanDoMore extends CanDo {
	void doMore();
}

/*heredo interface*/
interface CanDoFaster extends CanDo {
	void doFaster();
}

/*heredo interface*/
interface CanDoMost extends CanDoMore, CanDoFaster {
	void doMost();
}

class Doer implements CanDoMost {
	public void doIt() { System.out.println("CanDo interface doIt() method"); }
	public void doMore() { System.out.println("CanDoMore interface doMore() method"); }
	public void doFaster() { System.out.println("CanDoFaster interface doFaster() method"); }
	public void doMost() { System.out.println("CanDoMost hereda: CanDoMore, CandoFaster  interface doMost() method"); }
}

public class HerenciaDiamante {
	public static void main(String[] args) {
		Doer d = new Doer();
		((CanDoMore)d).doMore();
		((CanDoFaster)d).doFaster();
		((CanDo)d).doIt();
	}
}