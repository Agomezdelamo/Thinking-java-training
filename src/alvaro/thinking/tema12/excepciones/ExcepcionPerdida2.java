package alvaro.thinking.tema12.excepciones;

//exceptions/LostMessageFound19.java
//TIJ4 Chapter Exceptions, Exercise 19, page 479
//Repair the problem in LostMessage.java by guarding the call in the
//finally clause.

class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

public class ExcepcionPerdida2 {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}
	void dispose() throws HoHumException {
		throw new HoHumException();
	}
	public static void main(String[] args) {
		try {
			ExcepcionPerdida2 lmf = new ExcepcionPerdida2();
			try {
				lmf.f(); //1. lanzo la importante 
			} catch(Exception e) {
				System.out.println(e);
			} finally {
				lmf.dispose();//2. lanzo la trivial 
			}

		} catch(Exception e) {
			System.out.println(e);
		}
	}
}