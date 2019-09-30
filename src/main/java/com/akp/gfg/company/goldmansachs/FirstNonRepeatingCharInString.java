package com.akp.gfg.company.goldmansachs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharInString {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine();

		System.out.println(string.charAt(firstNonRepeatingChar(string)));
	}

	private static Map<Character, CountIndex> getCharCountMap(String str) {
		Map<Character, CountIndex> hm = new HashMap<Character, CountIndex>();

		for (int i = 0; i < str.length(); i++) {
			if (hm.containsKey(str.charAt(i))) {
				hm.get(str.charAt(i)).incrementCount();
			} else {
				hm.put(str.charAt(i), new CountIndex(i));
			}
			printMap(hm);
			System.out.println("\n---------------------------------------------------------");
		}
		return hm;
	}

	private static int firstNonRepeatingChar(String string) {
		Map<Character, CountIndex> hm = getCharCountMap(string);
		int result = Integer.MAX_VALUE, i;
		for (i = 0; i < string.length(); i++) {
			if (hm.get(string.charAt(i)).count == 1 && result > hm.get(string.charAt(i)).index) {
				result = hm.get(string.charAt(i)).index;
			}
		}

		return result;
	}

	private static void printMap(Map<Character, CountIndex> map) {
		map.entrySet().stream().forEach(entry -> System.out.print("key : " + entry.getKey() + "  count : "
				+ entry.getValue().count + " index : " + entry.getValue().index + "--------"));
	}

	static class CountIndex {
		int count;
		int index;

		public CountIndex(int index) {
			this.count = 1;
			this.index = index;
		}

		public void incrementCount() {
			count++;
		}

		public int getCount() {
			return this.count;
		}
	}
}
