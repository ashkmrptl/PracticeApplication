package com.akp.gfg.practice.mathandalgos;

import java.util.Scanner;

public class CalculatingGCD {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			String temp = s.nextLine();
			if (temp.isEmpty()) {
				i = -1;
				continue;
			}
			int n1 = Integer.parseInt(temp.split(" ")[0]);
			int n2 = Integer.parseInt(temp.split(" ")[1]);
			System.out.println(calculateGCD(n1, n2));
		}
		s.close();
	}
	
	private static int calculateGCD(int a, int b) {
		if(a == 0)
			return b;
		
		return calculateGCD(b % a, a);
	}
}
