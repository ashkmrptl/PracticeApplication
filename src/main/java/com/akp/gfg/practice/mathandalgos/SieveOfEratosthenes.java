package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SieveOfEratosthenes {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			printAllPrimeNumbersUptoGivenNumber(n);
			System.out.println();
		}
		br.close();
	}

	private static void printAllPrimeNumbersUptoGivenNumber(int n) {
		// We will create an array of boolean of size n+1 which contains true for prime
		// numbers. Initially all will be true and the value of array[i] will finally be
		// false if i is not a prime.
		boolean[] primes = new boolean[n + 1];

		// Setting all as true
		for (int i = 0; i < primes.length; i++) {
			primes[i] = true;
		}

		for (int p = 2; p * p <= n; p++) {
			if (primes[p] == true) {
				for (int i = p * p; i <= n; i += p) {
					primes[i] = false;
				}
			}
		}
		// Printing all prime numbers
		for (int i = 2; i <= n; i++) {
			if (primes[i] == true) {
				System.out.print(i + " ");
			}
		}
	}
}
