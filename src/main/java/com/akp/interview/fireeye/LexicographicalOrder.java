package com.akp.interview.fireeye;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicalOrder {

    private static String solve1(int n, List<String> list) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < list.size() - 1; i++) {
            String curr = list.get(i);
            String next = list.get(i + 1);

            for (int j = 0; j < curr.length() && j < next.length(); j++) {
                if ((int) curr.charAt(j) == (int) next.charAt(j)) {
                    if ((j == curr.length() - 1) && !output.toString().contains(curr.charAt(j) + "")) {
                        output.append(curr.charAt(j));
                    }
                } else {
                    if (!output.toString().contains(curr.charAt(j) + "")) {
                        output.append(curr.charAt(j));
                    }
                    if ((i == list.size() - 2) && !output.toString().contains(next.charAt(j) + "")) {
                        output.append(next.charAt(j));
                    }
                    break;
                }
            }
        }
        return output.toString();
    }

    private static String solve(int n, List<String> list) {
        List<Character> l = new ArrayList<>();
        for (int i = 0; i < list.size() - 1; i++) {
            String curr = list.get(i);
            String next = list.get(i + 1);

            for (int a = 0; a < curr.length() && a < next.length(); a++) {
                int first = curr.charAt(a);
                int second = next.charAt(a);

                if (first == second) {
                    continue;
                } else {
                    l.add(i, curr.charAt(a));
                    l.add(i + 1, next.charAt(a));
                }
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : l) {
            if (sb.toString().contains(c + "")) {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<String> arr = new ArrayList<>(Arrays.asList(arrTempItems).subList(0, arrCount));

        String outcome = solve(n, arr);

        System.out.println(outcome + "\n");
    }
}
