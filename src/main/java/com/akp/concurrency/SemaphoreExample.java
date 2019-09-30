package com.akp.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/*
 * Semaphore can be used to limit the no of concurrent threads accessing a specific resource
 */
public class SemaphoreExample {

	// In this example I will implement a simple login queue to limit no of users in
	// the system
	private Semaphore semaphore;

	public SemaphoreExample(int limits) {
		this.semaphore = new Semaphore(limits);
	}

	private boolean tryLogin() {
		// tryAcquire() returns true if a permit is available immediately and acquire
		// it, otherwise return false, but acquire() acquires a permit and blocking
		// until one is available
		return semaphore.tryAcquire();
	}

	private void logout() {
		// release() releases a permit
		semaphore.release();
	}

	private int availableSlots() {
		// return the no of current permits available
		return semaphore.availablePermits();
	}

	public static void main(String[] args) {
		int limits = 4;
		SemaphoreExample ex = new SemaphoreExample(limits);

		ExecutorService executorService = Executors.newCachedThreadPool();
		IntStream.range(0, 10).forEach(user -> executorService.execute(() -> {
			System.out.println(Thread.currentThread().getName() + " execution started");
			ex.tryLogin();
			try {
				Thread.sleep(10 * 1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("no of available limits before : " + ex.availableSlots() + " from thread : "
					+ Thread.currentThread().getName());
			ex.logout();
			System.out.println("no of available limits after : " + ex.availableSlots() + " from thread : "
					+ Thread.currentThread().getName());
			System.out.println(Thread.currentThread().getName() + " execution completed");
		}));
		executorService.shutdown();
		
	}
}
