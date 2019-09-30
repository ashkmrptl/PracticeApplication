package com.akp.gfg.company.goldmansachs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringReversalApp {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println("Before swapping : " + str);
		System.out.println("After swapping : " + reverseString(str));
	}

	private static String reverseString(String string) {
		char[] array = string.toCharArray();
		Character temp = null;
		for (int i = 0, j = array.length - 1; i < array.length / 2; i++, j--) {
			temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

		return new String(array);
	}
}
