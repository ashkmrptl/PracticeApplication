package com.akp.gfg.company.morganstanly;

public class RemoveDuplicatedSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 2, 3, 4, 4, 4, 4, 5, 5};
        int n = arr.length;
        n = removeDuplicates(arr, n);
        // Print updated array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static int removeDuplicates(int[] arr, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] != arr[i + 1]) {
                arr[index++] = arr[i];
            }
        }
        arr[index++] = arr[n - 1];
        return index;
    }
}
