import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Print Fizz if number is multiple of 5, print Buzz if number is multiple of 7
 * and FizzBuzz when its multiple of both 5 and 7
 */
public class FizzBuzzProblem {
	public static void main(String[] args) {
		int[] array = { 4, 1, 35, 56, 5, 59 };

		Arrays.stream(array).mapToObj(e -> e % 5 == 0 ? (e % 7 == 0 ? "FizzBuzz" : "Fizz") : (e % 7 == 0 ? "Buzz" : e))
				.forEach(System.out::println);
		
		test();
		
		test1();
	}

	private static void test() {
		IntStream.rangeClosed(1, 50).mapToObj(
				e -> e % 3 == 0 ? (e % 5 == 0 ? "Manhattan Associates" : "Manhattan") : (e % 5 == 0 ? "Associates" : e))
				.forEach(System.out::println);
	}
	
	private static void test1() {
		IntStream.rangeClosed(1, 50).mapToObj(e -> e % 2 == 0 ? "even" : "odd").forEach(System.out::println);
	}
}
