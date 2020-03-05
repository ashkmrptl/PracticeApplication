package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class KthSmallestElementUsingQuickSelect {

    static String kthSmallest(String arr[], int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int pos = randomPartition(arr, l, r);
            if (pos - l == k - 1) {
                return arr[pos];
            }
            if (pos - l > k - 1) {
                return kthSmallest(arr, l, pos - 1, k);
            }

            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }
        return "";
    }

    static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Standard partition process of QuickSort(). It considers the last
// element as pivot and moves all smaller element to left of it
// and greater elements to right
    static int partition(String[] arr, int l, int r) {
        String x = arr[r];
        int i = l;
        for (int j = l; j <= r - 1; j++) {
            if (Integer.parseInt(arr[j]) <= Integer.parseInt(x)) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    static int randomPartition(String[] arr, int l, int r) {
        int pivot = new Random().nextInt(1);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();
            String[] array = br.readLine().split(" ");
            int k = Integer.parseInt(br.readLine());

            System.out.println(kthSmallest(array, 0, array.length - 1, k));
        }
    }
}
