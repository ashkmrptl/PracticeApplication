import java.util.Scanner;

public class ContinuousSubArrayWithGivenSum {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int noOfTestCases = s.nextInt();
		for (int i = 0; i < noOfTestCases; i++) {
			int arraySize = Integer.parseInt(s.next());
			int sum = Integer.parseInt(s.next());

			int[] array = new int[arraySize];
			for (int j = 0; j < arraySize; j++) {
				array[j] = Integer.parseInt(s.next());
			}
			findSubArray(array, sum);
			s.close();
		}
	}

	private static void findSubArray(int[] array, int sum) {
		int tempSum = 0;
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str = "";
			tempSum = 0;
			for (int j = i; j < array.length; j++) {
				tempSum = tempSum + array[j];
				if (tempSum > sum) {
					break;
				} else if (tempSum == sum) {
					str = str + " " + array[j];
					System.out.println(str.trim());
				} else {
					str = str + " " + array[j];
				}
			}
		}
	}
}
