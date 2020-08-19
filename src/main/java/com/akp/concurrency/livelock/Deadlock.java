package com.akp.concurrency.livelock;

public class Deadlock {
    private final Object object1 = new Object();
    private final Object object2 = new Object();

    public void methodOne() {
        synchronized (object1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object2) {
                System.out.println("Method one");
            }
        }
    }

    public void methodTwo() {
        synchronized (object2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object1) {
                System.out.println("Method two");
            }
        }
    }
}
