import java.util.Scanner;

public class MatrixRotator {
	public static void main(String[] args) {
		int[][] matrix = new int[3][2];
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 6 elements");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				matrix[i][j] = s.nextInt();
			}
		}
		System.out.println("Matrix is : ");
		displayMatrix(matrix);
		
		rotate90DegreeToRight(matrix);
		System.out.println("After rotation matrix is : ");
		displayMatrix(matrix);
	}

	private static int[][] rotate90DegreeToRight(int[][] matrix) {

		return matrix;
	}

	private static void displayMatrix(int[][] matrix) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
