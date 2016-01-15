package alvaro.thinking.tema10.anonimas;



interface a {
	void print();
};

interface b {
	void print();
};

public class dosInterfacesAnonimo implements a {
	@Override
	public void print() {
		System.out.print("soy el interface a");
	};

	public b tedoyelinterfazB() {
		
		/**
		 * el interfaz b lo de vuelvo porque el metodo admite retorno de clase b
		 * y porque en la clausura creo el objeto y lo devuelvo, de esta forma el metodo
		 * encapsula el interfaz b.
		 */
		
		return new b() {
			@Override
			public void print() {
				System.out.print("soy el interface b");
			}
		};
	};

	public static void main(String[] args) {
		dosInterfacesAnonimo soyAlayA = new dosInterfacesAnonimo();
		soyAlayA.print();
		soyAlayA.tedoyelinterfazB().print();
	}
}
