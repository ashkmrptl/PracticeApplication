package com.akp.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 599999; i++) {
			list.add(i);
		}

		// Printing the double of all even numbers
		// Declarative and Functional style(i.e. functional programming)
		list.stream()
			.filter(element -> (element % 2 == 0))
			.map(element -> element * 2)
			.collect(Collectors.toList())
			.forEach(System.out::println);
	}
}
