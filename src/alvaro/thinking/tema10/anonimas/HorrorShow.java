package alvaro.thinking.tema10.anonimas;

/* Modify interfaces/HorrorShow.java to implement DangerousMonster and
* Vampire using anonymous classes.
*/


/****************** INTERFACES **********************/
interface Monster { void amenaza(int i); }	

interface DangerousMonster extends Monster { void destruye(); }	

interface Lethal { void mata(); }

interface Vampire extends DangerousMonster, Lethal { void bebeSangre(); }

/****************** IMPLEMENTACIONES **********************/

class DragonZilla implements DangerousMonster {
	public void amenaza(int i) {}
	public void destruye() {}
}

class VeryBadVampire implements Vampire {
	public void amenaza(int i) {}
	public void destruye() {}
	public void mata() {}
	public void bebeSangre() {} 
}


public class HorrorShow {
	static void u(Monster b) { b.amenaza(1); }
	
	static void v(DangerousMonster d) {
		d.amenaza(2);
		d.destruye();
	}
	
	static void w(Lethal l) { l.mata(); }
	
	public DangerousMonster monsterMaker() { //Fabrica Dangerous Monsters anonimos.
		return new DangerousMonster() {
			public void amenaza(int i) { System.out.println("DangerousMonster amenaza" + i); }
			public void destruye() { System.out.println("DangerousMonster destruye"); }
		};
	}
	
	public Vampire vampireMaker() { //Fabrica Vampiros anónimos.
		return new Vampire() {
			public void amenaza(int i) { System.out.println("Vampire amenaza" +i); }
			public void destruye() { System.out.println("Vampire destruye"); }
			public void mata() { System.out.println("Vampire mata"); }
			public void bebeSangre() { System.out.println("Vampire bebeSangre"); }
		};
	}		
	
	public static void main(String[] args) {
		HorrorShow horrorShow = new HorrorShow();
		horrorShow.u(horrorShow.monsterMaker()); //1.método que recibe el interface base MONSTER como parametro y ejecuta amenaza().
		
		horrorShow.v(horrorShow.monsterMaker()); //2.método que recibe el interface MONSTERdANGEROUS como parametro y ejecuta amenaza() y destruye().
		
		horrorShow.u(horrorShow.vampireMaker()); //1.método que recibe el interface base MONSTER como parametro y ejecuta amenaza().
		horrorShow.v(horrorShow.vampireMaker()); //2.método que recibe el interface MONSTERdANGEROUS como parametro y ejecuta amenaza() y destruye().
		horrorShow.w(horrorShow.vampireMaker()); //3.método que recibe el interface LETHAL como parametro y ejecuta amenaza() y destruye().
	}
}