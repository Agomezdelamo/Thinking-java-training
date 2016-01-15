package alvaro.thinking.tema2.todoEsUnObjeto;

public class ObjetoBasico1 {
	
	public static void main(String[] args) {
		/*genero la clase*/
		class DataOnly {
			int i;
			double d;
			boolean b;
			void show() {
				System.out.println(i);
				System.out.println(d);
				System.out.println(b);	
			}
		}	
		
		/*construyo el objeto con el puntero data de tipo de la clase*/
		DataOnly data = new DataOnly();
		/*asigno valores e imprimo*/
		data.i = 3;
		data.d = 2.71828;
		data.b = false;		
		data.show();
	}
	
}
