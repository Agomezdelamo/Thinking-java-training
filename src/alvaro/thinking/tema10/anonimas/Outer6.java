package alvaro.thinking.tema10.anonimas;

//TIJ4 Chapter Innerclasses, Exercise 15, page361
/* Crea una clase con un constructor no predetermiando(con argumentos)
 * y uno predeterminado(sin argumentos).
 * 
 * Crea una segunda clase que tenga un método que retorne
 * una referencia a un objeto de la primera clase.
 * 
 * Crea un objeto en que retornes una clase interna anónima que herede de la primera clase.
 */

class One {
	private String s;
	One(String s) { this.s = s; } 
	public String showS() { return s; }
}

public class Outer6 {
	public One makeOne(String s) {//retorno un objeto One con el constructor no-default
		return new One(s) { };
	}
	
	public static void main(String[] args) {
		Outer6 x = new Outer6();
		System.out.println(x.makeOne("hi").showS());
	}
}