package com.akp.interview.jpmc;

import java.util.Stack;

/**
 * Evaluate the expression provided in String
 * ex : 5 % 6 * 4 + 3 - 4
 * <p>
 * <p>
 * Process followed :
 * 1. While there are still tokens to be read in,
 * 1.1 Get the next token.
 * 1.2 If the token is:
 * 1.2.1 A number: push it onto the value stack.
 * 1.2.2 A variable: get its value, and push onto the value stack.
 * 1.2.3 A left parenthesis: push it onto the operator stack.
 * 1.2.4 A right parenthesis:
 * 1 While the thing on top of the operator stack is not a
 * left parenthesis,
 * 1 Pop the operator from the operator stack.
 * 2 Pop the value stack twice, getting two operands.
 * 3 Apply the operator to the operands, in the correct order.
 * 4 Push the result onto the value stack.
 * 2 Pop the left parenthesis from the operator stack, and discard it.
 * 1.2.5 An operator (call it thisOp):
 * 1 While the operator stack is not empty, and the top thing on the
 * operator stack has the same or greater precedence as thisOp,
 * 1 Pop the operator from the operator stack.
 * 2 Pop the value stack twice, getting two operands.
 * 3 Apply the operator to the operands, in the correct order.
 * 4 Push the result onto the value stack.
 * 2 Push thisOp onto the operator stack.
 * 2. While the operator stack is not empty,
 * 1 Pop the operator from the operator stack.
 * 2 Pop the value stack twice, getting two operands.
 * 3 Apply the operator to the operands, in the correct order.
 * 4 Push the result onto the value stack.
 * 3. At this point the operator stack should be empty, and the value
 * stack should have only one value in it, which is the final result.
 */
public class ExpressionEvaluation {

    public static void main(String[] args) {
        String expresion1 = "12 / 2 * 3 + 4 - 1";
        System.out.printf("val 1 : " + evaluate(expresion1));
    }

    public static int evaluate(String expression) {
        char[] array = expression.toCharArray();

        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<Integer>();

        // Stack for Operators: 'ops'
        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < array.length; i++) {
            // Current token is a whitespace, skip it
            if (array[i] == ' ') {
                continue;
            }

            // Current token is a number, push it to stack for numbers
            if (array[i] >= '0' && array[i] <= '9') {
                StringBuffer sb = new StringBuffer();
                // There may be more than one digits in number
                while (i < array.length && array[i] >= '0' && array[i] <= '9') {
                    sb.append(array[i++]);
                }
                values.push(Integer.parseInt(sb.toString()));
            }

            // Current token is an opening brace, push it to 'ops'
            else if (array[i] == '(') {
                operators.push(array[i]);
            } else if (array[i] == ')') {// Closing brace encountered, solve entire brace
                while (operators.peek() != '(') {
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop();
            } else if (array[i] == '+' || array[i] == '-' ||
                    array[i] == '*' || array[i] == '/') {// Current token is an operator.
                // While top of 'ops' has same or greater precedence to current
                // token, which is an operator. Apply operator on top of 'ops'
                // to top two elements in values stack
                while (!operators.empty() && hasPrecedence(array[i], operators.peek())) {
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                }

                // Push current token to 'ops'.
                operators.push(array[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining
        // ops to remaining values
        while (!operators.empty()) {
            values.push(applyOp(operators.pop(), values.pop(), values.pop()));
        }

        // Top of 'values' contains result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

}
