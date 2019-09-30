package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PairCubeCount {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int count = 0;
			for (int i = 0; i < Math.cbrt(n); i++) {
				int cbrt = i * i * i;
				int diff = n - cbrt;
				
				//Checking if the difference is a perfect cube
				int cbrtDiff = (int) Math.cbrt(diff);
				
				if(cbrtDiff * cbrtDiff * cbrtDiff == diff) {
					count ++;
				}
			}
			System.out.println(count);
		}

		br.close();
	}
}
