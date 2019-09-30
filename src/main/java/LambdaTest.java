import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
	public static void main(String[] args) {
		List<Developer> devList = Arrays.asList(new Developer("Deepak", 22), new Developer("Ashish", 24));

		// List Before Sorting
		System.out.println("devList : " + devList);

		// Sorting by name using lambda
		devList.sort((Developer d1, Developer d2) -> {
			return d1.getName().compareTo(d2.getName());
		});

		// List After Sorting
		System.out.println("devList sorted by name : " + devList);

		// Sorting by age using lambda
		devList.sort((d1, d2) -> {
			return d1.getAge() - d2.getAge();
		});

		// List After Sorting
		System.out.println("devList sorted by age : " + devList);

		// Sorting by age using lambda - reverse order
		Comparator<Developer> developerComparator = (o1, o2) -> {
			return o1.getName().compareTo(o2.getName());
		};
		devList.sort(developerComparator.reversed());

		// List After Sorting
		System.out.println("devList sorted by name in reverse order : " + devList);
	}
}

class Developer {
	private String name;
	private Integer age;

	public Developer(String name, Integer age) {
		this.name = name;
		this.age = age;
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

	@Override
	public String toString() {
		return "Developer [name=" + name + ", age=" + age + "]";
	}
}
