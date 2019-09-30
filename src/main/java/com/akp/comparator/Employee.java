package com.akp.comparator;

import java.util.Comparator;
import java.util.Date;

public class Employee implements Comparable<Employee> {
	private Integer age;
	private String name;
	private Date doj;

	public Employee(int age, String name, Date doj) {
		super();
		this.age = age;
		this.name = name;
		this.doj = doj;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public int compareTo(Employee emp) {
		return this.age - emp.age;
	}

	public int compareByName(Employee e1, Employee e2) {
		Comparator<Employee> nameComparator = new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		};

		return nameComparator.compare(e1, e2);
	}

	public int compareByDoj(Employee e1, Employee e2) {
		Comparator<Employee> dojComparator = new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getDoj().compareTo(e2.getDoj());
			}
		};

		return dojComparator.compare(e1, e2);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((doj == null) ? 0 : doj.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (doj == null) {
			if (other.doj != null)
				return false;
		} else if (!doj.equals(other.doj))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + age + ", name=" + name + ", doj=" + doj + "]";
	}

}
