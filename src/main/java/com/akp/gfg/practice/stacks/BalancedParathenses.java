package com.akp.gfg.practice.stacks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedParathenses {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer t = new Integer(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();
            char[] arr = str.toCharArray();
            System.out.println(areParenthesisBalanced(arr));
        }
        br.close();
    }


    private static boolean areParenthesisBalanced(char[] charArray) {
        Stack<Character> stack = new Stack<>();

        for (char c : charArray) {
            if (c == '{' || c == '(' || c == '[')
                stack.push(c);
            if (c == '}' || c == ')' || c == ']') {

                if (stack.isEmpty()) {
                    return false;
                } else if (!isParenthesesMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isParenthesesMatching(char ch1, char ch2) {
        if (ch1 == '(' && ch2 == ')')
            return true;
        else if (ch1 == '{' && ch2 == '}')
            return true;
        else if (ch1 == '[' && ch2 == ']')
            return true;
        else
            return false;
    }

}
