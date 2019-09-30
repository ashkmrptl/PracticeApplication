package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PairsOfPrimeNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine()); // input n

			printLessThanPrimeset(n); // function to find pairs
			System.out.println();
		}
	}

	static boolean isPrime(int n) {
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;

		// This is checked so that we can skip
		// middle five numbers in below loop
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0)
				return false;

		return true;
	}

	static void printLessThanPrimeset(int n) {
		int i = 0, j = 0;
		if (n < 4)
			return;

		for (i = 2; i < n; i++) {
			if (isPrime(i)) // if i is prime the search a j for that i such that j
			// is also prime and i*j<=n
			{
				for (j = 2; j <= n / i; j++) {
					if (isPrime(j)) {
						System.out.print(i + " " + j + " "); // if found print them
					}
				}
			}
		}
		return;
	}
}
