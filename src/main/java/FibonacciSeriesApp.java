
public class FibonacciSeriesApp {
	static void fibonacci(int n) {
		int[] series = new int[n + 2];
		series[0] = 0;
		series[1] = 1;

		for (int i = 2; i <= n; i++) {
			series[i] = series[i - 1] + series[i - 2];
		}

		for (int i = 0; i < series.length -1; i++) {
			System.out.print(series[i] + " ");
		}
	}

	static int fib(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	static int fib1(int n) {
		int f[] = new int[n + 2];
		int i;

		f[0] = 0;
		f[1] = 1;

		System.out.print(0 + " " + 1 + " ");
		for (i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
			System.out.print(f[i] + " ");
		}

		return f[n];
	}

	public static void main(String args[]) {
		int n = 9;
		fibonacci(n);
		//fib1(n);
		// System.out.println(fib(n));
	}
}
