import java.util.HashMap;
import java.util.Map;

public class PairsOfSumInTwoArrays {
	public static void main(String[] args) {
		int[] array1 = { 1, 0, -4, 7, 6, 4 };
		int[] array2 = { 0, 2, 4, -3, 2, 1 };

		int sum = 8;

		findPairs(array1, array2, sum);
	}

	public static void findPairs(int[] array1, int[] array2, int sum) {
		// Insert all elements of array1 in a HashMap
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array1.length; i++) {
			map.put(array1[i], 0);
		}

		// Iterating through second array and
		for (int i = 0; i < array2.length; i++) {
			if (map.containsKey(sum - array2[i])) {
				System.out.println(sum - array2[i] + " " + array2[i]);
			}
		}
	}
}
