package com.akp.concurrency;

import com.akp.concurrency.livelock.Criminal;
import com.akp.concurrency.livelock.Deadlock;
import com.akp.concurrency.livelock.Police;

public class DeadLockTester {

    public static void main(String[] args) {
        final DeadLockTester tester = new DeadLockTester();
        tester.testLiveLock();
        tester.testDeadLock();
    }

    private void testLiveLock() {
        final Police police = new Police();
        final Criminal criminal = new Criminal();

        final Thread policeThread = new Thread(() -> police.sendRanson(criminal));
        policeThread.start();

        final Thread criminalThread = new Thread(() -> criminal.releaseHostage(police));
        criminalThread.start();

    }

    private void testDeadLock() {
        final Deadlock deadLock = new Deadlock();
        final Thread threadOne = new Thread(deadLock::methodOne);
        threadOne.start();

        final Thread threadTwo = new Thread(deadLock::methodTwo);
        threadTwo.start();
    }
}
