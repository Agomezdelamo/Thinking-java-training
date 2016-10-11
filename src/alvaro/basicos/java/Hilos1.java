package alvaro.basicos.java;

import java.util.Date;

public class Hilos1 {
	public static void main(String[] args) {
		Thread t = new Thread(new Hilo_primero());
		Thread t2 = new Thread(new Hilo_segundo());
		t.start();
		t2.start();
	}
}

class Hilo_primero implements Runnable {
	private int i = 10;
	public void run() {
		while(i > 1) {
			System.out.println("hilo primero --> " + new Date(i,i,i));
			--i;
		}
	}
}

class Hilo_segundo implements Runnable {
	private int i = 30;
	public void run() {
		while(i > 20) {
			System.out.println("hilo segundo --> " + new Date(i,i,i));
			--i;
		}
	}
}