package com.akp.sklillenza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallWindowInString {
	static final int no_of_chars = 256;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(findSubString(br.readLine(), br.readLine()));
		br.close();
	}

	static String findSubString(String str, String txt) {
		int strLength = str.length();
		int txtLength = txt.length();

		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE;
		int hash_txt[] = new int[no_of_chars];
		int hash_str[] = new int[no_of_chars];

		if (strLength < txtLength) {
			return "-1";
		}

		for (int i = 0; i < txtLength; i++)
			hash_txt[txt.charAt(i)]++;

		int count = 0; // count of characters
		for (int j = 0; j < strLength; j++) {
			hash_str[str.charAt(j)]++;

			if (hash_txt[str.charAt(j)] != 0 && hash_str[str.charAt(j)] <= hash_txt[str.charAt(j)])
				count++;

			if (count == txtLength) {
				while (hash_str[str.charAt(start)] > hash_txt[str.charAt(start)] || hash_txt[str.charAt(start)] == 0) {

					if (hash_str[str.charAt(start)] > hash_txt[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}

				int len_window = j - start + 1;
				if (min_len > len_window) {
					min_len = len_window;
					start_index = start;
				}
			}
		}

		if (start_index == -1) {
			return "-1";
		}
		return str.substring(start_index, start_index + min_len);
	}
}
