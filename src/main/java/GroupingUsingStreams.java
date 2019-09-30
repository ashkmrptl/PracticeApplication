import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingUsingStreams {
	public static void main(String[] args) {
		// gropuList();
		groupCustomObjects();
	}

	private static void gropuList() {
		List<String> list = Arrays.asList("Ashish", "Kumar", "Patel", "Ashish", "Ashish", "Kumar");

		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("map : " + map);

		Map<String, Long> finalMap = new LinkedHashMap<>();

		map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println("mafinalMapp : " + finalMap);
	}

	private static void groupCustomObjects() {

		List<Item> items = Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
				new Item("banana", 20, new BigDecimal("19.99")), new Item("orang", 10, new BigDecimal("29.99")),
				new Item("watermelon", 10, new BigDecimal("29.99")), new Item("papaya", 20, new BigDecimal("9.99")),
				new Item("apple", 10, new BigDecimal("9.99")), new Item("banana", 10, new BigDecimal("19.99")),
				new Item("apple", 20, new BigDecimal("9.99")));

		Map<String, Integer> groupByNameMap = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getId)));
		System.out.println("groupByNameMap : " + groupByNameMap);

		// Sort by salary
		Map<BigDecimal, Set<String>> salaryGroupMap = items.stream()
				.collect(Collectors.groupingBy(Item::getSalary, Collectors.mapping(Item::getName, Collectors.toSet())));
		System.out.println("salaryGroupMap : " + salaryGroupMap);
		
		
	}

}

class Item {
	private String name;
	private Integer id;
	private BigDecimal salary;

	public Item(String name, Integer id, BigDecimal salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
