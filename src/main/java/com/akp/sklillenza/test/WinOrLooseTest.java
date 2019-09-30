package com.akp.sklillenza.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WinOrLooseTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		System.out.println("noOfTestCases : " + t);

		Long[] strengthArray = null;
		Long[] energyArray = null;

		int n = 0;

		for (int a = 0; a < t; a++) {
			n = scanner.nextInt();

			strengthArray = new Long[n];
			for (int i = 0; i < n; i++) {
				strengthArray[i] = Long.parseLong(scanner.next());
			}

			energyArray = new Long[n];
			for (int i = 0; i < n; i++) {
				energyArray[i] = Long.parseLong(scanner.next());
			}

			if (getResult(strengthArray, energyArray)) {
				System.out.println("WIN");
			} else {
				System.out.println("LOSE");
			}
		}

		scanner.close();
	}

	private static boolean getResult(Long[] strengthArray, Long[] energyArray) {
		boolean result = true;
		List<Long> sortedStrengthArray = Arrays.stream(strengthArray).sorted().collect(Collectors.toList());

		List<Long> sortedEnergyArray = Arrays.stream(energyArray).sorted().collect(Collectors.toList());

		for (int i = 0; i < sortedEnergyArray.size(); i++) {
			if (sortedEnergyArray.get(i) < sortedStrengthArray.get(i)) {
				result = false;
				break;
			}
		}
		return result;
	}
}
