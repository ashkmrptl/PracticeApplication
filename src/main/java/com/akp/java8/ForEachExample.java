package com.akp.java8;

import com.akp.java8.vo.Student;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ForEachExample {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        map.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println("key : " + entry.getKey());
                    System.out.println("value : " + entry.getValue());
                });

        //Sorting map by key
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                            System.out.println("key : " + entry.getKey());
                            System.out.println("value : " + entry.getValue());
                        }
                );

        //Sorting map by value
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> {
                    System.out.println("key : " + entry.getKey());
                    System.out.println("value : " + entry.getValue());
                });

        //Using custom comparator
        Map<Student, Integer> studentIntegerMap = new HashMap<>();

        studentIntegerMap.put(new Student("Kumar", 22, 59000F), 2);
        studentIntegerMap.put(new Student("Patel", 24, 49000F), 3);
        studentIntegerMap.put(new Student("Ashish", 30, 60000F), 1);

        //Printing the map
        studentIntegerMap.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println("Key : " + entry.getKey());
                    System.out.println("Value : " + entry.getValue());
                });

        System.out.println("Sorting by age : ");
        //Sorting map by student's age
        studentIntegerMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getAge)))
                .forEach(
                        entry -> {
                            System.out.println("Key : " + entry.getKey());
                            System.out.println("Value : " + entry.getValue());
                        }
                );

        System.out.println("Sorting by name and salary : ");
        //Sorting map by student's name
        studentIntegerMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey(Comparator.comparing(Student::getName).thenComparing(Student::getSalary).reversed()))
                .forEach(
                        entry -> {
                            System.out.println("Key : " + entry.getKey());
                            System.out.println("Value : " + entry.getValue());
                        }
                );
    }
}
