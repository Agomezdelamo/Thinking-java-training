package alvaro.basicos.java.patrones;

//TIJ4 Chapter Interfaces, Exercise 11, page 324

/**
 * Crear una clase con un metodo que tome como argumento un String y produzca un resultado
 * que intercambie cada par de caracteres en el argumento.
 * 
 * Adapta la clase para que funcione con interfaceprocessor.Aply.process()
 * 
 */

interface Procesador {
	String name();
	Object procesar(Object input);
}

class MezcladorString {
	/**
	 * Este método invierte el orden de cada dos letras
	 * @param s String
	 * @return String
	 */
	static String proceso(String s) {
		char[] ca = new char[s.length()];
		if((s.length())%2 == 0) {
			for(int i = 0; i < s.length(); i += 2) {
				ca[i] = s.charAt(i + 1);
				ca[i + 1] = s.charAt(i);			
			}		
			return new String(ca);
		}
		else {
		for(int i = 0; i < s.length() - 1; i += 2) {
				ca[i] = s.charAt(i + 1);
				ca[i + 1] = s.charAt(i);			
			}
			ca[s.length() - 1] = s.charAt(s.length() - 1);		
			return new String(ca);
		}
	}	
}

class AdaptadorStringMezclados implements Procesador {
	public String name() { return "StringMixerAdapter"; }
	MezcladorString mezcladorString;
	public AdaptadorStringMezclados(MezcladorString mezcladorString) {
		this.mezcladorString = mezcladorString;
	}
	public String procesar(Object input) {
		return mezcladorString.proceso((String)input);
	}	
}

/**
 * Esto es un patrón de diseño de adaptacion.
 * 
 * Convierte la interfaz de una clase en otra interfaz que el cliente espera.
 * Adapter permite a las clases trabajar juntas, lo que de otra manera no podría
 * hacerlo debido a sus interfaces incompatibles.
 * 
 * usar el patrón Adapter cuando:
 * Se desea usar una clase existente, y su interfaz no se iguala con la necesitada.
 * 
 * uando se desea crear una clase reusable que coopera con clases no relacionadas,
 * es decir, las clases no tienen necesariamente interfaces compatibles.
 * @author agomez
 */
class Apply {
	public static void procesando(Procesador p, Object o) {
		System.out.println("usando procesador " + p.name());
		System.out.println(p.procesar(o));
	}
}

public class PatronAdapter {
	public static void main(String[] args) {
		String s = new String("primero");
		Apply.procesando(new AdaptadorStringMezclados(new MezcladorString()), s);
	}
}