package com.akp.concurrency;

import com.akp.concurrency.livelock.Criminal;
import com.akp.concurrency.livelock.Deadlock;
import com.akp.concurrency.livelock.Police;

public class DeadLocktester {
	public static void main(String[] args) {
		DeadLocktester tester = new DeadLocktester();
		//tester.testLiveLock();
		tester.testDeadLock();
	}

	private void testLiveLock() {
		Police police = new Police();
		Criminal criminal = new Criminal();

		Thread policeThread = new Thread(() -> {
			police.sendRanson(criminal);
		});
		policeThread.start();

		Thread criminalThread = new Thread(() -> {
			criminal.releaseHostage(police);
		});
		criminalThread.start();

	}
	
	private void testDeadLock() {
		Deadlock deadLock = new Deadlock();
		Thread threadOne = new Thread(() -> {
			deadLock.methodOne();
		});
		threadOne.start();
		
		Thread threadTwo = new Thread(() -> {
			deadLock.methodTwo();
		});
		threadTwo.start();
	}
}
