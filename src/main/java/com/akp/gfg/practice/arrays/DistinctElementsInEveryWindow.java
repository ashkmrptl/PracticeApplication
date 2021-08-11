package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array A[] of size N and an integer K. Your task is to complete the function countDistinct() which prints the count of distinct numbers in all windows of size k in the array A[].
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains two integers N and K. Then in the next line are N space separated values of the array A[].
 * Output:
 * For each test case in a new line print the space separated values denoting counts of distinct numbers in all windows of size k in the array A[].
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N, K <= 100
 * 1 <= A[] <= 100
 * Example(To be used only for expected output):
 * Input:
 * 2
 * 7 4
 * 1 2 1 3 4 2 3
 * 3 2
 * 4 1 1
 * Output:
 * 3 4 4 3
 * 2 1
 */
public class DistinctElementsInEveryWindow {
    public static void main(String[] args) throws IOException {
        System.out.println("Started");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] tempArr = br.readLine().split(" ");
            int n = Integer.parseInt(tempArr[0]);
            int k = Integer.parseInt(tempArr[1]);

            String[] temp = br.readLine().split(" ");
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(temp[i]);
            }

            //countDistinct(array, k, n);
            countDistinctOptimised(array, k, n);
            System.out.println();
        }

        br.close();

    }

    private static void countDistinct(int[] array, int k, int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= n - k; i++) {
            for (int j = i; j < i + k; j++) {
                set.add(array[j]);
            }
            System.out.print(set.size() + " ");
            set = new HashSet<>();
        }
    }

    private static void countDistinctOptimised(int[] array, int k, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - k; i++) {
            if (map.isEmpty()) {
                for (int j = i; j < i + k; j++) {
                    if (!map.containsKey(array[j])) {
                        map.put(array[j], 1);
                    } else {
                        map.put(array[j], map.get(array[j]) + 1);
                    }
                }
            } else {
                if (map.containsKey(array[i - 1])) {
                    if (map.get(array[i - 1]) == 1) {
                        map.remove(array[i - 1]);
                    } else {
                        map.put(array[i - 1], map.get(array[i - 1]) - 1);
                    }
                }

                if (!map.containsKey(array[i + k - 1])) {
                    map.put(array[i + k - 1], 1);
                } else {
                    map.put(array[i + k - 1], map.get(array[i + k - 1]) + 1);
                }
            }

            System.out.print(map.size() + " ");
        }
    }

}
