package com.akp.sklillenza.test;
import java.util.Scanner;

public class QueenSkillenzaProblem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(scanner.next());
			int r = 0;
			int c = 0;
			while(scanner.hasNext()) {
				String[] arr = scanner.next().replaceAll("\\(", "").replaceAll("\\)", "").split(",");
				r = Integer.parseInt(arr[0]);
				c = Integer.parseInt(arr[1]);
				break;
			}
			countPosiions(n, r, c);
		}
	}

	private static void countPosiions(int n, int rowNum, int colNum) {
		int noOfRowBlocks = 0;
		int noOfColBlocks = 0;
		int noOfTopRightBlocks = 0;
		int noOfDownRightBlock = 0;
		int noOfTopLeftBlocks = 0;
		int noOfDownLeftBlocks = 0;

		// Counting no of row blocks
		noOfRowBlocks = n - 1;
		noOfColBlocks = n - 1;

		// System.out.println("No of row blocks : " + noOfRowBlocks);
		// System.out.println("No of col blocks : " + noOfColBlocks);

		// Counting top right blocks
		int currRow = rowNum;
		int currCol = colNum;
		while (currRow <= n && currCol <= n) {
			noOfTopRightBlocks++;
			currRow++;
			currCol++;
		}
		--noOfTopRightBlocks;

		// Counting down right blocks
		currRow = rowNum;
		currCol = colNum;
		while (currRow <= n && currCol > 0) {
			noOfDownRightBlock++;
			currRow++;
			currCol--;
		}
		--noOfDownRightBlock;

		// Counting top left blocks
		currRow = rowNum;
		currCol = colNum;
		while (currRow > 0 && currCol <= n) {
			noOfTopLeftBlocks++;
			currRow--;
			currCol++;
		}
		--noOfTopLeftBlocks;

		// Counting down left blocks
		currRow = rowNum;
		currCol = colNum;
		while (currRow > 0 && currCol > 0) {
			noOfDownLeftBlocks++;
			currRow--;
			currCol--;
		}
		--noOfDownLeftBlocks;

		System.out.println((((n * n) - (noOfRowBlocks + noOfColBlocks + noOfTopRightBlocks + noOfDownRightBlock
				+ noOfTopLeftBlocks + noOfDownLeftBlocks))));
	}
}
