package alvaro.basicos.java.string;

public class StringBasico {
	public static void main(String[] args) {
		
		class ObjectSimple{
			private int campo = 1;
			
			public void print() {System.out.println("mi campo es "+campo);}
		}
		
//		la reasignacion de un string funciona igual que un objeto
		String a = "one";
		ObjectSimple c = new ObjectSimple();
		System.out.println("string ---------> "+a.hashCode());
		System.out.println("objectSimple ---> "+c.hashCode());

		/**
		 * la diferencia es que un string es inmmutable, 
		 * si le cambias el valor generas un nuevo objeto como nos muestra hasCode,
		 * mientras que si a un objeto le cambias una propiedad, no generas un nuevo objeto.
		 */		
		a="jota";
		System.out.println("string ---------> "+a.hashCode()+" ----- ES DISTINTO CADA VEZ QUE DAS UN VALOR A UN STRING HAY UN NUEVO OBJETO");
		c.campo=3;
		System.out.println("objectSimple ---> "+c.hashCode()+"  ----- ES EL MISMO CÓDIGO QUE ANTES PORQUE ES EL MISMO OBJETO" );
	}
}
