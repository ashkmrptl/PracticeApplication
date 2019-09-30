package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfAllPrimesUptoN {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(findSumOfPrimes(n));
		}
		br.close();
	}

	private static long findSumOfPrimes(int n) {
		long sum = 0;

		boolean[] primes = new boolean[n + 1];

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

		for (int i = 2; i <= n; i++) {
			if (primes[i] == true) {
				sum = sum + i;
			}
		}

		return sum;
	}
}
