
public class GCDApp {
	public static void main(String[] args) {
		int n1 = 10, n2 = 30;
		System.out.println("The GCD is : " + findGCD(n1, n2));
	}

	private static int findGCD(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return findGCD(a, a % b);
		}
	}
}
