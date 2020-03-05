package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] array = br.readLine().split(" ");

            Map<String, Integer> map = new HashMap<>();

            for (String i : array) {
                if (!map.containsKey(i)) {
                    map.put(i, 1);
                } else {
                    map.put(i, map.get(i) + 1);
                }
            }

            String num = "-1";

            for(Map.Entry<String, Integer> e: map.entrySet()){
                if (e.getValue() > n / 2) {
                    num = e.getKey();
                }
            }

            System.out.println(num);

        }
    }
}
