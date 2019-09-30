package com.akp.gfg.practice.mathandalgos;

import java.util.Scanner;

public class ReverseDigit {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			System.out.println(getNumAfterDigitRev(n));
		}
		s.close();
	}

	private static int getNumAfterDigitRev(int n) {
		int res = 0;
		while (n > 0) {
			res = ((n % 10) + (res * 10));
			n = n / 10;
		}
		return res;
	}
}
