package com.akp.algos.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {9, 4, 3, 6, 5, 8, 2, 7, 1};
        System.out.println("Before sorting : ");
        printArray(array);

        sort(array, 0, array.length - 1);
        System.out.println("\nAfter sorting : ");
        printArray(array);

    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(e -> {
            System.out.print(e + " ");
        });
    }

    private static void sort(int[] array, int start, int end) {
        if (start < end) {
            //Finding the middle element
            int mid = (start + end) / 2;

            //Sorting the left half
            sort(array, start, mid);
            sort(array, mid + 1, end);

            //Merging the sorted halves
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int middle, int end) {
        //Finding the size of two sub array to be merged
        int sizeOfLeftSubArray = (middle - start) + 1;
        int sizeOfRightSubArray = end - middle;

        //Creating temp array to store sorted merged sub arrays
        int left[] = new int[sizeOfLeftSubArray];
        int right[] = new int[sizeOfRightSubArray];

        //Copying data to temp arrays
        for (int i = 0; i < sizeOfLeftSubArray; ++i) {
            left[i] = array[start + i];
        }
        for (int i = 0; i < sizeOfRightSubArray; ++i) {
            right[i] = array[middle + 1 + i];
        }

        //Merging the temp arrays
        //Initial indices of left and right sub arrays
        int i = 0, j = 0;

        //Initial index of merged sub array
        int k = start;

        while (i < sizeOfLeftSubArray && j < sizeOfRightSubArray) {
            if (left[i] < right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        //Copying remaining element from left sub-array
        while (i < sizeOfLeftSubArray) {
            array[k++] = left[i++];
        }

        //Copying remaining element from right sub-array
        while (j < sizeOfRightSubArray) {
            array[k++] = right[j++];
        }
    }
}
