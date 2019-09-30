import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoxedStreamExample {

	public static void main(String[] args) {
		/*
		 * In Java 8 if we want to convert stream to collection then we can use one of
		 * the static method from Collectors class.
		 */
		List<String> list = Stream.of("a", "s", "h", "i", "s", "h").collect(Collectors.toList());

		System.out.println("list : " + list);

		/*
		 * This works only for objects and not for primitives. To convert stream of
		 * primitives we need to boxed the stream first, then we can use one of the
		 * Collectors static method to convert it into Collection.
		 */

		List<Integer> intList = IntStream.of(1, 2, 3, 4, 5, 6, 7).boxed().collect(Collectors.toList());
		System.out.println("intList : " + intList);

		// Getting maximum of elements
		Optional<Integer> maxOptional = IntStream.of(1, 2, 3, 6, 3, 8, 9, 3).boxed().max(Integer::compareTo);
		if (maxOptional.isPresent()) {
			System.out.println("Greatest number is : " + maxOptional.get());
		}

		// Method reference example
		/*
		 * Using method reference the static and the instance method of a class can be
		 * invoked just by using the class name. It can also be used to invoke the
		 * default constructor by using new key word.
		 */

		List<String> myList = Arrays.asList("Ashish", "Kumar", "Patel", "is", "from", "sundargarh");

		List<String> sortedLlist = myList.stream().sorted((s1, s2) -> s1.compareTo(s2))
				.collect(Collectors.toCollection(ArrayList::new));

		System.out.println("sortedLlist : " + sortedLlist);

		List<String> sortedList1 = myList.stream().sorted(String::compareTo).collect(Collectors.toList());
		System.out.println("sortedList1 : " + sortedList1);

		// Objects.requireNnonNull()
		Object obj = new Object();
		Objects.requireNonNull(obj, () -> "Why the hell is 'obj' null?");
		
		//Supplier example
		Supplier<Double> supplier = () -> Math.random();
		System.out.println("random value : "+supplier.get());
	}
}
