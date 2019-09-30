package com.akp.sklillenza.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CandidateCode {
	public static void main(String args[]) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();

		List<Integer> list = null;

		int n = 0;

		for (int a = 0; a < t; a++) {
			n = scanner.nextInt();
			list = new ArrayList<>();
			boolean allNegative = true;

			for (int i = 0; i < n; i++) {
				int tempNo = Integer.parseInt(scanner.next());
				list.add(tempNo);
				if (tempNo >= 0) {
					allNegative = false;
				}
			}

			// getFirstSubArray(list);
			String result = getResult(list, allNegative);

			System.out.println(result != null ? result : "");
		}

		scanner.close();
	}

	private static String getResult(List<Integer> list, boolean allNegative) {

		int firstSum = 0;
		int secondSum = 0;

		Integer startIndexForSecondSum = null;

		StringBuffer firstString = new StringBuffer();
		StringBuffer secondString = new StringBuffer();

		List<Integer> firstSubList = new ArrayList<>();
		List<Integer> secondSubList = new ArrayList<>();

		if (!allNegative) {
			// Calculating first sum
			for (int i = list.size() - 1; i >= 0; i--) {

				if (list.get(i) > 0) {
					firstSum = firstSum + list.get(i);
					firstString.append(list.get(i));
					firstSubList.add(list.get(i));
					i--;
					if (startIndexForSecondSum == null)
						startIndexForSecondSum = i;
				}
			}

			// Calculating second sum
			for (int i = startIndexForSecondSum; i >= 0; i--) {

				if (list.get(i) > 0) {
					secondSum = secondSum + list.get(i);
					secondString.append(list.get(i));
					secondSubList.add(list.get(i));
					i--;
				}
			}
		}

		if (firstSum < secondSum) {
			return secondString.toString();
		} else if (firstSum > secondSum) {
			return firstString.toString();
		} else {
			if (allNegative) {
				return String
						.valueOf(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(0));
			} else {
				int length = firstSubList.size() > secondSubList.size() ? secondSubList.size() : firstSubList.size();
				for (int i = 0; i < length; i++) {
					if (firstSubList.get(i) > secondSubList.get(i)) {
						return firstString.toString();
					} else if (firstSubList.get(i) < secondSubList.get(i)) {
						return secondString.toString();
					}
				}
			}
		}
		return null;
	}
}
