package com.akp.concurrency;

public class ProdConsumerExample {
	volatile int i;

	public static void main(String[] args) {
		new ProdConsumerExample().accCreatorAndDeletor();
	}

	private void accCreatorAndDeletor() {
		Thread creator = new Thread(() -> {
			while (true) {
				System.out.println("Account " + i + " created");
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

		Thread deletor = new Thread(() -> {
			while (true) {
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				System.out.println("Account " + (i++) + " deleted");
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

		creator.start();
		deletor.start();

	}
}
