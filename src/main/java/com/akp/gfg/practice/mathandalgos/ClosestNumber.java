package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClosestNumber {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] arr = br.readLine().split("\\s+");

			int n = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);

			int q = n / m;

			int n1 = m * q;

			int n2 = (n * m) > 0 ? (m * (q + 1)) : (m * (q - 1));

			if (Math.abs(n - n1) < Math.abs(n - n2)) {
				System.out.println(n1);
			} else {
				System.out.println(n2);
			}
		}

	}
}
