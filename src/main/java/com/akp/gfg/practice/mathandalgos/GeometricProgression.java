package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GeometricProgression {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] arr = br.readLine().split("\\s+");
			double a = Double.parseDouble(arr[0]);
			double b = Double.parseDouble(arr[1]);

			int n = Integer.parseInt(br.readLine());

			System.out.println((int) Math.floor(a * Math.pow((b / a), n - 1)));
		}
		br.close();
	}
}
