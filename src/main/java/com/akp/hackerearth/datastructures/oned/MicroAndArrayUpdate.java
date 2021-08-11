package com.akp.hackerearth.datastructures.oned;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MicroAndArrayUpdate {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            final String[] array = br.readLine().trim().split(" ");
            int k = Integer.parseInt(array[1]);

            final List<Integer> list = Arrays.stream(br.readLine().trim().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

            Integer smallest = Integer.MAX_VALUE;

            for (final Integer i : list) {
                if (i < smallest) {
                    smallest = i;
                }
            }

            if (smallest >= k) {
                System.out.println("0");
            } else {
                System.out.println(k - smallest);
            }
        }
    }
}
