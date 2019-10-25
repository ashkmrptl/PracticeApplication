package com.akp.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * As the get() method of Future makes the current thread to wait until the computation is done by the thread, CompletableFuture is given to overcome tis scenario.
 */
public class CompletableFutureExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        runAsyncExample();

        supplyAsyncExampleWithLambda();

        supplyAsyncExampleWithoutLambda();

        thenApplyExample();
    }

    /**
     * CompletableFuture.get() method is blocking. It waits until the Future is completed and the result is returned after its completion.
     * But using CompletableFuture we can attach call backs which will be performed once the Future is completed asynchronously.
     * <p>
     * It accepts a Function<T,R> as an argument. Function<T,R> is a simple functional interface which takes an argument of type T and
     * returns an argument of type R.
     */
    private static void thenApplyExample() throws ExecutionException, InterruptedException {
        //Creating a CompletableFuture
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "Ashish Kumar Patel";
        }).thenApply(name -> "Hello " + name)
                .thenApply(greeting -> greeting + ". Welcome to My World!");


        //Block and get the result f the Future
        System.out.println(future.get());
    }

    /**
     * If we want to run some background task asynchronously and dn't want to return anything from the task, then we can use CompletableFuture.runAsync() method.
     */
    private static void runAsyncExample() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException ex) {
                throw new IllegalStateException(ex);
            }
            System.out.println("I will run in a separate thread than main thread.");
        });
        //block and wait for the future to complete
        future.get();
    }

    /**
     * if we want to return something from the background task than we can use supplyAsync().
     * suppplyAsync() takes a Supplier<T> and returns CompletableFuture<T> where T is the type f value obtained by calling
     * the given supplier.
     *
     * @return String
     */
    private static void supplyAsyncExampleWithoutLambda() throws ExecutionException, InterruptedException {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException ex) {
                    throw new IllegalStateException(ex);
                }
                return "Result of the asynchronous computation.";
            }
        };

        CompletableFuture<String> future = CompletableFuture.supplyAsync(supplier);

        String msg = future.get();

        System.out.println("message : " + msg);
    }

    private static void supplyAsyncExampleWithLambda() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }

            return "Result of asynchronous computation using lambda";
        });

        String msg = future.get();

        System.out.println("message : " + msg);
    }
}
