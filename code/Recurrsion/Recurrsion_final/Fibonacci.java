package Recurrsion_final;

public class Fibonacci {
	private static int first = 1;
	private static int second = 1;
	public static int fibonacci(int n) {
		if (n==1) return first;
		else if (n==2) return second;
		else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	public static int[] fibonacci_fast(int n) {
		if (n==2) return new int[]{first, second};
		else {
			int[] prev = fibonacci_fast(n-1);
			return new int[]{prev[1], prev[0] + prev[1]};
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Fibonacci.fibonacci(45));
//		System.out.println(Fibonacci.fibonacci_fast(45)[1]);
	}
}
