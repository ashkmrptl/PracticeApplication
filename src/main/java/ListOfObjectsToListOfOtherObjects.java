import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListOfObjectsToListOfOtherObjects {
	List<Employee> empList = Arrays.asList(new Employee("Ashish", 1, new BigDecimal(10000)),
			new Employee("Kumar", 2, new BigDecimal(20000)), new Employee("Patel", 3, new BigDecimal(40000)));

	List<EmployeePublic> publicEmployeeList = empList.stream().map(temp -> {
		EmployeePublic empPub = new EmployeePublic();
		empPub.setName(temp.getName());
		empPub.setId(temp.getId());
		if (temp.getName().equals("Ashish")) {
			empPub.setName("Updated");
		}
		return empPub;
	}).collect(Collectors.toList());

}

class Employee {
	private String name;
	private Integer id;
	private BigDecimal salary;

	public Employee(String name, Integer id, BigDecimal salary) {
		this.name = name;
		this.id = id;
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", id=" + id + ", salary=" + salary + "]";
	}

}

class EmployeePublic {
	private String name;
	private Integer id;
	private String extra;

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

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return "EmployeePublic [name=" + name + ", id=" + id + ", extra=" + extra + "]";
	}

}
