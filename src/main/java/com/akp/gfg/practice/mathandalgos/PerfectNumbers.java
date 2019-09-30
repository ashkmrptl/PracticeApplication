package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class PerfectNumbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			long n = Long.parseLong(br.readLine());
			System.out.println(calculateSumOfFactors(n) == n ? 1 : 0);
		}

		br.close();
	}

	private static long calculateSumOfFactors(long n) {
		Set<Long> set = new HashSet<>();
		for (long i = 1; i < Math.sqrt(n); i++) {
			if (n % i == 0) {
				set.add(i);
				if (n / i != n) {
					set.add(n / i);
				}
			}
		}
		return set.stream()/* .peek(System.out::println) */.mapToLong(Long::longValue).sum();
	}
}
