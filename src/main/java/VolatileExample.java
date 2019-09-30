
/**
 * Using volatile key-word is yet another way of making class thread safe (like
 * synchronized, atomic wraper)
 */
public class VolatileExample {
	volatile int a = 0;

	public static void main(String[] args) {
		new VolatileExample().testVolatile();
	}

	private void testVolatile() {
		Thread threadOne = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				a = a + 2;
				System.out.println("a in th1 after increment : "+a);
			}
		});

		Thread threadTwo = new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				a = a + 3;
				System.out.println("a in th2 after increment : "+a);
			}
		});
		threadOne.start();
		threadTwo.start();

		System.out.println("a : " + a);
	}
}
