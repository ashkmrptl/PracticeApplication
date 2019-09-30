package com.akp.sklillenza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BinaryMadness {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			BigInteger n = new BigInteger(br.readLine());
			String binaryStr = n.toString(2);
			System.out.println(countSubStringWithOddNoOfOnes(binaryStr));
		}
		br.close();
	}

	private static int countSubStringWithOddNoOfOnes(String binaryStr) {
		int count = 0;
		for (int i = 0; i < binaryStr.length(); i++) {
			for (int j = i + 1; j <= binaryStr.length(); j++) {
				if (binaryStr.substring(i, j).chars().filter(c -> c == '1').count() % 2 != 0) {
					count++;
				}
			}
		}
		return count;
	}

}
