import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairsOfSumInArray {
	public static void main(String[] args) {
		int[] array = { 5, 7, 9, 13, 11, 6, 6, 3, 3 };
		int sum = 12;

		findPairUsingMap(array, sum);
		System.out.println("---------------------------");
		findPairUsingSet(array, sum);
		System.out.println("No of distinct pairs of sum : ");
		System.out.println(countDistinctPairsOfSum(array, sum));
	}

	private static void findPairUsingMap(int[] array, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < array.length; i++) {
			if (map.containsKey(array[i])) {
				System.out.println(map.get(array[i]) + "  " + array[i]);
			} else {
				map.put(sum - array[i], array[i]);
			}
		}
	}

	private static void findPairUsingSet(int[] array, int sum) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			if (set.contains(array[i])) {
				System.out.println((sum - array[i]) + "  " + array[i]);
			} else {
				set.add(sum - array[i]);
			}
		}
	}

	private static int countDistinctPairsOfSum(int[] array, int sum) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		int count = 0;

		for (int i = 0; i < array.length; i++) {
			int value = array[i];
			int diff = sum - value;

			if (frequencyMap.containsKey(diff)) {
				int freq = frequencyMap.get(diff) - 1;
				count++;

				if (freq == 0) {
					frequencyMap.remove(diff);
				} else {
					frequencyMap.put(diff, freq);
				}
			} else {
				if (frequencyMap.containsKey(value)) {
					frequencyMap.put(value, frequencyMap.get(value) + 1);
				} else {
					frequencyMap.put(value, 1);
				}
			}
			System.out.println("item : " + value + " diff : " + diff + " map : " + frequencyMap);
		}
		return count;
	}
}