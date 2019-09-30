package com.akp.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Test {
	/*public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Kumar", new Date("06/06/2018")));
		empList.add(new Employee(2, "Ashish", new Date("06/06/2018")));
		empList.add(new Employee(3, "Patel", new Date("06/01/2017")));
		
		System.out.println("Original List");
		printList(empList);	
		
		System.out.println("List sorted by name");
		Comparator<Employee> nameComparator = new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getName().compareTo(e2.getName());
			}
		};
		Collections.sort(empList, nameComparator);
		printList(empList);
		
		System.out.println("List sorted by DOJ");
		Comparator<Employee> dojComparator = new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getDoj().compareTo(e2.getDoj());
			}
		};
		Collections.sort(empList, dojComparator);
		printList(empList);
		
	}*/
	
	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(11, "Ashish", new Date("06/06/2018")));
		empList.add(new Employee(21, "Ashish", new Date("06/06/2018")));
		empList.add(new Employee(13, "Ashish", new Date("06/01/2017")));
		
		System.out.println("Original List : ");
		printList(empList);
		
		//comparatorComparision(empList);
		
		java8Comparator(empList);
	}
	
	private static void java8Comparator(List<Employee> empList) {
		Collections.sort(empList, Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
		System.out.println("Sorted List : ");
		printList(empList);
	}
	
	private static void comparatorComparision(List<Employee> empList) {
		Comparator<Employee> empComparator = new Comparator<Employee>() {
			
			@Override
			public int compare(Employee e1, Employee e2) {
				if(e1.getName().equals(e2.getName())) {
					return e1.getAge().compareTo(e2.getAge());
				}
				return e1.getName().compareTo(e2.getName());
			}
		};
		
		Collections.sort(empList, empComparator);
		System.out.println("Sorted List : ");
		printList(empList);
	}
	private static void printList(List<Employee> list) {
		for (Employee employee : list) {
			System.out.println(employee);
		}
		System.out.println();
	}
}
