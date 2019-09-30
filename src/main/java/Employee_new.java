
public class Employee_new {
	private String name;
	private int salary;

	public Employee_new(String n, int s) {
		this.name = n;
		this.salary = s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		return "Name: " + this.name + "-- Salary: " + this.salary;
	}

	@Override
	public int hashCode() {
		System.out.println("10");
		return 10;
	}

	@Override
	public boolean equals(Object arg) {
		Employee_new obj = (Employee_new) arg;
		if (this.salary == obj.salary) {
			return true;
		} else {
			return false;
		}
	}
}
