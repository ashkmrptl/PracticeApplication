package com.akp.java8;

public class FunctionalInterfaceTester implements TestFunctionalInterface {

	@Override
	public void printMe(String str) {
		System.out.println("From child class : " + str);
	}

	public static void main(String[] args) {
		FunctionalInterfaceTester tester = new FunctionalInterfaceTester();
		tester.printMe("Ashish Kumar patel");

		// Using Lambda expression
		TestFunctionalInterface testFunctionalInterface = string -> System.out
				.println("From lambda Expression : " + string);
		testFunctionalInterface.printMe("Patel Kumar Ashish");
	}
}
