import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Both map and flatmap can be applied to Stream<T> and both returns Stream<R>.
 * The difference is that map operation produces one output value for each input
 * value, whereas the flatmap operation produces an arbitrary number (zero or
 * more) values for each input value.
 * 
 * The map operation takes a Function, which is called for each value in the
 * input stream and produces one output result value, which is sent to the
 * output stream.
 * 
 * The flatmap operation takes a function that conceptually wants to consume one
 * value and produce an arbitrary no of values. However in Java since methods
 * can return only zero or one value flatmap takes a value and returns an array
 * or list of values, which are then sent to output.
 * 
 * Typical use of mapper function of flatmap to return Stream.empty() if it
 * wants to return zero values, or something like Stream.of(a, b, c) if it wants
 * to return several values
 */
public class MapAndFlatmapExample {
	public static void main(String[] args) {
		// map example
		List<Integer> integerList = Stream.of("1", "2", "3", "4").map(Integer::valueOf).collect(Collectors.toList());
		System.out.println("integerList : " + integerList);

		// flatmap example
		List<Integer> oddList = Arrays.asList(1, 3, 5);
		List<Integer> evenList = Arrays.asList(2, 4, 6);
		List<Integer> primeList = Arrays.asList(1, 2, 3);

		List<Integer> combinedList = Stream.of(oddList, evenList, primeList).flatMap(list -> list.stream())
				.collect(Collectors.toList());
		System.out.println("combinedList : " + combinedList);
	}
}
