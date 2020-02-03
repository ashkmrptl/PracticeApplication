package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * This problem can be solved in O(n log k) time by using a min-heap.
 * The idea is to build a min-heap of size k and insert first k elements of the array(A[0...k-1).
 * Then for each of the remaining elements of the array(A[k...n-1]), if the element is greater than the root of the
 * heap, we replace the root with the current element. We repeat this process till the array is exhausted. Now we will
 * be left with k largest elements in the array and kth largest element will be at the root of the min-heap.
 */
public class SecondLargestNumberInArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] array = br.readLine().split("\\s");
            List<Integer> list = Arrays.stream(array).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

            int k = 2;//As we want 2nd largest element
            //Creating max heap
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(list.subList(0, k));

            //For remaining elements
            for (int i = k; i < n - 1; i++) {
                if (list.get(i) > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(list.get(i));
                }
            }

            System.out.println(minHeap.peek());
        }
    }
}
