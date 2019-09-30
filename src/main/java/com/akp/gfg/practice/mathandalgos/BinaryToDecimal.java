package com.akp.gfg.practice.mathandalgos;

import java.util.Scanner;

public class BinaryToDecimal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			long binary = scanner.nextLong();
			System.out.println(getDecimalFromBinary(binary));
		}
		scanner.close();
	}

	private static long getDecimalFromBinary(long binary) {
		long result = 0;
		int base = 1;
		while (binary > 0) {
			result = result + ((binary % 10) * base);
			binary = binary / 10;
			base = base * 2;
		}

		return result;
	}
}
