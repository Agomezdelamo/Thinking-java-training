package alvaro.thinking.tema12.excepciones;

//exceptions/LostMessage18.java
//TIJ4 Chapter Exceptions, Exercise 18, page 479
//Add a second level of exception loss to LostMessage.java so that the
//HoHumException is itself replaced by a third exception.

class ExcepcionMuyImportante extends Exception {
	public String toString() {
		return "Una excepción muy importante!";
	}
}

class ExcepcionMediocre extends Exception {
	public String toString() {
		return "Una excepción mediocre";
	}
}

class ExcepcionInsignificante extends Exception {
	public String toString() {
		return "Una excepción insignificante";
	}
}	

public class ExcepcionPerdida1 {
	void f() throws ExcepcionMuyImportante {
		throw new ExcepcionMuyImportante();
	}
	
	void dispose() throws ExcepcionMediocre {
		throw new ExcepcionMediocre();
	}
	
	void eliminate() throws ExcepcionInsignificante {
		throw new ExcepcionInsignificante();
	}
	
	public static void main(String[] args) {
		try {
			ExcepcionPerdida1 lm = new ExcepcionPerdida1();
			try {
					try {
						lm.f();
						lm.dispose();
					} 
					
					finally {
						lm.eliminate();
					}
			} catch(Exception e) {
				System.out.println(e);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}
