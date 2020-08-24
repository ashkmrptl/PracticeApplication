package com.akp.ds;

import java.util.Arrays;

public class Queue {
    private int[] arr;
    private int front, rear, size;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = capacity - 1;
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(final int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        //Add element
        rear = (rear + 1) % capacity;
        arr[rear] = element;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }

        // Remove element
        int element = arr[front];
        front = (front + 1) % capacity;
        size--;

        return element;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "arr=" + Arrays.toString(arr) +
                ", front=" + front +
                ", rear=" + rear +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Queue queue = new Queue(2);

        queue.enqueue(1);
        queue.enqueue(2);

        System.out.println(queue);

        int a = queue.dequeue();
        System.out.println(a);
        System.out.println(queue);
        int b = queue.dequeue();
        System.out.println(b);
        System.out.println(queue);

        queue.enqueue(3);
        System.out.println(queue);

        int c = queue.dequeue();
        System.out.println(c);
        System.out.println(queue);
    }
}
