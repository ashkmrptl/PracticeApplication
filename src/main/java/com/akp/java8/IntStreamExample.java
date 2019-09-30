package com.akp.java8;

import java.util.stream.IntStream;

public class IntStreamExample {
	public static void main(String[] args) {
		System.out.println("Odd Numbers : ");
		printOddNumbers();
		System.out.println("\nPrime Numbers");
		printPrimeNumbers();
	}

	private static void printOddNumbers() {
		IntStream intStream = IntStream.rangeClosed(0, 10);
		intStream.filter(e -> e % 2 != 0).forEach(System.out::print);
	}

	private static void printPrimeNumbers() {

		IntStream intStream = IntStream.rangeClosed(1, 10);
		intStream.filter(e -> (IntStream.rangeClosed(2, e / 2).noneMatch(i -> e % i == 0)) == true).peek(System.out::print)
				.forEach(System.out::print);
		System.out.println();
		IntStream.rangeClosed(1, 0).forEach(System.out::print);
	}
}