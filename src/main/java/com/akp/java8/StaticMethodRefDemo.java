package com.akp.java8;

public class StaticMethodRefDemo {
	public boolean numCheck(IntPredicate intPredicate, int n) {
		return intPredicate.check(n);
	}

	public static void main(String[] args) {
		StaticMethodRefDemo demo = new StaticMethodRefDemo();

		boolean result;
		int num = 9;

		// Using Lambda expression to check if a number is even
		IntPredicate intPredicate = number -> (number % 2) == 0;
		result = demo.numCheck(intPredicate, num);
		System.out.println("Using lambda to check if number " + num + " is even. Result : " + result);

		// Using method reference to a static method to check if the number is even
		result = demo.numCheck(IntPredicateChecker::isEven, num);
		System.out.println("Using static method reference to check if number " + num + " is even. Result : " + result);

		// Using Lambda Expression to check is number is positive
		IntPredicate intPredicate2 = number -> (number > 0);
		result = demo.numCheck(intPredicate2, num);
		System.out.println("Using lambda to check if number " + num + " is positive. Result : " + result);
		
		//Using static method reference to check is number is positive
		result = demo.numCheck(IntPredicateChecker::isPositive, num);
		System.out.println("Using static method reference to check if number " + num + " is positive. Result : " + result);
	}
}
