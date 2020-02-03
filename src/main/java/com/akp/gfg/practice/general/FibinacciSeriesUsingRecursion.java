package com.akp.gfg.practice.general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibinacciSeriesUsingRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println("Fibonacci number is : " + fibonacci(num));
    }

    private static int fibonacci(int number) {
        if (number <= 1) {
            return number;
        }

        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
