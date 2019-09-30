package com.akp.gfg.practice.mathandalgos;

import java.util.Scanner;

/*
 * An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself
 */
public class ArmstrongNumbers {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < scanner.nextInt(); i++) {
			int n = scanner.nextInt();
			int temp = n;
			int sum = 0;
			while (n > 0) {
				sum = (int) (sum + Math.pow((n % 10), 3));
				n = n / 10;
			}
			if (temp == sum) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
		scanner.close();
	}
}
