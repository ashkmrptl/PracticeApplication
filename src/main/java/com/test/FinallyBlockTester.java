package com.test;

public class FinallyBlockTester {
	private static int value = 1;

	public static void main(String[] args) {
		System.out.println(value);
		int value2 = print();
		System.out.println(value2);
		System.out.println(value);
	}

	private static int print() {
		try {
			return (value = 2);
			//throw new Exception();
		} catch (Exception e) {
			return (value = 4);
		} finally {
			return (value = 4);
		}
	}
}
