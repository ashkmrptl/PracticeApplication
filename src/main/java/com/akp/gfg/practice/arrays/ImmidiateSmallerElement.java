package com.akp.gfg.practice.arrays;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ImmidiateSmallerElement {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String[] array = br.readLine().split("\\s");

			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(array[i]);

			for (int i = 0; i < n - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					// System.out.print(array[i + 1] + " ");
					bw.write(array[i + 1] + " ");
				} else {
					// System.out.print("-1 ");
					bw.write("-1 ");
				}
			}

			/*
			 * for (int i = 0; i < n - 1; i++) { if (Integer.parseInt(array[i]) >
			 * Integer.parseInt(array[i + 1])) { System.out.print(array[i + 1] + " "); }
			 * else { System.out.print("-1 "); } }
			 */
			// System.out.println("-1 ");
			bw.write("-1 ");
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
