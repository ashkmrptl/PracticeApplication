import java.util.concurrent.atomic.AtomicInteger;

public class PrintingCharsOfStringFromThreads {

	public static void main(String[] args) {
		// usingAtomicInteger();

		usingThreadSwitching();
	}

	private static void usingAtomicInteger() {
		String string = "Ashish";
		final char[] array = string.toCharArray();

		AtomicInteger atomicInteger = new AtomicInteger(0);

		Thread t1 = new Thread(() -> {
			while (atomicInteger.get() < array.length) {
				int divVal = atomicInteger.get() % 2;
				if (divVal == 0) {
					System.out.println(array[atomicInteger.getAndIncrement()]);
				}
			}
		});

		Thread t2 = new Thread(() -> {
			while (atomicInteger.get() < array.length) {
				int divVal = atomicInteger.get() % 2;
				if (divVal != 0) {
					System.out.println(array[atomicInteger.getAndIncrement()]);
				}
			}
		});

		t1.start();
		t2.start();
	}

	private static void usingThreadSwitching() {
		String string = "Ashish";
		final char[] array = string.toCharArray();

		Object lock = new Object();

		Thread evenThread = new Thread(() -> {
			for (int i = 0; i < array.length; i++) {
				synchronized (lock) {
					if (i % 2 == 0)
						System.out.println("Even -> " + array[i]);
					try {
						lock.notify();
						if (i == array.length - 1) {
							break;
						}
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread oddThread = new Thread(() -> {
			for (int i = 0; i < array.length; i++) {
				synchronized (lock) {
					if (i % 2 != 0)
						System.out.println("Odd  -> " + array[i]);
					try {
						lock.notify();
						if (i == array.length - 1) {
							break;
						}
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		evenThread.start();
		oddThread.start();
	}
}
