package com.test;

public class Test {
    private void print() {
        final int[] oddArray = {1, 3, 5, 7, 9};
        final int[] evenArray = {2, 4, 6, 8, 10};

        Thread t1 = new Thread(() -> {
            for (int i : oddArray) {
                synchronized (this) {
                    System.out.println(i);
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.notify();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i : evenArray) {
                synchronized (this) {
                    System.out.println(i);
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.notify();
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.print();
    }
}
