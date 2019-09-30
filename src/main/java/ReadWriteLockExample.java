import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReadWriteLock is advance thread lock mechanism, which allows multiple threads
 * to read a certain resource but only one to write at a time. It means it there
 * is no write lock on the object then multiple threads can acquire lock for
 * read operation and if no threads are reading or writing then only one thread
 * can lock the object for writing.
 */
public class ReadWriteLockExample {
	public static void main(String[] args) {
		Thread t1 = new Thread(() -> {
			ReadWriteLockExample.test(true);
		}, "Thread_one");
		Thread t2 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_two");
		Thread t3 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_three");
		Thread t4 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_four");
		Thread t5 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_five");
		Thread t6 = new Thread(() -> {
			ReadWriteLockExample.test(true);
		}, "Thread_six");
		Thread t7 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_seven");
		Thread t8 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_eight");
		Thread t9 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_nine");
		Thread t10 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_ten");
		Thread t11 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_eleven");
		Thread t12 = new Thread(() -> {
			ReadWriteLockExample.test(false);
		}, "Thread_12");

		t1.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		t12.start();
	}

	private static void test(boolean isWriteRequired) {
		ReadWriteLock lock = new ReentrantReadWriteLock();

		// Reading section which can be read simultaneously by multiple threads by
		// acquiring lock
		if (!isWriteRequired) {
			lock.readLock().lock();
			System.out.println("Read section read from : " + Thread.currentThread().getName());
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " read wait completed");
			lock.readLock().unlock();
		}

		// Writing section which can be accessed by only one thread at a time
		if (isWriteRequired) {
			lock.writeLock().lock();
			System.out.println("Writen from : " + Thread.currentThread().getName());
			try {
				Thread.sleep(4000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.writeLock().unlock();
		}
	}
}
