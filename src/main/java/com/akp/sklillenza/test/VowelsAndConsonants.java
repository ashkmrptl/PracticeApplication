package com.akp.sklillenza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VowelsAndConsonants {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			String s = br.readLine();
			countSubSequences(s);
		}
		br.close();
	}

	private static void countSubSequences(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			boolean consonantFlag = true;
			if (isConsonant(s.charAt(i))) {
				consonantFlag = false;
			} else {
				consonantFlag = true;
			}

			for (int j = i + 1; j < s.length(); j++) {
				if (consonantFlag) {
					if (isVowel(s.charAt(j))) {
						break;
					} else {
						count++;
						consonantFlag = false;
					}
				} else {
					if (isConsonant(s.charAt(j))) {
						break;
					} else {
						count++;
						consonantFlag = true;
					}
				}
			}
		}
		System.out.println(count);
	}

	private static boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	private static boolean isConsonant(char c) {
		return !(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
}
