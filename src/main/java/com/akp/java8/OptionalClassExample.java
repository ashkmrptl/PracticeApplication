package com.akp.java8;

import java.util.Optional;

public class OptionalClassExample {
	public static void main(String[] args) {
		// objectCreation();
		checkingValues();
		orElseAndOrElseGetDifference();
	}

	private static void checkingValues() {
		Optional<String> optional = Optional.of("Ashish");
		// Using isPresent()
		System.out.println("is value present : " + optional.isPresent());

		// ifPresent()
		optional.ifPresent(name -> System.out.println(name.length()));

		// Default value with orElse
		// orElse() is used to retrieve value wrapped inside an Optional instance
		// orElse() sets default value, if the value inside Optional is null then
		// default value is returned, else the value wrapped inside it is returned
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElse("Patel");
		System.out.println("name : " + name);

		// orElseget() is similar to orElse() but instead of taking value to return is
		// the Optional value is not present, it takes a Supplier functional interface
		// which is invoked and the result of invocation is returned
		String orElsegetName = Optional.ofNullable(nullName).orElseGet(() -> "ashish");
		System.out.println("orElsegetName : " + orElsegetName);

		// orElseThrow() unlike orElse() and orElseget() throws an exception when value
		// is not available
		//String returnStr = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
		//System.out.println("returnStr : " + returnStr);

		Optional<String> opt = Optional.ofNullable(nullName);
		System.out.println("value : " + opt.get());
	}

	private static void orElseAndOrElseGetDifference() {
		// Another difference of orElse() and orElseGet() is, orElse() set default value
		// even if the Optional has value, but orElseGet() doesn't do that
		String str1 = null;
		Optional.ofNullable(str1).orElse(getDefaultValue());
		Optional.ofNullable(str1).orElseGet(OptionalClassExample::getDefaultValue);

		String str2 = "text";
		Optional.ofNullable(str2).orElse(getDefaultValue());
		Optional.ofNullable(str2).orElseGet(OptionalClassExample::getDefaultValue);
	}

	private static String getDefaultValue() {
		System.out.println("get default called");
		return "default";
	}

	private static void objectCreation() {
		// Creating empty Optional object
		Optional<String> empty = Optional.empty();
		// isPresent() is used to check if there is a value inside optional object
		System.out.println("empty.isPresent() : " + empty.isPresent());

		// Creating Optional object using static method of()
		String name = "Ashish";
		Optional<String> optional = Optional.of(name);
		System.out.println("is present : " + optional.isPresent());
		System.out.println("value : " + optional.get());
		System.out.println(optional);
		// The value passed to the of() method can not be null, else it throws
		// NullPointerException
		// optional = Optional.of(null);

		// When we expect some null values then we can use ofNullable()
		String str = "Kumar";
		Optional<String> opt = Optional.ofNullable(str);
		System.out.println(opt);
		// Using ofNnullable() we can send null value, in that case empty Optional class
		// is instantiated
		// and it doesn't throw NullPointerException
		opt = Optional.ofNullable(null);
		System.out.println(opt);
	}
}
