import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
	public static void main(String[] args) throws InterruptedException {
		IntStream intStream = IntStream.rangeClosed(0, 50);

		intStream.forEach(System.out::print);
	}
}