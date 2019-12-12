package com.akp.concurrency;

public class PrintEvenAndOddFromThreadsInSequence {
    public static void main(String[] args) {
        final Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (PrintEvenAndOddFromThreadsInSequence.class) {
                    if (i % 2 != 0) {
                        try {
                            PrintEvenAndOddFromThreadsInSequence.class.notify();
                            System.out.print(i + " ");
                            PrintEvenAndOddFromThreadsInSequence.class.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        final Thread evenThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                synchronized (PrintEvenAndOddFromThreadsInSequence.class) {
                    if (i % 2 == 0) {
                        try {
                            PrintEvenAndOddFromThreadsInSequence.class.notify();
                            System.out.print(i + " ");
                            PrintEvenAndOddFromThreadsInSequence.class.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();

    }
}
