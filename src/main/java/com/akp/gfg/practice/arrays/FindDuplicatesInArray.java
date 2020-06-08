package com.akp.gfg.practice.arrays;

import java.util.*;

public class FindDuplicatesInArray {

    private static String[] findDuplicate(final String[] array) {
        final Map<String, Integer> map = new HashMap<>();
        Arrays.stream(array).forEach(element -> {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1);
            } else {
                map.put(element, 1);
            }
        });
        final List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }

        return list.toArray(new String[0]);
    }

    private static ArrayList<Integer> findDups(final String[] array) {
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }

        final ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(Integer.parseInt(entry.getKey()));
            }
        }

        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {
        final Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        while (t-- > 0) {
            int n = Integer.parseInt(s.nextLine());
            final String[] arr = s.nextLine().split(" ");
            final String[] resArr = findDuplicate(arr);
            if (resArr.length == 0) {
                System.out.println("-1");
            } else {
                for (int i = 0; i < resArr.length; i++) {
                    System.out.print(resArr[i] + " ");
                }
            }
        }
    }
}
