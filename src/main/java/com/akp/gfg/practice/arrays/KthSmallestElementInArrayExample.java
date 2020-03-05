package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
 * This problem can be fixed in O(nlogk) by using max heap. The idea is to construct a max heap of size k and insert first k elements of array (A[0...k-1]) into the heap.
 * Then for each of the remaining element of the array(A[k...n-1), if that element is less than the root of the heap, we replace the root with current element. We repeat
 * this process until array is exhausted. Now we will be left with Kth smallest element of the array in the max-heap and the Kth smallest element will reside at the
 * root of the max-heap.
 */
public class KthSmallestElementInArrayExample {
    public static String findKthSmallest(List<String> list, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(list.subList(0, k));
        for (int i = k; i < list.size(); i++) {
            // if current element is less than the root of the heap
            if (Integer.parseInt(list.get(i)) < Integer.parseInt(pq.peek())) {
                pq.add(list.get(i));
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());

            String[] array = br.readLine().split(" ");
            List<String> list = Arrays.stream(array).collect(Collectors.toList());

            System.out.println(findKthSmallest(list, k));
        }
    }
}
