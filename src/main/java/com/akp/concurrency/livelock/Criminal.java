package com.akp.concurrency.livelock;

public class Criminal {
	private boolean hostageReleased = false;

	public void releaseHostage(Police police) {
		while (!police.isMoneySent()) {
			System.out.println("Waiting for the police to send ranson. Thread state : "+Thread.currentThread().getState());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Hostage released");

		hostageReleased = true;
	}

	public boolean isHostageReleased() {
		return this.hostageReleased;
	}
}
