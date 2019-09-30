import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfObjectToListOfString {
	public static void main(String[] args) {
		List<Staff> staffList = Arrays.asList(new Staff("Ashish", 28, new BigDecimal(10000)),
				new Staff("Kumar", 27, new BigDecimal(20000)), new Staff("Patel", 26, new BigDecimal(40000)));

		// Before Java 8
		List<String> nameList = new ArrayList<String>();
		for (Staff s : staffList) {
			nameList.add(s.getName());
		}
		System.out.println("nameList : " + nameList);

		// After Java 8
		List<String> nameList1 = staffList.stream().map(x -> x.getName()).collect(Collectors.toList());
		System.out.println("nameList1 : " + nameList1);
	}
}

class Staff {
	private String name;
	private Integer age;
	private BigDecimal salary;

	public Staff(String name, Integer age, BigDecimal salary) {
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}