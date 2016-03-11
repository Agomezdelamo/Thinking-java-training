package alvaro.thinking.tema9.interfaces;

//interfaces/Adventure12.java
//TIJ4 Chapter Interfaces, Exercise 12, page 328
/* In Adventure.java, add an interface called CanClimb, following
* the form of the other interfaces.
*/

interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

interface CanClimb {
	void climb();
}

class ActionCharacter {
	public void fight() {System.out.println(this+" can Fight");}
	@Override
	public String toString() { return "Hero"; }
}

class Hero extends ActionCharacter 
		implements CanFight, CanSwim, CanFly {
	public void swim() {System.out.println(this + " can Swim");}
	public void fly() {
		System.out.println(this + " can Fly");
	}	
	@Override
	public String toString() { return "Hero"; }
}

public class Interface3 {
	public static void fight (CanFight x) { x.fight(); }
	public static void swim (CanSwim x) { x.swim(); }
	public static void fly (CanFly x) { x.fly(); }
	public static void climb (CanClimb x) { x.climb(); }	
	public static void fightAction (ActionCharacter x) { x.fight(); }
	public static void main(String[] args) {
		Hero h = new Hero();
		fight(h); // Hero CanFight
		swim(h); // Hero CanSwim
		fly(h); // Hero CanFly
		//climb(h); // Hero don´t CanClimb
		fightAction(h); // Hero upcasting ActionCharacter can fight
	}
}