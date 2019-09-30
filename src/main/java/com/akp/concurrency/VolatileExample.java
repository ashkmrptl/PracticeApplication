package com.akp.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/*
 * volatile keyword ensures the value of the variable is stored in main memory instead of local cache. It is similar to access a variable within synchronized block.
 * It is used to solve the variable visibility problem in multi-threaded environment.
 */
public class VolatileExample {
	private static volatile int count = 0;
	private static AtomicInteger atomicCounter = new AtomicInteger();
	private static LongAdder adder = new LongAdder();
	private static LongAccumulator accumulator = new LongAccumulator((x, y) -> x * y, 1);

	public static void main(String[] args) {
		accumulatorTester();
		adderTester();
		atomicTester();
		volatileTester();
	}

	/*
	 * Accumulator is very similar to Adder but it takes a custom function as an
	 * argument like shown below
	 */
	private static void accumulatorTester() {
		ExecutorService service = Executors.newFixedThreadPool(10);
		IntStream.rangeClosed(1, 5)/* .peek(System.out::println) */
				.forEach(e -> service.execute(() -> accumulator.accumulate(2)));

		System.out.println("accumulator : " + accumulator.get());
	}

	private static void adderTester() {
		ExecutorService service = Executors.newFixedThreadPool(10);
		IntStream.rangeClosed(1, 5)/*.peek(System.out::println)*/.forEach(e -> service.execute(() -> adder.increment()));

		System.out.println("LongAdder sum : " + adder.sum());
	}

	private static void atomicTester() {
		List<Runnable> runnableList = new ArrayList<>();
		ExecutorService service = Executors.newFixedThreadPool(10);
		IntStream.range(0, 10).forEach(user -> runnableList.add(() -> {
			if (atomicCounter.get() % 2 == 0) {
				atomicCounter.incrementAndGet();
				System.out.println("Running atomic the block from : " + Thread.currentThread().getName());
			} else {
				atomicCounter.incrementAndGet();
			}
		}));

		runnableList.stream().forEach(e -> service.execute(e));

		service.shutdown();
	}

	private static void volatileTester() {
		List<Runnable> runnableList = new ArrayList<>();
		ExecutorService service = Executors.newFixedThreadPool(10);
		IntStream.range(0, 10).forEach(user -> runnableList.add(() -> {
			if (count % 2 == 0) {
				count++;
				System.out.println("Running the block from : " + Thread.currentThread().getName());
			} else {
				count++;
			}
		}));

		runnableList.stream().forEach(e -> service.execute(e));

		service.shutdown();
	}
}
