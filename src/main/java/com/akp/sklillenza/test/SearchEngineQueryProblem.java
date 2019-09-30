package com.akp.sklillenza.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SearchEngineQueryProblem {
	static Map<String, OrderedString> resultMap = new HashMap<String, OrderedString>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scanner.nextInt();
			for (int j = 0; j <= n; j++) {
				String str = scanner.nextLine();
				if (!str.isEmpty() && !str.contains("top")) {
					OrderedString os = new OrderedString(str, 1);
					OrderedString existingOS = resultMap.put(str, os);
					if (existingOS != null) {
						existingOS.setNoOfSearches(existingOS.getNoOfSearches() + 1);
						resultMap.put(str, existingOS);
					}
				}
				if (str.contains("top")) {
					int no = Integer.parseInt(str.split(" ")[1]);
					// Printing result
					List<OrderedString> resultList = new ArrayList<>();
					for (OrderedString orderedString : resultMap.values()) {
						resultList.add(orderedString);
					}
					Comparator<OrderedString> comp = Comparator.comparing(OrderedString::getString);
					Collections.sort(resultList, comp);
					Comparator<OrderedString> comp1 = Comparator.comparing(OrderedString::getNoOfSearches).reversed();
					Collections.sort(resultList, comp1);
					for (int ik = 0; ik < (no > resultList.size() ? resultList.size() : no); ik++) {
						System.out.print(resultList.get(ik).getString() + (ik == n - 1 ? "" : " "));
					}

					System.out.println();
				}
			}
			resultMap = new HashMap<String, OrderedString>();
		}
		scanner.close();
	}
}

class OrderedString implements Comparator<OrderedString> {
	private String string;
	private Integer noOfSearches;

	public OrderedString(String string, Integer noOfSearches) {
		super();
		this.string = string;
		this.noOfSearches = noOfSearches;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Integer getNoOfSearches() {
		return noOfSearches;
	}

	public void setNoOfSearches(Integer noOfSearches) {
		this.noOfSearches = noOfSearches;
	}

	@Override
	public String toString() {
		return "OrderedString [string=" + string + ", noOfSearches=" + noOfSearches + "]";
	}

	@Override
	public int compare(OrderedString o1, OrderedString o2) {
		int res = o1.getNoOfSearches().compareTo(o2.getNoOfSearches());
		if (res == 0) {
			return o1.getString().compareTo(o2.getString());
		} else {
			return res;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((string == null) ? 0 : string.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderedString other = (OrderedString) obj;
		if (string == null) {
			if (other.string != null)
				return false;
		} else if (!string.equals(other.string))
			return false;
		return true;
	}

}
