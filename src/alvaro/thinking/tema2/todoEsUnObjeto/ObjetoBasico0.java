package alvaro.thinking.tema2.todoEsUnObjeto;

public class ObjetoBasico0 {
		public static void main(String[] args) {
			class ATypeName {
				int i;
				double d;
				boolean b;
				void show() {
					System.out.println(i);
					System.out.println(d);
					System.out.println(b);	
				}
			}
			
			/**
			 * @category construye
			 * un puntero "a" que apunta a un nuevo objeto
			 * que se crea de la clase ATypeName con
			 * las propiedades de clase que tiene y el método.
			 */
			ATypeName a = new ATypeName();
			a.i = 3;
			a.d = 2.71828;
			a.b = false;		
			a.show();
		}
}
