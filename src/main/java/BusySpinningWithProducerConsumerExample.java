import java.util.ArrayList;
import java.util.List;

/**
 * Busy spinning is a waiting strategy in which one thread loop continuously to
 * check certain condition and waiting for other threads to change this
 * condition to break the loop without releasing CPU so that processing thread
 * can proceed its work further.
 * 
 * The traditional methods like sleep(), wait(), notify() releases the CPU but
 * busy spin doesn't relinquish CPU and hence preserves CPU caches.
 */
public class BusySpinningWithProducerConsumerExample {
	public static void main(String[] args) {
		Producer producer = new Producer();
		Consumer consumer = new Consumer(producer);

		//new Thread(producer).start();
		//new Thread(consumer).start();

		SynchronizedProducer syncProducer = new SynchronizedProducer();
		SynchronizedConsumer syncConsumer = new SynchronizedConsumer(syncProducer);

		new Thread(syncProducer).start();
		new Thread(syncConsumer).start();

	}
}

class Producer implements Runnable {
	boolean isProgress;
	List<Integer> proList;

	Producer() {
		isProgress = true;
		proList = new ArrayList<Integer>();
	}

	@Override
	public void run() {
		for (int i = 0; i < 3; i++) {
			proList.add(i);
			System.out.println("Producer is still Producing, Produced : " + i);

			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("isProgress changed to false");
		isProgress = false;
	}
}

class Consumer implements Runnable {
	Producer producer;

	Consumer(Producer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {
		while (this.producer.isProgress) {
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Busy Spinning condition");
		}
		System.out.println("Consumer starts consuming products");
		int size = this.producer.proList.size();
		for (int i = 0; i < size; i++) {
			System.out.println("Consumed : " + this.producer.proList.remove(0) + " ");
		}
	}
}

class SynchronizedProducer implements Runnable {
	List<Integer> prodList;

	SynchronizedProducer() {
		prodList = new ArrayList<>();
	}

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 8; i++) {
				prodList.add(i);
				System.out.println("Producer is still producing. Produced : " + i);

				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Going to notify consumer");
			this.notifyAll();
		}
	}
}

class SynchronizedConsumer implements Runnable {
	SynchronizedProducer producer;

	public SynchronizedConsumer(SynchronizedProducer producer) {
		this.producer = producer;
	}

	@Override
	public void run() {
		synchronized (this.producer) {
			try {
				this.producer.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Consumer starts consuming products.");
		int size = this.producer.prodList.size();
		for (int i = 0; i < size; i++) {
			System.out.println("Consumed : " + this.producer.prodList.remove(0) + " ");
		}
	}

}
