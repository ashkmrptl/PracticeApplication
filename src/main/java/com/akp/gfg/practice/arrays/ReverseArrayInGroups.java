package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Given an array arr[] of positive integers of size N. Reverse every sub-array of K group elements.
 * Example:
 * Input
 * 2
 * 5 3
 * 1 2 3 4 5
 * 6 2
 * 10 20 30 40 50 60
 * <p>
 * Output
 * 3 2 1 5 4
 * 20 10 40 30 60 50
 */
public class ReverseArrayInGroups {

    public static void reverseInGroups(String[] array, int k, int n) {
        for (int i = 0; i < n; i = i + k) {
            int left = i;
            int right = Math.min(i + k - 1, n - 1);
            String temp;

            //Reverse sub-array
            while (left < right) {
                temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int k = Integer.parseInt(temp[1]);

            String[] array = br.readLine().split(" ");
            reverseInGroups(array, k, n);

            StringBuffer sb = new StringBuffer();

            System.out.println("\nReversed array : ");
            Arrays.stream(array).forEach(e -> sb.append(e).append(" "));

            System.out.println(sb.toString());
        }
    }
}
