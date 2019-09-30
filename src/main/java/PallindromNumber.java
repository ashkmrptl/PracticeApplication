
public class PallindromNumber {
	static boolean isPallindromNumber(int n) {
		boolean flag = false;
		int temp = n, r, sum = 0;
		while (n > 0) {
			r = n % 10;
			System.out.println("r : " + r);
			sum = (sum * 10) + r;
			System.out.println("sum : " + sum);
			n = n / 10;
			System.out.println("n : " + n);
		}
		if (temp == sum) {
			flag = true;
		}
		return flag;
	}

	static boolean isPallindromString(String str) {
		char[] arr = str.toCharArray();
		String revStr = "";
		for (int i = arr.length - 1; i >= 0; i--) {
			revStr = revStr + arr[i];
		}
		if (str.equals(revStr)) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println("is 123 pallindrom : " + isPallindromNumber(123));
		System.out.println("is 232 pallindrom : " + isPallindromNumber(232));

		System.out.println("is akp pallindrom : " + isPallindromString("akp"));
		System.out.println("is bkb pallindrom : " + isPallindromString("bkb"));
	}
}
