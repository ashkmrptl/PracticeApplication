package com.akp.sklillenza.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheKingsMarchFaster {

	private static int MAX = 0;
	private static Map<Integer, Integer> map = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			map = new HashMap<>();
			MAX = 0;
			int n = Integer.parseInt(br.readLine());
			String[][] board = new String[n][n];
			String tempLine =  null;
			for (int j = n - 1; j >= 0; j--) {
				tempLine = br.readLine();
				String[] tempArr = tempLine.split(" ");
				for (int k = tempArr.length - 1, l = 0; k >= 0; k--, l++) {
					board[j][k] = tempArr[l];
				}
			}

			List<String> list = new ArrayList<String>();
			findPaths(board, list, 0, 0);

			int max = 0;
			int count = 0;
			if (!map.isEmpty()) {
				max = MAX;
				count = map.get(MAX);
			}
			bw.write(max + " " + count);
			bw.newLine();
			bw.flush();
		}
		br.close();
		bw.close();
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
		}
		MAX = Math.max(MAX, sum);
		if (map.containsKey(sum)) {
			map.put(sum, map.get(sum) + 1);
		} else {
			map.put(sum, 1);
		}
	}

}
