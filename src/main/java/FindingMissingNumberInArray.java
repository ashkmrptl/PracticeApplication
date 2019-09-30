import java.util.Arrays;

public class FindingMissingNumberInArray {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 6, 7, 8, 9 };

		int sumUptoN = ((arr[arr.length - 1]) * (arr[arr.length - 1] + 1)) / 2;
		int sum = Arrays.stream(arr).sum();

		System.out.println("missingn number is : " + (sumUptoN - sum));
	}
}
