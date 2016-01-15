package alvaro.thinking.tema3.operadores;

public class StringCompare {
	
	/**
	 * método sencillo, recibe un booleano, si es
	 * verdad pinta verdad sino pinta mentira.
	 * @param b booleano
	 */
	static void verdaderoFalso(boolean b) {
		if(b == true) {
			System.out.println(true);
		}
		else { 
			System.out.println(false); 
		}
	}

	static void stringTest(String s, String t) {
		verdaderoFalso(s == t);
		verdaderoFalso(s.equals(t));
		verdaderoFalso(t.equals(s));
		verdaderoFalso(s != t);
		// verdaderoFalso(!s);
		// verdaderoFalso(!t);
		// s = s && t;
		// s = s || t;
		// s = ~t;
		// s = s  & t;
		// s = s | t;
		// s = s ^ t;
		// s &= t;
		// s ^= t;
		// s |= t;
	}	
	
	public static void main(String[] args) {
		String s = "one", t = "two";
		StringCompare.stringTest(s, t);		
	}
	
}
