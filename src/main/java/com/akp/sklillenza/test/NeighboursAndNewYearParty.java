package com.akp.sklillenza.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NeighboursAndNewYearParty {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		int[] array = null;

		int n = 0;

		for (int a = 0; a < t; a++) {
			n = scanner.nextInt();

			array = new int[n];

			boolean allNegative = true;

			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(scanner.next());
				if (array[i] >= 0) {
					allNegative = false;
				}
			}

			System.out.println(getResut(array, allNegative) == null ? "" : getResut(array, allNegative));

		}

		scanner.close();
	}

	private static String getResut(int[] array, boolean allNegative) {
		String result = null;

		Integer evenSum = 0;
		Integer oddSum = 0;

		String evenResult = "";
		String oddResult = "";

		List<Integer> evenList = new ArrayList<>();
		List<Integer> oddList = new ArrayList<>();

		if (allNegative) {
			evenSum = null;
			oddSum = null;
			for (int i = array.length - 1; i >= 0; i--) {
				if (i % 2 == 0) {
					if (evenSum == null) {
						evenSum = array[i];
						evenResult = "" + array[i];
					} else {
						evenSum = evenSum > array[i] ? evenSum : array[i];
						evenResult = "" + array[i];
					}
				} else {
					if (oddSum == null) {
						oddSum = array[i];
						oddResult = "" + array[i];
					} else {
						oddSum = oddSum > array[i] ? oddSum : array[i];
						oddResult = "" + oddSum;
					}
				}
			}
		} else {
			for (int i = array.length - 1; i >= 0; i--) {
				if (array[i] > 0) {
					if (i % 2 == 0) {
						evenSum = evenSum + array[i];
						evenResult = evenResult + array[i];
						evenList.add(array[i]);
					} else {
						oddSum = oddSum + array[i];
						oddResult = oddResult + array[i];
						oddList.add(array[i]);
					}
				}
			}
		}

		// System.out.println(evenSum + " " + oddSum);

		if (evenSum < oddSum) {
			result = oddResult;
		} else if (evenSum > oddSum) {
			result = evenResult;
		} else {
			if (allNegative) {
				result = oddResult;
			} else {
				int length = evenList.size() > oddList.size() ? oddList.size() : evenList.size();
				for (int i = 0; i < length; i++) {
					if (evenList.get(i) > oddList.get(i)) {
						result = evenResult;
						break;
					} else if (evenList.get(i) < oddList.get(i)) {
						result = oddResult;
						break;
					}
				}
			}
		}

		return result;
	}
}
