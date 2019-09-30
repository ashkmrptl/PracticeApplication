package com.akp.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		CountDownLatch countDownLatch = new CountDownLatch(4);
		Thread t1 = new Thread(new MyThread(countDownLatch, 1000L));
		Thread t2 = new Thread(new MyThread(countDownLatch, 2000L));
		Thread t3 = new Thread(new MyThread(countDownLatch, 3000L));
		Thread t4 = new Thread(new MyThread(countDownLatch, 4000L));

		executorService.submit(t1);
		executorService.submit(t2);
		executorService.submit(t3);
		executorService.execute(t4);

		System.out.println("Going to wait for latch to complete");
		countDownLatch.await();
		System.out.println("Waiting completed as count came to zero");

		executorService.shutdown();
	}
}

class MyThread implements Runnable {
	private CountDownLatch countDownLatch;
	private long secs = 0L;

	public MyThread(CountDownLatch countDownLatch, Long secs) {
		this.countDownLatch = countDownLatch;
		this.secs = secs;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(secs);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+" -- Thread sleep completed");
		countDownLatch.countDown();
	}
}
