package com.akp.sklillenza.test;

import java.util.Arrays;
import java.util.Scanner;

public class BurnTheCallories {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int n = 0;
		Long[] allowedMilesArray = null;
		for (int a = 0; a < t; a++) {
			n = scanner.nextInt();

			allowedMilesArray = new Long[n];
			for (int i = 0; i < n; i++) {
				allowedMilesArray[i] = Long.parseLong(scanner.next());
			}

			Arrays.sort(allowedMilesArray);

			System.out.println(calloriesBurnt(allowedMilesArray));
		}
		scanner.close();
	}

	private static Long calloriesBurnt(Long[] array) {
		Long totalCalloriesBurnt = 0L;

		Long i = 0L;

		for (int k = array.length - 1; k >= 0; k--) {
			totalCalloriesBurnt = totalCalloriesBurnt + (2 * i + array[k]);
			i = i + array[k];
		}

		return totalCalloriesBurnt;
	}
	
	
}
