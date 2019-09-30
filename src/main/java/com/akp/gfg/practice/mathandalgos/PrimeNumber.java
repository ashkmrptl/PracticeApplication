package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			System.out.println(checkPrimeNumber(n));
			System.out.println("----------------------------------------");

			System.out.println("From ver 2 : " + checkPrimeNumberVer2(n));
			System.out.println("----------------------------------------");

			System.out.println("From ver 3 : " + checkPrimeNumberVer3(n));
			System.out.println("----------------------------------------");
		}
		br.close();
	}

	private static String checkPrimeNumber(int n) {
		int count = 0;
		boolean flag = true;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			count++;
			if (n % i == 0) {
				flag = false;
				break;
			}
		}
		System.out.println("count : " + count);
		if (flag) {
			return "Yes";
		} else {
			return "No";
		}
	}

	private static String checkPrimeNumberVer2(int n) {
		int count = 0;
		boolean flag = true;
		for (int i = 2; i * i <= n; i++) {
			count++;
			if (n % i == 0) {
				flag = false;
				break;
			}
		}
		System.out.println("count ver 2 : " + count);
		if (flag) {
			return "Yes";
		} else {
			return "No";
		}
	}

	private static String checkPrimeNumberVer3(int n) {
		int count = 0;
		boolean flag = true;
		if (n <= 1) {
			flag = false;
		}
		if (n <= 3) {
			flag = true;
		}

		if (n % 2 == 0 || n % 3 == 0) {
			flag = false;
		}

		for (int i = 5; i * i < n; i += 6) {
			count++;
			if (n % i == 0 || n % (i + 2) == 0) {
				flag = false;
			}
		}

		System.out.println("count ver 3 : " + count);

		if (flag) {
			return "Yes";
		} else {
			return "No";
		}
	}
}
