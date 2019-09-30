package com.akp.sklillenza.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchEngineQueryProblem2 {
	static Map<String, Integer> resultMap = new HashMap<String, Integer>();
	static Map<String, Integer> sortedMap = null;
	static Set<String> set = null;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			for (int j = 0; j <= n; j++) {
				String str = scanner.nextLine();
				if (!str.isEmpty() && !str.contains("top")) {
					Integer existingCount = resultMap.put(str, 1);
					if (existingCount != null) {
						existingCount = existingCount + 1;
						resultMap.put(str, existingCount);
					}
					// System.out.println("map after add : " + resultMap);
				}

				if (str.contains("top")) {
					int no = Integer.parseInt(str.split(" ")[1]);
					// Printing result
					sortedMap = resultMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
							.sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors
									.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

					// System.out.println("sorted map : " + sortedMap);

					set = sortedMap.keySet();
					int temp = 0;
					for (String string : set) {
						if (temp >= no) {
							break;
						}
						temp++;
						System.out.print(string + " ");
					}

					System.out.println();
				}
			}
			resultMap = new HashMap<String, Integer>();
		}
		scanner.close();
	}
}
