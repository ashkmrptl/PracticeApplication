import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ForEachWithLambda {
	public static void main(String[] args) {
		// testMap();
		testList();

	}

	private static void testList() {
		List<String> list = new ArrayList<>();
		list.add("ash");
		list.add("akp");
		list.add("kps");
		list.add("pak");
		list.add("psh");

		list.forEach(str -> System.out.println(str));

		System.out.println("__________________");

		// Using filter
		list.forEach(string -> {
			if (string.contains("a")) {
				System.out.println(string);
			}
		});

		System.out.println("------------------");

		list.stream().filter(str -> str.contains("a")).forEach(str -> System.out.println(str));
	}

	private static void testMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("a", 16);
		map.put("b", 27);
		map.put("c", 23);
		map.put("d", 54);
		map.put("e", 32);
		map.put("f", 21);
		map.put("g", 12);

		// Before java 8
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		System.out.println("------");

		// After Java 8 using lambda
		map.forEach((key, value) -> System.out.println(key + " " + value));
	}
}
