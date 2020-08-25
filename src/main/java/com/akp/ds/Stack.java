package com.akp.ds;

import java.util.Arrays;

public class Stack {
    private int top, size, capacity;
    private Integer[] array;

    public Stack(final int capacity) {
        this.capacity = capacity;
        array = new Integer[capacity];
        top = -1;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(final Integer element) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }

        // Add element
        top++;
        array[top] = element;
        size++;
    }

    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        final int element = array[top];
        array[top] = null;
        top--;
        size--;

        return element;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                ", size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) {
        final Stack stack = new Stack(2);

        System.out.println(stack);

        stack.push(1);
        System.out.println(stack);

        stack.push(2);
        System.out.println(stack);

        System.out.println("pop : " + stack.pop());
        System.out.println(stack);

        stack.push(3);
        System.out.println(stack);

        stack.push(4);
        System.out.println(stack);

        System.out.println("pop : " + stack.pop());
        System.out.println(stack);

        System.out.println("pop : " + stack.pop());
        System.out.println(stack);

        System.out.println("pop : " + stack.pop());
    }
}
