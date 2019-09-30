import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsFilterExample {
	public static void main(String[] args) {
		// testFilter();
		// testMoreFilter();
		// testMapToInt();
		filterMapAndSort();
	}

	private static void filterMapAndSort() {
		Integer[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		List<Integer> list = Arrays.asList(arr);

		list.stream().filter(n -> n % 2 == 0).map(n -> n * 2).sorted(/* Comparator.reverseOrder() */).forEach(System.out::println);

	}

	private static void testFilter() {
		List<String> list = Arrays.asList("Ashish", "Kumar", "Patel");

		// Filter before java 8
		List<String> filteredList = new ArrayList<>();
		for (String string : list) {
			if (string.contains("s")) {
				filteredList.add(string);
			}
		}
		filteredList.forEach(str -> System.out.println(str));

		System.out.println("----------------");

		// After Java 8
		List<String> filteredList1 = list.stream().filter(str -> str.contains("s")).collect(Collectors.toList());
		filteredList1.forEach(str -> System.out.println(str));
	}

	private static void testMoreFilter() {
		List<Person> persons = Arrays.asList(new Person("mkyong", 30), new Person("jack", 20),
				new Person("lawrence", 40));
		Person p1 = persons.stream().filter(person -> person.getName().equals("jack")).findAny().orElse(null);
		System.out.println("p1 : " + p1);

		Person p2 = persons.stream().filter(person -> person.getName().equals("humble")).findAny().orElse(null);
		System.out.println("p2 : " + p2);
	}

	/**
	 * mapToInt convert streams to IntStream, which can be converted to
	 * Stream<Integer> by calling boxed() method and then we can use collector to
	 * convert the collection to list of integer
	 */
	private static void testMapToInt() {
		List<Person> persons = Arrays.asList(new Person("mkyong", 30, 1000), new Person("jack", 20, 4000),
				new Person("lawrence", 40, 3000));
		List<Integer> ageList = persons.stream().filter(p -> p.getAge() > 20).mapToInt(Person::getAge).boxed()
				.collect(Collectors.toList());
		System.out.println("age List : " + ageList);

		// Printing the sum of salary of all person in list
		Integer sum = persons.stream().mapToInt(Person::getSalary).sum();
		System.out.println("Total salary : " + sum);
	}

	private static void ifPresentTest() {

	}

}

class Person {
	private String name;
	private Integer age;
	private Integer salary;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, Integer age, Integer salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
}
