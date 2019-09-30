package com.akp.compititiveProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Example :
 * array = [8, 7, 2, 5, 3, 1]
 * sum = 10
 * 
 * Output:
 * Pair found at index 0 and 2 (8 + 2)
 * or
 * Pair found at index 1 and 4 (7 + 3)
 */
public class PairWithGivenSum {
	/*
	 * Idea is to sort the array then take first and last element, take the add
	 * value of both, compare with the sum, if add value is less increment first,
	 * else decrement last until sum is found. Iterate till low is less than high.
	 * 
	 * This will take O(nlog(n)) time
	 */
	private static void findPair(int[] array, int sum) {
		int low = 0, high = array.length - 1;
		Arrays.sort(array);
		while (low < high) {
			if ((array[low] + array[high]) == sum) {
				System.out.println("Pair is found : " + array[low] + " and : " + array[high]);
				low++;
				high--;
			} else if ((array[low] + array[high]) < sum) {
				low++;
			} else {
				high--;
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 5, 1, 7, 3, 9, 2, 4 };
		int sum = 10;
		findPair(array, sum);
		findPairUsingHashing(array, sum);
	}

	/*
	 * We can use HashMap to store the elements of the array as key and (sum -
	 * element) in value, before storing we will check if key is already available,
	 * if it is then we found a pair.
	 * 
	 * This will take linear time O(n)
	 */
	private static void findPairUsingHashing(int[] array, int sum) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(sum - array[i])) {
				System.out.println("Pair is found : " + array[i] + " and : " + (sum - array[i]));
				System.out.println("Pair foud at indexes : " + i + " and : " + map.get(array[i]));
			} else {
				map.put(array[i], i);
			}
		}
	}
}
