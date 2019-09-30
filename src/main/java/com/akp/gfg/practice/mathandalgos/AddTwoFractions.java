package com.akp.gfg.practice.mathandalgos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AddTwoFractions {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String[] arr = br.readLine().split("\\s+");
			addFraction(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]),
					Integer.parseInt(arr[3]));
		}
		br.close();
	}

	static void addFraction(int num1, int den1, int num2, int den2) {
		int resd, resn;
		resd = lcm(den1, den2);
		resn = num1 * (resd / den1) + num2 * (resd / den2);
		int k = gcd(resn, resd);
		resd = resd / k;
		resn = resn / k;
		System.out.println(resn + "/" + resd);
	}

	static int gcd(int a, int b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);

	}

	static int lcm(int a, int b) {
		return (a * b) / gcd(a, b);
	}
}
