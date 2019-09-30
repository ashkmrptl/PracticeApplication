package com.test;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	ReentrantLock lock = new ReentrantLock();

	public void print() {
		for (int i = 0; i < 3; i++) {
			lock.lock();
			System.out.println(Thread.currentThread().getName() + " ::  print : " + i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(lock.getHoldCount());
		secondPrint();
	}

	private void secondPrint() {
		for (int i = 3; i < 6; i++) {
			System.out.println(Thread.currentThread().getName() + " :: secondPrint : " + i);
			try {
				Thread.sleep(400);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
		}
		System.out.println(lock.getHoldCount());
	}

	public static void main(String[] args) {
		LockTest test = new LockTest();
		MyThread t1 = new MyThread(test);
		MyThread t2 = new MyThread(test);

		t1.start();
		t2.start();
	}
}
