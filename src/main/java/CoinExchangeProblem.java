
public class CoinExchangeProblem {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		System.out.println(count(arr, m, 8));
		System.out.println("Total no of times : " + i);
	}

	static int i = 0;

	private static int count(int S[], int m, int n) {
		i++;
		// If n is 0 then there is only 1 solution(do not include any coin)
		if (n == 0) {
			return 1;
		}

		// If n is less than 0 then there is no solution exists
		if (n < 0) {
			return 0;
		}

		// If there are no coins and n is greater than 0 then no solution exists
		if (m <= 0 && n >= 1) {
			return 0;
		}

		return count(S, m - 1, n) + count(S, m, n - S[m - 1]);

	}
}
