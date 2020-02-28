package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Solution :
 * Divide the array in two parts(if array to be rotated to left then divide from left side, else divide from right side)
 * Reverse both part and the revert the entire array
 */
public class RotateArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] arr = br.readLine().split(" ");
            int d = Integer.parseInt(arr[1]);

            String[] array = br.readLine().split(" ");

            rotateLeft(array, d);
            System.out.println();
        }
    }

    private static void rotateLeft(String[] arr, int d) {
        //Rotating left half
        rotateArray(arr, 0, d - 1);

        //Rotate right array
        rotateArray(arr, d, arr.length - 1);

        //Rotate entire array
        rotateArray(arr, 0, arr.length - 1);

        Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
    }

    private static void rotateArray(String[] array, int start, int end) {
        int mid = (start + end) / 2;
        for (int i = start, j = end; i <= mid; i++, j--) {
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
