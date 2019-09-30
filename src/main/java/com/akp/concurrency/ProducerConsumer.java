package com.akp.concurrency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {
	private Lock lock = new ReentrantLock();
	private Condition produced = lock.newCondition();
	private Condition consumed = lock.newCondition();

	private Integer size;
	private Queue<String> queue;

	int data = 0;

	public ProducerConsumer(Integer size) {
		this.size = size;
		queue = new LinkedList<String>();
	}

	public void produce() {
		lock.lock();
		try {
			while (queue.size() == size) {
				produced.await();
			}
			String item = (data++) + "";
			queue.add(item);
			System.out.println("Produced : " + item);
			printQueue(queue,"prod");
			consumed.signal();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void consume() {
		lock.lock();
		try {
			while (queue.size() == 0) {
				consumed.await();
			}
			String item = queue.poll();
			System.out.println("Consumed : " + item);
			printQueue(queue,"con");
			produced.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	private void printQueue(Queue<String> queue, String flag) {
		System.out.print("Queue is : ");
		for (String string : queue) {
			System.out.print(string + " ");
		}

		String str = "";
		if (flag.equals("prod")) {
			str = "----------------------------------------------------------------";
		} else {
			str = "-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --";
		}
		System.out.print(" Size is : " + queue.size() + " is Queue empty : " + queue.isEmpty() + "\n" + str + "\n");
	}
}
