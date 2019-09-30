package com.akp.gfg.company.goldmansachs;

import java.util.HashMap;
import java.util.Map;

/*
 * For duplicate elements the no of occurrence should be same
 */
public class CheckingIfTwoArraysAreIdentical {
	public static void main(String[] args) {
		int[] array1 = { 1, 2, 5, 4, 0, 2, 1 };
		int[] array2 = { 2, 4, 5, 0, 1, 0, 2 };

		areArraysSimilar(array1, array2);
	}

	private static void areArraysSimilar(int[] array1, int[] array2) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < array1.length; i++) {
			if (map.containsKey(array1[i])) {
				map.put(array1[i], map.get(array1[i]) + 1);
			} else {
				map.put(array1[i], 1);
			}
		}

		// Traversing second array and checking if all the elements are present same no
		// of times
		for (int i = 0; i < array2.length; i++) {
			// If an element in array2 is not present in array1
			if (!map.containsKey(array2[i])) {
				System.out.println("Arrays are not identical.");
				return;
			}

			// If an element in array2 appears more time than it is in array1
			if (map.get(array2[i]) == 0) {
				System.out.println("Arrays are not identical.");
				return;
			}

			map.put(array2[i], map.get(array2[i]) - 1);
		}

		System.out.println("Arrays are identical.");
	}
}
