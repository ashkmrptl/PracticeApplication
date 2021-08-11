package com.akp.hackerearth.datastructures.oned;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BracketSequences {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String string = br.readLine();

        final String[] arr = string.split("");

        if (arr.length % 2 != 0) {
            System.out.println(0);
        } else {
            int count = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i].equals("(") && isComplete(i, arr)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isComplete(int startIndex, String[] array) {
        final Stack<String> stack = new Stack<>();

        int i = startIndex;
        do {
            if (array[i].equals("(")) {// push into stack
                stack.push(array[i]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    final String str = stack.pop();
                    if (!str.equals("(")) {
                        return false;
                    }
                }
            }

            if (i == array.length - 1) {
                i = 0;
            } else {
                i++;
            }
        } while (i != startIndex);
        return true;
    }
}
