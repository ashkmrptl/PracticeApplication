package com.akp.sklillenza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPatternPrinting {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());

			while (t-- > 0) {
				String[] arr = br.readLine().split("\\s");
				char[] chArr = arr[0].toCharArray();
				int h = Integer.parseInt(arr[1]);
				String dir = arr[2];

				int temp = 0;

				for (int i = 0; i < h; i++) {
					for (int j = h - i; j > 1; j--) {
						System.out.print(" ");
					}
					for (int j = 0; j <= i; j++)
						System.out.print(chArr[temp > 2 ? temp = 0 : temp++]+" ");

					System.out.println();
				}
			}
		} catch (IOException e) {
		}
	}
}
