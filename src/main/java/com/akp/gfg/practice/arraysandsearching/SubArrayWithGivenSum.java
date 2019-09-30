package com.akp.gfg.practice.arraysandsearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of non-negative integers, the following program is to find the continuous sub-array which adds to given SUM.
 */
public class SubArrayWithGivenSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] temp = br.readLine().split("\\s");
			int n = Integer.parseInt(temp[0]);
			int s = Integer.parseInt(temp[1]);

			temp = br.readLine().split("\\s");
			int[] array = new int[n];

			for (int i = 0; i < n; i++) {
				array[i] = Integer.parseInt(temp[i]);
			}

			subArraySum(array, n, s);

		}

		br.close();
	}

	private static void subArraySum(int[] arr, int n, int sum) {
		// cur_sum to keep track of cumulative sum till that point
		int cur_sum = 0;
		int start = 0;
		int end = -1;
		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < n; i++) {
			cur_sum = cur_sum + arr[i];
			// check whether cur_sum - sum = 0, if 0 it means the sub array is starting from index 0- so stop
			if (cur_sum - sum == 0) {
				start = 0;
				end = i;
				break;
			}
			// if hashMap already has the value, means we already have sub-array with the sum - so stop
			if (hashMap.containsKey(cur_sum - sum)) {
				start = hashMap.get(cur_sum - sum) + 1;
				end = i;
				break;
			}
			// if value is not present then add to has-map
			hashMap.put(cur_sum, i);

		}
		// if end is -1 : means we have reached end without the sum
		if (end == -1) {
			System.out.println("");
		} else {
			System.out.println((start + 1) + " " + (end + 1));
		}

	}
}
