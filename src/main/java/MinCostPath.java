import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinCostPath {

	private static int count = 0;
	private static final int[][] DIRECTIONS = new int[][] { { -1, 0 }, { -1, -1 }, { 0, -1 } };
	private static List<String> indexList = null;
	private static Integer temp[][] = null;
	private static String[][] board = null;
	private static String tempLine = null;
	private static String[] tempArr = null;
	private static String result = null;

	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			count = 0;
			int n = s.nextInt();
			board = new String[n][n];
			for (int j = n - 1; j >= 0; j--) {
				tempLine = s.nextLine();
				if (tempLine.isEmpty()) {
					j = n;
					continue;
				}
				tempArr = tempLine.split(" ");
				for (int k = tempArr.length - 1, l = 0; k >= 0; k--, l++) {
					board[j][k] = tempArr[l].equals("s") || tempArr[l].equals("e") ? "0" : tempArr[l];
				}
			}
			result = maxCost(board, n - 1, n - 1);
			System.out.println(result);
		}

		s.close();
	}

	private static String maxCost(String[][] board, int m, int n) {
		temp = new Integer[m + 1][n + 1];
		int sum = 0;
		for (int i = 0; i <= n; i++) {
			if (board[0][i].equals("x")) {
				break;
			}
			temp[0][i] = sum + Integer.parseInt(board[0][i]);
			sum = temp[0][i];
		}

		sum = 0;
		for (int i = 0; i <= m; i++) {
			if (board[i][0].equals("x")) {
				break;
			}
			temp[i][0] = sum + Integer.parseInt(board[i][0]);
			sum = temp[i][0];
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (board[i][j].equals("x")
						|| (temp[i - 1][j - 1] == null && temp[i - 1][j] == null && temp[i][j - 1] == null)) {
					continue;
				}
				temp[i][j] = Integer.parseInt(board[i][j]) + max(temp[i - 1][j - 1], temp[i - 1][j], temp[i][j - 1]);
			}
		}

		int max = temp[m][n] == null ? 0 : temp[m][n];
		countPaths(temp, temp.length - 1, temp.length - 1);

		return max + " " + count;
	}

	private static void countPaths(Integer[][] matrix, int x, int y) {
		if (x == 0 && y == 0) {
			count++;
		}
		indexList = new ArrayList<String>();
		int max = 0;
		for (int[] direction : DIRECTIONS) {
			int cx = x + direction[0];
			int cy = y + direction[1];
			if (cy >= 0 && cy < matrix.length) {
				if (cx >= 0 && cx < matrix[cy].length) {
					if (matrix[cx][cy] != null) {
						if (matrix[cx][cy] > max) {
							indexList.clear();
							max = matrix[cx][cy];
							indexList.add(cx + "~" + cy);
						} else if (matrix[cx][cy] == max) {
							indexList.add(cx + "~" + cy);
						}
					}
				}
			}
		}
		if (indexList.size() == 1) {
			int i = Integer.parseInt(indexList.get(0).split("~")[0]);
			int j = Integer.parseInt(indexList.get(0).split("~")[1]);
			countPaths(matrix, i, j);
		} else if (indexList.size() > 1) {
			for (String string : indexList) {
				int i = Integer.parseInt(string.split("~")[0]);
				int j = Integer.parseInt(string.split("~")[1]);
				countPaths(matrix, i, j);
			}
		}
	}

	private static int max(Integer a, Integer b, Integer c) {
		a = a == null ? 0 : a;
		b = b == null ? 0 : b;
		c = c == null ? 0 : c;
		int l = Math.max(a, b);
		return Math.max(l, c);
	}
}