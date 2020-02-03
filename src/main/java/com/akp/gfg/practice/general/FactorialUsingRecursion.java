package com.akp.gfg.practice.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FactorialUsingRecursion {
    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(--n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader be = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(be.readLine());
        System.out.println("Factorial is : " + factorial(number));
    }
}
