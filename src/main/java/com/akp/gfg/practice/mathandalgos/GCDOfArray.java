package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GCDOfArray {
	static int hcf(int a, int b) {
		if (a == 0)
			return b;

		return hcf(b % a, a);
	}

	public static void main(String[] args) throws IOException {
		/* code */
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			// taking n as size of array
			int n = Integer.parseInt(read.readLine());

			// trim removes initial and trailing space from input
			// split extracts values spacewise
			String st[] = read.readLine().trim().split("\\s+");

			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st[i]);

			int gcd = arr[0];

			for (int i = 0; i < n; i++)
				gcd = hcf(gcd, arr[i]); // overall gcd is hcf(gcd, element)

			System.out.println(gcd);
		}
	}
}
