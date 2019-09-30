package com.akp.gfg.practice.mathandalgos;

import java.util.HashSet;
import java.util.Set;

public class PallindromicSubstring {
	public static void findAllPallindromicSubString(String string) {
		// Set to store unique palindromic String
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < string.length(); i++) {
			// Finding all odd length pallindrome with string[i] as mid point
			expand(string, i, i, set);
			
			//find all even length pallindrome with string[i] and string[i+1] as mid point
			expand(string,i, i+1, set)	;
		}
		System.out.println("Set : "+set);
	}

	private static void expand(String str, int low, int high, Set<String> set) {
		while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
			set.add(str.substring(low, high + 1));

			// Expanding in both the direction
			low--;
			high++;
		}
	}
	
	public static void main(String[] args) {
		String string = "abcba";
		findAllPallindromicSubString(string);		
	}
}
