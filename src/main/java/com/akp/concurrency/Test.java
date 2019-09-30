package com.akp.concurrency;

public class Test {
	public static void main(String[] args) {
		ProducerConsumer producerConsumer = new ProducerConsumer(5);
		Thread producerThread = new Thread(() -> {
			while (true) {
				producerConsumer.produce();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread consumerThread = new Thread(() -> {
			while (true) {
				producerConsumer.consume();
				try {
					Thread.sleep(6000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		producerThread.start();
		consumerThread.start();
	}
}
