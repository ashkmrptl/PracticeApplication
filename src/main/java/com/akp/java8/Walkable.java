package com.akp.java8;

public interface Walkable {
	default void move() {
		System.out.println("I am walking");
	}
}
