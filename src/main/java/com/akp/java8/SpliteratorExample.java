package com.akp.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("ashish");
		list.add("kumar");
		list.add("patel");
		
		Spliterator<String> spliterator = list.spliterator();
		spliterator.forEachRemaining(System.out::println);
	}
}
