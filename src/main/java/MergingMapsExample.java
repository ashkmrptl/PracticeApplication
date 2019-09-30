import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMapsExample {
	public static void main(String[] args) {
		Map<String, Employee> map1 = new HashMap<String, Employee>();
		Map<String, Employee> map2 = new HashMap<String, Employee>();

		Employee e1 = new Employee("ashish", 1, new BigDecimal(200000));
		Employee e2 = new Employee("kumar", 2, new BigDecimal(150000));
		Employee e3 = new Employee("patel", 3, new BigDecimal(100000));

		map1.put(e1.getName(), e1);
		map1.put(e2.getName(), e2);
		map1.put(e3.getName(), e3);

		Employee e4 = new Employee("sri", 4, new BigDecimal(50000));
		Employee e5 = new Employee("patel", 4, new BigDecimal(70000));

		map2.put(e4.getName(), e4);
		map2.put(e5.getName(), e5);

		mergeUsingMapMergeMethod(map1, map2);

		mergeUsingStreamConcateMethod(map1, map2);
	}

	/**
	 * In java 8 merge() is added to Map interface. If specific key is not already
	 * associated with a value or the value is null, then merge() associates the key
	 * with the given value.Otherwise it replaces the value with result of the given
	 * remapping function. If the result of the remapping function is null then it
	 * removes the result.
	 */
	private static void mergeUsingMapMergeMethod(Map<String, Employee> map1, Map<String, Employee> map2) {
		Map<String, Employee> mergedMap = new HashMap<>(map1);

		map2.forEach((key, value) -> mergedMap.merge(key, value,
				(v1, v2) -> new Employee(v1.getName(), v2.getId(), v2.getSalary())));

		System.out.println("mergedMap : " + mergedMap);
	}

	private static void mergeUsingStreamConcateMethod(Map<String, Employee> map1, Map<String, Employee> map2) {
		Stream<Entry<String, Employee>> stream = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream());

		Map<String, Employee> mergedMap = stream.collect(Collectors.toMap(Entry::getKey, Entry::getValue,
				(v1, v2) -> new Employee(v1.getName(), v2.getId(), v1.getSalary())));

		System.out.println("mergedMap : " + mergedMap);
	}
}
