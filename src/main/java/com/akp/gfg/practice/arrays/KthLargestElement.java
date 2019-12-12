package com.akp.gfg.practice.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int k = 2;
        int[] array = {3, 1, 4, 2, 6, 8, 9, 5};
        //By default priority queue is min-heap
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            queue.add(i);
        }

        // do for remaining array elements
        for (int i = k; i < array.length; i++) {
            // if current element is less than the root of the heap
            if (array[i] < queue.peek()) {
                // replace root with the current element
                System.out.println("polled elem : " + queue.poll());
                queue.add(array[i]);
            }
        }

        System.out.println(k + " largest element is : " + queue.peek());
    }
}
