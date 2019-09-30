package com.akp.sklillenza.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TheKingsMarch {

	// private static List<Integer> sumlist = null;
	private static int MAX = 0;
	private static Map<Integer, Integer> map = null;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			Long start = System.currentTimeMillis();
			map = new HashMap<>();
			MAX = 0;
			int n = s.nextInt();
			String[][] board = new String[n][n];
			for (int j = n - 1; j >= 0; j--) {
				String tempLine = s.nextLine();
				if (tempLine.isEmpty()) {
					j = n;
					continue;
				}
				String[] tempArr = tempLine.split(" ");
				for (int k = tempArr.length - 1, l = 0; k >= 0; k--, l++) {
					board[j][k] = tempArr[l];
				}
			}

			System.out.println("Time taken to create matrix : " + (System.currentTimeMillis() - start) + " mili secs");

			List<String> list = new ArrayList<String>();
			findPaths(board, list, 0, 0);

			map.entrySet().stream().forEach(e -> System.out.println(e.getKey()+" "+e.getValue()));
			
			int max = 0;
			int count = 0;
			if (!map.isEmpty()) {
				max = MAX;
				count = map.get(MAX);
			}
			System.out.println(max + " " + count);
			System.out.println("Time taken to find result : " + (System.currentTimeMillis() - start) + " mili secs");
		}
		s.close();
	}

	public static void findPaths(String[][] mat, List<String> path, int i, int j) {
		int M = mat.length;
		int N = M;

		// if we have reached the last cell, print the route
		if (i == M - 1 && j == N - 1) {
			if (!path.contains("x")) {
				printPath(path);
			}
			return;
		}

		// include current cell in path
		if (path.contains("x")) {
			return;
		}
		path.add(mat[i][j]);

		// move right
		if ((i >= 0 && i < M && j + 1 >= 0 && j + 1 < N)) {
			findPaths(mat, path, i, j + 1);
		}

		// move down
		if ((i + 1 >= 0 && i + 1 < M && j >= 0 && j < N)) {
			findPaths(mat, path, i + 1, j);
		}

		// move down & right (diagonal)
		if (i < M - 1 && j < N - 1) {
			findPaths(mat, path, i + 1, j + 1);
		}

		// remove current cell from path
		path.remove(path.size() - 1);
	}

	// Function to print the route taken
	public static void printPath(List<String> path) {
		int sum = 0;
		for (String i : path) {
			if (!i.equalsIgnoreCase("s") && !i.equalsIgnoreCase("x") && !i.equalsIgnoreCase("e")) {
				sum = sum + Integer.parseInt(i);
			}
			System.out.print(i + " - ");
		}
		System.out.println();
		MAX = Math.max(MAX, sum);
		if (map.containsKey(sum)) {
			map.put(sum, map.get(sum) + 1);
		} else {
			map.put(sum, 1);
		}
	}

}
