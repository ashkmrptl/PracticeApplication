package com.akp.concurrency.livelock;

public class Police {
	private boolean ransomSent = false;

	public void sendRanson(Criminal criminal) {
		while (!criminal.isHostageReleased()) {
			System.out.println("Waiting for Criminal to releasae hostage. Thread state : " + Thread.currentThread().getState());

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Ransom sent");
		ransomSent = true;
	}

	public boolean isMoneySent() {
		return ransomSent;
	}
}
