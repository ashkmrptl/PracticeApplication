import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterNullFromStream {
	public static void main(String[] args) {
		filterNullFromStream();
	}

	private static void filterNullFromStream() {
		Stream<String> stringStream = Stream.of("java", "python", null, "php", null, "ruby");

		//List<String> listWithNull = stringStream.collect(Collectors.toList());

		//listWithNull.forEach(System.out::println);

		List<String> listWithoutNull = stringStream.filter(x -> x != null).collect(Collectors.toList());

		listWithoutNull.forEach(System.out::println);
	}
}
