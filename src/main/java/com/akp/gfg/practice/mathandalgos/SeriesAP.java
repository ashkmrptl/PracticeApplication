package com.akp.gfg.practice.mathandalgos;

import java.util.Scanner;

public class SeriesAP {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			String tempLine = s.nextLine();
			if (tempLine.isEmpty()) {
				i--;
				continue;
			}
			String[] arr = tempLine.split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int n = s.nextInt();

			int result = a + (n - 1) * (b - a);
			System.out.println(result);
		}
		s.close();
	}
}
