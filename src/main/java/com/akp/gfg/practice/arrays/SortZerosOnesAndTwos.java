package com.akp.gfg.practice.arrays;

public class SortZerosOnesAndTwos {
    private static void sort(int[] array, int array_size) {
        int low = 0;
        int high = array_size - 1;
        int mid = 0;

        while (mid <= high) {
            switch (array[mid]) {
                case 0:
                    swap(array, low, mid);
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(array, mid, high);
                    high--;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + array[mid]);
            }
        }

    }

    private static void swap(int[] array, int sourceIndex, int destinationIndex) {
        int temp = 0;
        temp = array[sourceIndex];
        array[sourceIndex] = array[destinationIndex];
        array[destinationIndex] = temp;
    }

    private static void printArray(int[] array) {
        for (int value : array)
            System.out.print(value + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arrSize = arr.length;
        sort(arr, arrSize);
        System.out.println("Array after seggregation ");
        printArray(arr);
    }
}
