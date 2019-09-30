import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSupplierEx {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Ashish", "Kumar", "Patel");
		//reuseStreamWithExp(list);
		
		reuseStreamWithoutExp(list);
	}

	private static void reuseStreamWithExp(List<String> list) {
		Stream<String> stream = list.stream();

		stream.forEach(System.out::println);

		List<String> filteredString = stream.filter(x -> x != "Kumar").collect(Collectors.toList());
		filteredString.forEach(x -> System.out.println(x));

	}

	private static void reuseStreamWithoutExp(List<String> list) {
		String[] array = new String[list.size()];
		Supplier<Stream<String>> supplier = () -> Stream.of(list.toArray(array));

		Stream<String> stream = supplier.get();

		stream.forEach(System.out::println);

		List<String> filteredString = supplier.get().filter(x -> x != "Kumar").collect(Collectors.toList());
		filteredString.forEach(x -> System.out.println(x));

	}
}
