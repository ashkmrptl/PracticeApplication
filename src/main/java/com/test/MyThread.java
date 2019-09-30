package com.test;

public class MyThread extends Thread{
	LockTest test;
	public MyThread(LockTest test) {
		this.test = test;
	}
	public void run() {
		test.print();
	}
}
