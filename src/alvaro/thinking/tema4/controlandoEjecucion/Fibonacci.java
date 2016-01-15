package alvaro.thinking.tema4.controlandoEjecucion;

public class Fibonacci {
	private int initial;
	public Fibonacci(int i){
		this.initial = i;
	}
	int fib(int n) {
		if(n < 2) return 1;
		return (fib(n - 2) + fib(n - 1));
	}
	public static void main(String[] args) {
		Fibonacci f = new Fibonacci(25);
		
		System.out.println("First " + f.initial + " Fibonacci number(s): ");
		for(int i = 0; i < f.initial; i++)
			System.out.println(f.fib(i));
	}	
}