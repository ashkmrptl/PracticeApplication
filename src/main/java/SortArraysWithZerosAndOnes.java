

import java.util.Arrays;

public class SortArraysWithZerosAndOnes {

	/*
	 * Take two pointers, pointer-1 for elements 0 starting from beginning(index =
	 * 0) and pointer-2 for element 1 starting from end (index = array.length - 1).
	 * It is intended to put 1s to the right side of the array. Once it is done 0
	 * will definitely to the left side of the array.
	 */
	public static void main(String[] args) {
		int[] array = { 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0 };
		sortZerosAndOnes(array);
		Arrays.stream(array).forEach(System.out::println);
	}

	private static void sortZerosAndOnes(int[] array) {
		int pointer1 = 0;
		int pointer2 = array.length - 1;

		while (pointer1 < pointer2) {
			if (array[pointer1] == 1) {
				// Swapping
				array[pointer2] = array[pointer2] + array[pointer1];
				array[pointer1] = array[pointer2] - array[pointer1];
				array[pointer2] = array[pointer2] - array[pointer1];
				pointer2--;
			} else {
				pointer1++;
			}
		}
	}
}
