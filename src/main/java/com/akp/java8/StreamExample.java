package com.akp.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamExample {

    public static void main(String[] args) {
        filterStartsWithExample();
        partitioningByExample();
        groupingByExample();
    }

    private static void filterStartsWithExample() {
        final List<String> list = Arrays.asList("ashish", "kumar", "patel");

        final List<String> listWithNameStartsWithA = list
                .stream()
                .filter(name -> name.startsWith("a"))
                .collect(Collectors.toList());

        System.out.println("Names starting with 'a' : " + listWithNameStartsWithA);
    }

    /**
     * "partitioningBy" always returns a map with two entries, one for where the predicate is TRUE and one for where
     * the predicate is FALSE. It iss possible that both the entries will have empty lists, but they will exists.
     * Hence when we send an empty stream to partitioningBy we will still get two entries in the map
     */
    private static void partitioningByExample() {
        final List<String> emptyList = Collections.emptyList();
        final Map<Boolean, List<String>> map = emptyList
                .stream()
                .collect(Collectors.partitioningBy(name -> name.startsWith("a")));

        System.out.println("map : " + map);

        final List<String> list = Arrays.asList("ashish", "aayush", "abinash", "ratan", "liza", "lipu", "likun");
        final Map<Boolean, List<String>> map1 = list
                .stream()
                .collect(Collectors.partitioningBy(name -> name.startsWith("a")));

        System.out.println("map1 : " + map1);
    }

    /**
     * The status factory methods Collectors.groupingBy() and Collectors.groupingByConcurrent() provide us with
     * functionality similar to the 'GROUP BY' clause in the SQL Language. They are used for grouping objects by some
     * property and storing results in a Map instance.
     */
    private static void groupingByExample() {
        final List<String> list = Arrays.asList("ashish", "aayush", "abinash", "ratan", "liza", "lipu", "likun", "ashish");
        final Map<String, List<String>> map = list
                .stream()
                .collect(Collectors.groupingBy(Function.identity()));

        System.out.println("map : " + map);

        final Map<String, List<String>> map1 = list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.toList()));

        System.out.println("map1 : " + map1);

        final Map<String, Long> map2 = list
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("map2 : " + map2);
    }
}
