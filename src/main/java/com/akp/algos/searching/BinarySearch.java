package com.akp.algos.searching;

import java.util.logging.Logger;

/**
 * Binary search needed the elements of the array to be sorted
 * Lets assume the array is sorted in ascending order.
 */
public class BinarySearch {
    private static final Logger logger = Logger.getLogger(BinarySearch.class.getName());

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int element = 9;
        int res = search(array, element, 0, array.length - 1);
        if (res > -1) {
            logger.info("Element '" + element + "' is found at position : " + res);
        } else {
            logger.info("Element '" + element + "' is not found in array");
        }

        element = 19;
        res = search(array, element, 0, array.length - 1);
        if (res > -1) {
            logger.info("Element '" + element + "' is found at position : " + res);
        } else {
            logger.info("Element '" + element + "' is not found in array");
        }
    }

    public static int search(int[] array, int element, int start, int end) {
        if (start == end) {
            if (array[start] == element) {
                return start;
            } else {
                return -1;
            }
        }

        int mid = (start + end) / 2;

        if (array[mid] == element) {
            return mid;
        } else if (element < mid) {
            return search(array, element, 0, mid - 1);
        } else {
            return search(array, element, mid + 1, array.length - 1);
        }
    }
}
