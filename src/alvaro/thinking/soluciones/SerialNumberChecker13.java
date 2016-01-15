// concurrency/SerialNumberChecker13.java
// TIJ4 Chapter Concurrency, Exercise 13, page 1167
// Repair SerialNumberChecker.java using the synchronized keyword.
// Can you demonstrate that it is now correct?
// { Args: 10 }

/* My solution to one of the exercises in 
* Thinking in Java 4th Edition (by Bruce Eckel).
* It compiles and runs correctly using JDK 1.6.0
* @author Greg Gordon
* @author www.greggordon.org
* May, 2009
*/


/** In same package:
* public class SerialNumberGenerator13 {	
*	private static volatile int serialNumber = 0;
*	public static synchronized int nextSerialNumber() { // synchronized!
*		return serialNumber++; // Not thread-safe
*	}	
* }
**/

import java.util.concurrent.*;

// Reuses storage so we don't run out of memory:
class CircularSet {
	private int[] array;
	private int len;
	private int index = 0;
	public CircularSet(int size) {
		array = new int[size];
		len = size;
		// Initialize to a value not produced
		// by the SerialNumberGenerator:
		for(int i = 0; i < size; i++)
			array[i] = -1;
	}
	public synchronized void add(int i) {
		array[index] = i;
		// Wrap index and write over old elements:
		index = ++index % len;
	}
	public synchronized boolean contains(int val) {
		for(int i = 0; i < len; i++)
			if(array[i] == val) return true;
		return false;
	}
}

public class SerialNumberChecker13 {	
	private static final int SIZE = 10;
	private static CircularSet serials = new CircularSet(1000);
	private static ExecutorService exec = Executors.newCachedThreadPool();
	static class SerialChecker13 implements Runnable {
		public void run() {
			while(true) {
				int serial = SerialNumberGenerator13.nextSerialNumber();
				if(serials.contains(serial)) {
					System.out.println("Duplicate: " + serial);
					System.exit(0);
				}
				serials.add(serial);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		for(int i = 0; i < SIZE; i++)
			exec.execute(new SerialChecker13());
		// Stop after n seconds if there's an argument:
		if(args.length > 0) {
			TimeUnit.SECONDS.sleep(new Integer(args[0]));
			System.out.println("No duplicates detected");
			System.exit(0);
		}
	}	
}