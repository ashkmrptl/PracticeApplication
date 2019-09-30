import java.util.ArrayList;
import java.util.List;

public class FindingAdjacentElements {
	static int count = 0;

	public static void main(String[] args) {
		Integer[][] matrix = { { 1, 2, 3, 4 }, { 2, 3, 2, 5 }, { 3, 5, 3, null }, { 4, 5, null, 7 } };

		getSurroundings(matrix, matrix.length - 1, matrix.length - 1);

		System.out.println("Routes : " + count);
	}

	static void getSurroundings(Integer[][] matrix, int x, int y) {
		int[][] directions = new int[][] { { -1, 0 }, { -1, -1 }, { 0, -1 } };

		if (x == 0 && y == 0) {
			count++;
		}
		List<String> indexList = new ArrayList<String>();
		int max = 0;
		for (int[] direction : directions) {
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
			getSurroundings(matrix, i, j);
		} else if (indexList.size() > 1) {
			for (String string : indexList) {
				int i = Integer.parseInt(string.split("~")[0]);
				int j = Integer.parseInt(string.split("~")[1]);
				getSurroundings(matrix, i, j);
			}
		}
	}
}
