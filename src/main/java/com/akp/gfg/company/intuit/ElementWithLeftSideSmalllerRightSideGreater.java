package com.akp.gfg.company.intuit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ElementWithLeftSideSmalllerRightSideGreater {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                String[] array = br.readLine().split("\\s");

                int pivot = 0;

                for (int i = 1; i < n - 1; i++) {
                    if (Integer.parseInt(array[i]) > Integer.parseInt(array[pivot])) {
                        pivot = i;
                    }
                }
                System.out.println(array[pivot]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
