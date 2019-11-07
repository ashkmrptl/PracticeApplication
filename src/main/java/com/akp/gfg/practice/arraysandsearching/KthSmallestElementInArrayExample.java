package com.akp.gfg.practice.arraysandsearching;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
 * This problem can be fixed in O(nlogk) by using max heap. The idea is to construct a max heap of size k and insert first k elements of array (A[0...k-1]) into the heap.
 * Then for each of the remaining element of the array(A[k...n-1), if that element is less than the root of the heap, we replace the root with current element. We repeat 
 * this process until array is exhausted. Now we will be left with Kth smallest element element of the array in the max-heap and the Kth smallest element will reside at the 
 * root of the max-heap. 
 */
public class KthSmallestElementInArrayExample {
	// Function to find the K'th smallest element in the
	// array using max-heap
	public static int findKthSmallest(List<Integer> list, int k) {
		// create an max-heap using PriorityQueue class and
		// insert first k elements of the array into the heap
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		System.out.println("sub-list : " + (list.subList(0, k)));
		pq.addAll(list.subList(0, k));
		System.out.println("After adding sub-list : ");
		pq.stream().forEach(e -> System.out.print(e + " "));
		System.out.println();

		// do for remaining array elements
		for (int i = k; i < list.size(); i++) {
			// if current element is less than the root of the heap
			if (list.get(i) < pq.peek()) {
				// replace root with the current element
				System.out.println("polled elem : " + pq.poll());
				pq.add(list.get(i));
			}
		}

		System.out.println("queue size : " + pq.size());
		pq.stream().forEach(e -> System.out.print(e + " "));
		System.out.println();

		System.out.println("Sorted array : ");
		list.stream().sorted().forEach(e -> System.out.print(e + " "));
		System.out.println();

		// return the root of max-heap
		return pq.peek();
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(7, 4, 6, 3, 9, 1);
		int k = 5;

		System.out.println("list : " + list);
		System.out.println("K'th smallest element in the array is " + findKthSmallest(list, k));
	}
}
