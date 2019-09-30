package com.akp.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AlternateCharFromStrings {
	public static void main(String[] args) {
		String s1 = "aaaaaaa";
		String s2 = "zzzzzzz";

		// new AlternateCharFromStrings().printAlternateCharsUsingReentrantLock(s1, s2);

		// System.out.println("-----------------------------------------------");

		new AlternateCharFromStrings().printAlternateCharsUsingSynchronization(s1, s2);
	}

	private void printAlternateCharsUsingReentrantLock(final String s1, final String s2) {
		final Lock lock = new ReentrantLock();
		Condition condition1 = lock.newCondition();// For String s1
		Condition condition2 = lock.newCondition();// For String s2

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < s1.length(); i++) {
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < s2.length(); i++) {
			}
		});

		t1.start();
		t2.start();
	}

	/*
	 * This method prints characters from String s1 and s2 alternately using
	 * synchronized keyword
	 */
	private void printAlternateCharsUsingSynchronization(final String s1, final String s2) {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < s1.length(); i++) {
				System.out.print(s1.charAt(i));
				synchronized (this) {
					try {
						this.notify();
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < s2.length(); i++) {
				System.out.print(s2.charAt(i));
				synchronized (this) {
					try {
						this.notify();
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t1.start();
		t2.start();

	}
}
