package com.akp.hackerearth.datastructures.oned;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrintArrayInReverse {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final int[] array = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            array[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("Array in reverse order : ");
        Arrays.stream(array).forEach(System.out::println);
    }
}
