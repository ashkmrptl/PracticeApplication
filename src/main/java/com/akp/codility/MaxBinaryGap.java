package com.akp.codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxBinaryGap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(findBinaryGap(n));
		}
		br.close();
	}

	private static int findBinaryGap(int n) {
		String binaryStr = Integer.toBinaryString(n);
		int largestGap = 0;
		for (int i = 1, gap = 0; i < binaryStr.length(); i++) {
			while (i < binaryStr.length() && binaryStr.charAt(i) == '0') {
				i++;
				gap++;
			}

			if (gap > largestGap && i < binaryStr.length()) {
				largestGap = gap;
			}

			gap = 0;
		}
		return largestGap;
	}
}
