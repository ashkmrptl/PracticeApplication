package com.test;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 3, 2, 4, 5, 7, 6 ,5,9,0};
		ArrayList<Integer> al = new ArrayList<>();
		int length = a.length;
		al.add(a[length - 1]);
		al.add(a[length - 2]);
		for (int i = 0; i <= length - 3; i++) {
			al.add(a[i]);
		}
		System.out.println(al);
	}
}
