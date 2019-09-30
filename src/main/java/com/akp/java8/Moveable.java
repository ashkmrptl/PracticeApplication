package com.akp.java8;

public interface Moveable {
	default void move() {
		System.out.println("moving");
	}
}
