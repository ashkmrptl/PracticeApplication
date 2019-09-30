package com.akp.gfg.practice.mathandalgos;

import java.util.Scanner;

public class SumOfDigitIsPallindrome {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < scanner.nextInt(); i++) {
			int n = scanner.nextInt();
			int sum = 0;
			while (n > 0) {
				sum = (int) (sum + Math.pow((n % 10), 3));
				n = n / 10;
			}
			if (isNumberPallindrome(123)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		scanner.close();

	}

	private static boolean isNumberPallindrome(int num) {
		int temp = num;
		int oppNo = 0;
		while (num > 0) {
			oppNo = ((num % 10) + (oppNo * 10));
			System.out.println("oppNo : " + oppNo);
			num = num / 10;
		}
		if (temp == oppNo) {
			return true;
		} else {
			return false;
		}
	}
}
