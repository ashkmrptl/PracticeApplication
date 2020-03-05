package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * An element of array is leader if it is greater than or equal to all the elements to its right side.
 * Also, the rightmost element is always a leader
 */
public class LeadersInAnArray {
    /*
     * Following method will take O(n*n).
     */
    public static List<String> getLeaders(String[] array) {
        List<String> result = new ArrayList<>();

        boolean isLeader = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (Integer.parseInt(array[i]) < Integer.parseInt(array[j])) {
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) {
                result.add(array[i]);
            }
            isLeader = true;
        }

        return result;
    }

    /**
     * We can scan the array from right to left and whenever a max is found, we can print it
     *
     * @param array input array
     */
    public static List<String> getLeadersOptimized(String[] array) {
        List<String> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            if (Integer.parseInt(array[i]) >= max) {
                max = Integer.parseInt(array[i]);
                result.add(array[i]);
            }
        }
        return result;
    }

    /*
     * Instead of using println for each element we can prepare a String and print it at once.
     * This will fix time out exception in GFG. As every time printing is costly.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] array = br.readLine().split(" ");

            System.out.println("\n leaders : ");
            getLeaders(array).forEach(e -> System.out.print(e + " "));

            System.out.println("\n leaders optimized : ");
            StringBuilder sb = new StringBuilder();
            List<String> list = getLeadersOptimized(array);
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
                sb.append(list.get(i) + " ");
            }
        }
    }
}
