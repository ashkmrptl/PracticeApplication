import java.util.Scanner;

// Java program to Print all possible paths from 
// top left to bottom right of a mXn matrix 
public class MatrixTraversal {

	/*
	 * mat: Pointer to the starting of mXn matrix i, j: Current position of the
	 * robot (For the first call use 0,0) m, n: Dimentions of given the matrix pi:
	 * Next index to be filed in path array path[0..pi-1]: The path traversed by
	 * robot till now (Array to hold the path need to have space for at least m+n
	 * elements)
	 */
	private static void printMatrix(int mat[][], int m, int n, int i, int j, int path[], int idx) {
		path[idx] = mat[i][j];

		// Reached the bottom of the matrix so we are left with
		// only option to move right
		if (i == m - 1) {
			for (int k = j + 1; k < n; k++) {
				path[idx + k - j] = mat[i][k];
			}
			for (int l = 0; l < idx + n - j; l++) {
				System.out.print(path[l] + " ");
			}
			System.out.println();
			return;
		}

		// Reached the right corner of the matrix we are left with
		// only the downward movement.
		if (j == n - 1) {
			for (int k = i + 1; k < m; k++) {
				path[idx + k - i] = mat[k][j];
			}
			for (int l = 0; l < idx + m - i; l++) {
				System.out.print(path[l] + " ");
			}
			System.out.println();
			return;
		}
		// Print all the paths that are possible after moving down
		printMatrix(mat, m, n, i + 1, j, path, idx + 1);

		// Print all the paths that are possible after moving right
		printMatrix(mat, m, n, i, j + 1, path, idx + 1);
	}

	// Driver code
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[][] board = new int[n][n];
		for (int j = n - 1; j >= 0; j--) {
			String tempLine = s.nextLine();
			if (tempLine.isEmpty()) {
				j = n;
				continue;
			}
			String[] tempArr = tempLine.split(" ");
			for (int k = tempArr.length - 1, l = 0; k >= 0; k--, l++) {
				board[j][k] = Integer.parseInt(tempArr[l]);
			}
		}
		int maxLengthOfPath = n + n - 1;
		printMatrix(board, n, n, 0, 0, new int[maxLengthOfPath], 0);
	}
}
