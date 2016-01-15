package alvaro.thinking.tema2.todoEsUnObjeto;

//Write a program that includes and calls the storage() method defined as a
//code fragment in this chapter.

public class MetodoRetorno {
	public static void main(String[] args) {
		/*genero la clase dentro del método static, si actuo fuera y luego la quiero meter dentro la tendria
		 * que transformar en static*/
		class StoreStuff {
			int storage(String s) {
				return s.length() * 2;
			}	
		}
		/*creo el objeto y el puntero*/
		StoreStuff x = new StoreStuff();
		
		/*imprimo el método, que multiplica el total del tamaño de string x 2*/
		System.out.println(x.storage("hi"));		
	}
}
