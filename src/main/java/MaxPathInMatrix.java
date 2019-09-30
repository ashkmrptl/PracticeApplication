import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxPathInMatrix {
	public static void main(String args[]) {
		MaxPathInMatrix mcp = new MaxPathInMatrix();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Integer[][] board = new Integer[n][n];
		for (int j = 0; j < n; j++) {
			String tempLine = s.nextLine();
			if (tempLine.isEmpty()) {
				j = -1;
				continue;
			}
			String[] tempArr = tempLine.split(" ");
			for (int k = 0; k < n; k++) {
				board[j][k] = Integer.parseInt(tempArr[k]);
			}
		}
		mcp.printMatrix(board);
		System.out.println("count : " + mcp.countPaths(board, board.length, board.length));
		s.close();
	}

	public int countPaths(Integer[][] matrix, int n, int m) {
		return 0;
	}
	

	private void printMatrix(Integer[][] arr) {
		System.out.println("--------------------------------");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
