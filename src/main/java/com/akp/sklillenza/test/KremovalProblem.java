package com.akp.sklillenza.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class KremovalProblem {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String line1 = s.nextLine();
		String line2 = s.nextLine();

		// int n = Integer.parseInt(line1.split(" ")[0]);
		int k = Integer.parseInt(line1.split(" ")[1]);

		List<Integer> list = Arrays.stream(line2.split(" ")).mapToInt(e -> Integer.parseInt(e)).sorted().boxed()
				.collect(Collectors.toList());

		System.out.println(getMaximum(list, k));
		s.close();
	}

	private static int getMaximum(List<Integer> list, int k) {

		boolean flag = true;

		int sum = 0;

		Set<Integer> set = new HashSet<>();
		for (int j = 0; j < list.size(); j++) {
			sum = 0;
			for (int i = 0; i <= list.size() - (k + 1); i++) {
				System.out.println("get(" + i + ") : " + list.get(i));
				sum += Math.abs(list.get(i) - list.get(i + 1));
				if (i == j) {
					i = j + k;
				}
			}
			flag = true;
			set.add(sum);
		}

		return set.stream().max(Integer::compare).get();
	}

	private static int getMaximum1(int[] array, int k) {
		int[] arrayAfterRemove = new int[array.length - k];
		for (int i = 0, j = 0; i < array.length; i++, j++) {
			arrayAfterRemove[j] = array[i];
			if (i == 0)
				i += k;
		}

		int sum = 0;

		// Calculating Sum
		for (int i = 0; i <= arrayAfterRemove.length - 2; i++) {
			sum = sum + Math.abs(arrayAfterRemove[i] - arrayAfterRemove[i + 1]);
		}

		return sum;
	}
}
