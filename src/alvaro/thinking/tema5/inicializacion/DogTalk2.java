package alvaro.thinking.tema5.inicializacion;


public class DogTalk2 {
	public static void main(String[] args) {
		
		class Dog {
			void bark() {System.out.println("quiet");}
			void bark(char c) {System.out.println("cawcaw");}
			void bark(byte b) {System.out.println("barkbark");}
			void bark(short s) {System.out.println("slurpslurp");}
			void bark(int i) {System.out.println("iyow");}
			void bark(long L) {System.out.println("lalala");}
			void bark(float f) {System.out.println("fififoofum");}
			void bark(double d) {System.out.println("dodo");}
			void bark(char c, int i) {System.out.println("caw-iyow");}
			void bark(int i, char c) {System.out.println("iyow-caw");}
		} 	
		
		Dog d = new Dog();
		char c = 'c';
		byte b = 0;
		short s = 0;
		d.bark();
		d.bark((char)c);
		d.bark((byte)b);
		d.bark((short)s);
		d.bark(1);
		d.bark(1L);
		d.bark(1.0f);
		d.bark(1.0);
		//con 2 argumentos.
		d.bark(c, 1);
		d.bark(1, c);
	}
}