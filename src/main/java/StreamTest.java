import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class StreamTest {
	public static void main(String[] args) {
		testPeek();

		testFindFirstAndFindAny();
	}

	private static void testPredicate() {
		/*
		 * Predicate a functional interface which represents a function, which takes an
		 * Object and returns a boolean. It is used in several stream methods like
		 * filter().
		 * 
		 * Signature :
		 * 
		 * @functionalInterface interface Predicate { public boolean test (T object); }
		 */
	}

	private static void testPeek() {
		int[] array = { 12, 1, 5, 4, 6, 3, 7, 8, 9, 11, 2 };
		IntStream stream = Arrays.stream(array);

		int sum = stream.peek(System.out::println).sum();
		System.out.println("sum : " + sum);
	}

	private static void testFindFirstAndFindAny() {
		int[] array = { 2, 3, 5, 7, 11, 13 };
		IntStream stream = Arrays.stream(array);

		int primeGreaterThanFive = stream.peek(num -> System.out.println("Going to filter : " + num)).filter(e -> e > 5)
				.findFirst().getAsInt();
		System.out.println("primeGreaterThanFive : " + primeGreaterThanFive);

		stream = Arrays.stream(array);
		OptionalInt optional = stream.peek(num -> System.out.println("Goint to filter : " + num)).filter(e -> e > 5)
				.findAny();
		if (optional.isPresent()) {
			System.out.println("any prime : " + optional.getAsInt());
		} else {
			System.out.println("no value");
		}
	}
}
