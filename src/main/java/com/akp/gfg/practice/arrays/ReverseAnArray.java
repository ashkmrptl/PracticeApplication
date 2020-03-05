package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split("\\s");

            for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--) {
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
        }
    }
}
