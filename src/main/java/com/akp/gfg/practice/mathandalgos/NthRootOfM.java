package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthRootOfM {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] arr = br.readLine().split("\\s");
			int n = Integer.parseInt(arr[0]);
			long m = Long.parseLong(arr[1]);

			Double root = Math.pow(Math.E, Math.log(m) / n);
			System.out.println("root : " + root);
			System.out.println((root == Math.floor(root) && !Double.isInfinite(root)) ? root.intValue() : "-1");
		}
		br.close();
	}
}
