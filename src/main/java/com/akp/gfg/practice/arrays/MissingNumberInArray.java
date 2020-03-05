package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MissingNumberInArray {

    public static int getMissingNumber(String[] array, int n) {
        int total = 1;
        for (int i = 2; i <= (n + 1); i++) {
            total = total + i;
            total = total - Integer.parseInt(array[i - 2]);
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();
            String[] array = input.split(" ");
            System.out.println(getMissingNumber(array, array.length));
        }
    }
}
