package com.akp.concurrency;

import java.util.concurrent.*;

/**
 * A future represents the pending result od an asynchronous computation. It offers a method get() that results of the computation nce its done.
 * The problem is that calling to get() will cause the current tread to wait until the computation is done.
 */
public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //callableExample();

        runnableExample();

    }

    private static void runnableExample() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable evenRunnable = () -> {
            for (int i = 1; i < 11; i++) {
                try {
                    Thread.sleep(4000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i % 2 == 0) {
                    System.out.println(i + " -> even");
                }
            }
        };

        Runnable oddRunnable = () -> {
            for (int i = 1; i < 11; i++) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i % 2 != 0) {
                    System.out.println(i + " -> odd");
                }
            }
        };

        Future<?> evenFuture = executorService.submit(evenRunnable);

        Future<?> oddFuture = executorService.submit(oddRunnable);

        System.out.println("evenStr : " + evenFuture.get());

        System.out.println("oddStr : " + oddFuture.get());

        executorService.shutdownNow();
    }

    private static void callableExample() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> evenCallable = () -> {
            for (int i = 1; i < 11; i++) {
                Thread.sleep(4000L);
                if (i % 2 == 0) {
                    System.out.println(i + " -> even");
                }
            }
            return "even printer ended";
        };

        Callable<String> oddCallable = () -> {
            for (int i = 1; i < 11; i++) {
                Thread.sleep(1000L);
                if (i % 2 != 0) {
                    System.out.println(i + " -> odd");
                }
            }
            return "odd printer ended";
        };

        Future<String> evenFuture = executorService.submit(evenCallable);

        Future<String> oddFuture = executorService.submit(oddCallable);

        String evenStr = evenFuture.get();

        System.out.println("evenStr : " + evenStr);

        String oddStr = oddFuture.get();

        System.out.println("oddStr : " + oddStr);

        executorService.shutdownNow();
    }
}
