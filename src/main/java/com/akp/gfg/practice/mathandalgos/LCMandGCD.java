package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCMandGCD {
	public static void main(String[] args) throws IOException {
		/* code */
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			// trim removes initial and trailing space from input
			// split extracts values spacewise
			String st[] = read.readLine().trim().split("\\s+");

			// input both numbers
			long a = Long.parseLong(st[0]);
			long b = Long.parseLong(st[1]);

			long hcf = gcd(a, b);
			System.out.println((a * b) / hcf + " " + hcf); // lcm*hcf=a*b formula used here
		}
	}

	// gcd function
	static long gcd(long a, long b) {
		if (a == 0)
			return b;

		return gcd(b % a, a);
	}
}
