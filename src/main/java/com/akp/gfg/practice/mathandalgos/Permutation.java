package com.akp.gfg.practice.mathandalgos;

import java.util.Scanner;

/*
 * Permutation P(n, r) = n! * (n-r)!
 */
public class Permutation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			String temp = s.nextLine();
			System.out.println("temp : " + temp);
			if (temp.isEmpty()) {
				i = -1;
				continue;
			}
			int n = Integer.parseInt(temp.split(" ")[0]);
			int r = Integer.parseInt(temp.split(" ")[1]);
			System.out.println(getPermutation(n, r));
		}
		s.close();
	}

	private static long getPermutation(int n, int r) {
		long nFacto = getFactorial(n);
		long nMinusRFacto = getFactorial(n - r);
		System.out.println("nFacto : " + nFacto + " nMinusRFacto : " + nMinusRFacto);
		return nFacto / nMinusRFacto;
	}

	private static long getFactorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * getFactorial(n - 1);
		}
	}
}
