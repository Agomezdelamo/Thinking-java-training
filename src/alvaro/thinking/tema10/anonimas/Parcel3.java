package alvaro.thinking.tema10.anonimas;

public class Parcel3 {
	class Contents {
		private int i = 11;
		public int value() { return i; }
	}
	
	class Destination {
		private String label;
		private Destination(String whereTo) {
			label = whereTo;
		}
		public String readLabel() { return label; }
	}

	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		
		//creamos inner class con puntero al objeto externo y 
		//llamada a new y la clase interna con un punto entremedias.
		Parcel3.Contents c = p.new Contents();
		Parcel3.Destination d = p.new Destination("Tanzania");
		
		System.out.print("la externa tiene un i que vale... "+c.value()+"\n");
		System.out.print("la interna tiene un destino que es... "+d.readLabel());
	}
}