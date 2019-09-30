package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KthDigitOfAPowerB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] arr = br.readLine().split("\\s+");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int k = Integer.parseInt(arr[2]);

			long pow = (long) Math.pow(a, b);

			int count = 0;
			while (pow > 0 && count < k) {
				if (count == k - 1) {
					System.out.println(pow % 10);
				}
				pow = pow / 10;
				count++;
			}
		}
		br.close();
	}
}
